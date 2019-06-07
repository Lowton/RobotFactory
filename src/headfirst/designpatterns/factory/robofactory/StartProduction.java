package headfirst.designpatterns.factory.robofactory;

import headfirst.designpatterns.factory.robofactory.robots.Robot;

public class StartProduction {

    public static void main(String[] args) {
        RoboFactory commonRoboFactory = new CommonRoboFactory();
        RoboFactory warRoboFactory = new WarRoboFactory();
        RoboFactory nanoRoboFactory = new NanoRoboFactory();

        for(RobotType type: RobotType.values()){
            System.out.println("Now creating " + type);
            System.out.println(commonRoboFactory.orderRobot(type));
            System.out.println(nanoRoboFactory.orderRobot(type));
            System.out.println(warRoboFactory.orderRobot(type));
        }
    }
}
