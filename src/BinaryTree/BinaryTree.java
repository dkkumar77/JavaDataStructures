package BinaryTree;

public class BinaryTree<T> {
    public static class Node<T>{

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

        public int getHeight(){
            return getHeight(this);
        }
        private int getHeight(Node<T> node)
        {
            int height = -1;
            if (node != null)
                height = 1 + Math.max(getHeight(node.getLeft()),getHeight(node.getRight()));

            return height;
        }

        public int getNumberOfNodes()
        {
            int leftNumber = 0;
            int rightNumber = 0;
            if(this==null)
                return 0;
            if (left != null)
                leftNumber = left.getNumberOfNodes();

            if (right != null)
                rightNumber = right.getNumberOfNodes();

            return 1 + leftNumber + rightNumber;
        } // end getNumberOfNodes
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

    public Node<T> getRoot(){
        return root;

    }

    public T getRootData(){
        return root.getData();
    }

    public int getHeight(){
        return root.getHeight();

    }

}
