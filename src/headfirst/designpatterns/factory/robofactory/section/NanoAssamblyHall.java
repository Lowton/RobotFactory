package headfirst.designpatterns.factory.robofactory.section;

import headfirst.designpatterns.factory.robofactory.RobotType;
import headfirst.designpatterns.factory.robofactory.State;
import headfirst.designpatterns.factory.robofactory.parts.body.Body;
import headfirst.designpatterns.factory.robofactory.parts.body.IronBody;
import headfirst.designpatterns.factory.robofactory.parts.body.LightBody;
import headfirst.designpatterns.factory.robofactory.parts.body.SteelBody;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Carriage;
import headfirst.designpatterns.factory.robofactory.parts.carriage.MagneticCushion;
import headfirst.designpatterns.factory.robofactory.parts.carriage.NearFieldImpact;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Arms;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Manipulators;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Palp;
import headfirst.designpatterns.factory.robofactory.parts.weapons.*;
import headfirst.designpatterns.factory.robofactory.robots.Robot;

public class NanoAssamblyHall implements AssamblyHall {

    private RobotType robotType;

    public NanoAssamblyHall(RobotType robotType) {
        this.robotType = robotType;
    }

    @Override
    public Body createBody() {
        switch (this.robotType) {
            case WORKER:
                return new SteelBody(2);
            case SOLDER:
                return new LightBody(4);
            case OFFICER:
                return new IronBody(10);
            case MARINE:
                return new SteelBody(20);
            default:
                return new LightBody(0);
        }
    }

    @Override
    public Carriage createCarriage() {
        switch (this.robotType) {
            case WORKER:
                return new NearFieldImpact(2f);
            case SOLDER:
                return new MagneticCushion(1.5f);
            case OFFICER:
                return new MagneticCushion(2f);
            case MARINE:
                return new MagneticCushion(2.5f);
            default:
                return new NearFieldImpact(1f);
        }
    }

    @Override
    public Manipulators createManipulators() {
        switch (this.robotType) {
            case WORKER:
                return new Palp(10);
            case SOLDER:
                return new Palp(14);
            case OFFICER:
            case MARINE:
                return new Palp(20);
            default:
                return new Arms(0);
        }
    }

    @Override
    public Weapons createWeapons() {

        switch (this.robotType) {
            case WORKER:
                return new Shocker(1);
            case SOLDER:
                return new Laser(3);
            case OFFICER:
                return new Faser(5);
            case MARINE:
                return new Laser(7);
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
                manipulatorsRate = 0;
                weaponRate = 1;
                break;
            }
            case SOLDER: {
                weaponRate = 1;
                manipulatorsRate = 1;
                break;
            }
            case OFFICER: {
                weaponRate = 1;
                manipulatorsRate = 0;
                break;
            }
            case MARINE: {
                weaponRate = 2;
                manipulatorsRate = 1;
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
                bodyRate = 1;
                carriageRate = 0;
                manipulatorsRate = 0;
                break;
            }
            case SOLDER: {
                bodyRate = 2;
                carriageRate = 0;
                manipulatorsRate = 0;
                break;
            }
            case OFFICER: {
                bodyRate = 3;
                carriageRate = 0;
                manipulatorsRate = 0;
                break;
            }
            case MARINE: {
                bodyRate = 5;
                carriageRate = 0;
                manipulatorsRate = 0;
                break;
            }
            default: {
                bodyRate = 0;
                carriageRate = 0;
                manipulatorsRate = 0;
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

