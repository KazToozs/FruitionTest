/**
 * Created by TooToozs on 11-Sep-18.
 */

public class Hoover {
    int posX;
    int posY;
    HooverProgram.Orientation orientation;
    HooverProgram.Instruction[] instructions;

    public void executeInstructions(Room room) {
        for (int i = 0; i < instructions.length; i++) {
            switch (instructions[i]) {
                case A:
                    if (orientation == HooverProgram.Orientation.N
                            && (this.posY + 1) < room.sizeY) {
                        this.posY = this.posY + 1;
                    }
                    else if (orientation == HooverProgram.Orientation.S
                            && this.posY > 0) {
                        this.posY = this.posY - 1;
                    }
                    else if (orientation == HooverProgram.Orientation.E
                            && (this.posX + 1) < room.sizeX) {
                        this.posX = this.posX + 1;
                    }
                    else if (orientation == HooverProgram.Orientation.W
                            && this.posX > 0) {
                        this.posX = this.posX - 1;
                    }
                    break;
                case D:
                    this.orientation = this.orientation.next();
                    break;
                case G:
                    this.orientation = this.orientation.prev();
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%d %d %s", posX, posY, orientation.getDesc() + "\n");
    }
}