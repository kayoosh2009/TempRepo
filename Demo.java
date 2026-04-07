public class Demo {
    public static void main (String [] args) {
        Person p1 = new Person("Alice Levi", "0525551234", "HaShikma 12, Tel Aviv");
        Person p2 = new Person("Boris Cohen", "Herzl 5, Jerusalem", "0527778888");

        System.out.println(p1);
        System.out.println(p2);

        Package p3 = new Package(p1, 11112222);
        Package p4 = new Package(p1, 11112222);
        Package p5 = new Package(p2, 33334444);

        System.out.println(p3);
        System.out.println(p4);

        System.out.println("Package 1 == Package 2: " + p3.equals(p4));
        System.out.println("Package 1 == Package 2: " + p3.equals(p4));
    }
}