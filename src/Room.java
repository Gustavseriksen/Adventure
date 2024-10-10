import java.util.ArrayList;

public class Room {

    // Attributter for ruminformation og forbindelser til andre rum
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ArrayList<Item> items; // Liste af items i rummet
    private ArrayList<Enemy> enemies; // Liste af enemies i rummet

    // Constructor til at initialisere navn, beskrivelse og lave en tom liste til items
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>(); // Initialiserer en tom liste til items
        this.enemies = new ArrayList<>(); //Initialiserer en tom liste til enemies
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

    // Metode til at tilføje et item til rummet
    public void addItem(Item item) {
        items.add(item);
    }

    //Metode til at få listen af items i rummet
    public ArrayList<Item> getItems() {
        return items;
    }

    //Metode til at finde et item i rummet ved hjælp af dets korte navn
    public Item findItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item; // Returnerer item hvis det findes
            }
        }
        return null; // Returnerer null hvis det ikke findes
    }

    // Metode til at fjerne et item fra rummet
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Metode til at tilføje en enemy til rummet
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    //Metode til at få listen af enemies i rummet
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    //Metode til at finde en enemy i rummet ved hjælp af dets navn
    public Enemy findEnemy(String name) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(name)) {
                return enemy;
            }
        }
        return null; // Returnerer null hvis det ikke findes
    }

    // Metode til at fjerne en enemy fra rummet
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }
}