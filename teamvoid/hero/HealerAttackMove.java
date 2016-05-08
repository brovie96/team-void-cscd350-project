package TeamVoid.Hero;

public class HealerAttackMove implements I_HeroAttackMove {
   private int health;
   
   public HealerAttackMove(){
   
   }
   public void getAttackMove(){
      health = 2;
   }
}