public class Person {

    int id;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String name;


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize invoked");
    }

    public static void main(String[] args) {
        Person p1 = new Person(1223, "gaj");
        p1 = null;
        System.gc();
    }



}
