package TeamVoid.Battle;
import TeamVoid.party.Party;
import TeamVoid.Hero.*;
import TeamVoid.Monster.*;
import TeamVoid.Weapons.*;

public class Test
{
   public static void main(String[] args)
   {
      Party p = new Party(new Warrior(), new Healer(), new Sorecor());
      BattleClassCopy ba = new BattleClassCopy(p, new Goblin(new GoblinClub()), new SlimeBall());
      ba.battle();
      
      
   }

}