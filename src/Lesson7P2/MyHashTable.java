package Lesson7P2;

public class MyHashTable {


    private static class Item {

        int key;
        String value;

        Item(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + " - " + value;
        }
    }
    // table size (always prime)
    private int capacity;
    private Item[] table;
    private final Item deleted;
    private int count;

    public MyHashTable(int capacity) {

        this.capacity = nextPrime(capacity);
        table = new Item[this.capacity];
        deleted = new Item(-1, null);
        count = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }
    /**
     * Stores a key‑value pair; rehashes when a load exceeds a threshold
     * rehash when a load factor stays below 75% full is recommended
     */
    public void put(int key, String value) {

        if ((double) count / capacity >= 0.75) {
            rehash();
        }
        int index = hash(key);

        while (table[index] != null &&
                table[index] != deleted) {

            // if we get the same key, replace value
            if (table[index].key == key) {
                table[index].value = value;
                return;
            }

            index = (index + 1) % capacity;//
        }
        table[index] = new Item(key, value);
        count++;
    }

    public String get(int key) {

        int index = hash(key);
        int start = index;

        // Searches table for a key until found or exhausted
        while (table[index] != null) {

            if (table[index] != deleted &&
                    table[index].key == key) {

                return table[index].value;
            }

            index = (index + 1) % capacity;

            if (index == start) break;
        }

        return null;
    }

    public String remove(int key) {

        int index = hash(key);
        int start = index;

        while (table[index] != null) {

            if (table[index] != deleted &&
                    table[index].key == key) {

                String val = table[index].value;

                table[index] = deleted;
                count--;

                return val;
            }

            index = (index + 1) % capacity;

            if (index == start) break;
        }

        return null;
    }

    public boolean contains(int key) {

        int index = hash(key);
        int start = index;

        while (table[index] != null) {

            if (table[index] != deleted &&
                    table[index].key == key) {

                return true;
            }

            index = (index + 1) % capacity;

            if (index == start) break;
        }

        return false;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void rehash() {

        int newCapacity = nextPrime(capacity * 2);
        MyHashTable newTable = new MyHashTable(newCapacity);

        for (Item item : table) {
            if (item != null && item != deleted) {
                newTable.put(item.key, item.value);
            }
        }

        this.table = newTable.table;
        this.capacity = newTable.capacity;
        this.count = newTable.count;
    }

    private int nextPrime(int n) {
        if (isPrime(n, 2)) return n;// start from divisor 2 (it is a prime number);
        return nextPrime(n + 1);
    }

    private boolean isPrime(int n, int divisor) {

        if (n <= 1) return false; //0,1 and negative numbers are not prime
        if (divisor * divisor > n) return true;// If divisor passed sqrt(n), n is prime
        if (n % divisor == 0) return false;// If divisible → not prime
        return isPrime(n, divisor + 1);
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null) {
                sb.append("null");
            }
            else if (table[i] == deleted) {
                sb.append("DELETED");
            }
            else {
                sb.append(table[i]);
            }

            if (i < table.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
    /**
     * Creates table; populates; prints string representation
     */

    static void main(String[] args) {

        MyHashTable hashTable = new MyHashTable(10);
        hashTable.put(1, "B");
        hashTable.put(2, "B");
        hashTable.put(3, "C");
        hashTable.put(4, "D");
        hashTable.put(3, "F");
        hashTable.put(11, "G");
        System.out.println(hashTable);
        System.out.println(hashTable.get(3));
        System.out.println(hashTable.remove(3));
        System.out.println(hashTable);
        System.out.println(hashTable.contains(3));
        System.out.println(hashTable.size());
        System.out.println(hashTable.isEmpty());


    }
}
