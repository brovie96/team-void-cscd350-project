public class Goblin extends A_Monster {
   private int armor;
   
   public Goblin(){
   
   }
   public void setDefaultStats(){
      health = 12;
      physicalDamage = 5;
      defense = 5;
      magicResist = 2;
      armor = 2;
   }
   public void setGoblinHealth(int health){
      health = health;
   }
   public void setGoblinPD(int pd){
      physicalDamage = pd;
   } 
   
   public void setGoblinMR(int magicResist){
      magicResist = magicResist;
   }
   public int getHealth(){
      return health;
   }
   public int getGoblinPD(){
      return physicalDamage;
   }
   public int getGoblinMR(){
      return magicResist;
   }
   public int getArmor(){
      return armor;
   }

}