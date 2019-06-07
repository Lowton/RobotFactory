package headfirst.designpatterns.factory.robofactory.section;

import headfirst.designpatterns.factory.robofactory.RobotType;
import headfirst.designpatterns.factory.robofactory.State;
import headfirst.designpatterns.factory.robofactory.parts.body.*;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Carriage;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Legs;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Arms;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Manipulators;
import headfirst.designpatterns.factory.robofactory.parts.weapons.*;


public class CommonAssamblyHall implements AssamblyHall {

    private RobotType robotType;

    public CommonAssamblyHall(RobotType type) {
        this.robotType = type;
    }

    @Override
    public Body createBody() {

        switch (this.robotType) {
            case WORKER:
                return new LightBody(1);
            case SOLDER:
                return new IronBody(3);
            case OFFICER:
                return new IronBody(2);
            case MARINE:
                return new SteelBody(5);
            default:
                return new LightBody(0);
        }
    }

    @Override
    public Carriage createCarriage() {

        switch (this.robotType) {
            case WORKER:
                return new Legs(1f, 2);
            case SOLDER:
                return new Legs(1.2f, 2);
            case OFFICER:
                return new Legs(1.3f, 2);
            case MARINE:
                return new Legs(1.5f, 2);
            default:
                return new Legs(1f, 2);
        }

    }

    @Override
    public Manipulators createManipulators() {
        switch (this.robotType) {
            case WORKER:
            case SOLDER:
                return new Arms(2);
            case OFFICER:
            case MARINE:
                return new Arms(4);
            default:
                return new Arms(0);
        }
    }

    @Override
    public Weapons createWeapons() {

        switch (this.robotType) {
            case WORKER:
                return new NoWeapon();
            case SOLDER:
                return new Rifle(15);
            case OFFICER:
                return new Gun(5);
            case MARINE:
                return new Shotgun(30);
            default:
                return new NoWeapon();
        }
    }

    @Override
    public int countCombatPower(State structure) {
        int weaponRate;
        int manipulatorsRate;

        switch (this.robotType) {
            case WORKER: {
                manipulatorsRate = 1;
                weaponRate = 1;
                break;
            }
            case SOLDER: {
                weaponRate = 1;
                manipulatorsRate = 3;
                break;
            }
            case OFFICER: {
                weaponRate = 1;
                manipulatorsRate = 2;
                break;
            }
            case MARINE: {
                weaponRate = 1;
                manipulatorsRate = 4;
                break;
            }
            default: {
                weaponRate = 0;
                manipulatorsRate = 0;
            }
        }
        return weaponRate * structure.getWeapons().getPower()
                + manipulatorsRate * structure.getManipulators().getCount();
    }

    @Override
    public int countHP(State structure) {
        int bodyRate;
        int carriageRate;
        int manipulatorsRate;

        switch (this.robotType) {
            case WORKER: {
                bodyRate = 3;
                carriageRate = 2;
                manipulatorsRate = 1;
                break;
            }
            case SOLDER: {
                bodyRate = 7;
                carriageRate = 2;
                manipulatorsRate = 2;
                break;
            }
            case OFFICER: {
                bodyRate = 5;
                carriageRate = 3;
                manipulatorsRate = 1;
                break;
            }
            case MARINE: {
                bodyRate = 10;
                carriageRate = 3;
                manipulatorsRate = 3;
                break;
            }
            default: {
                bodyRate = 1;
                carriageRate = 1;
                manipulatorsRate = 1;
            }
        }

        return bodyRate * structure.getBody().getStrength()
                + carriageRate * (int) structure.getCarriage().getSpeed()
                + manipulatorsRate * structure.getManipulators().getCount();
    }

    @Override
    public RobotType getRobotType() {
        return this.robotType;
    }
}
