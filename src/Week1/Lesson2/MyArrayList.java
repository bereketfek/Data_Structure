package Week1.Lesson2;

//A thread is a single path (flow) of execution in a program.
// thread-safe: multiple threads execution without errors.
//Vector<Integer> vec = new Vector<>();
//vec.add(10);   // automatically synchronized
//List<Integer> list =
//    Collections.synchronizedList(new ArrayList<>());// manually synchronized

public class MyArrayList<E> {

    private E[] elements;
    private int size;
    private int capacity;

    public MyArrayList(int capacity) {
        this.capacity = capacity;          // use this.capacity
        this.size = 0;
        elements = (E[]) new Object[capacity];
    }

    public boolean add(E data) {
        if (size == capacity) {
            reallocate();
        }
        elements[size++] = data;
        return true;
    }

    private void reallocate() {
        capacity = capacity * 2;
        E[] newArray = (E[]) new Object[capacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;

    }
    public int size(){
        return size;
    }
    public E get(int index){
        return elements[index];
    }
    public E remove(int index){
        E removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedElement;

    }
    public E set(int index, E element){
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }
    public static void main(String[] args) {



    }
}