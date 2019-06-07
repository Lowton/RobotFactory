package headfirst.designpatterns.factory.robofactory.parts.manipulators;

public class Palp extends Manipulators {
    public Palp(int count) {
        super(count);
        this.defenition = count + " palp";
    }
}
