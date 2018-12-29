package ToyRobot;

import java.io.*;

public class Main {



    public static void main(String[] args) {

        int X = 4;
        int Y = 4;
      //  Direction direction;
        GameBoard board = new GameBoard(X,Y);
        Robot robot = new Robot(0,0, Direction.NORTH);
        robot.loadBoard(board);

        robot.move();
        robot.rotateLeft();
        robot.rotateRight();
       System.out.println(robot.report());

    }

}