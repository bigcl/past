public class test2 {
    public static void main(String args[]){
        Room room =new Room();
        room.teacher.start();
        room.student1.start();
        //room.student2.start();
    }
}
class Room implements Runnable{
    Thread teacher,student1,student2;
    int a = 0;
    Room(){
        teacher = new Thread(this);
        student1 = new Thread(this);
        student2 = new Thread();
    }
    @Override
    public void run() {
        Thread name =Thread.currentThread();
        if(name==student1){
            synchronized (student1) {
                try {
                    System.out.println("student1正在睡觉");
                    student1.wait(1000 * 60 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println("student1被吵醒开始上课");

            }
        }
        if(name==teacher){
                for (int i = 0; i < 3; i++) {
                    System.out.println("上课");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a = 1;
            }
        synchronized (student1){
            if(a==1){
                student1.notify();
            }
        }
    }
}
