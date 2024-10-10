import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner; // Scanner til at læse brugerens input fra konsollen
    private Adventure adventure; // Reference til Adventure-klassen for at interagere med spillet
    private boolean running; // Boolean der styrer om spillet kører

    // Constructor til at initialisere scanner og adventure
    public UserInterface(Adventure adventure) {
        this.scanner = new Scanner(System.in);
        this.adventure = adventure;
    }

    // start() metoden starter brugerinteraktionen og spillets hovedloop
    public void start() {
        String input; // String til at holde brugerens input
        running = true; // Sætter running til true for at starte spillet

        // Udskriver introduktion til spillet og instruktioner til spilleren
        System.out.println("Welcome to Adventure \nthis is a text based game… a bit about how the game works… ");
        System.out.println("You are starting in a " + adventure.getPlayer().getCurrentRoom().getDescription()); // Udskriver beskrivelsen af det nuværende rum
        printItemsInRoom(adventure.getPlayer().getCurrentRoom()); // Udskriver items, ét pr. linje
        printEnemiesInRoom(adventure.getPlayer().getCurrentRoom()); //Udskriver enemies, en pr. linje
        System.out.println(getHelpDescription()); // Udskriver hjælpemenuen

        // Hovedloopet for spillet, kører indtil running bliver sat til false
        while (running) {
            System.out.println("Type a command to perform an action: ");
            input = scanner.nextLine().toLowerCase(); // // Læser brugerens input og gør det til småt

            // Splitter inputtet op i kommando og eventuelt item-navn
            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            String itemName;
            if (inputParts.length > 1) {
                // Hvis der er mere end én del i inputParts, henter vi den anden del (item-navnet)
                itemName = inputParts[1];
            } else {
                // Hvis der kun er én del, sættes itemName til en tom streng
                itemName = "";
            }

            // Switch-statement der håndterer brugerens input
            switch (command) {
                case "go":
                    switch (itemName) { // Tjek retningen for "go"
                        case "north":
                            goNorth(); // Spilleren bevæger sig nord
                            break;
                        case "east":
                            goEast(); // Spilleren bevæger sig øst
                            break;
                        case "south":
                            goSouth(); // Spilleren bevæger sig syd
                            break;
                        case "west":
                            goWest(); // Spilleren bevæger sig vest
                            break;
                        default:
                            System.out.println("Invalid direction, try again");
                            break;
                    }
                    break;
                case "exit":
                    exit(); // Afslutter spillet
                    break;
                case "help":
                    System.out.println(getHelpDescription()); // Viser hjælpemenuen
                    break;
                case "look":
                    look(); // Viser beskrivelsen af nuværende rum
                    break;
                case "take":
                    handleTakeCommand(itemName); // Kalder metoden for at "take" et item
                    break;
                case "inventory":
                    showInventory();
                    break;
                case "drop":
                    handleDropCommand(itemName); // Kalder metoden for at "drop" et item
                    break;
                case "health": // udskriver players health
                    health();
                    break;
                case "eat":
                    String result = adventure.getPlayer().eat(itemName); // Bruger Player-klassens eat-metode
                    System.out.println(result);
                    break;
                case "equip":
                    String equipResult = adventure.getPlayer().equip(itemName);
                    System.out.println(equipResult);
                    break;
                case "unequip":
                    unequipWeapon();
                    break;
                case "attack":
                    String attackResult = adventure.getPlayer().attack(itemName); // Kalder attack med itemName som parameter
                    System.out.println(attackResult);
                    break;
                default:
                    ukendtKommando(); // Håndterer ukendt kommando
                    break;
            }
        }
    }


    // Hjælpefunktion til at udskrive items i rummet, én pr. linje
    private void printItemsInRoom(Room room) {
        if (room.getItems().isEmpty()) {
            System.out.println("There are no items in this room.");
        } else {
            System.out.println("Items in this room:");
            for (Item item : room.getItems()) {
                System.out.println("- " + item.getLongName());
            }
        }
    }

    // Hjælpefunktion til at udskrive items i rummet, én pr. linje
    private void printEnemiesInRoom(Room room) {
        if (room.getEnemies().isEmpty()) {
            System.out.println("There are no enemies in this room.");
        } else {
            System.out.println("enemies in this room:");
            for (Enemy enemy : room.getEnemies()) {
                System.out.println("- " + enemy.getName() + " Health: " + enemy.getHealth() + " Damage: " + enemy.getCurrentWeapon().damage());
            }
        }
    }

    // Spilleren forsøger at bevæge sig nord
    private void goNorth() {
        // Tjekker om spilleren kan bevæge sig nord og opdaterer positionen
        if (adventure.getPlayer().moveNorth()) {
            System.out.println("You are now in a " + adventure.getPlayer().getCurrentRoom().getDescription());
            printItemsInRoom(adventure.getPlayer().getCurrentRoom()); // Udskriver items, ét pr. linje
            printEnemiesInRoom(adventure.getPlayer().getCurrentRoom()); //Udskriver enemies, en pr. linje
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    // Spilleren forsøger at bevæge sig øst
    private void goEast() {
        // Tjekker om spilleren kan bevæge sig øst og opdaterer positionen
        if (adventure.getPlayer().moveEast()) {
            System.out.println("You are now in a " + adventure.getPlayer().getCurrentRoom().getDescription());
            printItemsInRoom(adventure.getPlayer().getCurrentRoom()); // Udskriver items, ét pr. linje
            printEnemiesInRoom(adventure.getPlayer().getCurrentRoom()); //Udskriver enemies, en pr. linje
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    // Spilleren forsøger at bevæge sig syd
    private void goSouth() {
        // Tjekker om spilleren kan bevæge sig syd og opdaterer positionen
        if (adventure.getPlayer().moveSouth()) {
            System.out.println("You are now in a " + adventure.getPlayer().getCurrentRoom().getDescription());
            printItemsInRoom(adventure.getPlayer().getCurrentRoom()); // Udskriver items, ét pr. linje
            printEnemiesInRoom(adventure.getPlayer().getCurrentRoom()); //Udskriver enemies, en pr. linje
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    // Spilleren forsøger at bevæge sig vest
    private void goWest() {
        // Tjekker om spilleren kan bevæge sig vest og opdaterer positionen
        if (adventure.getPlayer().moveWest()) {
            System.out.println("You are now in a " + adventure.getPlayer().getCurrentRoom().getDescription());
            printItemsInRoom(adventure.getPlayer().getCurrentRoom()); // Udskriver items, ét pr. linje
            printEnemiesInRoom(adventure.getPlayer().getCurrentRoom()); //Udskriver enemies, en pr. linje
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    // Afslutter spillet
    private void exit() {
        System.out.println("Exiting program");
        running = false; // Dette vil stoppe while-loopet og afslutte programmet
    }

    // Viser hjælpemenuen
    private String getHelpDescription() {
        return "You have the following options: \n" +
                "1. Type \"go north\": then you will go north \n" +
                "2. Type \"go east\": then you will go east \n" +
                "3. Type \"go south\": then you will go south \n" +
                "4. Type \"go west\": then you will go west \n" +
                "5. Type \"exit\": then you will exit the game \n" +
                "6. Type \"help\": then you will get the following options \n" +
                "7. Type \"look\": then you will get a description of what you can see in the room \n" +
                "8. Type \"take itemName\": then you will take the following item and put it in your inventory \n" +
                "9. Type \"inventory\": then you will get a list of what you have in your inventory \n" +
                "10. Type \"drop itemName\": then you gonna drop the following item in the room \n" +
                "11. Type \"health\": then you see the current health you got\n" +
                "12. Type \"eat foodName\": then you will eat the following food\n" +
                "13. Type \"equip weaponName\": then you will equip the following weapon\n" +
                "14. Type \"unequip\": then you will unequip your weapon\n" +
                "15. Type \"attack\": then you will attack";
    }

    // Viser beskrivelsen af det nuværende rum og de items der befinder sig i rummet
    private void look() {
        System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());
        printItemsInRoom(adventure.getPlayer().getCurrentRoom()); // Udskriver items, ét pr. linje
        printEnemiesInRoom(adventure.getPlayer().getCurrentRoom()); //Udskriver enemies, en pr. linje
    }


    // Udskriver spillerens nuværende health
    private void health() {
        System.out.println("Health: " + adventure.getPlayer().getHealth());
    }

    // Metode til at håndtere 'take' kommandoen
    public void handleTakeCommand(String itemName) {
        // Finder item i det nuværende rum
        Item item = adventure.getPlayer().getCurrentRoom().findItem(itemName);

        if (item != null) {
            // Fjerner item fra rummet
            adventure.getPlayer().getCurrentRoom().removeItem(item);

            // Tilføjer item til spillerens inventory
            adventure.getPlayer().takeItem(item);

            // Giv feedback til spilleren
            System.out.println("You have taken the " + item.getLongName());
        } else {
            System.out.println("There is no such item in this room.");
        }
    }


    public void handleDropCommand(String itemName) {
        // Finder item i spillerens inventory
        Item item = adventure.getPlayer().findItemInInventory(itemName);

        if (item != null) {
            // Fjerner item fra spillerens inventory
            adventure.getPlayer().dropItem(item);

            // Tilføjer item til det nuværende rum
            adventure.getPlayer().getCurrentRoom().addItem(item);

            // Giv feedback til spilleren
            System.out.println("You have dropped the " + item.getLongName());
        } else {
            System.out.println("You don't have such item in your inventory.");
        }
    }

    // Step 4: Vise spillerens inventory
    public void showInventory() {
        ArrayList<Item> inventory = adventure.getPlayer().getInventory();
        Weapon equippedWeapon = adventure.getPlayer().getCurrentWeapon(); // Henter det udstyrede våben

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getLongName());
            }
        }


        if (equippedWeapon != null) {
            if (equippedWeapon.isUnlimitedUses()) {
                System.out.println("Currently equipped weapon: " + equippedWeapon.getLongName());
            } else {
                System.out.println("Currently equipped weapon: " + equippedWeapon.getLongName() + "\n" + "Ammo: " + equippedWeapon.remainingUses());
            }
        } else {
            System.out.println("You have no weapon equipped.");
        }
    }

    private void unequipWeapon() {
        if (adventure.getPlayer().getCurrentWeapon() == null) {
            System.out.println("You have no weapon equipped to unequip.");
        } else {
            adventure.getPlayer().unequip();
            System.out.println("You have unequipped your weapon");
        }
    }


    // Håndterer ukendte kommandoer fra spilleren
    private void ukendtKommando() {
        System.out.println("Invalid command, try again");
    }
}