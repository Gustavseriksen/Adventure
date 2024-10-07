public class Food extends Item{

    private int healthPoints;

// Constructor til Food, som kalder Item's constructor
    public Food(String longName, String shortName, int healthPoints) {
        super(longName, shortName); // Kalder Item's constructor
        this.healthPoints = healthPoints; // sætter healthPoints specifikt for Food
    }

    // Getter for healthPoints
    public int getHealthPoints () {
        return healthPoints;
    }
}
