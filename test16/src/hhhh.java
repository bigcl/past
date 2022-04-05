public class hhhh {
    public static void main(String args[]) {
        Worksite worksite=new Worksite();
        worksite.a.start();
        worksite.b.start();
        worksite.c.start();
    }
}
class Worksite implements Runnable{
    Thread a,b,c;
    public Worksite(){
        a=new Thread(this);
        b=new Thread(this);
        c=new Thread(this);
        a.setName("运货司机");
        b.setName("装运工");
        c.setName("仓库管理员");
    }
    public void run() {
        Thread current=Thread.currentThread();
        if(current==a){
            try {
                b.join();
                System.out.println("运货司机开始开车");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(current==b){
            try {
                c.join();
                System.out.println("装运工开始装运");
                Thread.sleep(1000);
                System.out.println("装运完成，可以开车了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (current==c){
            System.out.println("仓库管理员正在赶来");
            try {
                Thread.sleep(1000);
                System.out.println("仓库管理员开门了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
