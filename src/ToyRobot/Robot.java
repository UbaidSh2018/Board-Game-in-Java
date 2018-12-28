package ToyRobot;

import com.sun.javafx.scene.traversal.Direction;

public class Robot {

    private int X;
    private int Y;
    GameBoard gameBoard;
    private String Direction;

    public Robot(int x, int y , String direction) {
        X = x;
        Y = y;
     Direction = direction;
    }


    public void move() {

        switch (direction) {

            case NORTH:
                if (gameBoard.ValidXalongNorth(X))
                    X++;
                break;
            case SOUTH:
                if (gameBoard.ValidXalongSouth(X))
                    X--;
                break;
            case EAST:
                if (gameBoard.ValidYalongEast(Y))
                    Y++;
                break;
            case WEST:
                if (gameBoard.ValidYalongWest(Y))
                    Y--;
                break;

        }

    }



    public String report() {
        String reportPosition = "Output:(X, Y , Direction)= " + "(" + X + "," + Y + "," + Direction + ")";
        return reportPosition;

    }

}
