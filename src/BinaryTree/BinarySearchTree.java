package BinaryTree;


public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements BinarySearchTreeInterface{



    BinarySearchTree(T data) {
        super(data);

    }

    boolean add(T data) {

        return recursiveAddition(root, data) != null;
    }

    private Node<T> recursiveAddition(Node<T> root, T data) {
        if (root.getData().compareTo(data) > 0) {
            if (root.left == null) {
                root.setLeft(instantize(data));
            } else {
                recursiveAddition(root.left, data);
            }
        }
        if (root.getData().compareTo(data) <=0) {
            try {
                if (root.getData().equals(data)) {
                    throw new DuplicateNodeException();
                }
                else{
                    if (root.right == null) {
                        root.setRight(instantize(data));
                    } else {
                        recursiveAddition(root.right, data);
                    }
                }
            }
            catch(DuplicateNodeException e ){
                e.printStackTrace();
                return null;

            }

        }

        return null;
    }

    public int getHeight(){
        return super.getHeight();
    }

    private Node<T> instantize(T data){
        return new Node(data);

    }


}
