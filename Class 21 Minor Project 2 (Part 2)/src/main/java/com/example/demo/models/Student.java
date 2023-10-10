package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private Integer age;

    private String rollNumber;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("securedUser")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("securedUser")
    private List<Transaction> transactionList;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("securedUser")
    private SecuredUser securedUser;

}

// User -> (Student, Admin)


