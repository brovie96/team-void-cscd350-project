package teamvoid.ui;

import teamvoid.maze.Maze;

public class CommandLineUI implements I_UI {
   
   @Override
   public void damageDealtToHero(A_Hero hero, int damage, int currentHealth) {
      System.out.println(hero + " has taken " + damage + " damage.");
      System.out.println(hero + " now has " + currentHealth + " health.");
   }
   
   @Override
   public void damageDealtToMonster(A_Monster monster, int damage, int currentHealth) {
      System.out.println(monster + " has taken " + damage + " damage.");
      System.out.println(monster + " now has " + currentHealth + " health.");
   }
   
   /**
    * Starts up the game with the command line UI.
    */
   public static void main(String[] args) {
      int level = 1;
      CommandLineUI ui = new CommandLineUI();
      Maze maze = new Maze(ui, 1);
      System.out.println(maze);
      System.out.println("What would you like to do?");
   }
}