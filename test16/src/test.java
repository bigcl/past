public class test {
    public static void main(String args[]){
        Cinema cinema=new Cinema();
        cinema.a.start();
        cinema.b.start();
        cinema.c.start();
    }
}
class Cinema implements Runnable{
    Thread a,b,c;
    int leftmoney=15,tiketprice=5;
    public Cinema(){
        a=new Thread(this);
        b=new Thread(this);
        c=new Thread(this);
        a.setName("甲");
        b.setName("乙");
        c.setName("丙");
    }
    @Override
    public void run() {
        Thread current=Thread.currentThread();
        if(current==a) {
            sell(2,current.getName());
            }
        if(current==b) {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sell(5,current.getName());
        }
        if(current==c) {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sell(10,current.getName());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void sell(int money,String name){
        if (money<5){
            System.out.println(name+"钱不够无法买票");
        }
        if (money>=5){
            System.out.println(name+"买票成功，找"+(money-tiketprice)+"元");
        }
    }
}
