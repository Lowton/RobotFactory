package headfirst.designpatterns.factory.robofactory.parts.body;

import headfirst.designpatterns.factory.robofactory.parts.body.Body;

public class IronBody extends Body {
    public IronBody(int strength) {
        super(strength);
        this.defenition = "Iron body";
    }
}
