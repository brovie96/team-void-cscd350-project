package teamvoid.ui;

import teamvoid.battle.BattleClassCopy;
import teamvoid.hero.*;
import teamvoid.monster.A_Monster;
import teamvoid.maze.Maze;
import teamvoid.party.Party;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineUI implements I_UI {
   
   private static Scanner key = new Scanner(System.in);
   private Maze maze;
   private BattleClassCopy battle;
   private int level = 1;
   
   public CommandLineUI(Maze maze) {
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
   
   public void prompt() {
      if(battle == null) {
         System.out.println(maze);
         System.out.println("What would you like to do?");
         options();
      }
   }
   
   public void options() {
      System.out.println("Use WASD to move, press enter to send move (one space at a time)");
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
   
   public static Connection c = null;
   
   /**
    * Starts up the game with the command line UI.
    */
   public static void main(String[] args) throws SQLException {
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch(Exception e) {
         System.err.println(e.getClass().getName() + ": " + e.getMessage());
         System.exit(0);
      }
      System.out.println("Checking for save database...");
      Statement stmt = c.createStatement();
      String sql = "SELECT count(*) " +
                   "FROM sqlite_master " +
                   "WHERE type='table' AND name='SAVES'";
      stmt.execute(sql);
      ResultSet result = stmt.getResultSet();
      if(result.getInt("count(*)") == 0) {
         result.close();
         stmt.close();
         System.out.println("Creating new save database...");
         stmt = c.createStatement();
         sql = "CREATE TABLE SAVES " +
               "(NUM INT PRIMARY KEY NOT NULL, " +
               "DATA BLOB NOT NULL)";
         stmt.executeUpdate(sql);
         stmt.close();
      }
      CommandLineUI ui = null;
      boolean loadSave = promptLoadSave();
      if(loadSave) {
         int saveNum = loadSaveNum();
         
      }
      else {
         ui = new CommandLineUI(new Maze(1, new Party(new Warrior(), new Sorecor(), new Healer())));
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
   
   public static int loadSaveNum() {
      return inputInt("Which save would you like to load? ");
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