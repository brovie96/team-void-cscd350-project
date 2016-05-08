package teamvoid.hero;

public class WarriorAttackMove implements I_HeroAttackMove {
   private int physicalAttack;
   private int defense;
   
   public WarriorAttackMove(){
   
   }
   
   public void getAttackMove(){
      physicalAttack = 2;
      defense = 2;
   }


}