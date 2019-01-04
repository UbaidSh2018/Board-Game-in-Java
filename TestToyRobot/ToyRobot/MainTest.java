package ToyRobot;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static javafx.scene.input.KeyCode.X;
import static javafx.scene.input.KeyCode.Y;
import static org.junit.Assert.*;

public class MainTest {


    @Test
    public void testMainEmptyFileInput() throws IOException {
        String[] args = {"CommandFiles/C1_EmptyFile.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = new String(bOutput.toString());
        }
        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("CommandFiles/C1_EmptyFile.txt is an Empty File", breakDownOutput[0]);
        assertEquals("CommandFiles/C1_EmptyFile.txt is an Invalid Command File", breakDownOutput[1]);
       // assertEquals("Empty file: testFiles/TestCase_04_EmptyInputFile.txt", linesOfOutput[0]);
    }

    @Test
    public void testInvalidPlaceInput() throws IOException{
        String[] args = {"CommandFiles/C2_InvalidPlace.txt"};
        String output;

        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bOutput));
            Main.main(args);
            bOutput.flush();
            output = new String(bOutput.toString());
        }

        String newLine = System.getProperty("line.separator");
        String[] breakDownOutput = output.split(newLine);

        assertEquals(2, breakDownOutput.length);
        assertEquals("PLACE Command Invalid. Correct Format PLACE X,Y,Direction", breakDownOutput[0]);
        assertEquals("CommandFiles/C2_InvalidPlace.txt is an Invalid Command File", breakDownOutput[1]);




    }

}
