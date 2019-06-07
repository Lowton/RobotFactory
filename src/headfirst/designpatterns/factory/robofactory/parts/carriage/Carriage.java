package headfirst.designpatterns.factory.robofactory.parts.carriage;

public abstract class Carriage {
    float speed;
    String defenition;

    public Carriage(float speed){
        this.speed = speed;
    }

    @Override
    public String toString() {
        return defenition;
    }

    public float getSpeed() {
        return speed;
    }

    public String getDefenition() {
        return defenition;
    }
}
