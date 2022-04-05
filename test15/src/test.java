public class test {

    public static void main(String[] args) {
        Classroom cla = new Classroom();
        cla.student1.start();
        cla.student2.start();
        cla.teacher.start();
    }

}

class Classroom implements Runnable{
    Thread student1,student2,teacher;
    Classroom(){
        student1 = new Thread(this);
        student1.setName("student1");
        student2 = new Thread(this);
        student2.setName("student2");
        teacher = new Thread(this);
        teacher.setName("teacher");
    }

    @Override
    public  void run() {
        if (Thread.currentThread()==student1) {
            try {
                System.out.println(student1.getName()+"正在睡觉");
                student1.sleep(5*60*1000);
            } catch (InterruptedException e) {
                System.out.println(student1.getName()+"被老师叫醒了");
                student2.interrupt();
            }
        }
        else if(Thread.currentThread()==student2){
            try {
                System.out.println(student2.getName()+"正在睡觉,不听课");
                student2.sleep(10*60*1000);
            } catch (InterruptedException e) {
                System.out.println(student2.getName()+"被student1叫醒了");
            }
        }
        else if(Thread.currentThread()==teacher){
            for (int i = 0; i < 3; i++) {
                System.out.println("上课");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            student1.interrupt();
        }
    }
}