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
        System.out.println("“You are starting in the room called room1 and you have the following options: \n1. Type \"go north\": then you will go north \n2. Type \"go east\": then you will go east \n3. Type \"go south\": then you will go south \n4. Type \"go west\": then you will go west \n5. Type \"exit\": then you will exit the game \n6. Type \"help\": then you will get the following options \n7. Type \"look\": then you will get a description of what you can see in the room");

        // Hovedloopet for spillet, kører indtil running bliver sat til false
        while (running) {
            System.out.println("Type a command to perform an action: ");
            input = scanner.nextLine().toLowerCase(); // // Læser brugerens input og gør det til småt

            // Switch-statement der håndterer brugerens input
            switch (input) {
                case "go north":
                    goNorth(); // Spilleren bevæger sig nord
                    break;
                case "go east":
                    goEast(); // Spilleren bevæger sig øst
                    break;
                case "go south":
                    goSouth(); // Spilleren bevæger sig syd
                    break;
                case "go west":
                    goWest(); // Spilleren bevæger sig vest
                    break;
                case "exit":
                    exit(); // Afslutter spillet
                    break;
                case "help":
                    help(); // Viser hjælpemenuen
                    break;
                case "look":
                    look(); // Viser beskrivelsen af nuværende rum
                    break;
                default:
                    ukendtKommando(); // Håndterer ukendt kommando
                    break;
            }
        }
    }

    // Metode til at udskrive en besked i terminalen
    public void printBesked(String besked) {
        System.out.println(besked);
    }

    // Spilleren forsøger at bevæge sig nord
    private void goNorth() {
        // Tjekker om spilleren kan bevæge sig nord og opdaterer positionen
        if (adventure.getPlayer().moveNorth()) {
            printBesked("You are now in " + adventure.getPlayer().getCurrentRoom().getName());
        } else {
            printBesked("You cannot go that way.");
        }
    }

    // Spilleren forsøger at bevæge sig øst
    private void goEast() {
        // Tjekker om spilleren kan bevæge sig øst og opdaterer positionen
        if (adventure.getPlayer().moveEast()) {
            printBesked("You are now in " + adventure.getPlayer().getCurrentRoom().getName());
        } else {
            printBesked("You cannot go that way.");
        }
    }

    // Spilleren forsøger at bevæge sig syd
    private void goSouth() {
        // Tjekker om spilleren kan bevæge sig syd og opdaterer positionen
        if (adventure.getPlayer().moveSouth()) {
            printBesked("You are now in " + adventure.getPlayer().getCurrentRoom().getName());
        } else {
            printBesked("You cannot go that way.");
        }
    }

    // Spilleren forsøger at bevæge sig vest
    private void goWest() {
        // Tjekker om spilleren kan bevæge sig vest og opdaterer positionen
        if (adventure.getPlayer().moveWest()) {
            printBesked("You are now in " + adventure.getPlayer().getCurrentRoom().getName());
        } else {
            printBesked("You cannot go that way.");
        }
    }

    // Afslutter spillet
    private void exit() {
        printBesked("Exiting program");
        running = false; // Dette vil stoppe while-loopet og afslutte programmet
    }

    // Viser hjælpemenuen
    private void help() {
        printBesked("You have the following options: \n1. Type \"go north\": then you will go north \n2. Type \"go east\": then you will go east \n3. Type \"go south\": then you will go south \n4. Type \"go west\": then you will go west \n5. Type \"exit\": then you will exit the game \n6. Type \"help\": then you will get the following options \n7. Type \"look\": then you will get a description of what you can see in the room");
    }

    // Viser beskrivelsen af det nuværende rum
    private void look() {
        printBesked(adventure.getPlayer().getCurrentRoom().getDescription());
    }

    // Håndterer ukendte kommandoer fra spilleren
    private void ukendtKommando() {
        printBesked("Invalid command, try again");
    }
}