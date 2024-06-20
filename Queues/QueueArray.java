// Implementing Queue data structure using arrays without using any inbuilt methods

// Operations available on my Queue data structure
// 1. IsEmpty
// 2. Enqueue
// 3. Dequeue
// 4. Display
// 5. Peek

class Queues{
    static int arr[];
    static int rear;
    static int front;
    static int capacity;

    public Queues(int cap){
        capacity = cap;
        rear=0;
        front=0;
        arr = new int[capacity];
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void Enqueue(int data){
        if(rear==capacity){
            System.out.println("The queue is at max parimal");
            return;
        }

        arr[rear] = data;
        rear = rear + 1;
    }

    public int Dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty parimal");
            return -1;
        }

        int value = arr[0];
        for(int i=front; i<rear-1; i++){
            arr[i] = arr[i+1];
        }

        if(rear<capacity){
            arr[rear--]=0;
        }
        return value;
    }

    public void Display(){
        if(isEmpty()){
            System.out.println("Queue is empty parimal");
            return;
        }
        for(int i=0; i<rear; i++){
            System.out.print(arr[i]+"<--");
        }
        System.out.println();
    }

    public int Peek(){
        if(isEmpty()){
            System.out.println("Queue is empty parimal");
            return -1;
        }

        return arr[0];
    }

}
public class QueueArray {
    public static void main(String[] args) {
        Queues queue = new Queues(10);
        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);
        queue.Enqueue(40);

        queue.Display();

        queue.Dequeue();
        queue.Dequeue();

        queue.Display();

        queue.Enqueue(50);
        queue.Enqueue(60);

        queue.Display();

    }
}
