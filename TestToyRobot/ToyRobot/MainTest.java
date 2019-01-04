package ToyRobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {


    @Test
    public void testMainEmptyFileInput() throws IOException {
        String[] args = {"CommandFiles/C1_EmptyFile.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = bOutput.toString();
        }
        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("CommandFiles/C1_EmptyFile.txt is an Empty File", breakDownOutput[0]);
        assertEquals("CommandFiles/C1_EmptyFile.txt is an Invalid Command File", breakDownOutput[1]);
        // assertEquals("Empty file: testFiles/TestCase_04_EmptyInputFile.txt", linesOfOutput[0]);
    }

    @Test
    public void testInvalidPlace() throws IOException {
        String[] args = {"CommandFiles/C2_InvalidPlace.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("PLACE Command Invalid. Correct Format PLACE X,Y,Direction", breakDownOutput[0]);
        assertEquals("CommandFiles/C2_InvalidPlace.txt is an Invalid Command File", breakDownOutput[1]);

    }

    @Test
    public void testInvalidMovementCommand() throws IOException {
        String[] args = {"CommandFiles/C3_InvalidMovementCommands.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = bOutput.toString();
        }
        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(1, breakDownOutput.length);
        assertEquals("Output:(X, Y , Direction)= (2,2,NORTH)", breakDownOutput[0]);

    }

    @Test
    public void testInvalidReportCommand() throws IOException {
        String[] args = {"CommandFiles/C4_InvalidReportCommand.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(1, breakDownOutput.length);
        assertEquals("", breakDownOutput[0]);
    }

    @Test
    public void testFirstCommandNotPlace() throws IOException {
        String[] args = {"CommandFiles/C5_FirstCommandNotPlace.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("Output:(X, Y , Direction)= (0,0,EAST)", breakDownOutput[0]);
        assertEquals("Output:(X, Y , Direction)= (0,0,NORTH)", breakDownOutput[1]);
    }

    @Test
    public void testLeftRotateCommand() throws IOException {
        String[] args = {"CommandFiles/C6_LeftRotateCommand.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(1, breakDownOutput.length);
        assertEquals("Output:(X, Y , Direction)= (0,0,WEST)", breakDownOutput[0]);

    }

    @Test
    public void testRightRotateCommand() throws IOException {
        String[] args = {"CommandFiles/C7_RightRotateCommand.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(1, breakDownOutput.length);
        assertEquals("Output:(X, Y , Direction)= (0,0,EAST)", breakDownOutput[0]);

    }

    @Test
    public void testValidComboCommand() throws IOException {
        String[] args = {"CommandFiles/C8_ValidComboCommands.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(4, breakDownOutput.length);
        assertEquals("Output:(X, Y , Direction)= (0,4,EAST)", breakDownOutput[0]);
        assertEquals("Output:(X, Y , Direction)= (3,4,NORTH)", breakDownOutput[1]);
        assertEquals("Output:(X, Y , Direction)= (4,4,NORTH)", breakDownOutput[2]);
        assertEquals("Output:(X, Y , Direction)= (4,3,WEST)", breakDownOutput[3]);


    }

    @Test
    public void testMultiplePlaceCommand() throws IOException {
        String[] args = {"CommandFiles/C9_MultiplePlaceCommands.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(3, breakDownOutput.length);
        assertEquals("Output:(X, Y , Direction)= (2,0,NORTH)", breakDownOutput[0]);
        assertEquals("Output:(X, Y , Direction)= (0,0,EAST)", breakDownOutput[1]);
        assertEquals("Output:(X, Y , Direction)= (4,2,NORTH)", breakDownOutput[2]);


    }

    @Test
    public void testNorthBorder() throws IOException {
        String[] args = {"CommandFiles/C10_NorthBorderCheck.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(3, breakDownOutput.length);
        assertEquals("You've reached Northern Border : Can't go beyond this point", breakDownOutput[0]);
        assertEquals("You've reached Northern Border : Can't go beyond this point", breakDownOutput[1]);
        assertEquals("Output:(X, Y , Direction)= (4,2,EAST)", breakDownOutput[2]);

    }

    @Test
    public void testSouthBorder() throws IOException {
        String[] args = {"CommandFiles/C11_SouthBorderCheck.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(3, breakDownOutput.length);
        assertEquals("You've reached Southern Border : Can't go beyond this point", breakDownOutput[0]);
        assertEquals("You've reached Southern Border : Can't go beyond this point", breakDownOutput[1]);
        assertEquals("Output:(X, Y , Direction)= (0,1,EAST)", breakDownOutput[2]);

    }

    @Test
    public void testEastBorder() throws IOException {
        String[] args = {"CommandFiles/C12_EastBorderCheck.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(3, breakDownOutput.length);
        assertEquals("You've reached Eastern Border : Can't go beyond this point", breakDownOutput[0]);
        assertEquals("You've reached Eastern Border : Can't go beyond this point", breakDownOutput[1]);
        assertEquals("Output:(X, Y , Direction)= (2,4,NORTH)", breakDownOutput[2]);

    }

    @Test
    public void testWestBorder() throws IOException {
        String[] args = {"CommandFiles/C13_WestBorderCheck.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("You've reached Western Border : Can't go beyond this point", breakDownOutput[0]);
        assertEquals("Output:(X, Y , Direction)= (2,0,NORTH)", breakDownOutput[1]);

    }

    @Test
    public void testMultipleArgumentsPassed() throws IOException{

        String[] args = {"CommandFiles/C13_WestBorderCheck.txt" , "CommandFiles/C13_EastBorderCheck.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("You've reached Western Border : Can't go beyond this point", breakDownOutput[0]);
        assertEquals("Output:(X, Y , Direction)= (2,0,NORTH)", breakDownOutput[1]);
    }


    @Test
    public void testRobotOutOfBoard() throws IOException{

        String[] args = {"CommandFiles/C14_RobotOutofBoard.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            bOutput.flush();
            Main.main(args);
            output = bOutput.toString();
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(1, breakDownOutput.length);
        assertEquals("CommandFiles/C14_RobotOutofBoard.txt is an Invalid Command File", breakDownOutput[0]);

    }


}
