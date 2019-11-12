/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;
public class binaryTree {

    /**
     * @param args the command line arguments
     */
    
    class Node  
    { 
        int data; 
        Node left, right; 
       
        Node(int item)  
        { 
            data = item; 
            left = right = null; 
        } 
    } 
    Node root; 
    binaryTree(){
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
    void reverseLevelOrder(Node node)  
    { 
        int h = height(node); 
        int i; 
        for (i = h; i >= 1; i--)  
        { 
            printGivenLevel(node, i); 
            System.out.println();
        } 
    } 
    void printGivenLevel(Node node, int level)  
    { 
        if (node == null) 
            return; 
        if (level == 1) 
            System.out.print(node.data + " "); 
        else if (level > 1)  
        { 
            printGivenLevel(node.left, level - 1); 
            printGivenLevel(node.right, level - 1); 
        } 
    } 
    int height(Node node)  
    { 
        if (node == null) 
            return 0; 
        else
        {
            int lheight = height(node.left); 
            int rheight = height(node.right); 
            if (lheight > rheight) 
                return (lheight + 1); 
            else
                return (rheight + 1); 
        } 
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        binaryTree bt = new binaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes of Binary Tree");
        int n = s.nextInt();
        System.out.println("Enter the elements in Binary Tree");
        while(n-- > 0){
            bt.root = bt.insert(bt.root, s.nextInt());
        }
        System.out.println("Binary tree in reverse level order");
        bt.reverseLevelOrder(bt.root);
    }
    
}
