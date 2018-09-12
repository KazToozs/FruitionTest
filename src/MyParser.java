import java.util.Scanner;

/**
 * Created by TooToozs on 11-Sep-18.
 */

public class MyParser {
    static public boolean inputLineOne(Scanner input, Room room) {
        if (input.hasNextInt()) {
            room.sizeX = input.nextInt();
        }
        if (input.hasNextInt()) {
            room.sizeY = input.nextInt();
            return true;
        }
        return false;
    }

    static public boolean inputLineTwo(Scanner input, Hoover hoover) {
        if (input.hasNextInt()) {
            hoover.posX = input.nextInt();
        }
        if (input.hasNextInt()) {
            hoover.posY = input.nextInt();
        }
        else
            return false;
        if (input.hasNext()) {
            String orientationInput = input.next();
            hoover.orientation = HooverProgram.Orientation.valueOf(orientationInput);
            return true;
        }
        return false;
    }

    static public boolean inputLineThree(Scanner input, Hoover hoover) {
        String instructionInput = input.next();
        hoover.instructions = new HooverProgram.Instruction[instructionInput.length()];

        for (int i = 0; i < instructionInput.length(); i++) {
            char c = instructionInput.charAt(i);

            hoover.instructions[i] = HooverProgram.Instruction.valueOf(Character.toString(c));
        }
        return true;
    }
}