package ToyRobot;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) {

        int X = 4;
        int Y = 4;
        //  Direction direction;
        GameBoard board = new GameBoard(X, Y);
        Robot robot = null;

        File file = new File("CommandFiles/Commands1.txt");

        if(file.exists()){
            System.out.println("step 1");
        FileReader fileReader;
            try {
                fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String singleCommandLine;
                System.out.println("step 2");

                    try {
                        while ((singleCommandLine = bufferedReader.readLine()) != null) {
                            System.out.println("step 3");
                            if(singleCommandLine.toUpperCase().startsWith("PLACE")){
                                System.out.println("step 4");
                                String[] firstLine = singleCommandLine.split(" ");
                                String[] getParams = firstLine[1].split(",");

                                if (getParams.length == 3) {
                                    System.out.println("step 5");
                                    int x = Integer.parseInt(getParams[0]);
                                    int y = Integer.parseInt(getParams[1]);
                                    Direction direction = Direction.valueOf(getParams[2]);

                                    if ((x >= 0 && x <= board.getBoardHeight() &&
                                            (y >= 0 && y <= board.getBoardWidth()))) {
                                        System.out.println("step 6");
                                        robot = new Robot(x, y, direction);
                                        robot.loadBoard(board);
                                    }
                                }else System.out.println("PLACE Command Invalid. Correct Format \"PLACE X,Y,Direction\" ");

                            }

                            if(robot !=null){
                                System.out.println("step 7");
                               if(singleCommandLine.equalsIgnoreCase("MOVE")){
                                   robot.move();
                               } else if(singleCommandLine.equalsIgnoreCase("RIGHT")){
                                   robot.rotateRight();
                               } else if(singleCommandLine.equalsIgnoreCase("LEFT")){
                                   robot.rotateLeft();
                               } else if(singleCommandLine.equalsIgnoreCase("REPORT")){
                                   System.out.println(robot.report());
                               }
                            }

                        }

                        bufferedReader.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }



            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }



        } else{
            System.out.println("Invalid File");
        }

    }

}