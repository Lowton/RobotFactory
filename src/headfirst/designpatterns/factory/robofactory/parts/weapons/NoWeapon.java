package headfirst.designpatterns.factory.robofactory.parts.weapons;

public class NoWeapon extends Weapons {
    public NoWeapon() {
        super(0);
        this.defenition = "Without guns";
    }
}
