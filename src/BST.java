import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Logan
 * @version: 12/9/24
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // return results of helper variable
        return searchHelper(root, val);
    }

    public boolean searchHelper(BSTNode node, int val) {
        // If the val is not in the tree
        if (node == null) {
            return false;
        }
        // If the val is in the tree
        if (node.getVal() == val){
            return true;
        }
        // Use recursion depending on direction from the node (Bc of val)
        if (val > node.getVal()){
            return searchHelper(node.getRight(), val);
        }
        else {
            return searchHelper(node.getLeft(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // Create a list to return
        ArrayList <BSTNode> list = new ArrayList<BSTNode>();
        // Add to list from Helper
        getInorderHelper(root, list);
        return list;
    }

    public void getInorderHelper(BSTNode node, ArrayList<BSTNode> list) {
        // If node exists
        if (node != null) {
            // Add in left root right
            getInorderHelper(node.getLeft(), list);
            list.add(node);
            getInorderHelper(node.getRight(), list);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // Create a list to return
        ArrayList <BSTNode> list = new ArrayList<BSTNode>();
        // Add to list using helper function
        getPreorderHelper(root, list);
        return list;
    }

    public void getPreorderHelper (BSTNode node, ArrayList<BSTNode> list) {
        // If the node exists
        if (node != null) {
            // Add in root left right
            list.add(node);
            getPreorderHelper(node.getLeft(), list);
            getPreorderHelper(node.getRight(), list);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // Create a list to return
        ArrayList <BSTNode> list = new ArrayList<BSTNode>();
        // Add to list using helper function
        getPostorderHelper(root, list);
        return list;
    }

    public void getPostorderHelper (BSTNode node, ArrayList<BSTNode> list) {
        // If node exists
        if (node != null) {
            // Add in left right root
            getPostorderHelper(node.getLeft(), list);
            getPostorderHelper(node.getRight(), list);
            list.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // If the value is not in the tree
        if(!search(val)) {
            // Use helper function to find where and insert
            insertHelper(root, val);
        }
    }

    public void insertHelper (BSTNode node, int val) {
        // If the value is less check left
        if (val < node.getVal()) {
            // if left spot it empty then add
            if(node.getLeft() == null) {
                node.setLeft(new BSTNode(val));
            }
            // If it is not empty then go left
            else {
                insertHelper(node.getLeft(), val);
            }
        }
        // If the value is greater check right
        if (val > node.getVal()) {
            // if right spot is empty then add
            if(node.getRight() == null) {
                node.setRight(new BSTNode(val));
            }
            // If it is not empty then go right
            else {
                insertHelper(node.getRight(), val);
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
