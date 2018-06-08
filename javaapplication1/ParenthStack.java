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
public class ParenthStack {
    public static void conv(){
        
       MyStack<String> oprnd = new MyStack<>();
       MyStack<String> oprtr = new MyStack<>();
       String s="1+2)*3-4)*4-6)))";
       char[] ar=s.toCharArray();
       for(char c:ar){
           if(c==')'){
               String s1=oprtr.pop();
               String s3=oprnd.pop();
               String s2=oprnd.pop();
               String rez = "("+s2+s1+s3+")";
               oprnd.push(rez);
           }else if(c=='+'||c=='-'||c=='*'||c=='/'){
               oprtr.push(String.valueOf(c));
           }else oprnd.push(String.valueOf(c));
       }
        System.out.println(oprnd.pop());

        
    }
    
}
