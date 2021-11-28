package LinkedList;

import Structures.ArrayList.NonexistentElementException;

public class LinkedList<T>{

    private class Node<T> {

        Node<T> next;
        Node<T> previous;
        T data;

        Node() {
            this(null);

        }

        Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        private void setData(T data) {
            this.data = data;

        }

        private void setNext(Node<T> next) {
            this.next = next;

        }

        private void setPrevious(Node<T> previous) {
            this.previous = previous;

        }

        private T getData() {
            return this.data;

        }

        private Node<T> getNext() {
            return next;
        }

        private Node<T> getPrevious() {
            return previous;

        }

    }

        Node<T> front;
        Node<T> back;
        int nodeCount = 0;
        private final int STATUS_ZERO = 0x0;
        private final int STATUS_ONE = 0x1;

        LinkedList(){
            this.front = null;
            this.back = null;

        }
        LinkedList(T data){
            front = new Node<T>(data);
            back = front;
            nodeCount++;
        }

        public Node<T> getFront(){
            return this.front;
        }

        public Node<T> getBack(){
            return this.back;
        }

        public void add(T data){
            if(front == null) {
                front = new Node<>(data);
                back = front;
                nodeCount++;
            }
            else{
                Node<T> temporary = new Node<T>(data);
                back.next = temporary;
                temporary.setPrevious(back);
                back = temporary;
                nodeCount++;
            }
        }

        private void nullify(){
            this.front = null;
            this.back = null;
            this.nodeCount = 0;

        }
        public boolean delete(T data) throws NonexistentNodeException{
            try {
                if (search(data)) {
                    Node<T> temp = this.front;
                    if (temp.getData().equals(data)){
                        if(nodeCount == 1) {
                            nullify();
                        }
                        else {
                            front = front.next;
                            front.setPrevious(null);
                        }
                        nodeCount--;
                        return true;
                    }
                    if(this.back.getData().equals(data)){
                        back = this.back.getPrevious();
                        this.back.setNext(null);
                        nodeCount--;

                        return true;

                    }
                        temp = this.front;
                        while (temp != null) {
                            if (temp.next.getData().equals(data)) {
                                Node<T> link = temp.next.next;
                                link.setPrevious(null);
                                temp.setNext(link);
                                link.setPrevious(temp);
                                nodeCount--;
                                return true;
                            }
                            temp = temp.next;
                        }

                    }
                throw new NonexistentNodeException();
            } catch(NonexistentNodeException e ){}
            return false;

        }

        public boolean search(T data){
            Node<T> temporary = front;
            while((temporary != null)){
                if(temporary.getData().equals(data)){
                    return true;
                }
                temporary = temporary.next;
            }
            return false;
        }




    }

