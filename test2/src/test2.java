import java.util.Random;

public class test2 {
    public static void main(String args[]){
        int floor,i,mark=6,count=0,min=16;
        int liftfloor[]=new int[3];
        int liftstate[]=new int[3];
        String state[]=new String[3];
        Random random=new Random();
        floor=random.nextInt(16)+1;
        System.out.println("学生所在楼层："+floor);
        for(i=0;i<3;i++){
            liftfloor[i]=random.nextInt(16)+1;
            if(liftfloor[i]==1) {
                liftstate[i]=0;
            }
            else if(liftfloor[i]==16) {
                liftstate[i]=1;
            }
            else liftstate[i]=(int)(Math.random()*2);
            if(liftstate[i]==0) state[i]="上升";
            else state[i]="下降";
            System.out.println("电梯"+(i+1)+"所在楼层及运行状态"+liftfloor[i]+"   "+state[i]);
        }
        for(i=0;i<3;i++){
            if((liftfloor[i]-floor>=0&&liftstate[i]==1)||(liftfloor[i]-floor<=0&&liftstate[i]==0)){
                count++;
                if(Math.abs(liftfloor[i]-floor)<=min){
                    min=Math.abs(liftfloor[i]-floor);
                    mark=i;
                }
            }
        }
        if(count==0)
                System.out.println("暂时无法判断该同学最先乘坐哪台电梯");
        else System.out.println("该同学最终乘坐电梯："+(mark+1));

    }
}
