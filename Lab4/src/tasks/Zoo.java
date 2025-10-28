package tasks;

import animals.Animal;
import animals.Dog;
import animals.Snake;
import animals.Parrot;
import java.util.Random;

public class Zoo {
    private Animal[] animals;
    public Zoo(){
        Random random = new Random();
        this.animals =  new Animal[100];
        for (int i=0;i<animals.length;i++){
            int los = random.nextInt(3);
            if (los == 0){
                this.animals[i] = new Dog();
            }
            if(los == 1){
                this.animals[i] = new Snake();
            }
            if(los == 2){
                this.animals[i] = new Parrot();
            }
        }
    }
    public int sumLegs(){
        int sum = 0;
        for (int i=0;i<animals.length;i++){
            sum = sum + animals[i].legs;
        }
        return sum;
    }
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        int sumanog = zoo.sumLegs();
        System.out.println(sumanog);
    }
}
