/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author oem
 */
public class MyQuee<Item> {
    node first;
    node last;
    int cnt;
    
    class node {
        Item val;
        node next;
    }
    void enquee(Item itm){
        node oldlast=last;
        node tmp = new node();
        tmp.val=itm;
        last=tmp;
        if(isEmpty()) first=last; else oldlast.next=tmp;       
        cnt++;
    }
    
    Item dequee(){
        
        node cop=first;
        first=first.next;      
        if(isEmpty())last=null;
        cnt--;
        return cop.val;
    }
    
    boolean isEmpty(){
        return first==null;
    }
    
    int size(){
        return cnt;
    }
}
