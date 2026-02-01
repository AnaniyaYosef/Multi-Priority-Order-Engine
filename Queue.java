
public class Queue {
    private OrderEngine.Order[] data;
    private int front;
    private int rear;
    private int size;

    public Queue(int QueueSize) {
        data = new OrderEngine.Order[QueueSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty(){
        if(size == 0){return true;}
        return false;
    }
    public boolean isFull(){
        if(size == data.length){return true;}
        return false;
    }
    public void enqueue(OrderEngine.Order order){
        if(isFull()){
            System.out.println("Queue is Full");
        }

        rear = (rear +1)% data.length;
        data[rear] = order;
        size++;
    }
    public OrderEngine.Order dequeue(){
        if(isEmpty()){
            return null;
        }
        OrderEngine.Order temp = data[front];
        front = (front +1) % data.length;
        size--;
        return temp;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Queue is Empty.");
            return;
        }
        int tempFront = front;
        for(int i = 0;i < size;i++){
            System.out.println(data[tempFront].id);
            tempFront = (tempFront+1)%data.length;
        }
    }
    
}
