package ToyRobot;

public class GameBoard {

    private final int height; // board X axis : Height;
    private final int width; // board Y axis : Width;


    public GameBoard(int X, int Y) {
        height = X;
        width = Y;
    }

    /**
     * This function validates the position of Robot along X axis(height). Aim: To
     * be used to restrict movement of Robot towards North if it's greater than
     * board height.
     *
     * @param X
     * @return
     */
    public boolean ValidXalongNorth(int X) {
        return (X < height);
    }

    /**
     * This function validates the position of Robot along X axis(height). Aim: To
     * be used to restrict movement of Robot along South if it's less than 0.
     *
     * @param X
     * @return
     */
    public boolean ValidXalongSouth(int X) {
        return (X > 0);
    }

    /**
     * This function validates the position of Robot along Y axis(width). Aim: To be
     * used to restrict movement of Robot towards East if it's greater than board
     * width.
     *
     * @param Y
     * @return
     */
    public boolean ValidYalongEast(int Y) {
        return (Y < width);
    }

    /**
     * This function validates the position of Robot along Y axis(width). Aim: To be
     * used to restrict movement of Robot towards West if it's less than 0.
     *
     * @param Y
     * @return
     */
    public boolean ValidYalongWest(int Y) {
        return (Y > 0);
    }


    public int getBoardHeight() {
        return height;
    }

    public int getBoardWidth() {
        return height;
    }


}
