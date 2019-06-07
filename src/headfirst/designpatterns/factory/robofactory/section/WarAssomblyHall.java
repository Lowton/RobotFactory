package headfirst.designpatterns.factory.robofactory.section;

import headfirst.designpatterns.factory.robofactory.RobotType;
import headfirst.designpatterns.factory.robofactory.State;
import headfirst.designpatterns.factory.robofactory.parts.body.*;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Carriage;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Legs;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Truck;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Wheels;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Arms;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Manipulators;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Palp;
import headfirst.designpatterns.factory.robofactory.parts.weapons.*;
import headfirst.designpatterns.factory.robofactory.robots.Robot;

public class WarAssomblyHall implements AssamblyHall {
    RobotType robotType;

    public WarAssomblyHall(RobotType robotType) {
        this.robotType = robotType;
    }

    @Override
    public Body createBody() {
        switch (this.robotType) {
            case WORKER:
                return new IronBody(2);
            case SOLDER:
                return new SteelBody(4);
            case OFFICER:
                return new SteelBody(10);
            case MARINE:
                return new AdamantiteBody(20);
            default:
                return new LightBody(0);
        }
    }

    @Override
    public Carriage createCarriage() {

        switch (this.robotType) {
            case WORKER:
                return new Wheels(5f, 4);
            case SOLDER:
                return new Truck(2f);
            case OFFICER:
                return new Wheels(7f, 6);
            case MARINE:
                return new Truck(2.5f);
            default:
                return new Legs(1f, 2);
        }

    }

    @Override
    public Manipulators createManipulators() {
        switch (this.robotType) {
            case WORKER:
                return new Arms(2);
            case SOLDER:
                return new Arms(4);
            case OFFICER:
                return new Palp(8);
            case MARINE:
                return new Arms(6);
            default:
                return new Arms(0);
        }
    }

    @Override
    public Weapons createWeapons() {

        switch (this.robotType) {
            case WORKER:
                return new Gun(5);
            case SOLDER:
                return new Shotgun(20);
            case OFFICER:
                return new Shocker(15);
            case MARINE:
                return new Minigun(50);
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
                weaponRate = 2;
                break;
            }
            case SOLDER: {
                weaponRate = 2;
                manipulatorsRate = 2;
                break;
            }
            case OFFICER: {
                weaponRate = 2;
                manipulatorsRate = 1;
                break;
            }
            case MARINE: {
                weaponRate = 3;
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
                bodyRate = 5;
                carriageRate = 3;
                manipulatorsRate = 1;
                break;
            }
            case SOLDER: {
                bodyRate = 10;
                carriageRate = 10;
                manipulatorsRate = 2;
                break;
            }
            case OFFICER: {
                bodyRate = 10;
                carriageRate = 3;
                manipulatorsRate = 1;
                break;
            }
            case MARINE: {
                bodyRate = 15;
                carriageRate = 10;
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
