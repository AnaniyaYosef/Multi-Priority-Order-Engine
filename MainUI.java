import java.util.Scanner;

public class MainUI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderEngine engine = new OrderEngine();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Order");
            System.out.println("2. View Queues");
            System.out.println("3. Process One Step");
            System.out.println("4. Process All");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Order ID: ");
                    String id = sc.next();
                    System.out.print("Priority (1-5): ");
                    int p = sc.nextInt();
                    System.out.print("Items: ");
                    int items = sc.nextInt();
                    engine.addOrder(id, p, items);
                    break;

                case 2:
                    engine.viewQueues();break;
                case 3:
                    engine.processOneTick();
                    break;
                case 4:
                    engine.processAll();
                    return;
                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
