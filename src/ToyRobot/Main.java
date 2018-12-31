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

        File file = new File("CommandFiles/WestBorderCheck.txt");

        if(file.exists()){
            System.out.println("file exists");
        FileReader fileReader;
            try {
                fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String singleCommandLine;
                System.out.println("file buffered");

                    try {
                        while ((singleCommandLine = bufferedReader.readLine()) != null) {
                            System.out.println("reading line");
                            if(singleCommandLine.toUpperCase().startsWith("PLACE")){
                                System.out.println("place command found");
                                String[] firstLine = singleCommandLine.split(" ");
                                String[] getParams = firstLine[1].split(",");

                                if (getParams.length == 3) {
                                    System.out.println("valid place command");
                                    int x = Integer.parseInt(getParams[0]);
                                    int y = Integer.parseInt(getParams[1]);
                                    Direction direction = Direction.valueOf(getParams[2]);

                                    if ((x >= 0 && x <= board.getBoardHeight() &&
                                            (y >= 0 && y <= board.getBoardWidth()))) {
                                        System.out.println("fetching params from place");
                                        robot = new Robot(x, y, direction);
                                        robot.loadBoard(board);
                                    }
                                }else System.out.println("PLACE Command Invalid. Correct Format \"PLACE X,Y,Direction\" ");

                            }

                            if(robot !=null){
                                System.out.println("Robot object not null");
                               if(singleCommandLine.equalsIgnoreCase("MOVE")){
                                   robot.move();
                                   System.out.println("move executed");
                               } else if(singleCommandLine.equalsIgnoreCase("RIGHT")){
                                   robot.rotateRight();
                                   System.out.println("rotate right executed");
                               } else if(singleCommandLine.equalsIgnoreCase("LEFT")){
                                   robot.rotateLeft();
                                   System.out.println("rotate left executed");
                               } else if(singleCommandLine.equalsIgnoreCase("REPORT")){
                                   System.out.println(robot.report());
                                   System.out.println("report executed");
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