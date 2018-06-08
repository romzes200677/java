/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import edu.princeton.cs.algs4.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author Roman
 */
public class S122 {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, IllegalAccessException {
      //ur1();
      //S123.test();
      //ur2();
      //workHard();
     // System.out.println(S122.class.getProtectionDomain().getCodeSource());  
     // IntDownloader.dload();
      //ip2();
      //udpsesrv();
    
    
     /*File f = new File("/mnt/DiskE/4mail");
     
     ArrayList<File> wrk=new ArrayList<>();
     print(wrk,f);
     for(File t:wrk){
         System.out.println(t.getName());
     }*/
     
    // copyfl(new File("/mnt/DiskE/4mail"),new File("/mnt/DiskE/tst"));
    
    //System.out.println(rez("(((2+2)))"));    
    //System.out.println(rez("32+((64-15)*(44*6))+2"));
    
    /*
    MyQuee<String> st = new MyQuee<>();
    while(!StdIn.isEmpty()){        
        String item = StdIn.readString();
        if(item.equals("q")) break;
        if(!item.equals("-")){
            st.enquee(item);
            
        }else if(!item.isEmpty()) StdOut.println(st.dequee());
        
    }
      System.out.println("Elements in stack avail = " +st.size()+"\n");
      
      Iterator<String> itr= st.iterator();
      while(itr.hasNext()){
          System.out.println(itr.next()); 
      }
    
    
    String eq="(([]{})){)"; 
    MyStack<Character> st = new MyStack<>();
    boolean rez=true;
    char c;
    for(int i=0;i<eq.length();i++){
        rez=true;
        c=eq.charAt(i);
        if('('==c || '['==c || '{'==c) st.push(c);
          
        else{
            
            if(st.idEmpty()) rez=true;
                if((c==')' && st.pop()!='(')||
                        (c==']'&& st.pop()!='[')||
                        (c=='}'&& st.pop()!='{')) rez=false;
        }
        rez=true;
        if(rez)System.out.println("oK");
        else System.out.println("no");
    }
   
     */ 
    
   // ParenthStack.conv();
   InfToPostf.chk();
   
    
    }
    
    //32+((64-15)*(44*6))+2
    //////////////////////////////////////////////////////////
    
    public static Double rez(String s){
        Stack<Double> oprnd= new Stack<>();
        Stack<Character> operat= new Stack<>();
        char c=0;
        String nmb="";
        for(int i=0;i<s.length();i++){
            
            c=s.toCharArray()[i];
           
            if(String.valueOf(c).compareTo("+")==0 ||
               String.valueOf(c).compareTo("-")==0 ||
               String.valueOf(c).compareTo("*")==0 ||
               String.valueOf(c).compareTo("/")==0 ){
                operat.push(c);
                
                if (nmb.compareTo("")!=0){
                    
                    oprnd.push(Double.parseDouble(nmb));
                    nmb="";
                    continue;
                }
                continue;
                
            }else if(String.valueOf(c).compareTo("(")==0){
                continue;
            }
           
            else if(String.valueOf(c).compareTo(")")==0){
                if (nmb.compareTo("")!=0){
                    oprnd.push(Double.parseDouble(nmb));
                    nmb="";
                    double d=oprpop(oprnd,operat);
                    oprnd.push(d);
                    continue; 
                }else{
                    double d2=oprpop(oprnd,operat);
                    oprnd.push(d2);
                    continue; 
                } 
                
            }  
            nmb = nmb+String.valueOf(c);
           //         
                
           
        }
        if (nmb.compareTo("")!=0) oprnd.push(Double.parseDouble(nmb));
        while(operat.size()>0){
           double d3=oprpop(oprnd,operat);
           oprnd.push(d3); 
        }
        return oprnd.pop();
    }
    
    public static Double oprpop(Stack<Double>oprnd ,Stack<Character> oprt ){
        
          
          double d2=oprnd.pop();  
          double d1=oprnd.pop();
          char chr=oprt.pop();
          String s=String.valueOf(chr);
          switch(s){
              case "+" :
                      return d1 + d2;
                      
                  case "-" :
                      return d1 - d2;
                      
                  case "*" :
                      return d1 * d2;
                     
                  case "/" :
                      return d1 / d2;
                      
          }
          return -1.0;
             
    }          
            
       
        
    
    
    
    public static int bs(int k,int[] lst,Counter cnt){
    int lo=0;
    int hi=lst.length-1;
    while(lo<=hi){
      int mid=lo+(hi-lo)/2;
      cnt.increment();
      if(k<lst[mid])hi=mid-1;
      else if(k>lst[mid])lo=mid+1;
      else return mid;
      
    }
    return -1;
        
    }
    
    
    public static void copyfl(File src,File dst) throws IOException{
        if(src.isDirectory()){                    
            if(!dst.exists()){
                dst.mkdir();
            }
            for(File subdir:src.listFiles()){
                String nm=subdir.getName();
                copyfl(subdir,new File(dst,nm));
            }
        }else{
            InputStream in = null;
            OutputStream os= null;
            try {
                in = new FileInputStream(src);
                os= new FileOutputStream(dst);
                byte[] buf=new byte[1024*1024];
                int cnt=0;
                while((cnt=in.read(buf))!=-1){
                  os.write(buf, 0, cnt);
                }
                os.flush();
          
            } catch (IOException ex) {
                throw new IOException("Error create stream");
            }finally{
                if(in != null){
                    try{
                        in.close();
                        os.close();
                    }catch(IOException ex){
                        //NOP
                    }
                }
            }
              
          
          
        }
    }   
    
    public static void print(List l2,File root){
        if(root.isFile()){
           
                l2.add(root);
       } else{
            
                File[] arr =root.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if(
                        (
                            (pathname.getName().endsWith("bmp") || 
                                pathname.getName().endsWith("gif") ||
                                pathname.getName().endsWith("jpg")         
                            ) && (pathname.length()>1024*1024)
                        )||
                            (pathname.isDirectory())
                      ) return true;
                    else 
                      return false;
                                      
                }
                
            });
            for(File k: arr){
                    if(k.isDirectory()){
                      print(l2,k);  
                    }else
                   l2.add(k);
               }
                
            }
        }
        
    
    
    
   
    
    
    public static void ip2() throws IOException{
     final int BUFFSIZE=32;
     int servPort=8889;
     ServerSocket ss = new ServerSocket(servPort);
     int rcvMes;
     byte[] buff = new byte[BUFFSIZE];
     for(;;){
         Socket clnt =  ss.accept();
         System.out.println("Client with address "+ clnt.getInetAddress().getHostAddress() +"connect to port "+ clnt.getPort());
         InputStream in = clnt.getInputStream();
         OutputStream os = clnt.getOutputStream();
         
         while((rcvMes = in.read(buff))!=-1){
             os.write(buff, 0, rcvMes);
         }
         clnt.close();
     }
       
   }
    
   static void udpsesrv() throws SocketException, IOException{
       final int ECHOMAX=255;
       int servPort=8833;
       byte[] receiveData = new byte[1024];
       DatagramSocket socket = new DatagramSocket(servPort);
       DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
       for(;;){
           socket.receive(packet);
           System.out.println("Handling client at" + packet.getAddress().getHostAddress() + "on port " + packet.getPort());
           socket.send(packet);
           packet.setLength(ECHOMAX);
       }
   }
   
   
     private static void workHard() {
       
		try	{
			int i = 100/0;
		}
		finally	{
			int i = 0;
			try	{
				while(i++<10) {
					System.out.println(i);
					Thread.sleep(1000);
				}
			}
			catch(InterruptedException e)	{
				System.out.println(e);
			}
		}
	}
   
    
    
    public static void ur2(){
         System.out.println(0);
        try {
            System.out.println(1);
       /****/     
            if (true)/****/ {
             // throw new NullPointerException();
               throw new Error();  
            }
            
            
            System.out.println(2);
        } catch (RuntimeException e) {
            System.out.println(3);
            
       /*****/
            if (true)/****/ {
              //throw new NullPointerException();
               throw new Error();
            }
            
            System.out.println(4);
        } finally {
            System.out.println(5);
        
        /****/   
            if (true)/****/ {
              
              //  throw new NullPointerException();
              throw new Error();
            }
            
            System.out.println(6);
        }
        System.out.println(7);
    }
    
    
    
    
    public static void ur1() throws IOException{
             String s ="";
     int n =0;
     double x;
     double y;
     System.out.println("input count interval>");
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     s = br.readLine();
     n = Integer.parseInt(s); // count intervals
     Interval1D otr[] = new Interval1D[n];
     
     for(int i=0;i<n;i++){
         System.out.println("input coordinate interval " + i);
         /*
         x =Double.parseDouble( br.readLine());
         y =Double.parseDouble( br.readLine()); 
         */
         x=Math.random();
         y = x +Math.random();
         otr[i] = new Interval1D(x, y);

     }
     for(int j =0;j<=n-1;j++){
         for(int k = j+1;k<=n-1;k++){
             if(otr[j].intersects(otr[k])){
                 System.out.println("Itersect " + otr[j] + "with "+otr[k]);
             }
         }
     }
     
     int c=0;
        while (c < (otr.length)){
            System.out.println("("+c+")"+ otr[c++].toString());
    }
    }
    
    }

    