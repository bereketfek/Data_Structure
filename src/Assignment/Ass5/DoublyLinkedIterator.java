package Assignment.Ass5;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedIterator<E> implements Iterable<E> {

    /**
     * iterator() is a method that returns an object typed as Iterator<E>
     * forward only: have hasNext() and next()*/

    @Override

    public Iterator<E> iterator() {
        return new DLLIterator();
    }
    /**
     * listIterator() is a manual method that returns an object typed as ListIterator<E>
     * it is bidrectional due to having extra methods
     * both methods return same objects coz DLLIterator implements both interfaces
     * purpose of two methods: enhabced loop does not work without an Iterator interface
     */

    public ListIterator<E> listIterator() {
        return new DLLIterator(); }

    private class DLLIterator implements ListIterator<E> {

        //in the beginning hasNext conceptually before the head

        private Node next = head;
        private Node lastReturned = null;// node returned recently by next() or previous()
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        /**
         * Determines if a previous element exists in a list
         * next==null means we passed the last element.
         */
        @Override
        public boolean hasPrevious() {
            return next == null || next.prev != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();

            if (next == null) {
                next = tail;
            } else {
                next = next.prev;
            }

            lastReturned = next;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        /**
         * Implements list removal by relinking nodes and adjusting state
         */
        @Override
        public void remove() {
            if (lastReturned == null) throw new IllegalStateException();

            Node prev = lastReturned.prev;
            Node nextNode = lastReturned.next;

            if (prev == null) head = nextNode;
            else prev.next = nextNode;

            if (nextNode == null) tail = prev;
            else nextNode.prev = prev;

            if (next == lastReturned) next = nextNode;
            else nextIndex--;

            size--;
            lastReturned = null;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null) throw new IllegalStateException();
            lastReturned.data = e;
        }

        @Override
        public void add(E e) {
            Node newNode = new Node(e);
            Node prev = (next == null) ? tail : next.prev;

            newNode.next = next;
            newNode.prev = prev;

            if (prev == null) head = newNode;
            else prev.next = newNode;

            if (next == null) tail = newNode;
            else next.prev = newNode;

            nextIndex++;
            size++;
            lastReturned = null;
        }
    }

    private class Node {
        private E data;
        private Node prev;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds element at index by relinking nodes
     */
    public void add(int index, E element) {
        validateIndex(index);

        if (index == 0) {
            addFirst(element);
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;

        Node newNode = new Node(element);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    public E removeFirst() {
        if (head == null) return null;

        E data = head.data;
        head = head.next;

        if (head != null) head.prev = null;
        else tail = null;

        size--;
        return data;
    }

    public E removeLast() {
        if (tail == null) return null;

        E data = tail.data;
        tail = tail.prev;

        if (tail != null) tail.next = null;
        else head = null;

        size--;
        return data;
    }

    /**
     * Removes element at index; handles edge cases
     */
    public E remove(int index) {
        validateIndex(index);

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;

        E data = current.data;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
        return data;
    }

    public E get(int index) {
        validateIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public E set(int index, E element) {
        validateIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;

        E old = current.data;
        current.data = element;
        return old;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

