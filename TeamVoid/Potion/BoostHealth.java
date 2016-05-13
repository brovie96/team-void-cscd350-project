package TeamVoid.Potion;
import TeamVoid.Hero.*;

public class BoostHealth implements I_Potion{
   public void potionBoost(A_Hero a){
      int heroHealth = a.getHealth() + 3;
      a.setHealth(heroHealth);
      
   }

}