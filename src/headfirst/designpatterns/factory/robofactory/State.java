package headfirst.designpatterns.factory.robofactory;

import headfirst.designpatterns.factory.robofactory.parts.body.Body;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Carriage;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Manipulators;
import headfirst.designpatterns.factory.robofactory.parts.weapons.Weapons;

public class State {
    Body body;
    Manipulators manipulators;
    Carriage carriage;
    Weapons weapons;

    public State(Body body, Carriage carriage, Manipulators manipulators, Weapons weapons) {
        this.body = body;
        this.manipulators = manipulators;
        this.carriage = carriage;
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        return "{" + body +
                ", " + manipulators +
                ", " + carriage +
                ", " + weapons +
                '}';
    }

    public Body getBody() {
        return body;
    }

    public Manipulators getManipulators() {
        return manipulators;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public Weapons getWeapons() {
        return weapons;
    }
}
