public class Player {
    private Room currentRoom; // Spilleren holder styr på sit nuværende rum

    // Constructor initialiserer spilleren med startposition
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
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