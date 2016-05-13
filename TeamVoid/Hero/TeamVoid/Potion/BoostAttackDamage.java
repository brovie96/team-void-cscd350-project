


public class BoostAttackDamage implements I_Potion{
  public void potionBoost(A_Hero a){
      int attack = a.getAttackDamage() + 2;
      a.setDefense(attack);
      int magicResist = a.getMagicResist() + 2;
      a.setMagicResist(magicResist);
  }
}