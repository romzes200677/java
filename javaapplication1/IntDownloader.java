/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;

import java.net.URL;
import java.util.Properties;
import sun.net.www.URLConnection;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

/**
 *......................
 * @author Roman
 */
public class IntDownloader {
    public static void dload() throws IOException{
  
       URL url = new URL("http://192.168.1.247/my.bmp");
       HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
       httpconn.setUseCaches(false);
        httpconn.setDefaultUseCaches(false);
      
       
       
       
            
            
        InputStream in  = null;
        OutputStream os = null;
        OutputStream os2= null;
        BufferedInputStream buf=null;
        byte[] ar = new byte[64];
        try{
          
          in = httpconn.getInputStream();
         // buf = new BufferedInputStream(in,64);
        }catch(IOException e){
            throw new IOException("internet problem");
        }
        
        
        try{
             os = new FileOutputStream("/mnt/DiskE/4mail/1.bmp");
            try{
                 os2 = new FileOutputStream("/mnt/DiskE/4mail/2.bmp");
            }catch(IOException ex2){
              try{
                new File("/mnt/DiskE/4mail/1.bmp").delete();
              }catch(SecurityException ex3){
                 //NOP  
              }
              
              throw new IOException("Can not create file2,try download again",ex2);
            }
        }catch(IOException ex1){
            throw new IOException("Can not create file1,try download again",ex1);
        }
        
        int b; 
        try{
            while ((b=/*buf.*/in.read(ar)) != -1){
                try{
                    os.write(ar,0,b);
                    os2.write(ar,0,b);
                    
                }catch(IOException iowr){
                   try{
                       new File("/mnt/DiskE/4mail/1.bmp").delete();
                       new File("/mnt/DiskE/4mail/2.bmp").delete();
                   }catch(SecurityException iowr2){
                       //NOP
                   }
                   throw new IOException("Can not write to the file",iowr);
                }


            }
        }
        catch(IOException io7){
           throw new IOException("Can not write to hdd");
        }finally{
            try{
                os.flush();
                os2.flush();
                os.close();
                os2.close();
                in.close();
            }catch(IOException io9){
                throw new IOException("Can not close files");
            }
            
           
        }    
        
        
    }
}
