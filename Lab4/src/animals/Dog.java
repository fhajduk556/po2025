package animals;

public class Dog extends Animal{
    public Dog() {
        this.legs = 4;
    }
    public String getDescription() {
        return "Dog";
    }
    public void makeSound() {
        System.out.println("hau hau");
    }
}
