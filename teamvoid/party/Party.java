package teamvoid.party;
import teamvoid.hero.A_Hero;
import java.io.Serializable;

public class Party implements Serializable {
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
    public void boostGlobalHealth(){
      int p1Health = playerOne.getHealth() + 3;
      playerOne.setHealth(p1Health);
      int p2Health = playerTwo.getHealth() + 3;
      playerTwo.setHealth(p2Health);
      int p3Health = playerThree.getHealth() + 3;
      playerThree.setHealth(p3Health);
   }

}
