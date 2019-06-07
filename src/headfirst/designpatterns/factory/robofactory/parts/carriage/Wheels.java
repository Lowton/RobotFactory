package headfirst.designpatterns.factory.robofactory.parts.carriage;

public class Wheels extends Carriage {
    int wheelCount;

    public Wheels(float speed, int wheelCount) {
        super(speed);
        this.wheelCount = wheelCount;
        this.defenition = wheelCount + " wheels";
    }
}
