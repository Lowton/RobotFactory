package headfirst.designpatterns.factory.robofactory.parts.weapons;

public abstract class Weapons {

    int power;
    String defenition;

    public Weapons(int power){
        this.power = power;
    }

    @Override
    public String toString() {
        return defenition;
    }

    public int getPower() {
        return power;
    }

    public String getDefenition() {
        return defenition;
    }
}
