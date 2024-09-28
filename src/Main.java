public class Main {
    public static void main(String[] args) {
        // Opretter et Adventure-objekt, som styrer hele spillet
        Adventure adventure = new Adventure();

        // Opretter et UserInterface-objekt og overfører Adventure-objektet
        // UserInterface håndterer al brugerinteraktion
        UserInterface ui = new UserInterface(adventure);

        // Starter brugerinteraktionen og kommandoerne
        ui.start();
    }
}