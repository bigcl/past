abstract class Animal{
   abstract void cry();
   abstract void getAniaml();
}
class Simulator{
    void playSound(Animal animal){
        animal.cry();
        animal.getAniaml();
    }
}
class Dog extends Animal{
    void cry() {
        System.out.println("汪汪汪");
    }
    void getAniaml() {
        System.out.println("狗");
    }
}
class Cat extends Animal{
    @Override
    void cry() {
        System.out.println("喵喵喵");
    }

    @Override
    void getAniaml() {
        System.out.println("猫");
    }
}
public class test5{
    public static void main(String args[]){
        Animal animal;
        animal=new Dog();
        animal.cry();
        animal.getAniaml();
        animal=new Cat();
        animal.cry();
        animal.getAniaml();
    }
}
