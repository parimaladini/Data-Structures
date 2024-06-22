

import java.util.Scanner;
public class ParimalLinkedList{
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    public static Node Head;
    public static Node Tail;
    public static int size;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(Head==null){
            Head=Tail=newNode;
            return;
        }

        newNode.next = Head;
        Head = newNode;
    }

    public static void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(Head==null){
            Head=Tail=newNode;
            return;
        }

        Tail.next = newNode;
        Tail = newNode;
    }

    public static int removeFirst(){
        if(size==0){
            return -1;
        }

        else if(size==1){
            int val = Head.data;
            Head=Tail=null;
            size--;
            return val;
        }

        int val = Head.data;
        Head = Head.next;
        size--;

        return val;
    }

    public static int removeLast(){
        if(size==0){
            return -1;
        }

        else if(size==1){
            int val = Head.data;
            Head=Tail=null;
            size--;
            return val;
        }

        Node temp = Head;
        while(temp.next!=Tail){
            temp = temp.next;
        }

        int val = Tail.data;
        temp.next=null;
        size--;
        Tail = temp;
        return val;
    }

    public static void Display(){
        Node temp = Head;
        while(temp!=null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void addData(int data, int idx){
        Node newNode = new Node(data);
        size++;

        if(Head==null){
            addFirst(data);
            return;
        }

        Node temp = Head;
        for(int i=2; i<idx; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Operations available: " +
                "\n 1. Add the element in the beginning of the LinkedList" +
                "\n 2. Add the element in the end of the LinkedList" +
                "\n 3. Remove the first element from the LinkedList" +
                "\n 4. Remove the last element from the LinkedList" +
                "\n 5. Print the size of the LinkedList" +
                "\n 6. Display all the elements in the LinkedList" +
                "\n 7. Add an element at a specified index in the LinkedList" +
                "\n 8. Parimal EXIT!!");

        while(true){

            System.out.println("Enter the operation no: ");

            int no = sc.nextInt();
            boolean flag = false;

            switch(no){

                case 1:
                    System.out.println("Enter the data you want to add at the beginning: ");
                    int value1 = sc.nextInt();
                    addFirst(value1);
                    break;

                case 2:
                    System.out.println("Enter the data you want to add at the end: ");
                    int value2 = sc.nextInt();
                    addLast(value2);
                    break;

                case 3:
                    int value3 = removeFirst();
                    System.out.printf("\n The First Element %d has been removed.. \n", value3);
                    break;

                case 4:
                    int value4 = removeLast();
                    System.out.printf("\n The Last Element %d has been removed.. \n", value4);
                    break;

                case 5:
                    System.out.println("The current size of the LinkedList is: " + size);
                    break;

                case 6:
                    Display();
                    break;

                case 7:
                    System.out.println("Enter only the value: ");
                    int value7 = sc.nextInt();
                    System.out.println("Enter the index: ");
                    int index = sc.nextInt();
                    addData(value7, index);
                    break;

                case 8:
                    System.out.println("Thank-You Parimal:)");
                    flag = true;
                    break;

                default:
                    System.out.println("Enter a valid operation");

            }

            if(flag){
                break;
            }
        }

    }

}