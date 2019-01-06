package ToyRobot;

import ToyRobotInterface.RobotInterface;

/**
 * This Class defines Toy Robot and it's navigation commands.
 */
public class Robot implements RobotInterface {


    private int X;
    private int Y;
    private Direction direction;
    private GameBoard gameBoard;

    /**
     * Instantiate Robot with position and Direction parameters.
     *
     * @param x   Position along X
     * @param y   Position along Y
     * @param dir Direction of Robot
     */
    Robot(int x, int y, Direction dir) {
        X = x;
        Y = y;
        direction = dir;

    }

    /**
     * Initiate board
     *
     * @param board Board instance to pass
     */
    void loadBoard(GameBoard board) {
        gameBoard = board;
    }


    /**
     * Move command to increment X or Y co-ordinates until boundary along NSWE is reached.
     */
    @Override
    public void move() {

        switch (direction) {

            case NORTH:
                if (gameBoard.ValidXalongNorth(X))
                    X++;
                else System.out.println("You've reached Northern Border : Can't go beyond this point");
                break;
            case SOUTH:
                if (gameBoard.ValidXalongSouth(X))
                    X--;
                else System.out.println("You've reached Southern Border : Can't go beyond this point");
                break;
            case EAST:
                if (gameBoard.ValidYalongEast(Y))
                    Y++;
                else System.out.println("You've reached Eastern Border : Can't go beyond this point");
                break;
            case WEST:
                if (gameBoard.ValidYalongWest(Y))
                    Y--;
                else System.out.println("You've reached Western Border : Can't go beyond this point");
                break;

        }

    }

    /**
     * Rotate Robot Direction to Left. This function checks the existing direction and switches it accordingly
     */
    @Override
    public void rotateLeft() {

        switch (direction) {

            case NORTH:
                direction = Direction.WEST;
                break;

            case SOUTH:
                direction = Direction.EAST;
                break;

            case EAST:
                direction = Direction.NORTH;
                break;

            case WEST:
                direction = Direction.SOUTH;
                break;
        }

    }

    /**
     * Rotate Robot Direction to Right. This function checks the existing direction and switches it accordingly
     */
    @Override
    public void rotateRight() {
        switch (direction) {

            case NORTH:
                direction = Direction.EAST;
                break;

            case SOUTH:
                direction = Direction.WEST;
                break;

            case EAST:
                direction = Direction.SOUTH;
                break;

            case WEST:
                direction = Direction.NORTH;
                break;
        }

    }

    /**
     * This function returns current position of Robot on the board.
     *
     * @return Position of Robot
     */
    @Override
    public String report() {

        String reportPosition;

        return reportPosition = "Output:(X, Y , Direction)= " + "(" + X + "," + Y + "," + direction + ")";


    }

}
