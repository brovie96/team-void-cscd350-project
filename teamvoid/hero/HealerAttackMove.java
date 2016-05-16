package teamvoid.hero;

public class HealerAttackMove implements I_HeroAttackMove {
   private int health;
   
   public HealerAttackMove(){
   
   }
   public void getAttackMove(A_Hero a){
      int health = a.getHealth() + 2;
      a.setHealth(health);
   }
}