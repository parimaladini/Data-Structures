// Implementing queue using LinedList without us

class Queue{
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node Head;
    public static Node Tail;

    public boolean isEmpty(){
        return Head==null && Tail==null;
    }

    public void Enqueue(int data){
        Node newNode = new Node(data);
        if(Tail==null){
            Head = Tail = newNode;
            return;
        }

        Tail.next = newNode;
        Tail = newNode;

    }

    public int Dequeue(){
        if(Head==null){
            System.out.println("Queue is empty Parimal");
            return -1;
        }

        int val = Head.data;
        Head = Head.next;

        return val;
    }

    public void Display(){
        if(isEmpty()){
            System.out.println("Queue is empty Parimal");
            return;
        }
        Node temp = Head;
        while(temp!=null){
            System.out.print(temp.data+"<--");
            temp = temp.next;
        }
        System.out.println();
    }

}
public class QueueLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
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
