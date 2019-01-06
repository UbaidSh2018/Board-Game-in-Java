package ToyRobot;

import ToyRobotInterface.GameBoardInterface;

/**
 * This Class defines the Board and it's boundaries.
 */
public class GameBoard implements GameBoardInterface {

    private final int height; // board X axis : max Height;
    private final int width; // board Y axis : max Width;


    GameBoard(int X, int Y) {
        height = X;
        width = Y;
    }

    /**
     * This function validates the position of Robot along X axis(height). Aim: To
     * be used to restrict movement of Robot towards North if it's greater than
     * board height.
     * @param X Value of X co-ordinate
     * @return True if X is less than height
     */
    @Override
    public boolean ValidXalongNorth(int X) {
        return (X < height);
    }

    /**
     * This function validates the position of Robot along X axis(height). Aim: To
     * be used to restrict movement of Robot along South if it's less than 0.
     * @param X Value of X co-ordinate
     * @return True if X is greater than 0
     */
    @Override
    public boolean ValidXalongSouth(int X) {
        return (X > 0);
    }

    /**
     * This function validates the position of Robot along Y axis(width). Aim: To be
     * used to restrict movement of Robot towards East if it's greater than board
     * width.
     * @param Y Value of Y co-ordinate
     * @return True if Y is less than width
     */
    @Override
    public boolean ValidYalongEast(int Y) {
        return (Y < width);
    }

    /**
     * This function validates the position of Robot along Y axis(width). Aim: To be
     * used to restrict movement of Robot towards West if it's less than 0.
     * @param Y Value of X co-ordinate
     * @return True if Y is greater than 0
     */
    @Override
    public boolean ValidYalongWest(int Y) {
        return (Y > 0);
    }

    int getBoardHeight() {
        return height;
    }

    int getBoardWidth() {
        return width;
    }


}
