public class Item {
    private String longName; //langt navn på item, f.eks. "a shiny brass lamp"
    private String shortName; // kort navn på item f.eks. "lamp"

    // constructor der initialiserer navnene
    public Item(String longName, String shortName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    // Getter-metode for langt navn
    public String getLongName() {
        return longName;
    }

    // Getter-metode for kort navn
    public String getShortName() {
        return shortName;
    }
}
