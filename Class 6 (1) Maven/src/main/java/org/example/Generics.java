package org.example;

public class Generics {



//    Generics->
//    Benefits
    // 1. Type Safety
    // 2. Type casting is not required
    // 3. Compile time checking -> better to handle the problems at compile time than runtime


//    Syntax to use generic collection -> ClassOrAnyInterface<Type>
    //





    public static void main(String[] args) {

//        List<String> list = new ArrayList();
//        list.add("true");
//        list.add("false");
//        list.add("true");

//        MyGen<String, String> myGen = new MyGen<>("19", "10");
//        myGen.print();
//
//        MyGen<Integer, Integer> myGen2 = new MyGen<>(10, 12);
//        myGen2.print();


        Integer[] intArray = {10, 12, 124, 13, 12};
        Character[] charArray = {'J', 'A', 'V'};

        MyGen1.printArray(intArray);
//        MyGen1.printArray(charArray);



    }



}

// T - type
// E - Element
//K, N, V



//Generic class
class MyGen<A, B> {
    A obj1;
    B obj2;

    public MyGen(A obj, B obj2) {
        this.obj1 = obj;
        this.obj2 = obj2;
    }


    void print() {
        System.out.println("Values are: " + obj1 + " and " + obj2);
    }
}

class MyGen1 {
    public static <T> void printArray(T[] elements) {
        for(T element : elements) {
            System.out.println(element);
        }

//        for(K element : element1) {
//            System.out.println(element);
//        }
    }
}


// Wildcard -> Upper Bounded (? extends), lower bounded (? super) and unbounded
// Volatile keyword