public abstract class Weapon extends Item {

    protected int remainingUses;

    // Constructor til Weapon, som kalder Item's constructor og tilføjer remainingUses
    public Weapon(String longName, String shortName, int remainingUses) {
        super(longName, shortName);
        this.remainingUses = remainingUses; //  Initialiser remainingUses

    }

    // Abstrakt metode for attack, som subklasserne skal implementere
    public abstract String attack();

    // Metode til at returnere hvor mange gange våbenet kan bruges
    public int remainingUses() {
        return remainingUses;
    }

    // Metode til at tjekke om våbnet har ubegrænsede anvendelser, kan overrides
    public boolean isUnlimitedUses() {
        return remainingUses == -1;
    }

}
