/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueusing2stack;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;
public class queueUsing2Stack {

    /**
     * @param args the command line arguments
     */
    static class Queue{
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        void enQueue(int o){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(o);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        void deQueue(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
            }else{
                System.out.println("Element removed successfully " + s1.pop());
            }
        }
        void display(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
            }else{
                while(!s1.isEmpty()){
                    System.out.print(s1.peek() + " ");
                    s2.push(s1.pop());
                }
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
                System.out.println();
            }
        }
        void firstElement(){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
            }else{
                System.out.println(s1.peek());
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Queue q = new Queue();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements to be entered in queue");
        int n = s.nextInt();
        System.out.println("Enter elements in queue");
        while(n-- > 0){
            q.enQueue(s.nextInt());
        }
        q.display();
        q.firstElement();
        q.deQueue();
        q.display();
        q.firstElement();
    }
}
