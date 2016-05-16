package TeamVoid.party;
import TeamVoid.Hero.A_Hero;

public class Party {
   A_Hero playerOne = null;
   A_Hero playerTwo = null;
   A_Hero playerThree = null;
   
   public Party(A_Hero h1, A_Hero h2, A_Hero h3){
      this.playerOne = h1;
      this.playerTwo = h2;
      this.playerThree = h3;
   }
   public A_Hero getHeroOne()
   {
      return playerOne;
   }
   public A_Hero getHeroTwo()
   {
      return playerTwo;
   }
   public A_Hero getHeroThree()
   {
      return playerThree;
   }
}