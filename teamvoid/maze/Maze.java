package teamvoid.maze;

import teamvoid.battle.BattleClassCopy;
import teamvoid.monster.*;
import teamvoid.weapons.*;
import teamvoid.party.Party;
import teamvoid.ui.I_UI;

import java.io.Serializable;
import java.util.ArrayList;

public class Maze implements Serializable {
   
   /**
    * The maze itself. The cell that represents the party's location is set
    * to {@code true}, and all other cells are set to {@code false}. 
    */
   private boolean[][] maze;
   
   /**
    * All of the possible (horizontal) wall locations.
    */
   private boolean[][] walls;
   
   /**
    * The minimum encounter rate for this maze, in percent chance.
    */
   private final int MIN_ENCOUNTER_RATE;
   
   /**
    * The current encounter rate for this maze, in percent chance.
    */
   private int encounterRate;
   
   /**
    * Whether encounters are enabled (used in cheats).
    */
   private boolean encountersEnabled = true;
   
   /**
    * The level that this maze represents.
    */
   private int level;
   
   /**
    * A reference to the UI.
    */
   private transient I_UI ui;
   
   /**
    * The party of heroes in the maze.
    */
   private Party party;
   
   /**
    * Default constructor. Takes the level as an argument.
    * <p>
    * This constructor takes the level number as an argument and builds a
    * new maze of size 4x4 for level 1, 5x5 for level 2, and so on, up to
    * 8x8 for level 5. Additionally, it initializes the walls.
    *
    * @param level the level number to be used, from 1 to 5
    */
   public Maze(int level, Party party) {
      this.level = level;
      this.party = party;
      MIN_ENCOUNTER_RATE = 10 * this.level;
      encounterRate = MIN_ENCOUNTER_RATE;
      maze = new boolean[this.level + 3][this.level + 3];
      walls = new boolean[this.level + 3][this.level + 2];
      maze[0][maze[0].length - 1] = true; //set starting position to bottom left of maze
      randomizeWalls();
   }
   
   /**
    * Attaches maze to UI.
    *
    * @param The UI to be attached
    */
   public void setUI(I_UI ui) {
      this.ui = ui;
   }
   
   /**
    * Randomizes the walls of the maze.
    */
   private void randomizeWalls() {
      for(int j = 0; j < walls[0].length; j++) {
         int noWallIndex = (int) Math.floor(Math.random() * walls.length);
         for(int i = 0; i < walls.length; i++) {
            if(i != noWallIndex)
               walls[i][j] = true;
            else
               walls[i][j] = false;
         }
      }
   }
   
   /**
    * Returns the location of the player. {@code getLoc()[0]} is the x-coordinate
    * counting from the left, and {@code getLoc()[1]} is the y-coordinate counting
    * from the top.
    *
    * @return an int array of length 2
    */
   public int[] getLoc() {
      for(int i = 0; i < maze.length; i++) {
         for(int j = 0; j < maze[i].length; j++) {
            if(maze[i][j]) {
               int[] result = {i, j};
               return result;
            }
         }
      }
      return null;
   }
   
   /**
    * Returns the party in the maze
    *
    * @return The party
    */
   public Party getParty() {
      return party;
   }
   
   /**
    * Tries to move the player up.
    *
    * @return {@code true} if the move is successful, {@code false} if the move is impeded by a wall
    */
   public boolean moveUp() {
      int[] position = getLoc();
      if(position[1] == 0 || walls[position[0]][position[1] - 1])
         return false;
      else {
         maze[position[0]][position[1]] = false;
         maze[position[0]][position[1] - 1] = true;
         return true;
      }
   }
   
   /**
    * Tries to move the player down.
    *
    * @return {@code true} if the move is successful, {@code false} if the move is impeded by a wall
    */
   public boolean moveDown() {
      int[] position = getLoc();
      if(position[1] == maze[0].length - 1 || walls[position[0]][position[1]])
         return false;
      else {
         maze[position[0]][position[1]] = false;
         maze[position[0]][position[1] + 1] = true;
         return true;
      }
   }
   
   /**
    * Tries to move the player right.
    *
    * @return {@code true} if the move is successful, {@code false} if the move is impeded by a wall
    */
   public boolean moveLeft() {
      int[] position = getLoc();
      if(position[0] == 0)
         return false;
      else {
         maze[position[0]][position[1]] = false;
         maze[position[0] - 1][position[1]] = true;
         return true;
      }
   }
   
   /**
    * Tries to move the player left.
    *
    * @return {@code true} if the move is successful, {@code false} if the move is impeded by a wall
    */
   public boolean moveRight() {
      int[] position = getLoc();
      if(position[0] == maze.length - 1)
         return false;
      else {
         maze[position[0]][position[1]] = false;
         maze[position[0] + 1][position[1]] = true;
         return true;
      }
   }
   
   /**
    * Checks for an encounter.
    *
    * @return a BattleClassCopy object if there is an encounter, {@code null} otherwise
    */
   public BattleClassCopy encounter() {
      int[] loc = getLoc();
      if(loc[0] == (maze.length - 1) && loc[1] == 0) {
         ui.changeLevel();
         switch(level) {
            case 1:  return null;
            case 2:  return new BattleClassCopy(party, new Dragon());
            case 3:  return new BattleClassCopy(party, new Necromancer(new StaffOfPain()));
            case 4:  return new BattleClassCopy(party, new Dragon());
            case 5:  return new BattleClassCopy(party, new Dragon(), new Necromancer(new StaffOfPain()));
            default: return null;
         }
      }
      else if(encountersEnabled) {
         int chance = (int) Math.ceil(Math.random() * 100);
         if(chance < encounterRate) {
            encounterRate = MIN_ENCOUNTER_RATE;
            return new BattleClassCopy(party, new SlimeBall(), new Goblin(new GoblinClub()), new EvilLeperachan(new EvilPot()));
         }
         else {
            encounterRate += 5;
            return null;
         }
      }
      else return null;
   }
   
   /**
    * Move player to a specific spot (used in cheats)
    *
    * @return {@code true} if move is valid, {@code false} if not 
    */
   public boolean moveToCoords(int x, int y) {
      if(x >= maze.length || y >= maze[0].length)
         return false;
      else {
         int[] loc = getLoc();
         maze[loc[0]][loc[1]] = false;
         maze[x][y] = true;
         return true;
      }
   }
   
   /*
    * Returns whether encounters are enabled
    *
    * @return the value of encountersEnabled
    */
   public boolean encountersEnabled() {
      return encountersEnabled;
   }
   
   /*
    * Toggles encounters enabled (used in cheats)
    *
    * @return the new value of encountersEnabled
    */
   public boolean toggleEncountersEnabled() {
      encountersEnabled = !encountersEnabled;
      return encountersEnabled;
   }
   
   /**
    * Gets the level of the maze.
    *
    * @return the level of this maze
    */
   public int getLevel() {
      return level;
   }
   
   /**
    * Returns a visual representation of the maze, in string form.
    *
    * @return a visual representation of the maze, in string form
    */
   @Override
   public String toString() {
      ArrayList<String> rows = new ArrayList<>();
      ArrayList<String> wallList = new ArrayList<>();
      for(int j = 0; j < maze[0].length; j++) {
         String s = "";
         for(int i = 0; i < maze.length; i++) {
            if(maze[i][j])
               s += "*";
            else
               s += ".";
         }
         rows.add(s);
      }
      for(int j = 0; j < walls[0].length; j++) {
         String s = "";
         for(int i = 0; i < walls.length; i++) {
            if(walls[i][j])
               s += "+";
            else
               s += " ";
         }
         wallList.add(s);
      }
      String s = "";
      int i;
      for(i = 0; i < wallList.size(); i++) {
         s += rows.get(i);
         s += "\n";
         s += wallList.get(i);
         s += "\n";
      }
      s += rows.get(i);
      return s;
   }
}