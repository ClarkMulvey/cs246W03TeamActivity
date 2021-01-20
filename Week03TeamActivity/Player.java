package Week03TeamActivity;

import java.util.HashMap;
import java.util.Map;

public class Player {
    // Member variables for the Player
    private String name;
    private int health;
    private int mana;
    private int gold;
    private Map<String, Integer> equipmentList;

    // Default constructor - need to use HashMap as Map is abstract class
    public Player() {
        this.name = "Bob";
        this.health = 10;
        this.mana = 10;
        this.gold = 10;
        this.equipmentList = new HashMap<>();
    }

    // Non-Default constructor - need to use HashMap as Map is abstract class
    // Keep in mind as is you cannot use an existing equipment list to instantiate
    // this equipment list, it must be added one by one by the ftn addPieceOfEquipment
    public Player(String name, int health, int mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
        this.equipmentList = new HashMap<>();
    }

    // Returns the equipment list
    public Map<String, Integer> getEquipmentList() {
        return this.equipmentList;
    }

    // Adds a piece of equipment to the equipmentList map member var
    public void addPieceOfEquipment(String equipmentName, Integer equipmentCost) {
        equipmentList.put(equipmentName, equipmentCost);
    }

    // Print out to the console the player's statistics - note the for each loop for the hashmap
    public void displayPlayerStats() {
        System.out.println("Player name: " + this.name);
        System.out.println("Player health: " + this.health);
        System.out.println("Player mana: " + this.mana);
        System.out.println("Player gold: " + this.gold);
        this.equipmentList.forEach((k, v) -> System.out.printf("%s: $%d%n", k, v));
    }
}
