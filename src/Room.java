public class Room {

    // Attributter for ruminformation og forbindelser til andre rum
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    // Constructor til at initialisere navn og beskrivelse af rummet
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Metoder til at sætte forbindelse til andre rum
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    // Getter-metoder for rumnavn og beskrivelse
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Getter-metoder for rumsforbindelser
    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }
}