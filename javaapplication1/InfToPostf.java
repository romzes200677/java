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
public class InfToPostf {
    public static void chk(){
        String s="(((1+2)*(4+2))/2)";
        MyStack<String> oprt = new MyStack<>();
        MyStack<String> oprnd = new MyStack<>();

        String s1;
        String s2;
        String rez;
        String znak;
        char[] arr = s.toCharArray();
        for(char c: arr){

        if(c=='('); else //NOP;
        if(c==')'){
            s2=oprnd.pop();
            s1=oprnd.pop();
            znak=oprt.pop();
            rez="("+s1+s2+znak+")";
            oprnd.push(rez);
        }else if(c=='+' || c=='-' || c=='/' || c=='*'){
            oprt.push(String.valueOf(c));
        }else oprnd.push(String.valueOf(c));

        } 
        System.out.println(oprnd.pop());
    }
    
}

