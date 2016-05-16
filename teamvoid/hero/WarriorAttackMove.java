package teamvoid.hero;

public class WarriorAttackMove implements I_HeroAttackMove {

   
   public WarriorAttackMove(){
   
   }
   
   public void getAttackMove(A_Hero p){
      int physicalAttack = p.getAttackDamage() + 2;
      p.setAttackDamage(physicalAttack);  
      int defense = p.getDefense() - 2;
      p.setDefense(defense);    
   }


}