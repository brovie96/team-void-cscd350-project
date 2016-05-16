package TeamVoid.Potion;
import TeamVoid.Hero.*;

public class Potion {

   protected I_Potion potion;
   
 
   
   public Potion(){
      
   }
   public void getPotionBoost(A_Hero sd){
      potion.potionBoost(sd);
   }

}