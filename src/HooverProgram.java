/**
 * Created by TooToozs on 11-Sep-18.
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

class HooverProgram {
    public static void main (String[] args) throws FileNotFoundException {
        if (args.length <= 0) {
            Scanner input = new Scanner(System.in);
            executeFromCmdLine(input);
        }
        else {
            File file = new File(args[0]);
            Scanner input = new Scanner(file);
            executeFromFile(input);
        }
    }

    private static void executeFromCmdLine(Scanner input) {
        Hoover hoover = new Hoover();
        Room room = new Room();
        int initPhase = 0;

        System.out.print("Welcome, please input room dimensions: ");

        while (initPhase != 3) {
            if (input.hasNextLine()) {
                switch (initPhase) {
                    case 0:
                        if (!MyParser.inputLineOne(input, room)) {
                            System.out.print("Error input, please input room dimensions [x y]: ");
                            break;
                        }
                        initPhase = 1;
                        break;
                    case 1:
                        System.out.print("Please input hoover starting position/orientation: ");
                        if (!MyParser.inputLineTwo(input, hoover)) {
                            System.out.print("Error on input, please input hoover starting position/orientation [x y o]: ");
                            break;
                        }
                        initPhase = 2;
                        break;
                    case 2:
                        System.out.print("Please input instruction sequence: ");
                        if (!MyParser.inputLineThree(input, hoover)) {
                            System.out.print("Error on input, please input instruction sequence [DGA]: ");
                            break;
                        }
                        initPhase = 3;
                        break;
                    default:
                        break;
                }
            }
        }
        hoover.executeInstructions(room);
    }

    private static void executeFromFile(Scanner input) {
        Hoover hoover = new Hoover();
        Room room = new Room();
        int initPhase = 0;

        while (initPhase != 3) {
            if (input.hasNextLine()) {
                switch (initPhase) {
                    case 0:
                        if (!MyParser.inputLineOne(input, room)) {
                            break;
                        }
                        initPhase = 1;
                        break;
                    case 1:
                        if (!MyParser.inputLineTwo(input, hoover)) {
                            break;
                        }
                        initPhase = 2;
                        break;
                    case 2:
                        if (!MyParser.inputLineThree(input, hoover)) {
                            break;
                        }
                        initPhase = 3;
                        break;
                    default:
                        break;
                }
            }
        }
        hoover.executeInstructions(room);
    }

    public enum Orientation {
        N("N") {
            @Override
            public Orientation prev() {
                return W;
            }
        },
        E("E"),
        S("S"),
        W("W") {
            @Override
            public Orientation next() {
                return N;
            }
        };

        public Orientation next() {
            return values()[ordinal() + 1];
        }

        public Orientation prev() {
            return values()[ordinal() - 1];
        }

        private String desc;
        Orientation(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

    }

    public enum Instruction {
        D,
        G,
        A
    }

}

