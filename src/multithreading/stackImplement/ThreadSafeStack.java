package multithreading.stackImplement;

class Node<T>{
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class ThreadSafeStack <T>{
    private Node<T> top;

    public ThreadSafeStack() {
        this.top = null;
    }

    synchronized void push(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + data);
    }

    synchronized T pop(){
        if(top == null){
            System.out.println("Stack is empty!");
            return null;
        }
        T data = top.data;
        top = top.next;
        System.out.println("Popped: " + data);
        return data;
    }

    synchronized boolean isEmpty(){
        return top == null;
    }
}
