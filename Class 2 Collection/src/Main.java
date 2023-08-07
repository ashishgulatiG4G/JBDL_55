import java.util.*;

public class Main {

    public void main(String[] args) {
        /*
        // Collection -> Data structure to store data

        // Collection
        // Array -> contiguous in nature
        // List -> array of any data [non contiguous], homogenous in nature
        // Set -> store data without the duplicates [HashSet, LinkedHashSet]
        // Map -> key->value , [key, value store] , key cannot have duplicates
        // Queue -> PriorityQueue, Deque, ArrayDeque

        //Anonymous Inner Class


            Q-1 ->Given an unsorted list of integers, find out the first pair whose sum is equal to target, If no such pair exist, you can return -1
            L = [1, 2, 3, 5, 7, 4, 8, 10, 20]
            Target = 15


        List<Integer> list = Arrays.asList(1, 2, 3, 5, 7,10, 4, 8, 3, 2, 20);

        // Interface -> blueprint or a Contract
        // Program to an interface and not the concrete implementation

        Set<Integer> set = new HashSet<>();

        int target = 15;

        //forEach, enhanced for loop
        for(Integer el : list) {
            int value = target-el;
            if(set.contains(value)) {
                System.out.println(value + " " + el);
                break;
            }
            set.add(el);
        }



        // key->value
        //Q-2 ->Given an unsorted list of integers, find out the number of pairs whose sum is equal to target, If no such pair exist, you can return -1
                // including the duplicates
        //        L = [1, 2, 3, 7, 5, 7, 8, 8, 8, 8, 10]
        //        Target = 15

        // 1. Take a map, we will be computing the frequency of each element

        // 1 -> 1
        // 2 -> 1
        // 3 -> 1
        // 7 -> 2
        // 5 -> 1
        // 8 -> 3
        // 10 -> 1

        // [7, 8] & [8, 7]

        List<Integer> list = Arrays.asList(1, 2, 3, 5, 7,10, 4, 8, 3, 2, 20);
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer el : list) {
            if(map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        }

        int target = 15;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(); // number
            int value = entry.getValue(); // frequency

            Integer frequencyOfDiff = map.get(target-key);
            if(frequencyOfDiff != null) {
                count += frequencyOfDiff * value;
                map.put(target - key, 0);
            }

            map.put(key, 0);
        }

        System.out.println(count);

*/

        /*
           Type of interfaces ->
           1. Normal Interface
           2. Marker Interface -> No methods


           // to update a compiler about something

           // Serialisation -> store the contents of the object from heap to hard disk
           // Deserialisation -> fetching the contents from hard disk and adding to object


           3. Functional Interface {[SAM] - Single abstract method} -> with just one abstract method , but it can have any number of default methods




        // Lambda expression - only works with functional interfaces, because if you have multiple methods, compiler won't understand which method you are implementing
//        Runnable2 runnable2 = (i, j) -> i+j;
//        System.out.println(runnable2.add(1, 2));

        @FunctionalInterface
        public interface Runnable2 {
            int add(int a, int b);
        }


        Q-3 -> Given a list of integers and a value 'k', we need to find the kth largest number
        (1, 2, 3, 5, 7,10, 4, 8, 3, 2, 20);

        // O(n*logn + n) -> O(nlogn)
        //

        // Say k = 2

        //  max heap ->


        // Max Heap ->
        // The parent would be greater than its child

        heap = [1, 2, 3, 5]

        how the elements are inserted in a heap and how do we take them out?
        [1, 2, 3, 5]

           5
        3    2
       1


        Brute force approach -> Sort and find list[n-k] -> O(nlogn)

        // Max heap - size N
        // O(nlogn)


        // MinHeap - size k

        (1, 2, 3, 5, 7, 10, 4, 8, 3, 2, 20);

        kth largest element

        jth index = [minHeap = k largest elements till jth index]
        j = n => minHeap = k largest elements till nth index


        20, 10, 8, 7 ->

        7
      8  10
     20

        int k = 4;
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 7,10, 4, 8, 20);




//        Comparator<Integer> integerComparator = Comparator.comparingInt(s -> s);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, integerComparator);

        for(Integer el : list) {
            if(pq.size() == k && pq.peek() < el) {
                pq.poll();
                pq.offer(el);
            } else {
                pq.offer(el);
            }
        }

        System.out.println(pq.peek());
*/
//
//        Person person1 = new Person("Raj");
//        Person person2 = new Person("Raj");
//
//        System.out.println(person1);



        //Static keyword

// variable or a method is static -> it belongs to the class
// We can call them directly with class name


        // Singleton Design Pattern -> when we want to restrict to create one instance of a class

        // Logger, error manager, DB connection
//        SingletonDP singletonDP1 = SingletonDP.getInstance();
//        System.out.println(singletonDP1.config);

    }

}

//Singleton Design Pattern

// 1. Eager Initialisation, use it when the class is light or its guaranteed that you will use this class
// class SingletonDP {
//    String config;
//    private static SingletonDP obj = new SingletonDP("hd");
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    public static SingletonDP getInstance() {
//        return obj;
//    }
//}


//2. Classic Implementation -> not thread safe
//class SingletonDP {
//    String config;
//    private static SingletonDP obj;
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    public static SingletonDP getInstance() {
//        if(obj == null)
//            obj = new SingletonDP("s");
//        return obj;
//    }
//}

//3. Using synchronised keyword
//class SingletonDP {
//    String config;
//    private static SingletonDP obj;
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    synchronized public static SingletonDP getInstance() {
//        if(obj == null)
//            obj = new SingletonDP("s");
//        return obj;
//    }
//}
// obj = null t1 -> put a lock,  enters => obj == null => create an obj
// obj != null t1 -> put a lock , enters => get the obj
// obj != null



// 4.Doubled checked locking
//class SingletonDP {
//    String config;
//    private static SingletonDP obj;
//    private SingletonDP(String config) {
//        this.config = config;
//    }
//
//    public static SingletonDP getInstance() {
//        if(obj == null) {
//            synchronized (SingletonDP.class) {
//                if (obj == null) obj = new SingletonDP("hdd");
//            }
//        }
//        return obj;
//    }
//}
// obj = null t1 -> put a lock,  enters => [obj == null] => create an obj
// obj != null t1 -> get the obj
// obj != null t1-> get the obj

