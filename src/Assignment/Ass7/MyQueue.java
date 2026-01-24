package Assignment.Ass7;

import java.util.Queue;

public interface MyQueue <E> {
    void enqueue(E e);
    E dequeue();
    E peek();
    boolean isEmpty();

}
