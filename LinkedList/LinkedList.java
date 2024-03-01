public class LinkedList{
    class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add an element in the beginning of the linked list.
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //add an element at the end of the linked list.
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    //add an element at the middle of the linked list by specifying the index.
    public void add(int idx, int data){
        if(head==null){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove the first element from the linked list.
    public int removeFirst(){

        if(size==0){
            System.out.println("The Linked List Is Empty :<");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Remove the last element from the linked list
    public int removeLast(){
        if(size==0){
            System.out.println("Linked List is Empty :<");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }

        Node temp = head;
        for(int i=0; i<size-1; i++){
            temp = temp.next;
        }
        int val=tail.data;
        temp.next = null;
        tail = temp;
        return val;
    }

    //print the elements in the linked list
    public void printLL(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }

    //Interative approach to find an element; it returns the index of that element if found.
    public int itrSearch(int idx){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data==idx){
                return i;
            }
            i++;
        }

        return -1;
    }

    //Recursive approach to find an element; it returns the index of that element if found.
    public int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        else if(head.data==key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx==-1){
            return -1;
        }

        return idx+1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }
    


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();


    }
}