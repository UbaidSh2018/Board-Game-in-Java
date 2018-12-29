package ToyRobot;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {

    @Test
    public void validXalongNorthPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidXalongNorth(3);
        Assert.assertTrue(result);

    }

    @Test
    public void validXalongSouthPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidXalongSouth(3);
        Assert.assertTrue(result);
    }

    @Test
    public void validYalongEastPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidYalongEast(3);
        Assert.assertTrue(result);
    }

    @Test
    public void validYalongWestPass() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidYalongWest(3);
        Assert.assertTrue(result);
    }

    @Test
    public void validXalongNorthFail() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidXalongNorth(4);
        Assert.assertFalse(result);

    }

    @Test
    public void validXalongSouthFail() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidXalongSouth(-1);
        Assert.assertFalse(result);
    }


    @Test
    public void validYalongEastFail() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidYalongEast(4);
        Assert.assertFalse(result);
    }

    @Test
    public void validYalongWestFail() {
        GameBoard gameBoard = new GameBoard(4,4);
        boolean result = gameBoard.ValidYalongWest(-1);
        Assert.assertFalse(result);
    }
}