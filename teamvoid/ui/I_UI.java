package teamvoid.ui;

import teamvoid.hero.A_Hero;
import teamvoid.monster.A_Monster;

public interface I_UI {
   
   /**
    * Informs the UI that damage has been dealt to a hero.
    *
    * @param hero The hero in question
    * @param damage The amount of damage done
    * @param currentHealth The current remaining health of the hero
    */
   public void damageDealtToHero(A_Hero hero, int damage, int currentHealth);
   
   /**
    * Informs the UI that damage has been dealt to a monster.
    *
    * @param monster The monster in question
    * @param damage The amount of damage done
    * @param currentHealth The current remaining health of the monster
    */
   public void damageDealtToMonster(A_Monster monster, int damage, int currentHealth);
   
   /**
    * Informs the UI that the level needs to be changed.
    */
   public void changeLevel();
}