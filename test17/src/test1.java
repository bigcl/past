
import java.io.*;
public class test1 implements Runnable {
    DataInputStream in;
    public void setDataInputStream(DataInputStream in) {
        this.in = in;
    }
    public void run() {
        String result=null;
        try{ result=in.readUTF();
            System.out.println("result:"+result);
        }
        catch(IOException e) {
            System.out.println("与服务器已断开"+e);
        }
    }
}

