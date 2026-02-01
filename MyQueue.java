public class MyQueue {
    private Order[] data;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int capacity) {
        data = new Order[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void enqueue(Order order) {
        if (isFull()) {
            System.out.println("Queue full!");
            return;
        }
        rear = (rear + 1) % data.length;
        data[rear] = order;
        size++;
    }

    public Order dequeue() {
        if (isEmpty()) return null;
        Order temp = data[front];
        front = (front + 1) % data.length;
        size--;
        return temp;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.print(data[index].id + " ");
            index = (index + 1) % data.length;
        }
        System.out.println();
    }
}
