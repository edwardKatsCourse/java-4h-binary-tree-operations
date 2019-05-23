package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(5);
        binaryTree.add(4);
        boolean contains = binaryTree.contains(3);
        System.out.println("Main: contains=" + contains);
    }
}

class BinaryTree {
    Node root;


    //1
    //2
    //3
    public void add(int value) {
        root = addNode(value, root);
    }

    private Node addNode(int value, Node node) { //3
        if (node == null) { //node(1), node(2)
            System.out.printf("addNode() - new node, value: %s\n", value);
            return new Node(value);
        }
        int currentValue = node.value; //currentValue=2, value = 3
        if (currentValue == value) {
            return node;
        }
        if (currentValue > value) { //2 > 3
            System.out.printf("addNode() - left, value: %s\n", value);
            node.left = addNode(value, node.left);
        } else {
            System.out.printf("addNode() - right, value: %s\n", value);
            node.right = addNode(value, node.right); //return new Node(3)
        }
        return node;
    }

    public boolean contains(int value) {
        return nodeContains(value, root);
    }

    private boolean nodeContains(int value, Node node) {
        if (node == null) {
            System.out.printf("nodeContains() - value: %s, node is null\n", value);
            return false;
        }

        if (node.value == value) { //1 == 1
            System.out.printf("nodeContains() - value: %s, node.value: %s\n", value, node.value);
            return true;
        }

        if (value > node.value) {
            System.out.printf("value: %s, node.right, node.value: %s\n", value, node.value);
            return nodeContains(value, node.right);
        } else {
            System.out.printf("value: %s, node.left, node.value: %s\n", value, node.value);
            return nodeContains(value, node.left);
        }
    }


}

class Node {
    int value;
    Node right;
    Node left;

    public Node(int value) {
        this.value = value;
    }
}