package teamvoid.hero;


public class SorecerAttackMove implements I_HeroAttackMove {
   
   
   public SorecerAttackMove(){
   
   }
   public void getAttackMove(A_Hero p){
      int magicDamage = p.getMagicAttack() + 3;
      p.setAttackDamage(magicDamage);
   }

}
