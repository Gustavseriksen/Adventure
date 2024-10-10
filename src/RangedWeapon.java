public class RangedWeapon extends Weapon {
    public RangedWeapon(String longName, String shortName, int remainingUses, int damage) {
        super(longName, shortName, remainingUses, damage);
    }

    @Override
    public String attack() {
        if (remainingUses > 0) {
            remainingUses--; //Reducerer remainingUses med 1
            return "You have fire the " + getLongName() + ". Remaining uses: " + remainingUses;
        } else {
            return "The " + getLongName() + " is out of ammunition and cannot be used.";
        }
    }

    @Override
    public int remainingUses() {
        return remainingUses;
    }


}
