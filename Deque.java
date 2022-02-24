import java.util.ArrayDeque;
import java.util.*;
public class Deque<Item> implements Iterable<Item> {
    private Node First,Last;
    int n;
    private class Node{
        Item data;
        Node next;
    }
    // construct an empty deque
    public Deque(){
        First=null;
        Last=null;
        n=0;
    }
    // is the deque empty?
    public boolean isEmpty(){
        if(First==null&&Last==null){
            return true;
        }
        else{
            return false;
        }
    }

    // return the number of items on the deque
    public int size(){
        return n;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item==null) throw new IllegalArgumentException();
            Node oldFirst=First;
            First=new Node();
            First.data=item;
            First.next=oldFirst;
            n=n+1;

    }

    // add the item to the back
    public void addLast(Item item){
        if(item==null) throw new IllegalArgumentException();
            Node oldLast=Last;
            Last=new Node();
            Last.data=item;
            oldLast.next=Last;
            n=n+1;

    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        Item item = First.data;
        First = First.next;
        n = n-1;
        return item; 
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(isEmpty()) throw new NoSuchElementException(); 
        
        if(First.next==null)
        { 
            Item item1 = First.data;
            Last=null; 
            First=null;
            n--;
            return item1; 
        } 
        else 
        { 
            Node temp= First; 
            while(temp.next!=Last) 
            { 
                temp=temp.next;
            } 
            Last=temp; 
            Last.next=null; 
            n--;
            return Last.data; 
        }     

    }
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new hasIterator();
    }
    public class hasIterator implements Iterator<Item>{
        Node temp = First;
        public boolean hasNext(){ 
            return temp != null; 
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item_1 = temp.data;
            temp = temp.next;
            return item_1;
        }
        public void remove() {
            throw new UnsupportedOperationException(); } 
    }

    // unit testing (required)
    public static void main(String[] args){
        // Scanner scan = new Scanner(System.in);
        Deque Deque1 = new Deque();
        Deque1.addFirst("sai");
        Deque1.addFirst("ram");
        Deque1.addFirst("456");
        Deque1.addFirst("123");
        System.out.println(Deque1.isEmpty());
        System.out.println(Deque1.size());
        System.out.println(Deque1.removeFirst());
        System.out.println(Deque1.removeLast());
    }
}

