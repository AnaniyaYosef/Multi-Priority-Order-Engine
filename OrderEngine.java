public class OrderEngine{
    private Queue queue;
    private int currentTime = 0;
    private int maxWait = 5;
    private Order currentOrder = null;



    public static class Order {
        String id;
        int priority;
        int arrivalTime;
        int item;
        int remainingTime;

        public Order(String id,int priority, int item,int arrivalTime){
            this.id = id;
            this.priority = priority;
            this.item = item;
            this.arrivalTime = arrivalTime;
            this.remainingTime = (item+1/2);
        }

        
    } 
    
    
}