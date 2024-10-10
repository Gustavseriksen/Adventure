public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon currentWeapon;

    public Enemy(String name, String description, int health, Weapon currentWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.currentWeapon = currentWeapon;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void hit (int damage) {
        health -= damage;
    }

}
