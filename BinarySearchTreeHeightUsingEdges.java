/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtreeheightusingedges;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;
public class BinarySearchTreeHeightUsingEdges {

    /**
     * @param args the command line arguments
     */
    
    class Node{
        int data;
        Node left, right;
        public Node(int value){
            this.data = value;
            left = right = null;
        }
    }
    
    Node root;
    BinarySearchTreeHeightUsingEdges(){
        root = null;
    }
    
    Node insert(Node node,int key){
        if(node == null){
            node = new Node(key);
        }
        
        if(key < node.data){
            node.left = insert(node.left, key);
        }else if(key > node.data){
            node.right = insert(node.right, key);
        }
        return node;
    }
    
    int height(Node node){
        if(node == null)
            return -1;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight >= rightHeight){
            return leftHeight+1;
        }else{
            return rightHeight+1;
        }
    }
    
     void preOrderTraversal(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        BinarySearchTreeHeightUsingEdges bst = new BinarySearchTreeHeightUsingEdges();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes of Binary Search Tree");
        int nodes = s.nextInt();
        System.out.println("Enter elements of BST");
        while(nodes-- > 0){
            int k = s.nextInt();
            bst.root = bst.insert(bst.root, k);
        }
        
        bst.preOrderTraversal(bst.root);
        System.out.println("\nHeight of a tree is: " + bst.height(bst.root));
    }
}
