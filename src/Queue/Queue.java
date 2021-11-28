package Queue;

import Structures.ArrayList.ArrayList;

public class Queue <T> extends ArrayList<T> {


    private static final int DEFAULT_SIZE = 10;

    Queue(){
        super(DEFAULT_SIZE);
    }



    public void add(T data){
        super.add(data);
    }

    public void remove(){
        this.deleteFirst();

    }

}
