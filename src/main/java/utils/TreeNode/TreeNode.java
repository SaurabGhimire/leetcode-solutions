package utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int value;
    TreeNode left;

    TreeNode right;

    TreeNode(int value){this.value = value;}

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createADefaultTreeNode(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return  root;
    }

    public static TreeNode createTreeNodeFromIntArray(int[] arr){
        if(arr.length == 0) return  null;
        if(arr.length == 1) return  new TreeNode(arr[0]);
        TreeNode root = new TreeNode(arr[0]);
        for(int i=1;i<arr.length;i++){
            addNode(root, arr[i]);
        }
        traverseTree(root);
        return root;
    }

    static void addNode(TreeNode node, int value){
        if(node.left == null){
            node.left = new TreeNode(value);
        }
        node.right = new TreeNode(value);
    }

    static void traverseTree(TreeNode root){
        if(root == null) return;
        traverseTree(root.left);
        System.out.println(root.value);
        traverseTree(root.right);
    }

    public static  void breadthFirstSearch(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Enqueue the root node

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Dequeue the current node
            System.out.print(current.value + " "); // Process the current node

            // Enqueue the left child if it exists
            if (current.left != null) {
                queue.offer(current.left);
            }

            // Enqueue the right child if it exists
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
}
