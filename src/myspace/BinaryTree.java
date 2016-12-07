package myspace;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<? super E>>{
    private E value;
    private BinaryTree<E> parent;
    private BinaryTree<E> left;
    private BinaryTree<E> right;
    private BinaryTree<E> root = null;

    public BinaryTree<E> getRoot() {
        return root;
    }


    public BinaryTree(E value, BinaryTree<E> parent) {
        this.value = value;
        this.parent = parent;

        this.left = null;
        this.right = null;

        if (root == null){
            root = this;
        }
    }

    public E getValue() {
        return value;
    }

    public BinaryTree<E> getParent() {
        return parent;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public BinaryTree<E> addLeftChild(E value) {
        this.left = new BinaryTree<E>(value, this);
        return this.left;
    }

    public BinaryTree<E> addRightChild(E value) {
        this.right = new BinaryTree<E>(value, this);
        return this.right;
    }

    // Pre Order Traverse: DFS
    private void preOrder(BinaryTree<E> node){
        if (node != null){
            node.visit();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void preOrder(){
        this.preOrder(root);
    }


    // Post Order Traverse: DFS
    private void postOrder(BinaryTree<E> node){
        if (node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            node.visit();
        }
    }

    public void postOrder(){
        this.postOrder(root);
    }


    // In Order Traverse
    private void inOrder(BinaryTree<E> node){
        if (node != null){
            inOrder(node.getLeft());
            node.visit();
            inOrder(node.getRight());
        }
    }

    public void inOrder(){
        this.inOrder(root);
    }

    // Level Order Traverse: BFS
    public void levelOrder(){
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTree node = queue.remove();
            if (node == null)
                break;
            node.visit();
            queue.add(node.getLeft());
            queue.add(node.getRight());
        }
    }


    private void visit() {
        System.out.print(getValue() + " ");
    }


    // Search in BST
    public boolean contains(E toFind){
        BinaryTree<E> curr = root;

        int comp;
        while (curr != null){

            comp = toFind.compareTo(curr.getValue());

            if (comp < 0)
                curr = curr.getLeft();
            else if (comp > 0)
                curr = curr.getRight();
            else
                return true;
        }

        return false;
    }


    public boolean add(E newValue) {
        BinaryTree<E> curr = root;

        int comp;
        while (true) {
            comp = newValue.compareTo(curr.value);
            if (comp < 0) {
                if (curr.getLeft() == null) {
                    curr.addLeftChild(newValue);
                    return true;
                } else
                    curr = curr.getLeft();
            } else if (comp > 0){
                if (curr.getRight() == null) {
                    curr.addRightChild(newValue);
                    return true;
                }
                else
                    curr = curr.getRight();
            }
            else
                return false;
        }
    }
}
