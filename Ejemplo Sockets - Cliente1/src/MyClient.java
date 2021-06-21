// IMPORTS

import java.net.*;  
import java.io.*;

// CLASS
class MyClient{  
    public static void main(String args[])throws Exception{  
        Socket s = new Socket("localhost",3333);  
        DataInputStream din = new DataInputStream(s.getInputStream());  
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        
        String str = "";
        String str2 = "";  
        while(!str.equals("stop")){  
            str=br.readLine();  
            dout.writeUTF(str);  
            dout.flush();  
            str2=din.readUTF();  
            System.out.println("Server says: " + str2);  
        }  
        
        dout.close();  
        s.close();  
    }

}


/*
import java.io.*;  
import java.net.*;  
public class MyClient {  
    public static void main(String[] args) {  
        try{      
            Socket s=new Socket("localhost",6666);  
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            dout.writeUTF("Hello Server cnn");  
            dout.flush();  
            dout.close();  
            s.close();
        }catch(Exception e){System.out.println(e);}  
    }  
}
*/