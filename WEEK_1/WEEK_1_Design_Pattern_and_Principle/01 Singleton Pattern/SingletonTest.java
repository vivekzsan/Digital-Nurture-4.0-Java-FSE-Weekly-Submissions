public class SingletonTest {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("First log message");
        l2.log("Second log message");

        if (l1 == l2) {
            System.out.println("Only one instance exists. Singleton is working.");
        } else {
            System.out.println("Multiple instances created. Singleton failed.");
        }
    }
}

