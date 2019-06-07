package headfirst.designpatterns.factory.robofactory;

import headfirst.designpatterns.factory.robofactory.robots.*;
import headfirst.designpatterns.factory.robofactory.section.AssamblyHall;
import headfirst.designpatterns.factory.robofactory.section.NanoAssamblyHall;

public abstract class RoboFactory {

    protected abstract Robot createRobot(RobotType roboType);

    public Robot orderRobot(RobotType type){
        Robot robot = createRobot(type);
        robot.constract();
        return robot;
    }

    protected Robot switchRobotType(AssamblyHall assamblyHall){
        RobotType type = assamblyHall.getRobotType();
        switch (type){
            case WORKER: {
                return new Worker(assamblyHall);
            }
            case SOLDER: {
               return new Solder(assamblyHall);
            }
            case OFFICER: {
                return new Officer(assamblyHall);
            }
            case MARINE: {
                return new Marine(assamblyHall);
            }
            default: return null;
        }
    }
}
