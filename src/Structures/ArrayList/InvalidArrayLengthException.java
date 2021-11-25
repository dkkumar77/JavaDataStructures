package Structures.ArrayList;

public class InvalidArrayLengthException extends RuntimeException{

    public InvalidArrayLengthException() {
        System.out.println("Array size must be greater or equal to one");
    }
}
