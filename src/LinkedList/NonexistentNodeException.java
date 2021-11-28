package LinkedList;

public class NonexistentNodeException extends RuntimeException{

    public NonexistentNodeException() {
        System.out.println("Element does not exist inside of LinkedList.");
    }
}
