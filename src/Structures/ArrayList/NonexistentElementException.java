package Structures.ArrayList;

public class NonexistentElementException extends RuntimeException{

    public NonexistentElementException() {
        System.out.println("Element does not exist inside of array.");
    }
}
