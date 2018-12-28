package ToyRobot;

import java.io.*;

public class Main {



    public static void main(String[] args) {

        Robot robot = new Robot(4,4, "North");

        robot.place();
        robot.move();
        robot.rotateLeft();
        robot.rotateRight();
        robot.report();

    }

}