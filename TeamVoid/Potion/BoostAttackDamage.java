package TeamVoid.Potion;
import TeamVoid.Hero.*;

public class BoostAttackDamage implements I_Potion{
  public void potionBoost(A_Hero a){
      int attack = a.getAttackDamage() + 2;
      a.setDefense(attack);
      int magicDamage = a.getMagicAttack() + 2;
      a.setMagicAttack(magicDamage);
  }
}