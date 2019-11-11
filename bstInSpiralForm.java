/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstinspiralform;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;

public class bstInSpiralForm {

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
    bstInSpiralForm(){
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
    
    void printSpiral(Node node) 
    { 
        if (node == null) 
            return;
        Stack<Node> s1 = new Stack<Node>();  
        Stack<Node> s2 = new Stack<Node>();  
        s1.push(node); 
        while (!s1.empty() || !s2.empty()) { 
            while (!s1.empty()) { 
                Node temp = s1.peek(); 
                s1.pop(); 
                System.out.print(temp.data + " "); 
                if (temp.right != null) 
                    s2.push(temp.right); 
  
                if (temp.left != null) 
                    s2.push(temp.left); 
            } 
            while (!s2.empty()) { 
                Node temp = s2.peek(); 
                s2.pop(); 
                System.out.print(temp.data + " "); 
                if (temp.left != null) 
                    s1.push(temp.left); 
                if (temp.right != null) 
                    s1.push(temp.right); 
            } 
        } 
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here    
        bstInSpiralForm bst = new bstInSpiralForm();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes of Binary Search Tree");
        int nodes = s.nextInt();
        System.out.println("Enter the elements of bst");
        while(nodes-- > 0){
            int k = s.nextInt();
            bst.root = bst.insert(bst.root, k);
        }
        
        bst.printSpiral(bst.root);
    }
    
}
