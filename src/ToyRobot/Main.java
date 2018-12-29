package ToyRobot;

import java.io.*;

public class Main {



    public static void main(String[] args) {

        Direction direction;
        Robot robot = new Robot(4,4, Direction.NORTH);

        robot.move();
        robot.rotateLeft();
        robot.rotateRight();
        robot.report();

    }

}