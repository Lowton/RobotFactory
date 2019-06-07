package headfirst.designpatterns.factory.robofactory.parts.weapons;

public class Laser extends Weapons {
    public Laser(int power) {
        super(power);
        this.defenition = "Laser";
    }
}
