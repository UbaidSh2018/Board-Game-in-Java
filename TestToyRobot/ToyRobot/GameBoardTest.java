package ToyRobot;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {

    @Test
    public void validXalongNorthPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean resultPass = gameBoard.ValidXalongNorth(3);
        Assert.assertTrue(resultPass);

        boolean resultFail = gameBoard.ValidXalongNorth(4);
        Assert.assertFalse(resultFail);

    }

    @Test
    public void validXalongSouthPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean resultPass = gameBoard.ValidXalongSouth(3);
        Assert.assertTrue(resultPass);

        boolean resultFail = gameBoard.ValidXalongSouth(-1);
        Assert.assertFalse(resultFail);
    }

    @Test
    public void validYalongEastPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean resultPass = gameBoard.ValidYalongEast(3);
        Assert.assertTrue(resultPass);

        boolean resultFail = gameBoard.ValidYalongEast(4);
        Assert.assertFalse(resultFail);
    }

    @Test
    public void validYalongWestPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean resultPass = gameBoard.ValidYalongWest(3);
        Assert.assertTrue(resultPass);

        boolean resultFail = gameBoard.ValidYalongWest(-1);
        Assert.assertFalse(resultFail);
    }


}