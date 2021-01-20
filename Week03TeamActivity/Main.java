package Week03TeamActivity;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        // create a new Player with non default constructor
        Player newPlayer = new Player("Richard", 50, 50, 100000);

        // Creates a new game object with the Player being passed as a parameter to constructor
        Game newGame = new Game(newPlayer);

        // Save the game with filename as parameter
        newGame.saveGame("GameSave1.json");

        // Create a new game from loading the old game
        Game newGame2 = newGame.loadGame("GameSave1.json");

        // Display stats to make sure all good - keep in mind this game method calls the player's display method
        newGame2.displayPlayerStats();

        // Add a piece of equipment to player within game, keep in mind this game method calls the player's
        // addPieceOfEquipment() method
        newGame2.playerAddPieceOfEquipment("bandana", 100);
        newGame2.displayPlayerStats();

        // Add a piece of equipment to the player NOT within game, but within main
        newPlayer.addPieceOfEquipment("Sting", 50000);
        newPlayer.addPieceOfEquipment("Glamdring", 100000);

        newPlayer.displayPlayerStats();

        // Just trying everything above but with the fully flushed out player object (including populated equipment
        // list
        Game newGame3 = new Game(newPlayer);
        newGame3.saveGame("GameSave2.json");
        Game newGame4 = newGame.loadGame("GameSave2.json");
        newGame4.displayPlayerStats();
    }
}
