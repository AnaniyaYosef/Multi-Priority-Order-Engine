public class Order {
    public String id;
    public int priority;
    public int arrivalTime;
    public int items;
    public int remainingTime;

    public Order(String id, int priority, int items, int arrivalTime) {
        this.id = id;
        this.priority = priority;
        this.items = items;
        this.arrivalTime = arrivalTime;
        this.remainingTime = (items + 1) / 2;
    }
}
