package ConsoleUI;

import java.util.*;
public class Menu {
    private final String VERSION_NUMBER = "0.0.1", MENU_COPYRIGHT = "Eemil's ConsoleUI";
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
        menuTitle = "Generic Program Using Eemil's Menu Program. V" + VERSION_NUMBER;
        menuTitleSet = false;
        numMenuChoices = 0;
        menuChoicesAlreadyCalled = false;
        if (DEBUGGING_MODE_ENABLED) {
            menuChoices[0] = "Quit the program";
            menuChoices[1] = "Reset the program";
            menuChoices[2] = "Very Long String to Test stuff";
        }
    }
// | (1) - gdhjdffhghdfghdfgh |
    public int callMenu() {
        boolean longestIsMenu = false, greaterThanC = false;
        boolean isValid = false;
        int longest = getLongest() + 1, additionalNeeded = 0;
        if (longest == menuTitle.length()) {
            longestIsMenu = true;
        }
        if (longest > MENU_COPYRIGHT.length() + 1) {
            greaterThanC = true;
        }
        //Eemil's ConsoleUI
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
            System.out.print('┤');
            isValid = true;
        } while (!isValid);
        return 0;
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
    /**private static int menu() {
        int choice = 0;
        boolean isValid = false;
        String title = "CARPET COST CALCULATOR\n______________________";
        System.out.println(title);
        System.out.printf("Current Price/SF $%,.2f\n",carpet.getPrice());
        System.out.println("Please Enter Selection:");
        System.out.println("(1) - Enter X Dimension");
        System.out.println("(2) - Enter Y Dimension");
        System.out.println("(3) - Calculate Total Price");
        System.out.println("(4) - Change Price(REQUIRES PASSWORD)");
        System.out.println("(5) - Reset Carpet Object");
        System.out.println("(0) - Exit Program");

        do {
            System.out.print("Enter Choice: ");
            choice = keyboard.nextInt();
            if (choice >= 0 || choice <= 5) {
                isValid = true;
            }
            else {
                System.out.println("Invalid Input: Please Try Again\nExpected Input: 0-5\nActual Input: " + choice);
                isValid = false;
            }
        } while(!isValid);

        clearScreen();

        return choice;
    }
*/