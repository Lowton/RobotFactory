package headfirst.designpatterns.factory.robofactory.parts.manipulators;

public class Arms extends Manipulators{

    public Arms(int count) {
        super(count);
        this.defenition = count + " arms";
    }
}
