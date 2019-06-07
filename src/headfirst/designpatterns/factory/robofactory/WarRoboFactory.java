package headfirst.designpatterns.factory.robofactory;

import headfirst.designpatterns.factory.robofactory.robots.Robot;
import headfirst.designpatterns.factory.robofactory.section.AssamblyHall;
import headfirst.designpatterns.factory.robofactory.section.NanoAssamblyHall;
import headfirst.designpatterns.factory.robofactory.section.WarAssomblyHall;

public class WarRoboFactory extends RoboFactory {
    @Override
    protected Robot createRobot(RobotType roboType) {
        AssamblyHall assamblyHall = new WarAssomblyHall(roboType);
        Robot robot = this.switchRobotType(assamblyHall);
        robot.constract();
        return robot;
    }
}
