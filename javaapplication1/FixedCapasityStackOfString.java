/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Iterator;

/**
 *
 * @author oem
 */
public  class FixedCapasityStackOfString<Item> implements Iterable<Item>{
    Item[] a;
    int n;
    
    FixedCapasityStackOfString(int Cap){
        this.a= (Item[]) new Object[Cap];
    }
    
    boolean isFull(){
        return n==a.length;
    }
    
    boolean isEmpty(){
        return n==0;
    }
    void push(Item str){
        if(n==a.length)resize(2*a.length);
        a[n++]=str;
    }
    
    Item pop(){
       Item itm =  a[--n];
       a[n]=null;
       if(n>0 && n==a.length/4 ) resize(a.length/2);
       return itm;
    }
    
    int Size(){
        return n;
    }
    
    void resize(int sz){
        Item[] tmp= (Item[]) new Object[sz];
        for(int i=0;i<a.length;i++){
            tmp[i]=a[i];
        }
        a=tmp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArray(); 
    }
    
    private class ReverseArray implements Iterator<Item>{
        private int i=n;

        @Override
        public boolean hasNext() {
          return n>0;  
        }

        @Override
        public Item next() {
           return a[--i];
        }
    }
}
