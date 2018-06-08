/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author oem
 */
public class MyStack<El> implements Iterable<El>{
    node fld;
    int cnt;

    @Override
    public Iterator<El> iterator() {
        return new Walk();
    }
    
    El peek(){
        return fld.value;
    }
    private class Walk implements Iterator<El>{
        node current=fld;
        
       
        @Override
        public boolean hasNext() {
          return current!=null;
        }

        @Override
        public El next() {
           if (!hasNext()) throw new NoSuchElementException();
                El tmp = current.value;
                current=current.next;
                return tmp;
           
        }
    
    }
    
    int size(){
    return cnt;
    }
    
    boolean idEmpty(){
        return cnt==0;
    }
    
    private class node{
        El value;
        node next;       
    }
    
    void push(El val){
            node old=fld;    
            fld = new node();
            fld.value=val;
            fld.next=old;
            cnt++;                 
    }
    
    El pop(){
        El tmp =fld.value;
        fld =fld.next;
        cnt--;
        return tmp;
    }
    
    
    
        
}

