import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


//class Counter{
//    int count = 0;
//    public synchronized void increment() {
//        count++;
//    }
//}

class Container<name> {
     name value;
    public name getValue() {
        return value;
    }

    public void setValue(name value) {
        this.value = value;
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {

//        Thread.currentThread().setDaemon(true);

//        Test test = new Test();
//        test.start();
//
//        Test1 test1 = new Test1();
//        test1.start();
//
//        test.join();
//        test1.join();

//        System.out.println("Main thread");

        //      M
        //    /   \
        // T1      T2



//        test.setPriority(10);
//
//        for(int i = 0; i < 1000; i++) {
//            Thread.yield();
//            System.out.println(Thread.currentThread().getName() + "- " + i);
//        }


//        Counter c = new Counter();
//
//        Runnable obj1 = () -> {
//            for(int i = 0; i < 1000; i++) {
//                c.increment();
//            }
//        };
////
//        Runnable obj2 = () -> {
//            for(int i = 0; i < 1000; i++) {
//                c.increment();
//            }
//        };
//
//        Thread t1 = new Thread(obj1);
//        Thread t2 = new Thread(obj2);
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println(c.count);




        // count = 723
        // t1-> reads -> 723 => 724
        // t2 -> reads -> 723 => 724


//        Thread t1 = new Thread(obj1);
//        t1.setDaemon(true);
//        t1.start();


//        System.out.println("Parent Thread");


        // 1 - We have to create Daemon before starting the thread
        // 2 - We cannot create main thread as a daemon thread

        //Race condition


//        System.out.println(Thread.currentThread().getPriority());
//
//      Test test = new Test();
//      Test2 test2 = new Test2();
//      test.start();
//
//
//
//      test2.start();


      // priority -> 1-10 => default -> 5, 10 = highest priority, 1 -> minPriority
    // Threads are difficult to manage


        //Daemon threads -> Runs in the background of a given thread and acts as a service provider
        // Ex -> Garbage collection

        // yield = stop the execution of current executing thread and give a chance to other threads for execution

//        Thread.yield();

        // yield, join



//        long start = System.currentTimeMillis();
//        IntStream.range(0, 100000).forEach(n->System.out.print(n));
//        long endTime = System.currentTimeMillis();
//        System.out.println();
//
//        System.out.println("Time:" + (endTime-start));
//        System.out.println("==============");
//
//        start = System.currentTimeMillis();
//        IntStream.range(0, 100000).parallel().forEach(n->System.out.print(n));
//        System.out.println();
//        endTime = System.currentTimeMillis();
//
//        System.out.println("Time:" + (endTime-start));

//        IntStream.range(1,10).forEach(x->{
//            System.out.println("Sequential Thread : "+Thread.currentThread().getName()+" : "+x);
//        });
//
//        IntStream.range(1,10).parallel().forEach(x->{
//            System.out.println("Parallel Thread : "+Thread.currentThread().getName()+" : "+x);
//        });


//        List<Employee> employees = EmployeeDatabase.addEmployee();
//
//        //normal
//        long start=System.currentTimeMillis();
//        double salaryWithStream = employees.stream()
//                .map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
//        long end=System.currentTimeMillis();
//
//        System.out.println("Normal stream execution time : "+(end-start)+" : Avg salary : "+salaryWithStream);
//
//        start=System.currentTimeMillis();
//        double salaryWithParallelStream = employees.parallelStream()
//                .map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
//
//        end=System.currentTimeMillis();
//
//        System.out.println("Parallel stream execution time : "+(end-start)+" : Avg salary : "+salaryWithParallelStream);
//
//
//
//
//
//        HashMap m = new HashMap(17);

//        1 << 4
//        10000 => 16

//        2^32 =>

        // 2^32 => 2^32/2 => 2^31

//        =>2^31-1
//       2^32 =>  Integer => -2^31 to 2^31-1 (zero)

//        MAXIMUM_CAPACITY = 1 << 30 => 2^30


        // 3 ->


//        % =>

//        key = "randomString" => h(key) => 20 % size => (4)
//            key = "random2" => h



//        map.put("random3", "modifiedValue")
//         map.get("randomString")

//        map.put("", "")


//        0->
//        1-> [random2, value2]
//        2->
//        3->
//        4 -> [randomString, value], [random3, value], [], [], [], []
//        5
//        6
//        7
//        8
//        9







        // 25 ->

        // 1, 2, 4, 8, 16, 32


        // 16


        // 0 ->
        // 1 ->
        // 2 ->
        // 3 ->
        // 4 ->
        // 5 ->



        // GENERICS ->




//        List<Integer> values = new ArrayList();
//        values.add(10);
//        values.add(16);
//        values.add("str");
//        values.add(17);
//        values.add(16);
//
//
//        for(int i = 0; i < values.size(); i++) {
//            System.out.println(Integer.parseInt(values.get(i).toString()));


//        }

        Container<Integer> container = new Container();
        container.setValue(188);
        System.out.println(container.getValue());



        // 1. Type safety => knowing the type before using it
        // Handling the compile time error is better than handling the run time errors
        // Individual type casting is not required

//        ArrayList<Integer> s1 = new ArrayList<>();
//        String s = s1.get(0);














    }



}



// How to implement thread in JAVA
// LIFE CYCLE OF A THREAD
// Join, interrupt, SLEEP, RUN, START, ISDAEMON, PRIORITY
// Synchronisation


// Multitasking -> doing multiple tasks/process/job at the same time
// Context Switching -> process which involves switching of CPU from one process to another , the process which is running is suspended and other proces which might be in some ready state will be picked up

// Multiprocessing -> More than one processor

// Multithreading -> Executing multiple threads at a single time (more than one core -> quad core, dual core etc)
// Threads -> Lightweight sub process, small task in a big process
// share address sPACE, SHARE MEMORY, CONTEXT SWITCHING IS FASTER, THREAD CREATION TAKES LESS TIME

// Program -> Process (Running program) -> Threads

//VLC player -> music, video, progress bar, the timer


// 2 WAYS TO CREATE A THREAD -
//1.  EXTENDING THREAD CLASS
//2. IMPLEMENTING RUNNABLE INTERFACE


//Lifecycle of thread ->
// State -1- > Creation of new thread
// State - 2 -> Runnable (Scheduler will pick up based on algo, JVM will allocate the processor)
// State - 3 -> Running state

// State-4 -> Non runnable states -> sleep(), waiting, yield()

// State - 5 -> Dead (stop() or  once the work is done



//  test.setPriority(10);
// Thread.sleep
// Parallel stream
//HashMap Implementation
// Join


// Generic

