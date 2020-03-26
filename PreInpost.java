import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class PreInpost {
    /**
     * This is the main method and execute when project run
     *
     * @param args
     * @author Priota Roy
     * @version 1.0
     * @since 2020-03-24
     */
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        /**
         * This binaryTree map contains every nodes and their mapping
         */
        HashMap<Integer, Node> binaryTree = new HashMap<>();

        Node rootNode = null;

        /**
         * Infinity loop that take node values from user
         * Break Point : (0 to all negative numbers)
         */
        for (; ; ) {

            System.out.println("Enter node value: ");
            int nodeValue = scanner.nextInt();
            /** Checking that node already contains in map or, user want to terminate from creating new node*/
            if (nodeValue > 0 && !binaryTree.containsKey(nodeValue)) {
                /** Create a new Node by user value*/
                Node node = new Node(nodeValue);

                System.out.println("Enter parent value (if it is root then enter 0) : ");
                int parentNodeValue = scanner.nextInt();
                /** Checking that node is root or not
                 * If the node is root then the parentNode will be 0
                 * */
                if (parentNodeValue > 0) {

                    try {
                        /** Searching for parentNode by user's input
                         * If not exists then throw the exception*/
                        Node parentNode = binaryTree.get(parentNodeValue);
                        if (Objects.nonNull(parentNode)) {
                            /** Taking input from user for the position of node
                             * If it is left child then take L
                             * If it is right child then take R
                             * TODO: Exception handle properly*/
                            System.out.println("Enter node's position(For Right R, For Left L) : ");
                            scanner.nextLine();
                            String position = scanner.nextLine();

                            /**
                             * If user input R then system set the node as it's right child*/
                            if (position.equals("R")) {
                                /** Checking that already parentNode have rightChild
                                 * If have then throw exception */
                                if (parentNode.rightNode == null) {
                                    parentNode.rightNode = node;
                                    node.rootNode = parentNode;
                                } else
                                    throw new Exception("Right node already assigned");

                            } else if (position.equals("L")) {
                                /** Checking that already parentNode have leftChild
                                 * If have then throw exception */
                                if (parentNode.leftNode == null) {
                                    parentNode.leftNode = node;
                                    node.rootNode = parentNode;
                                } else
                                    throw new Exception("Left node already assigned");
                            }
                        } else
                            throw new Exception("Parent node not found");

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                } else {
                    node.rootNode = null;
                    rootNode = node;
                }

                /**Putting node into the binaryTree map*/
                binaryTree.put(nodeValue, node);

            } else
                break;
        }

        /**Traversing the binaryTree*/
        try {
            if (Objects.nonNull(rootNode)) {
                for (; ; ) {
                    System.out.println("Traverse the binary tree as\n1. Pre-Order\n2. In-Order\n3. Post-Order\nPress Anu Digit For Exit");
                    int input = scanner.nextInt();

                    if (input >= 4 || input <= 0)
                        break;
                    else if (input == 1) {
                        preOrder(rootNode);
                        System.out.println();
                    } else if (input == 2) {
                        inOrder(rootNode);
                        System.out.println();
                    } else if (input == 3) {
                        postOrder(rootNode);
                        System.out.println();
                    } else
                        break;
                }
                System.out.println(binaryTree);
            } else
                throw new Exception("Root Node not found");

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    /**
     * Traversing binaryTree in pre order traversal
     *
     * @param root
     * @Author Priota Roy
     * @since 2020-03-26
     */

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.nodeValue + " ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    /**
     * \
     * reversing binaryTree by in order traversal
     *
     * @param root
     * @Author Priota Roy
     * @since 2020-03-26
     */

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.nodeValue + " ");
        inOrder(root.rightNode);
    }


    /**
     * reversing binaryTree by post order traversal
     *
     * @param root
     * @Author Priota Roy
     * @since 2020-03-26
     */
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.nodeValue + " ");
    }

}

/**
 * This class contain the nodeValue and two child as left, right node
 * Initially left and right node will be null
 */
class Node {
    Node rootNode;
    int nodeValue;
    Node leftNode;
    Node rightNode;

    /**
     * This is the constructor of Node class
     *
     * @param nodeValue
     * @author Priota Roy
     * @version 1.0
     * @since 2020-03-23
     */
    public Node(int nodeValue) {
        this.nodeValue = nodeValue;
    }

}

