public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String longName, String shortName, int damage) {
        super(longName, shortName, -1, damage); // Sætter remainingUses til -1 for ubegrænsede anvendelser
    }

    @Override
    public String attack() {
        return "You have made a melee attack with the " + getLongName();
    }

    @Override
    public int remainingUses() {
        return -1; // Returnerer -1 for at signalere ubegrænsede anvendelser
    }

}
