package TeamVoid.Potion;

public class AttackBoostingPotion extends Potion {
   private int attack = 2;
   private int magicDamage = 2;
   
   public AttackBoostingPotion(){
   
   }
   public void setAttackPotion(int attackPotion)
   {
      this.attack = attackPotion;
   }
   public void setMagicDamagePotion(int magicDamage)
   {
      this.magicDamage = magicDamage;
   }
   public int getAttackPotionStat()
   {
      return attack;
   }
   public int getMagicDamagePotionStat()
   {
      return magicDamage;
   }  
}