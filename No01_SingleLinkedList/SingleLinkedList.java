package No01_SingleLinkedList;

public class SingleLinkedList<T> {
    private class Node{
        T t;
        Node next;
        public Node(T t){
            this.t = t;
            this.next = null;
        }
    }
    private int size;
    private Node head;
    private Node tail;

    public SingleLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public void insert(T t){
        Node newNode = new Node(t);
        this.size++;
        if (head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    public void pop(){
        if (this.head == null){
            return;
        }
        this.head = this.head.next;
        this.size--;
        if (this.head == null){
            this.tail = null;
        }
    }
    public String toString(){
        String str = "head -> ";
        Node temp = this.head;
        while(temp != null){
            str += temp.t.toString() + " -> ";
            temp = temp.next;
        }
        str += "null";
        return str;
    }
    public T getHead() {
        return head.t;
    }
    public T getTail(){
        return tail.t;
    }
    public int getSize(){
        return size;
    }
    public int size(){
        return size();
    }



}

