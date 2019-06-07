package headfirst.designpatterns.factory.robofactory;

import headfirst.designpatterns.factory.robofactory.robots.Robot;
import headfirst.designpatterns.factory.robofactory.robots.Solder;
import headfirst.designpatterns.factory.robofactory.robots.Worker;
import headfirst.designpatterns.factory.robofactory.section.AssamblyHall;
import headfirst.designpatterns.factory.robofactory.section.CommonAssamblyHall;
import headfirst.designpatterns.factory.robofactory.section.NanoAssamblyHall;

public class CommonRoboFactory extends RoboFactory {

    @Override
    protected Robot createRobot(RobotType roboType) {
        AssamblyHall assamblyHall = new CommonAssamblyHall(roboType);
        Robot robot = this.switchRobotType(assamblyHall);
        robot.constract();
        return robot;
    }
}
