package teamvoid.battle;
import teamvoid.party.Party;
import teamvoid.hero.*;
import teamvoid.monster.*;
import teamvoid.maze.*;
import teamvoid.weapons.*;
import teamvoid.ui.*;

public class Test
{
   public static void main(String[] args)
   {
      Party p = new Party(new Warrior(), new Healer(), new Sorecor());
      BattleClassCopy ba = new BattleClassCopy(p, new Goblin(new GoblinClub()), new SlimeBall());
      ba.battle(new CommandLineUI(new Maze(1, p)));
      
      
   }

}