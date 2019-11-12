/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstevenlevelprinting;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;
public class BstEvenLevelPrinting {

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
    BstEvenLevelPrinting(){
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
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight >= rightHeight){
            return leftHeight+1;
        }else{
            return rightHeight+1;
        }
    }
    
    void traverseGivenLevel(){
        int height = height(root);
        int evenLevel = 0;
        for(int i = 1; i <= height; i++, evenLevel++){
            printGivenLevel(root, i, evenLevel);
            if(evenLevel % 2 == 0)
                System.out.println();
        }
    }
    
    void printGivenLevel(Node root, int level, int evenLevel){
        if(root == null)
            return;
        if(level == 1 && evenLevel % 2 == 0)
            System.out.print(root.data + " ");
        else if(level > 1){
            printGivenLevel(root.right, level-1, evenLevel);
            printGivenLevel(root.left, level-1, evenLevel);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here    
        BstEvenLevelPrinting bst = new BstEvenLevelPrinting();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes of Binary Search Tree");
        int nodes = s.nextInt();
        System.out.println("Enter elements in Binary Search Tree");
        while(nodes-- > 0){
            int k = s.nextInt();
            bst.root = bst.insert(bst.root, k);
        }
        
        bst.traverseGivenLevel();
    }
    
}
