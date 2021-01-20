package Week03TeamActivity;

import com.google.gson.Gson;

import java.io.*;
import java.util.Map;


public class Game {

    // Member variables
    private Player player;

    // Instantiate a game with a player object as a parameter
    public Game(Player newPlayer) {
        this.player = newPlayer;
    }

    // calls player's display ftn for encapsulation
    public void displayPlayerStats() {
        player.displayPlayerStats();
    }

    // calls player's getEquipmentList ftn for encapsulation
    public Map<String, Integer> getEquipmentList() {
        return this.player.getEquipmentList();
    }

    // calls a playr's addPieceOfEquipment() ftn for encapsulation
    public void playerAddPieceOfEquipment(String equipmentName, Integer equipmentCost) {
        player.addPieceOfEquipment(equipmentName, equipmentCost);
    }

    // Saves the game to a file specified by the user as the parameter
    public void saveGame(String filename) {
        // Serialize the object
        Gson gson = new Gson();
        String playerJson = gson.toJson(this.player);

        // Create the File
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

            } else {
                System.out.println("File already exists.");
            }
            // Write to the File
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(playerJson);
            myWriter.close();
            System.out.println("Successfully saved the game.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Game loadGame(String filename) {

        // read file
        try {
            FileReader file = new FileReader(filename);
            Gson gson = new Gson();
            Player player = gson.fromJson(file, Player.class);

            // create game
            Game newGame = new Game(player);

            // return Game
            return newGame;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }
}
