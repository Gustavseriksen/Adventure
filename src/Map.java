public class Map {
    // Metode til at oprette hele kortet og returnere startpositionen
    public Room createMap() {
        // Opretter rummene med navn og beskrivelse
        Room room1 = new Room("Room 1", "room with no distinct features, except two doors. One of the doors go's in the direction of east and the other goes in south.");
        Room room2 = new Room("Room 2", "room with no distinct features, except two doors. One of the doors go's in the direction of west and the other goes in east.");
        Room room3 = new Room("Room 3", "room with no distinct features, except two doors. One of the doors go's in the direction of west and the other goes in south.");
        Room room4 = new Room("Room 4", "room with no distinct features, except two doors. One of the doors go's in the direction of north and the other goes in south.");
        Room room5 = new Room("Room 5", "room with no distinct features, except one door. The door goes in the direction of south.");
        Room room6 = new Room("Room 6", "room with no distinct features, except two doors. One of the doors go's in the direction of north and the other goes in south.");
        Room room7 = new Room("Room 7", "room with no distinct features, except two doors. One of the doors go's in the direction of north and the other goes in east.");
        Room room8 = new Room("Room 8", "room with no distinct features, except three doors. One of the doors go's in the direction of north and the other goes in west and the last one goes in east.");
        Room room9 = new Room("Room 9", "room with no distinct features, except two doors. One of the doors go's in the direction of north and the other goes in west.");

        //opretter nogle items
        Item book = new Item("ancient book", "book");
        Item matches = new Item("cardboard box with matches in it", "matches");
        Item bottle = new Item("bottle with liquid inside", "bottle");
        Item stone = new Item("stone with engraved ancient text", "stone");
        Item bucket = new Item("old rusty bucket","bucket");
        Item key = new Item("small golden key", "key");
        Food apple = new Food("shiny apple", "apple", 10);
        MeleeWeapon sword = new MeleeWeapon("shiny silver sword", "sword");
        RangedWeapon rifle = new RangedWeapon("rusty rifle", "rifle", 20);


        //Tilføjer items til rummene
        room1.addItem(rifle);
        room1.addItem(sword);
        room2.addItem(book); // Tilføjer book til room2
        room2.addItem(matches); //Tilføjer matches til room2
        room2.addItem(apple); // Tilføjer apple til room 2
        room3.addItem(bottle); // Tilføjer bottle til room3
        room3.addItem(stone); // Tilføjer stone til room3
        room3.addItem(bucket); // Tilføjer bucket til room3
        room4.addItem(key); // Tilføjer key til room4




        //  Forbinder de rum, der hænger sammen, ved at sætte retninger
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);
        room9.setNorth(room6);
        room9.setWest(room8);

        // Returnerer startpositionen, som er room1
        return room1;
    }
}