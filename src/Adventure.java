public class Adventure {
    private Player player; // Spilleren, der bevæger sig rundt i spillet
    private Map map; // Map-objekt, der opretter og håndterer spillets kort

    // Constructor initialiserer Map og Player
    public Adventure() {
        map = new Map();  // Opretter et Map-objekt
        Room startRoom = map.createMap();  // Opretter hele kortet og får startpositionen
        player = new Player(startRoom);  // Opretter en Player, der starter i startRoom
    }

    // Getter for player, så UserInterface kan få adgang til spilleren
    public Player getPlayer() {
        return player;
    }


}