package Assignment.Ass9;

public class VisitorTrackingSystem {

    private class Node {
        private Visitor data;
        private Node left;
        private Node right;

        private Node(Visitor data) {
            this.data = data;
        }
    }

    private Node root;

    public void add(Visitor vst) {
        root = addHelper(root, vst);
    }

    /**
     * Recursively inserts a visitor, maintaining a sorted tree
     */
    private Node addHelper(Node current, Visitor vst) {
        if (current == null) {
            return new Node(vst);
        }
        int comp = Integer.compare(vst.getBadgeNumber(), current.data.getBadgeNumber());
        if (comp < 0) {
            current.left = addHelper(current.left, vst);
        } else if (comp > 0) {
            current.right = addHelper(current.right, vst);
        }
        return current;
    }

    public Visitor search(int badgeNumber) {
        return searchHelper(root, badgeNumber);
    }

    /**
     * Recursively searches for a visitor by badge number
     */
    public Visitor searchHelper(Node current, int badgeNumber) {
        if (current == null) {
            return null;
        }
        int comp = Integer.compare(badgeNumber, current.data.getBadgeNumber());
        if (comp < 0) {
            return searchHelper(current.left, badgeNumber);
        } else if (comp > 0) {
            return searchHelper(current.right, badgeNumber);
        } else {
            return current.data;
        }

    }

    private Visitor deletedData;

    /**
     * Recursively removes node with matching badge number
     */
    //public method should return the Visitor (or void), & root must be updated.
    public Visitor remove(int badgeNumber) {
        deletedData = null; // reset tracker
        root = removeHelper(root, badgeNumber);
        return deletedData;
    }

    // This MUST return Node to update the parent's pointers
    private Node removeHelper(Node current, int badgeNumber) {
        if (current == null) {
            return null;
        }

        int comp = Integer.compare(badgeNumber, current.data.getBadgeNumber());

        if (comp < 0) {
            current.left = removeHelper(current.left, badgeNumber);
        } else if (comp > 0) {
            current.right = removeHelper(current.right, badgeNumber);
        } else {
            // Found the visitor! (comp == 0)
            deletedData = current.data;

            // Cases: No child or one child
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // Case 3: Two children
            // We find the Successor's data
            current.data = getRightMin(current.right);
            // We remove that Successor node from the right subtree
            current.right = removeHelper(current.right, current.data.getBadgeNumber());
        }
        return current;
    }

    // we already passed right, so from right look in to left side
    private Visitor getRightMin(Node current) {
        if (current.left == null) {
            return current.data; // Return the data
        }
        return getRightMin(current.left);

    }

    public void displayTree() {
        inOrderTraversal(root);
        System.out.println();
    }

    /**
     * Performs in‑order traversal, printing visitor data
     */
    private void inOrderTraversal(Node current) {
        if (current == null) {
            return;
        }
        inOrderTraversal(current.left);
        System.out.print(current.data.getName() + " "+current.data.getBadgeNumber()+" ");
        inOrderTraversal(current.right);

    }
    public int NumberOfVisitors(){
        return sizeHelper(root);
    }
    private int sizeHelper(Node current){
        if(current==null){
            return 0;
        }
        return 1+sizeHelper(current.left)+sizeHelper(current.right);
    }



    public static void main(String[] args) {
        VisitorTrackingSystem tree = new VisitorTrackingSystem();

        // Sample Input
        tree.add(new Visitor("Alice",50));
        tree.add(new Visitor("Bob",30));
        tree.add(new Visitor("Charlie",70));
        tree.add(new Visitor("Diana",20));
        tree.add(new Visitor("Evan",40));
        tree.add(new Visitor("Fiona",60));
        tree.add(new Visitor("George",80));

        System.out.println("Initial Tree:");
        tree.displayTree();

        // Task 1: Remove badge 20 (Leaf)
        tree.remove(20);
        System.out.println("\nAfter removing badge 20:");
        tree.displayTree();

        // Task 2: Remove badge 30 (One child)
        tree.remove(30);
        System.out.println("\nAfter removing badge 30:");
        tree.displayTree();

        // Task 3: Remove badge 50 (Root with two children)
        tree.remove(50);
        System.out.println("\nAfter removing badge 50:");
        tree.displayTree();

        // entry time
        Visitor v=tree.search(70);
        System.out.println("\nEntry time for badge 70 is: "+v.getEntryTime());

    }
}