import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory; // Liste over items, spilleren bærer rundt på
    private Room currentRoom; // Spilleren holder styr på sit nuværende rum
    private int health; // Health viser spillerens aktuelle health-status – både som tal og forklarende tekst
    private Weapon currentWeapon; // Holder styr på hvilket våben spilleren har equipped


    private void hit (int damage) {
        health -=damage;
    }

    // Constructor
    public Player(Room startRoom) {
        this.currentRoom = startRoom; // initialiserer spillerens startposition
        this.inventory = new ArrayList<>(); // initialiserer en tom inventory liste
        this.health = 100; // initialiserer spillerens health til at være 100 når spillet starter
        this.currentWeapon = null; // Spilleren starter uden et våben udstyret
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

    public String attack(String enemyName) {
        Weapon weapon = getCurrentWeapon();
        Room currentRoom = getCurrentRoom();
        Enemy enemy = enemyName.isEmpty() ? currentRoom.getEnemies().get(0) : currentRoom.findEnemy(enemyName);

        if (weapon == null) {
            return "You don't have any weapon equipped.";
        }
        if (weapon.remainingUses() == 0) {
            return "Your weapon has no ammunition left.";
        }
        if (enemy == null) {
            return "There are no enemies to attack here.";
        }

        // Angrib fjenden
        int damage = weapon.damage();
        enemy.hit(damage);

        // Reducere ammunition for RangedWeapon
        if (weapon instanceof RangedWeapon) {
            ((RangedWeapon) weapon).attack();
        }

        // Check om fjenden døde
        if (enemy.getHealth() <= 0) {
            currentRoom.removeEnemy(enemy);
            currentRoom.addItem(enemy.getCurrentWeapon()); // Fjenden dropper våbenet
            return "You defeated the " + enemy.getName() + " and it dropped a " + enemy.getCurrentWeapon().getLongName();
        }

        // Fjendens modangreb
        int enemyDamage = enemy.getCurrentWeapon().damage();
        this.hit(enemyDamage);

        return "You attacked the " + enemy.getName() + " with " + damage + " damage. The " + enemy.getName() + " remaining health is now " + enemy.getHealth() + "." +
               "The " + enemy.getName() + " attacked back with " + enemyDamage + " damage. Your health is now " + this.getHealth();
    }



    public String equip(String itemName) {
        //Tjekker om våbenet er i inventory
        Item item = findItemInInventory(itemName);

        if (item != null) {
            // Hvis item er fundet i inventory
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                currentWeapon = weapon; //Våbnet tilføjes til currentWeapon og er hermed equipped
                return "You have equipped " + weapon.getLongName();
            } else {
                return "You can't equip " + item.getLongName() + " it is not a weapon.";
            }
        }
        return "There is no such weapon to equip.";
    }


    public String eat(String itemName) {
        // Tjekker om maden er i inventory
        Item item = findItemInInventory(itemName);

        if (item != null) {
            // Hvis item er fundet i inventory
            if (item instanceof Food) {
                Food food = (Food) item;
                health += food.getHealthPoints();  // Justerer health med madens healthPoints
                inventory.remove(item);  // Fjerner maden fra inventory permanent
                return "You have eaten " + food.getLongName() + " and gained " + food.getHealthPoints() + " health.";
            } else {
                return "You can't eat " + item.getLongName() + ".";
            }
        }

        // Hvis maden ikke er i inventory, tjekker vi rummet
        item = currentRoom.findItem(itemName);

        if (item != null) {
            // Hvis item er fundet i rummet
            if (item instanceof Food) {
                Food food = (Food) item;
                health += food.getHealthPoints();  // Justerer health med madens healthPoints
                currentRoom.removeItem(item);  // Fjerner maden fra rummet permanent
                return "You have eaten " + food.getLongName() + " and gained " + food.getHealthPoints() + " health.";
            } else {
                return "You can't eat " + item.getLongName() + ".";
            }
        }

        return "There is no such item to eat.";
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

    // Getter-metode for spillerens health
    public int getHealth() {
        // Returnerer spillerens nuværende health-værdi
        return health;
    }

    // Setter-metode for spillerens health
    public void setHealth(int health) {
        // Opdaterer spillerens health med en ny værdi
        this.health = health;
    }

    // Getter-metode for currentWeapon
    public Weapon getCurrentWeapon() {
        // Returnerer spillerens nuværende equipped weapon
        return currentWeapon;
    }

    // Metode til at unequip weapon
    public void unequip() {
        currentWeapon = null;
    }
}