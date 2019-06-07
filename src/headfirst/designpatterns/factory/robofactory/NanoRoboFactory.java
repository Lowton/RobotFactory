package headfirst.designpatterns.factory.robofactory;

import headfirst.designpatterns.factory.robofactory.robots.Robot;
import headfirst.designpatterns.factory.robofactory.robots.Solder;
import headfirst.designpatterns.factory.robofactory.robots.Worker;
import headfirst.designpatterns.factory.robofactory.section.AssamblyHall;
import headfirst.designpatterns.factory.robofactory.section.NanoAssamblyHall;

public class NanoRoboFactory extends RoboFactory {
    @Override
    protected Robot createRobot(RobotType roboType) {
        AssamblyHall nanoAssamblyHall = new NanoAssamblyHall(roboType);
        Robot robot = this.switchRobotType(nanoAssamblyHall);
        robot.constract();
        return robot;
    }
}
