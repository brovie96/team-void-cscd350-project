package TeamVoid.Potion;

public class HealthPotion extends Potion{
   private int healthPotion=3;
   
   public HealthPotion(){
   
   }
   public void setHealth(int health)
   {
      this.healthPotion = health;
   }  
   public int getHealth()
   {
      return healthPotion;
   }
}