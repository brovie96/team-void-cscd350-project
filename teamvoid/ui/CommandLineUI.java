package teamvoid.ui;

import teamvoid.battle.BattleClassCopy;
import teamvoid.hero.*;
import teamvoid.monster.A_Monster;
import teamvoid.maze.Maze;
import teamvoid.party.Party;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineUI implements I_UI {
   
   private static Scanner key = new Scanner(System.in);
   private Maze maze;
   private BattleClassCopy battle;
   
   public CommandLineUI(Maze maze) {
      this.maze = maze;
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
   
   public void prompt() {
      if(battle == null) {
         System.out.println(maze);
         System.out.println("What would you like to do?");
         options();
      }
   }
   
   public void options() {
      if(battle == null) {
         System.out.println("1: Move left");
         System.out.println("2: Move right");
         System.out.println("3: Move up");
         System.out.println("4: Move down");
         while(true) {
            int choice = getInt();
            switch(choice) {
               case 1:  moveLeft();
                        break;
               case 2:  moveRight();
                        break;
               case 3:  moveUp();
                        break;
               case 4:  moveDown();
                        break;
               default: System.out.println("Invalid option.");
                        continue;
            }
            break;
         }
      }
   }
   
   public int getInt() {
      while(true) {
         try {
            int result = key.nextInt();
            return result;
         } catch(InputMismatchException e) {
            key.nextLine();
            System.out.println("Please enter an integer.");
         }
      }
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
         }
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
         }
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
         }
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
         }
      }
   }
   
   /**
    * Starts up the game with the command line UI.
    */
   public static void main(String[] args) {
      int level = 1;
      CommandLineUI ui = new CommandLineUI(new Maze(1, new Party(new Warrior(), new Sorecor(), new Healer())));
      while(true) {
         ui.prompt();
      }
   }
}