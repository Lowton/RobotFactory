package headfirst.designpatterns.factory.robofactory.robots;

import headfirst.designpatterns.factory.robofactory.State;
import headfirst.designpatterns.factory.robofactory.parts.body.Body;
import headfirst.designpatterns.factory.robofactory.parts.carriage.Carriage;
import headfirst.designpatterns.factory.robofactory.parts.manipulators.Manipulators;
import headfirst.designpatterns.factory.robofactory.parts.weapons.Weapons;
import headfirst.designpatterns.factory.robofactory.section.AssamblyHall;

public abstract class Robot {

    private int hitPoints;
    private int combatPower;
    private float moveSpeed;
    private State structure;
    private AssamblyHall assamblyHall;

    public Robot(AssamblyHall assamblyHall){
        this.assamblyHall = assamblyHall;
    }

    public void constract(){
        structure = new State(
                this.assamblyHall.createBody(),
                this.assamblyHall.createCarriage(),
                this.assamblyHall.createManipulators(),
                this.assamblyHall.createWeapons()
        );

        this.combatPower = this.assamblyHall.countCombatPower(structure);
        this.moveSpeed = this.structure.getCarriage().getSpeed();
        this.hitPoints = this.assamblyHall.countHP(structure);
    }

    @Override
    public String toString() {
        return "Robot {" +
                "structure: " + structure +
                ", hit points: " + hitPoints +
                ", combat power: " + combatPower +
                ", move speed: " + moveSpeed +
                " mph}";
    }
}
