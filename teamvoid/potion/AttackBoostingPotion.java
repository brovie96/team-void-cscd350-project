package TeamVoid.Potion;

public class AttackBoostingPotion extends Potion {
   private int attack = 2;
   private int magicDamage = 2;
   
   public AttackBoostingPotion(){
      potion = new BoostAttackDamage();      
   }
}