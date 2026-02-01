public class OrderEngine {

    private MyQueue[] queues;
    private int currentTime = 0;
    private int maxWait = 5;
    private Order currentOrder = null;

    public OrderEngine() {
        queues = new MyQueue[6]; 
        for (int i = 1; i <= 5; i++) {
            queues[i] = new MyQueue(50);
        }
    }

    private boolean isIdDuplicate(String id) {
        if (currentOrder != null && currentOrder.id.equals(id)) {
            return true;
        }

        for (int p = 1; p <= 5; p++) {
            MyQueue q = queues[p];
            int index = q.getFront();
            for (int i = 0; i < q.getSize(); i++) {
                if (q.getData()[index].id.equals(id)) {
                    return true;
                }
                index = (index + 1) % q.getData().length;
            }
        }

        return false; 
    }

    public void addOrder(String id, int priority, int items) {
        if (isIdDuplicate(id)) {
            System.out.println("Error: Order ID already exists!");
            return;
        }
        
        Order o = new Order(id, priority, items, currentTime);
        queues[priority].enqueue(o);
        System.out.println("Order " + id + " added at priority " + priority);
    }

    public void viewQueues() {
        for (int i = 5; i >= 1; i--) {
            System.out.print("Priority " + i + ": ");
            queues[i].display();
        }
    }

    public void processOneTick() {
        currentTime++;
        if (currentOrder != null) {
            currentOrder.remainingTime--;
            if (currentOrder.remainingTime == 0) {
                System.out.println("Order " + currentOrder.id + " completed");
                currentOrder = null;
            }
        }

        if (currentOrder == null) {
            for (int p = 5; p >= 1; p--) {
                if (!queues[p].isEmpty()) {
                    currentOrder = queues[p].dequeue();
                    System.out.println("Processing " + currentOrder.id);
                    break;
                }
            }
        }
    }

    public void processAll() {
        while (true) {
            boolean allEmpty = true;
            for (int p = 1; p <= 5; p++) {
                if (!queues[p].isEmpty()) {
                    allEmpty = false;
                    break;
                }
            }

            if (allEmpty && currentOrder == null) {
                System.out.println("All orders processed!");
                break;
            }
            processOneTick();
        }
    }



}
