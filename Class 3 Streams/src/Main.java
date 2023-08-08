import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

//class Student implements Comparable<Student>{
//    int marks;
//
//    public Student(int marks) {
//        this.marks = marks;
//    }
//
//    //this
//    public int compareTo(Student that) {
//        return this.marks - that.marks;
//    }
//
//};

public class Main {
    public static void main(String[] args) {

        //Comparator vs Comparable

//        Comparator<Integer> comparator = (o1, o2) -> o2-o1;
//
//        List<Integer> arrayList = Arrays.asList(1, 2, 5, 2, 3);

//
//        Collections.sort(arrayList, comparator);
//
//        for(Integer s : arrayList) {
//            System.out.println(s);
//        }
//
//        List<Student> studentList = new ArrayList<>();
//
//        for(int i = 1; i <= 10; i++) {
//            studentList.add(new Student(i*100));
//        }
//
//        Collections.sort(studentList);

        //1. Supplier FI
//        Supplier<Integer> supplier = () -> new Random().nextInt();
//        System.out.println(supplier.get());
//
//        //2. Predicate
//        Predicate<String> predicate = (a) -> a.length() > 5;
//        System.out.println(predicate.test("heyaaa"));
//
//        //3. Function
//        Function<String, Integer> function = (a) -> Integer.parseInt(a);
//        System.out.println(function.apply("32"));

        //4. Consumer
//        Consumer<String> consumer = (a) -> System.out.println(a);
//        consumer.accept("Hey there");


        //5. Runnable -> Multithreading
//        Runnable runnable = () -> System.out.println("Hey");
//        runnable.run();


        //6. BiFunction
//        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a+b;
//        System.out.println(biFunction.apply(1, 100));

        // Raw material -> [M1] -> Dough -> [M2] -> Cookies -> [M3] -> end_result

        //Streams


//        To check which program is more optimised
        // 1. Time taken
        // 2. Number of operations -> Same





        //Q1 -> List of integers, calculate the sum of square of odd numbers
        // L = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

        // Filtering out even numbers -> removing the even numbers
        // Squaring the number
        // Summation


//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        System.out.println("Sum" + sum2(list));



//        Stream<Integer> streamOfList = list.stream();

        // Given a list of integer, find first even integer

//        List<Integer> list = Arrays.asList(1, 13, 51, 12, 46, 18, 9, 1234);
//        System.out.println(findFirstEven(list));



        //Q - Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        // 1.convert to string [n -> n+""]
        // 2. filteration = looking at first index of string ('1')

        //        list.stream()
        //                .map(n -> n+"")
        //                .filter(s -> s.startsWith("1")).forEach(str -> System.out.println(str));


        //How to find duplicate elements in a given integers list in java using Stream functions?
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 2, 3, 4);

        // Set [HashSet]

        // 1. Adding element to set, if element gets added to set -> first encounter (true) , if not -> duplicate (false)

//        Set<Integer> set = new HashSet<>();
////        [set.add(element) == false => duplicate]
//        list.stream()
//                .filter(n -> !set.add(n))
//                .forEach(n-> System.out.println(n));




        //Given a list of integers, find the maximum value element present in it using Stream functions
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 2, 3, 40);
//        int ret = list.stream()
//                .max(new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        System.out.println(o1 + " : " + o2);
//                        return 01 > 02 ? 1 : -1;
//                    }
//                }).get();
//        System.out.println(ret);


//        int max = -1;
//        for(Integer i : list) {
//            if(i > max) {
//                max = i;
//            } else {
//                continue;
//            }
//        }
//        System.out.println(max);


//        perform cube on list elements and get the numbers greater than 50.
//        List<Integer> list = Arrays.asList(4, 5, 7, 1, 2, 3);

        //Algo
        // 1. Convert (finding the cube)
        // 2. filter ()


//        list.stream()
//                .map(n -> n*n*n)
//                .filter(c -> c > 50)
//                .forEach(n -> System.out.println(n));


        // find the totl number of elements in a list using stream
//        List<Integer> list = Arrays.asList(4, 5, 7, 1, 2, 3);
//        int totalNumberOfElements = (int) list.stream().count();
//        System.out.println(totalNumberOfElements);










































    }

    public static Integer findFirstEven(List<Integer> list) {

        Integer ret = list.stream().filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return false;
                    }
                })
                .findFirst()
                .orElse(-1);

        return ret;
    }


    //Benefits ->
    //Readability and Pipelining

    // 1. Filtering out even numbers -> removing the even numbers
    // 2. Squaring the number
    // 3. Summation
    public static Integer sum2(List<Integer> list) {

        long start = System.currentTimeMillis();
        int result =  list.stream()
            .filter(a -> a % 2 == 1)
            .map(a -> a * a)
            .reduce(0, (a, b) -> a + b);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        return result;
    }

    //iterative -> 1687922147328

    public static Integer sum1(List<Integer> list) {
        long start = System.currentTimeMillis();

        int sum = 0;
        for(Integer l : list) {
            if(l % 2 == 1) {
                sum += l*l;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);

        return sum;
    }










//    Given a list of integers, find the total number of elements present in the list using Stream functions?

//    Given a list of integers, find out all the even numbers that exist in the list using Stream functions?



    //Given a list of integers, find the maximum value element present in it using Stream functions


    //perform cube on list elements and filter numbers greater than 50.

    //How to use map to convert object into Uppercase in Java 8?








}