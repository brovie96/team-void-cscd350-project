package teamvoid.ui;

import teamvoid.battle.BattleClassCopy;
import teamvoid.hero.*;
import teamvoid.monster.A_Monster;
import teamvoid.maze.Maze;
import teamvoid.party.Party;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineUI implements I_UI {
   
   private static Scanner key = new Scanner(System.in);
   private Maze maze;
   private BattleClassCopy battle;
   private int level = 1;
   private Connection c = null;
   
   public CommandLineUI(Connection c, Maze maze) {
      this.c = c;
      this.maze = maze;
      maze.setUI(this);
   }
   
   @Override
   public void damageDealtToHero(A_Hero hero, int damage, int currentHealth) {
      System.out.println(hero.getTypeHero() + " has taken " + damage + " damage.");
      System.out.println(hero.getTypeHero() + " now has " + currentHealth + " health.");
   }
   
   @Override
   public void damageDealtToMonster(A_Monster monster, int damage, int currentHealth) {
      System.out.println(monster.getTypeMonster() + " has taken " + damage + " damage.");
      System.out.println(monster.getTypeMonster() + " now has " + currentHealth + " health.");
   }
   
   @Override
   public void changeLevel() {
      level++;
      if(level <= 5) {
         maze = new Maze(level, maze.getParty());
         maze.setUI(this);
      }
      else {
         System.out.println("Conglaturation! A winner is you!!");
         System.out.println("Press enter to exit.");
         key.nextLine();
         System.exit(0);
      }
   }
   
   public void prompt() throws SQLException {
      if(battle == null) {
         System.out.println(maze);
         System.out.println("What would you like to do?");
         options();
      }
   }
   
   public void options() throws SQLException {
      System.out.println("Use WASD to move, press enter to send move");
      System.out.println("Type \"#\" to save");
      while(true) {
         int choice = getChar();
         switch(choice) {
            case 'a':   moveLeft();
                        break;
            case 'd':   moveRight();
                        break;
            case 'w':   moveUp();
                        break;
            case 's':   moveDown();
                        break;
            case '#':   save();
                        break;
            default:    System.out.println("Invalid option.");
                        continue;
         }
         break;
      }
   }
   
   public char getChar() {
      String placeHolder = key.nextLine();
      return placeHolder.toCharArray()[0];
   }
   
   public void moveLeft() {
      boolean success = maze.moveLeft();
      if(success) {
         System.out.println("Move successful.");
         BattleClassCopy battle = maze.encounter();
         if(battle != null) {
            System.out.println("Encounter met!");
            this.battle = battle;
            this.battle.battle(this);
            this.battle = null;
         }
      }
      else {
         System.out.println("Ran into a wall.");
      }
   }
   
   public void moveRight() {
      boolean success = maze.moveRight();
      if(success) {
         System.out.println("Move successful.");
         BattleClassCopy battle = maze.encounter();
         if(battle != null) {
            System.out.println("Encounter met!");
            this.battle = battle;
            this.battle.battle(this);
            this.battle = null;
         }
      }
      else {
         System.out.println("Ran into a wall.");
      }
   }
   
   public void moveUp() {
      boolean success = maze.moveUp();
      if(success) {
         System.out.println("Move successful.");
         BattleClassCopy battle = maze.encounter();
         if(battle != null) {
            System.out.println("Encounter met!");
            this.battle = battle;
            this.battle.battle(this);
            this.battle = null;
         }
      }
      else {
         System.out.println("Ran into a wall.");
      }
   }
   
   public void moveDown() {
      boolean success = maze.moveDown();
      if(success) {
         System.out.println("Move successful.");
         BattleClassCopy battle = maze.encounter();
         if(battle != null) {
            System.out.println("Encounter met!");
            this.battle = battle;
            this.battle.battle(this);
            this.battle = null;
         }
      }
      else {
         System.out.println("Ran into a wall.");
      }
   }
   
   public void save() throws SQLException {
      int saveSlot = inputInt("What slot to save in? ");
      String sql = "SELECT count(*) " +
                   "FROM SAVES " +
                   "WHERE SLOT = ?";
      PreparedStatement stmt = c.prepareStatement(sql);
      stmt.setInt(1, saveSlot);
      stmt.execute();
      ResultSet result = stmt.getResultSet();
      int saveCount = result.getInt("count(*)");
      result.close();
      stmt.close();
      if(saveCount != 0) { //save slot in use
         System.out.println("Save slot in use. Overwrite? (y/n)");
         while(true) {
            switch(getChar()) {
               case 'y':   sql = "DELETE FROM SAVES " +
                                 "WHERE SLOT = ?";
                           stmt = c.prepareStatement(sql);
                           stmt.setInt(1, saveSlot);
                           stmt.executeUpdate();
                           stmt.close();
                           saveToSlot(saveSlot);
                           break;
               case 'n':   save();
                           break;
               default:    System.out.println("Please enter either 'y' or 'n'.");
                           continue;
            }
            break;
         }
      }
      else
         saveToSlot(saveSlot);
   }
   
   private void saveToSlot(int saveSlot) throws SQLException {
      ByteArrayOutputStream b = new ByteArrayOutputStream();
      ObjectOutputStream o = null;
      try {
         o = new ObjectOutputStream(b);
         o.writeObject(maze);
      } catch(IOException e) {
         System.out.println("Save failed.");
         return;
      }
      byte[] saveData = b.toByteArray();
      String sql = "INSERT INTO SAVES (SLOT, DATA) " +
                   "VALUES (?, ?)";
      PreparedStatement stmt = c.prepareStatement(sql);
      stmt.setInt(1, saveSlot);
      stmt.setBytes(2, saveData);
      stmt.executeUpdate();
      stmt.close();
      System.out.println("Saved to slot " + saveSlot);
   }
   
   /**
    * Starts up the game with the command line UI.
    */
   public static void main(String[] args) throws SQLException {
      Connection c = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
      }
      System.out.println("Checking for save table...");
      Statement stmt = c.createStatement();
      String sql = "SELECT count(*) " +
                   "FROM sqlite_master " +
                   "WHERE type='table' AND name='SAVES'";
      stmt.execute(sql);
      ResultSet result = stmt.getResultSet();
      if(result.getInt("count(*)") == 0) { //table does not exist
         result.close();
         stmt.close();
         System.out.println("Creating new save table...");
         stmt = c.createStatement();
         sql = "CREATE TABLE SAVES " +
               "(SLOT INT PRIMARY KEY NOT NULL, " +
               "DATA BLOB NOT NULL)";
         stmt.executeUpdate(sql);
         stmt.close();
      }
      else {
         System.out.println("Save table found!");
      }
      CommandLineUI ui = null;
      boolean loadSave = promptLoadSave();
      if(loadSave) {
         int saveSlot = loadSaveSlot(c);
         sql = "SELECT DATA " +
               "FROM SAVES " +
               "WHERE SLOT = ?";
         PreparedStatement pstmt = c.prepareStatement(sql);
         pstmt.setInt(1, saveSlot);
         pstmt.execute();
         result = pstmt.getResultSet();
         //Blob blob = result.getBlob("DATA");
         //byte[] saveData = blob.getBytes(1L, (int) blob.length());
         byte[] saveData = result.getBytes("DATA");
         Maze maze = null;
         ByteArrayInputStream b = new ByteArrayInputStream(saveData);
         ObjectInputStream o = null;
         try {
            o = new ObjectInputStream(b);
            maze = (Maze) o.readObject();
         } catch(Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Load failed.");
            System.exit(1);
         }
         ui = new CommandLineUI(c, maze);
      }
      else {
         ui = new CommandLineUI(c, new Maze(1, new Party(new Warrior(), new Sorecor(), new Healer())));
      }
      while(true) {
         ui.prompt();
      }
   }
   
   public static boolean promptLoadSave() {
      System.out.println("Would you like to load a save? (y/n)");
      while(true) {
         char response = key.nextLine().toCharArray()[0];
         switch(response) {
            case 'y':   return true;
            case 'n':   return false;   
            default:    System.out.println("Please enter either 'y' or 'n'.");
         }
      }
   }
   
   public static int loadSaveSlot(Connection c) throws SQLException {
      while(true) {
         int slot = inputInt("Which save would you like to load? ");
         String sql = "SELECT COUNT(*) " +
                      "FROM SAVES " +
                      "WHERE SLOT = ?";
         PreparedStatement stmt = c.prepareStatement(sql);
         stmt.setInt(1, slot);
         stmt.execute();
         ResultSet result = stmt.getResultSet();
         int count = result.getInt("count(*)");
         result.close();
         stmt.close();
         if(count != 1) {
            System.out.println("Slot " + slot + " is not in use.");
         }
         else
            return slot;
      }
   }
   
   public static int inputInt(String prompt) {
      Scanner key = new Scanner(System.in);
      int result = 0;
      while(true) {
         try {
            System.out.print(prompt);
            result = key.nextInt();
            break;
         } catch(InputMismatchException e) {
            key.nextLine();
            System.out.println("Please enter an integer.");
         }
      }
      return result;
   }
}