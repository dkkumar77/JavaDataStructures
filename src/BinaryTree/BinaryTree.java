package BinaryTree;

public class BinaryTree<T> {
    private static class Node<T>{

        protected T data;
        public Node<T> left, right;

        public Node(T data){
            this(data, null, null);

        }
        public Node(T data, Node<T> left, Node<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public T getData(){
            return data;
        }

        public Node<T> getLeft(){
            return left;
        }
        public Node<T> getRight(){
            return right;
        }

        public void setData(T data){
            this.data = data;

        }

        public void setRight(Node<T> right){
            this.right = right;
        }

        public void setLeft(Node<T> left){
            this.left = left;
        }
    }


    Node<T> root;


    BinaryTree(){
        this(null,null,null);
    }

    BinaryTree(T data){
        this.root = new Node<T>(data);

    }



    BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right){
        this.root = new Node<T>(data);
        root.setLeft(left.root);
        root.setRight(left.root);

    }




}
