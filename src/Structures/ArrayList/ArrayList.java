package Structures.ArrayList;

public class ArrayList<T> {


    private final static int DEFAULT_SIZE = 10;
    T [] array;
    int MAX_SIZE;
    int elementCount;

    public ArrayList(){
        this(DEFAULT_SIZE);
    }


    public int getMax(){
        return MAX_SIZE;
    }

    public int getElementCount(){
        return elementCount;
    }

    @SuppressWarnings("unused")
    public T [] getArray(){
        return array;
    }


    /**
     *
     * @param length
     */
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
        elementCount++;
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



    public void delete(T value){

        try {
            if (exists(value)) {
                int index = 0;

                for(int i = 0;  i < array.length; i++){
                    if(array[i].equals(value))
                        break;
                    index++;

                }

                leftShift(index);


            }
            else {
                throw new NonexistentElementException();
            }
        }
        catch(NonexistentElementException e){

        }


    }

    private void leftShift(int index) {
        array[index] = null;
        for(int i = index; i < elementCount; i++){
            array[i] = array[i+1];
        }
        array[--elementCount] = null;


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
