package teamvoid.potion;
import teamvoid.hero.*;

public class BoostDefense implements I_Potion{
  public void potionBoost(A_Hero a){
      int defense = a.getDefense() + 2;
      a.setDefense(defense);
      int magicResist = a.getMagicResist() + 2;
      a.setMagicResist(magicResist);
  }
}