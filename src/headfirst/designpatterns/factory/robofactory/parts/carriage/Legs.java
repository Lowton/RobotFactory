package headfirst.designpatterns.factory.robofactory.parts.carriage;

public class Legs extends Carriage {

    public Legs(float speed, int count) {
        super(speed);
        this.defenition = count + " legs";
    }
}
