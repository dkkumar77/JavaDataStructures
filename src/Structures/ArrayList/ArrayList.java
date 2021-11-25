package Structures.ArrayList;

public class ArrayList<T> {


    private final static int DEFAULT_SIZE = 10;
    T [] array;
    int MAX_SIZE;
    int elementCount;

    public ArrayList(){
        this(DEFAULT_SIZE);
    }
    public ArrayList(int length){
        try {
            if (length >= 1) {
                this.MAX_SIZE = length;
                this.elementCount = 0;
                this.array = (T[]) new Object[length];
            }
            else {
                throw new InvalidArrayLengthException();
            }
        }
        catch(InvalidArrayLengthException e){}
    }

    public void add(T object){
        if(elementCount == MAX_SIZE) {
            expandArray();

        }
        array[elementCount] = object;
    }

    public boolean exists(T object){
        for(T items : array){
            if(object.equals(items)){
                return true;
            }
        }
        return false;
    }

    public boolean search(T val){

        return !exists(val) ? false : true;

    }

    private void expandArray() {
        T[] deepCopy = (T[]) new Object[this.MAX_SIZE*2];
        System.arraycopy(array,0,deepCopy,0, elementCount);
        MAX_SIZE= deepCopy.length;
        array = deepCopy;
    }

    public int instanceCount(T object){
        int instance = 0;

        for(T items : array){
            if(object.equals(items)){
                instance++;
            }
        }
        return instance;


    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        int count = 0;
        for(T value : array){
            if(count == elementCount){
                break;
            }
            string.append(value + " ");
            count++;
        }

        return "[ " + string.toString() + "]";

    }



}
