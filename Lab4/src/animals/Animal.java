package animals;

public abstract class Animal {
    public String name;
    public int legs;
    public abstract String getDescription();
    public int getLegs() {
        return legs;
    }
    public void makeSound() {};
}
