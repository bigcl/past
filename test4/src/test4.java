class Retangle{
    int lengh,width;
    Retangle(int lengh,int width){
        this.lengh=lengh;
        this.width=width;
    }
    int getArea(){
        int s=lengh*width;
        return s;
    }
    int getRound(){
        int c=2*(lengh+width);
        return c;
    }
}
public class test4 {
    public static void main(String args[]){
        Retangle retangle=new Retangle(10,20);
        System.out.println("长:"+retangle.lengh+"宽:"+retangle.width);
        System.out.println("面积:"+retangle.getArea()+"周长："+retangle.getRound());
    }
}

