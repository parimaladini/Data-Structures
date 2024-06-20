 // Implementing Queue using ArrayList;

import java.util.ArrayList;

class QueueA{
    static ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void Enqueue(int data){
        list.add(data);
    }

    public int Dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty Parimal");
            return -1;
        }

        int value = list.get(0);
        list.remove(0);
        return value;
    }

    public void Display(){
        if(isEmpty()){
            System.out.println("Queue is empty parimal");
            return;
        }

        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+"<--");
        }
        System.out.println();
    }

    public int Peek(){
        if(isEmpty()){
            System.out.println("Queue is empty parimal");
            return -1;
        }

        return list.get(0);
    }

}
public class QueueArrayList{
    public static void main(String[] args) {
        QueueA queue = new QueueA();
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