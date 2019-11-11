/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstconversiontopostandinorder;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;

public class bstConversionToPostAndInOrder {

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
    bstConversionToPostAndInOrder(){
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
    
    void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    
    void postOrderTraversal(Node node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        bstConversionToPostAndInOrder bst = new bstConversionToPostAndInOrder();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes of Binary Search Tree");
        int nodes = s.nextInt();
        System.out.println("Enter the elements in pre-order");
        while(nodes-- > 0){
            int k = s.nextInt();
            bst.root = bst.insert(bst.root, k);
        }
        System.out.print("Inorder Traversal: ");
        bst.inOrderTraversal(bst.root);
        System.out.println();
        
        System.out.print("Post-order Traversal: ");
        bst.postOrderTraversal(bst.root);
        System.out.println();
    }
    
}
