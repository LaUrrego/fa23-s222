import java.util.List;
import java.util.ArrayList; // import the ArrayList class

public class LinkedListDeque<T> implements Deque<T> {

    private class Node {
        public T item;
        public Node next;
        public Node prev;

        private Node(T i, Node n, Node p){
            // i = item, n = next Node, p = previous Node
            this.item = i;
            this.next = n;
            this.prev = p;

        }

    }

    private int size;
    public Node sentinel;

    public LinkedListDeque(){
        this.size = 0;
        this.sentinel = new Node(null, null, null);
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;

    }
    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x, null, null);
        this.sentinel.next.prev = newNode;
        this.sentinel.next = newNode;
        newNode.prev = this.sentinel;
        this.size ++;

    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, null, null);
        newNode.prev = this.sentinel.prev;
        newNode.prev.next = newNode;
        newNode.next = this.sentinel;
        this.sentinel.prev = newNode;
        this.size ++;


    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node node = this.sentinel.next;
        for(int i = this.size; i > 0; i--){
            returnList.add(node.item);
            node = node.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        if(index >= this.size || index < 0){
            return null;
        }
        Node node = this.sentinel.next;

        for(int i = 0; i < index; i++ ){
            node = node.next;
        }
        return node.item;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
