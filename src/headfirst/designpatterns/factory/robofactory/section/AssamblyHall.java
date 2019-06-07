package headfirst.designpatterns.factory.robofactory.section;

import headfirst.designpatterns.factory.robofactory.RobotType;
import headfirst.designpatterns.factory.robofactory.State;
import headfirst.designpatterns.factory.robofactory.parts.body.Body;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Carriage;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Manipulators;
import headfirst.designpatterns.factory.robofactory.parts.weapons.Weapons;
import headfirst.designpatterns.factory.robofactory.robots.Robot;

public interface AssamblyHall {
    Body createBody();
    Carriage createCarriage();
    Manipulators createManipulators();
    Weapons createWeapons();

    int countCombatPower(State structure);

    int countHP(State structure);

    RobotType getRobotType();
}
