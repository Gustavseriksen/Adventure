import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory; // Liste over items, spilleren bærer rundt på
    private Room currentRoom; // Spilleren holder styr på sit nuværende rum

    // Constructor
    public Player(Room startRoom) {
        this.currentRoom = startRoom; // initialiserer spillerens startposition
        this.inventory = new ArrayList<>(); // initialiserer en tom inventory liste
    }


    // Metode til at tilføje et item til inventory
    public void takeItem(Item item) {
        inventory.add(item);  // Tilføjer item til inventory
    }

    // Metode til at fjerne et item fra inventory
    public void dropItem(Item item) {
        inventory.remove(item);  // Fjerner item fra inventory
    }

    // Metode til at se hvad spilleren har i inventory
    public ArrayList<Item> getInventory() {
        return inventory;  // Returnerer listen af items i inventory
    }

    // Metode til at finde et item i spillerens inventory ved hjælp af dets korte navn
    public Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item; // Returnerer item hvis det findes i inventory
            }
        }
        return null; // Returnerer null hvis det ikke findes
    }


    // Getter for nuværende rum
    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Setter for nuværende rum
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    // Metoder til at flytte spilleren og returnere om bevægelsen var succesfuld
    public boolean moveNorth() {
        if (currentRoom.getNorth() != null) { // Tjekker om der er et rum mod nord
            currentRoom = currentRoom.getNorth(); // Opdaterer nuværende rum til det nye rum
            return true;
        }
        return false;
    }

    public boolean moveSouth() {
        if (currentRoom.getSouth() != null) { // Tjekker om der er et rum mod syd
            currentRoom = currentRoom.getSouth(); // Opdaterer nuværende rum til det nye rum
            return true;
        }
        return false;
    }

    public boolean moveEast() {
        if (currentRoom.getEast() != null) { // Tjekker om der er et rum mod øst
            currentRoom = currentRoom.getEast(); // Opdaterer nuværende rum til det nye rum
            return true;
        }
        return false;
    }

    public boolean moveWest() {
        if (currentRoom.getWest() != null) { // Tjekker om der er et rum mod vest
            currentRoom = currentRoom.getWest(); // Opdaterer nuværende rum til det nye rum
            return true;
        }
        return false;
    }
}