package myspace;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BinaryTreeTest {


    private BinaryTree<String> binaryTree;
    private BinaryTree<Integer> rootBST;

    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree<String>("A", null);

        rootBST = new BinaryTree<>(5, null);

        rootBST.addLeftChild(3);
        rootBST.addRightChild(7);

        rootBST.getLeft().addLeftChild(1);
        rootBST.getLeft().addRightChild(4);

        rootBST.getRight().addLeftChild(6);
        rootBST.getRight().addRightChild(8);
    }

    @Test
    public void getRoot() throws Exception {
        BinaryTree<String> rootNode = binaryTree.getRoot();
        assertEquals(
                "Check root",
                "A",
                rootNode.getValue()
                );
    }

    @Test
    public void addLeftChildTest(){
        BinaryTree<String> leftNode = binaryTree.addLeftChild("Left Child");

        assertEquals("Check add left node child",
                "Left Child",
                leftNode.getValue()
                );
    }

    @Test
    public void addRightChildTest(){
        BinaryTree<String> rightNode = binaryTree.addLeftChild("Right Child");

        assertEquals("Check add right node child",
                "Right Child",
                rightNode.getValue()
        );
    }

    @Test
    public void preOrderTest(){
        System.out.println("\n=======PRE Order");
        rootBST.preOrder();
        System.out.println();
    }

    @Test
    public void postOrderTest(){
        System.out.println("\n=======POST Order");
        rootBST.postOrder();
        System.out.println();
    }

    @Test
    public void inOrderTest(){
        System.out.println("\n=======IN Order");
        rootBST.inOrder();
        System.out.println();
    }

    @Test
    public void levelOrderTest(){
        System.out.println("\n=======LEVEL Order");
        rootBST.levelOrder();
        System.out.println();
    }

    @Test
    public void containsTest(){
        assertEquals(
                "Check included int",
                true,
                rootBST.contains(6)
        );

        assertEquals(
                "Check excluded int",
                false,
                rootBST.contains(2)
        );
    }

    @Test
    public void addTest(){

        rootBST.add(2);

        assertEquals(
                "Check add data to BST",
                true,
                rootBST.contains(2)
        );

        rootBST.postOrder();
        System.out.println();

        rootBST.add(10);
        rootBST.postOrder();
        System.out.println();
        assertEquals(
                "Check same data doesn't added to the tree",
                false,
                rootBST.add(10)
        );
    }

}