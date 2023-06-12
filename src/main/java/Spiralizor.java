import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Spiralizor {

    public static int[][] spiralize(int size){

        int[][] room = new int[size + 2][size+2]; //create "surrounding walls"
        int[][] array = new int[size][size];


        Direction direction = Direction.RIGHT; //spiral "moving" to the right
        //String cleaner = "@";
        int row = 1;
        int column = 0;

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                if (i == 0 || i == room.length - 1 || j == 0 || j == room[0].length - 1) {
                    room[i][j] = 2; //create "surrounding walls"
                }else{
                    room[i][j] = 0;
                }
            }
        }


        // spiral "moving logic"
        while (!isEmpty(room)) {
            switch (direction) {
                case UP:
                    System.out.println("UP");
                    if (room[row - 1][column] != 1 && room[row - 1][column] != 2) {
                        row--;
                        room[row][column] = 1;
                        //
                        if(room[row + 1][column + 1] == 1){
                            room[row + 1][column + 1] = 1;
                        }else {
                            room[row + 1][column + 1] = 2;
                        }
                    } else {
                        direction = Direction.RIGHT;
                    }
                    break;
                case DOWN:
                    System.out.println("DOWN");
                    if (room[row + 1][column] != 1 && room[row + 1][column] != 2) {
                        row++;
                        room[row][column] = 1;
                        //
                        if(room[row - 1][column-1]==1){
                            room[row - 1][column-1] = 1;
                        } else{
                            room[row - 1][column-1] = 2;
                        }
                    } else {
                        direction = Direction.LEFT;
                    }
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    if (room[row][column - 1] != 1 && room[row][column - 1] != 2) {
                        column--;
                        room[row][column] = 1;
                        if(room[row - 1][column + 1] == 1){
                            room[row - 1][column + 1] = 1;
                        }else{
                            room[row - 1][column + 1] = 2;
                        }
                    } else {
                        direction = Direction.UP;
                    }
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    if (room[row][column + 1] != 1 && room[row][column + 1] != 2) {
                        column++;
                        room[row][column] = 1;
                        if(room[row + 1][column - 1] == 1){
                            room[row + 1][column - 1] = 1;
                        }else {
                            room[row + 1][column - 1] = 2;
                        }
                    } else {
                        direction = Direction.DOWN;
                    }
                    break;

            }


        }

        //create resultArray:
        for (int i = 1; i < room.length-1; i++) {
            for (int j = 1; j < room[0].length-1; j++) {
                if(room[i][j]==2) {
                    array[i - 1][j - 1] = 0;
                }else {
                    array[i - 1][j - 1] = room[i][j];
                }
            }
        }


        System.out.println("resultArray: "+Arrays.deepToString(array));
        return array;

    }

    public enum Direction {
        UP, DOWN, RIGHT, LEFT;
    }

    public static boolean isEmpty(int[][]room){
        for (int i = 0; i < room.length-1; i++) {
            for (int j = 0; j < room[i].length-1; j++) {
                if(room[i][j] != 1 && room[i][j] != 2){
                    return false;
                }
            }
        }
        return true;
    }

}
