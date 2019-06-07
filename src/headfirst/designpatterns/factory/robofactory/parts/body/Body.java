package headfirst.designpatterns.factory.robofactory.parts.body;

public abstract class Body {
    int strength;
    String defenition;

    public Body(int strength){
        this.strength = strength;
    }

    @Override
    public String toString() {
        return defenition;
    }

    public int getStrength() {
        return strength;
    }

    public String getDefenition() {
        return defenition;
    }
}
