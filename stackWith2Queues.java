/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackwith2queues;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;

public class stackWith2Queues {

    /**
     * @param args the command line arguments
     */
    static class Stack{
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        int size;
        Stack(){
            size = 0;
        }
        void push(int o){
            q2.add(o);
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
            Queue<Integer> q = q2;
            q2 = q1;
            q1 = q;
            size++;
        }
        void pop(){
            if(q1.isEmpty()){
                System.out.println("Underflow");
            }else{
                q1.remove();
                size--;
            }
        }
        void display(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty");
            }else{
                while(!q1.isEmpty()){
                    System.out.print(q1.peek() + " ");
                    q2.add(q1.remove());
                }
                System.out.println();
                Queue<Integer> q = q2;
                q2 = q1;
                q1 = q;
            }
        }
        int size(){
            return size;
        }
        void top(){
            if(q1.isEmpty()){
                System.out.println("Stack is empty");
            }else{
                System.out.println(q1.peek());
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stack s = new Stack();
        Scanner S = new Scanner(System.in);
        System.out.println("Enter the size of stack");
        int n = S.nextInt();
        System.out.println("Enter elements in stack");
        while(n-- > 0){
            s.push(S.nextInt());
        }
        s.display();
        System.out.println("Size of stack is " + s.size());
        s.pop();
        s.display();
        s.top();
        System.out.println("Size of stack is " + s.size());
    }
    
}
