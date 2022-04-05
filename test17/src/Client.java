
import java.io.*;
import java.net.*;
import java.util.*;
public class Client  {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Socket mysocket=null;
        DataInputStream in=null;
        DataOutputStream out=null;
        Thread readData ;
        test1 read=null;
        try{  mysocket=new Socket();
            read = new test1();
            readData = new Thread(read);
            if(mysocket.isConnected()){}
            else{
                InetAddress  address=InetAddress.getByName("192.168.177.132");
                InetSocketAddress socketAddress=new InetSocketAddress(address,50000);
                mysocket.connect(socketAddress);
                in =new DataInputStream(mysocket.getInputStream());
                out = new DataOutputStream(mysocket.getOutputStream());
                read.setDataInputStream(in);
                readData.start();
            }
        }
        catch(Exception e) {
            System.out.println("服务器已断开"+e);
        }
        System.out.print("输入数字:");
        scanner.hasNext();
        double radius=0;
        try {
            radius = scanner.nextDouble();
        }
        catch(InputMismatchException exp){
            System.exit(0);
        }
        try {
            out.writeDouble(radius);
        }
        catch(Exception e) {}

    }
}