public class Map {
    // Metode til at oprette hele kortet og returnere startpositionen
    public Room createMap() {
        // Opretter rummene med navn og beskrivelse
        Room room1 = new Room("Room 1", "dusty room with cracks in the ceiling. There are two doors: one to the east with rusty hinges, and one to the south covered in cobwebs.");
        Room room2 = new Room("Room 2", "room filled with a greenish glow, with moss creeping along the stone walls. You see doors to the west and east.");
        Room room3 = new Room("Room 3", "cold room where strange runes are carved into the walls. Doors lie to the west and south.");
        Room room4 = new Room("Room 4", "round room with a mosaic floor and old armor on the walls. Passageways open to the north and south.");
        Room room5 = new Room("Room 5", "room with rough stone walls where you hear strange whispers. A single door leads to the south.");
        Room room6 = new Room("Room 6", "room covered in ash, and the air smells burnt. There are two doors: one to the north and one to the south.");
        Room room7 = new Room("Room 7", "room where crystals shine on the walls, reflecting light. There are paths to the north and east.");
        Room room8 = new Room("Room 8", "large room with massive roots twisting across the floor, framing doorways to the north, west, and east.");
        Room room9 = new Room("Room 9", "dark room with damp walls that feel alive. There are two exits: one to the north and one to the west.");

        //opretter nogle items
        Item book = new Item("ancient book", "book");
        Item matches = new Item("cardboard box with matches in it", "matches");
        Item bottle = new Item("bottle with liquid inside", "bottle");
        Item stone = new Item("stone with engraved ancient text", "stone");
        Item bucket = new Item("old rusty bucket","bucket");
        Item key = new Item("small golden key", "key");
        Food apple = new Food("shiny apple", "apple", 10);
        Food fish = new Food("raw fish", "fish", 10);
        Food cheese = new Food("piece of moldy cheese", "cheese", 8);
        Food honey = new Food("small jar of honey", "honey", 12);
        MeleeWeapon sword = new MeleeWeapon("shiny silver sword", "sword", 5);
        RangedWeapon rifle = new RangedWeapon("rusty rifle", "rifle", 20, 10);
        MeleeWeapon axe = new MeleeWeapon("heavy iron axe", "axe", 7);
        MeleeWeapon dagger = new MeleeWeapon("sharp steel dagger", "dagger", 3);
        RangedWeapon bow = new RangedWeapon("old wooden bow", "bow", 15, 6);
        RangedWeapon crossbow = new RangedWeapon("small iron crossbow", "crossbow", 10, 8);






        //Tilføjer items til rummene
        room1.addItem(rifle);
        room1.addItem(sword);
        room2.addItem(book); // Tilføjer book til room2
        room2.addItem(matches); //Tilføjer matches til room2
        room2.addItem(apple); // Tilføjer apple til room 2
        room2.addItem(bow);
        room3.addItem(bottle); // Tilføjer bottle til room3
        room3.addItem(stone); // Tilføjer stone til room3
        room3.addItem(bucket); // Tilføjer bucket til room3
        room4.addItem(key); // Tilføjer key til room4
        room5.addItem(fish);
        room6.addItem(cheese);
        room7.addItem(honey);
        room7.addItem(axe);
        room8.addItem(dagger);
        room9.addItem(crossbow);




        //Opretter enemies
        Enemy goblin = new Enemy("goblin", "green goblin", 25, sword);
        Enemy human = new Enemy("human", "evil human", 30, sword);
        Enemy orc = new Enemy("orc", "large and brutish orc", 30, axe);
        Enemy bandit = new Enemy("bandit", "shifty-eyed bandit", 20, dagger);





        //Tilføjer enemies til rummene
        room4.addEnemy(goblin);
        room5.addEnemy(human);
        room6.addEnemy(orc);
        room7.addEnemy(bandit);




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