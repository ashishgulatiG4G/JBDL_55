package com.example.demo.service;

import com.example.demo.dto.InitiateTransactionRequest;
import com.example.demo.models.*;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Autowired
    AdminService adminService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${student.allowed.max-books}") // application.properties
    Integer maxBooksAllowed;

    @Value("${student.allowed.duration}") // application.properties
    Integer allowedDuration;

    public String initiateTransaction(InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        return initiateTransactionRequest.getTransactionType() == TransactionType.RETURN
                ? returnBook(initiateTransactionRequest)
                : issueBook(initiateTransactionRequest);

    }

    /**
     * Issue of a book -> {studentRollNumber, bookId, adminId, transaction Type}
     *      1. Validate the request -> student, book and admin is valid or not
     *      2. Validate if book is available -> If the book is already issued on someone's name
     *      3. Validate if the book can be issued to the given student -> We need to check if the student has available limit (issue limit) on his account or not
     *      4. Entry in the transaction
     *      5. Book to be assigned to a student => update Student column in the book table
     */
    private String issueBook(InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        List<Student> studentList = studentService.findStudent("rollNumber", initiateTransactionRequest.getStudentRollNumber());
        Student student = studentList.size() > 0 ? studentList.get(0) : null;

        List<Book> bookList = bookService.findBook("id", String.valueOf(initiateTransactionRequest.getBookId()));
        Book book = bookList.size() > 0 ? bookList.get(0) : null;

        Admin admin = adminService.find(initiateTransactionRequest.getAdminId());

        // 1. Validate the request
        if(student == null || book == null || admin == null) {
            throw new Exception("Invalid Request");
        }

        // 2. Validate if book is available
        if(book.getStudent() != null) {
            throw new Exception("This book is already issued to " + book.getStudent().getName());
        }

        // 3. Validate if the book can be issued to the given student
        if(student.getBookList().size() >= maxBooksAllowed) {
            throw new Exception("Issue limit reached for this student");
        }

        Transaction transaction = null;
        try {
            transaction = Transaction.builder()
                    .transactionId(UUID.randomUUID().toString())
                    .student(student)
                    .book(book)
                    .admin(admin)
                    .transactionStatus(TransactionStatus.PENDING)
                    .transactionType(TransactionType.ISSUE)
                    .build();

            // 4. Entry in the transaction table with status = PENDING
            transactionRepository.save(transaction);

            // 5. Book to be assigned to a student
            book.setStudent(student);
            bookService.createOrUpdateBook(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        } catch(Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
        } finally {
            transactionRepository.save(transaction);
        }

        return transaction.getTransactionId();
    }

    /**
     * 1. Validate the book, student, admin and also validate if the book is issued to the same person
     * 2. Get the corresponding issuance transaction
     * 3. Entry in the transaction table
     * 4. Due date check, if due date - issue date > allowedDuration => fine calculation
     * 5. If there is no fine, de-allocate the book from student's name ===> book table
     */
    private String returnBook(InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        List<Student> studentList = studentService.findStudent("rollNumber", initiateTransactionRequest.getStudentRollNumber());
        Student student = studentList.size() > 0 ? studentList.get(0) : null;

        List<Book> bookList = bookService.findBook("id", String.valueOf(initiateTransactionRequest.getBookId()));
        Book book = bookList.size() > 0 ? bookList.get(0) : null;

        Admin admin = adminService.find(initiateTransactionRequest.getAdminId());

        // 1. Validate the request
        if(student == null || book == null || admin == null) {
            throw new Exception("Invalid Request");
        }

        if(book.getStudent() == null || !book.getStudent().getId().equals(student.getId())) {
            throw new Exception("This book isn't assigned to the particular student");
        }

        // 2. Get the corresponding issuance transaction
        Transaction issuanceTransaction = transactionRepository.findTransactionByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);
        if(issuanceTransaction == null) {
            throw new Exception("This book hasn't been issued to anyone");
        }

        Transaction transaction = null;
        try {
            Integer fine = calculateFine(issuanceTransaction.getCreatedOn());

            transaction = Transaction.builder()
                    .transactionId(UUID.randomUUID().toString())
                    .transactionType(initiateTransactionRequest.getTransactionType())
                    .transactionStatus(TransactionStatus.PENDING)
                    .admin(admin)
                    .book(book)
                    .student(student)
                    .fine(fine)
                    .build();

            transactionRepository.save(transaction);

            //pay Fine

            if(fine == 0) {
                // de allocating the book
                book.setStudent(null);
                bookService.createOrUpdateBook(book);
                transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            }


        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
        } finally {
            transactionRepository.save(transaction);
        }

        return transaction.getTransactionId();
    }
    private Integer calculateFine(Date issuanceTime) {
        long issuanceTimeInMillis = issuanceTime.getTime();
        long currentTime = System.currentTimeMillis();

        long diff = currentTime - issuanceTimeInMillis;

        long daysPassed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        if(daysPassed > allowedDuration) {
            return (int)(daysPassed - allowedDuration);
        }
        return 0;
    }

    public void payFine(Integer amount, Integer studentId, String txnId) {
        // get the return trxn from DB using txnId
        //              Payment
        // Deallocate the book, mark this transaction as successful
        // save this transaction in DB
    }



}
