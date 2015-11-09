package ConsoleUI;
import java.util.Scanner;

public class Confirm {


    public static boolean callConfirm() {
        final char HORIZONTAL_THIN = '─', HORIZONTAL_THICK = '━', VERTICAL_THIN = '│', VERTICAL_THICK = '┃',
                TOP_LEFT = '┌', TOP_RIGHT = '┐', BOTTOM_LEFT = '└', BOTTOM_RIGHT = '┘', DIVIDER_LEFT = '├',
                DIVIDER_RIGHT = '┤';
        printSpace(40, false);
        System.out.print(TOP_LEFT);
        printLine(38);
        System.out.print(TOP_RIGHT);
        newLine();
        printSpace(40, false);
        System.out.print(VERTICAL_THIN);
        System.out.print("Are You Sure You Want To Continue? Y/N");
        System.out.print(VERTICAL_THIN);
        newLine();
        printSpace(40, false);
        System.out.print(BOTTOM_LEFT);
        printLine(38);
        System.out.print(BOTTOM_RIGHT);
        newLine();
        return getInput();
    }

    private static boolean getInput() {
        Scanner keyboard = new Scanner(System.in);
        String input;
        char inputChar;
        printSpace(40, false);
        System.out.print("Enter Input: ");
        input = keyboard.nextLine();
        input = input.toLowerCase();
        input = input.trim();
        inputChar = input.charAt(0);
        return inputChar == 'y';
    }

    private static void printSpace(int numSpaces, boolean newLine) {
        for (int x = 0; x < numSpaces; x++) {
            System.out.print(' ');
        }
        if (newLine) {
            newLine();
        }
    }

    private static void printLine(int numLines) {
        final char HORIZONTAL_THIN = '─', HORIZONTAL_THICK = '━', VERTICAL_THIN = '│', VERTICAL_THICK = '┃', TOP_LEFT = '┌', TOP_RIGHT = '┐',
                BOTTOM_LEFT = '└', BOTTOM_RIGHT = '┘', DIVIDER_LEFT = '├', DIVIDER_RIGHT = '┤';
        for (int x = 0; x < numLines; x++) {
            System.out.print(HORIZONTAL_THIN);
        }
    }

    private static void newLine() {
        System.out.print('\n');
    }

}
