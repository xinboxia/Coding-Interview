package SortAlgorithm;
/*
        Step 1: Take the elements input in an array.
        Step 2: Create a Binary search tree by inserting data items from the array into the
                binary search tree.
        Step 3: Perform in-order traversal on the tree to get the elements in sorted order.
 */

//  Time Complexity: Average O(nlogn),   Worst O(n^2)
//  Space Complexity: O(n)
//  How to improve?
//  Answer: Use self-balancing binary search tree such as Red Black Tree, AVL Tree

public class TreeSort {
    //define a class of Node
    public static class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    //root of BST
    public static Node root;
    //Constructor
    public TreeSort() {
        root = null;
    }
    //Method to call insertRec().
    public static void insert(int key) {
        root = insertRec(root ,key);
    }
    //Recursive function to insert a new key in BST.
    public static Node insertRec(Node root, int key) {
        //If tree is empty, return new Node
        if(root == null) {
            root = new Node(key);
            return root;
        }
        //Else, recur down the tree
        if(key < root.key) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    //Inorder traversal of the tree
    public static void inorderRec(Node root) {
        if(root != null) {
            inorderRec(root.left);
            System.out.println(root.key + " ");
            inorderRec(root.right);
        }
    }
    //Build a BST
    public static void buildBST(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
}
