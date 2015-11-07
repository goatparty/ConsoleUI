package ConsoleUI;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    private final String VERSION_NUMBER = "0.0.1", MENU_COPYRIGHT = "goatParty's ConsoleUI";
    private String menuTitle;
    private boolean menuTitleSet,menuChoicesAlreadyCalled;
    private String[] menuChoices = new String[900];
    private int numMenuChoices;
    private int counter;
    //____________________________________________
    //ENABLES DEBUGGING MODE WHICH BYPASSES STUFF |
    //____________________________________________|
    private final boolean DEBUGGING_MODE_ENABLED = true; //TODO: Check This

    public Menu() {
        menuTitle = "Generic Program Using Goat Party's Menu Program. V" + VERSION_NUMBER;
        menuTitleSet = false;
        numMenuChoices = 0;
        menuChoicesAlreadyCalled = false;
        if (DEBUGGING_MODE_ENABLED) {
            menuChoices[0] = "Quit the program";
            menuChoices[1] = "Reset the program";
            menuChoices[2] = "Very Long String to ";
            counter = 3;
        }
    }
// | (1) - jhjhhjjhjhjhjh |
    public int callMenu() {
        int input;
        boolean longestIsMenu = false, greaterThanC = false;
        boolean isValid = false,inputLoopControl = false;
        int longest = getLongest() + 1, additionalNeeded = 0;
        if (longest == menuTitle.length()) {
            longestIsMenu = true;
        }
        if (longest > MENU_COPYRIGHT.length() + 1) {
            greaterThanC = true;
        }
        do {
            int titleLength = menuTitle.length();
            System.out.print('╒');
            if (!greaterThanC) {
                for (int x = 0; x < longest; x++) {
                    System.out.print('═');
                }
            }
            else if (greaterThanC) {
                System.out.print('═');
                System.out.print(MENU_COPYRIGHT);
                for (int x = 0; x < longest - MENU_COPYRIGHT.length() + 1; x++) {
                    System.out.print('═');
                }
            }
            System.out.print("╕\n");
            additionalNeeded = longest - menuTitle.length() + 1;
            System.out.print("│ " + menuTitle );
            for (int x = 0; x <additionalNeeded; x++) {
                System.out.print(' ');
            }
            System.out.println('│');
            System.out.print('├');
            for (int x = 0; x < longest + 2; x++) {
                System.out.print('─');
            }
            System.out.print("┤\n");
            //THIS IS WERE THE OTHER STUFF STARTS
            for (int x = 0; x < counter; x++) {
                System.out.printf("│ (%d) - %s",x+1,menuChoices[x]);
                additionalNeeded = longest - menuChoices[x].length();
                for (int i = 0; i < additionalNeeded - 5; i++) {
                    System.out.print(' ');
                }
                System.out.print("│\n");
            }
            System.out.print('└');
            for (int x = 0; x < longest + 2; x++) {
                System.out.print('─');
            }
            System.out.print('┘');
            do {
                System.out.print("Please Enter Choice: ");
                try {
                    input = keyboard.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Make Sure Your Input Is A Valid int");
                    System.out.print("Please Enter Choice:");
                    input = keyboard.nextInt();
                }
                if (input  < counter && input >= 0) {
                    inputLoopControl = true;
                }
                else {
                    System.out.println("Input Out Of Bounds");
                    isValid = false;
                    inputLoopControl = false;
                }
            } while(!inputLoopControl);
            isValid = true;
        } while (!isValid);
        return input;
    }

    private int getLongest() {
        boolean biggestIsTitle = true;
        int biggest = menuTitle.length();
        for (int i = 0; i < 3; i++) {
            String menuChoice = menuChoices[i];
            if (biggest < menuChoice.length()) {
                biggest = menuChoice.length();
                biggestIsTitle = false;
            }
        }
        if (!biggestIsTitle) {
            biggest += 8;
        }
        return biggest;
    }

    public void addMenuChoices(String[] args) {
        int currentNumChoices = 0;
        if (menuChoicesAlreadyCalled) {
            currentNumChoices = menuChoices.length + 1;
        }
        for(String arg : args) {
            menuChoices[currentNumChoices] = arg;
            currentNumChoices++;
        }
        menuChoicesAlreadyCalled = true;
    }

    public void updateNumMenuChoices() {
        numMenuChoices = menuChoices.length;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
        menuTitleSet = true;
    }
}


