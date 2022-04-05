import java.util.Random;

public class test3 {
    public static void main(String args[]){
        Caculate caculate=new Caculate();
        caculate.outPut();
    }
}
class Mat{
    int [][]mat=new int[2][2];
    Mat(){
        int i,j;
        Random random=new Random();
        for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                mat[i][j]=random.nextInt(20);
            }
        }

    }
    void outPut(){
        for(int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                System.out.print(mat[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
class Det extends Mat{
    int valueOfDet(){
        int value=mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
        return value;
    }

}
class Caculate extends Mat {
    Det det;
    void outPut(){
        Det det=new Det();
        int i,j,value[][];
        value=new int[2][2];
        this.det=det;
        System.out.println("行列式：");
        det.outPut();
        System.out.println("矩阵：");
        for(i=0;i<2;i++){
            for (j=0;j<2;j++){
                System.out.print(mat[i][j]+"   ");
            }
            System.out.println();
        }
        for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                value[i][j]=det.mat[i][0]*mat[0][j]+det.mat[i][1]*mat[1][j];
            }
        }
        System.out.println("行列式与矩阵的乘积：");
        for(i=0;i<2;i++){
            for (j=0;j<2;j++){
                System.out.printf("%-6d",value[i][j]);
            }
            System.out.println();
        }
    }

}

