public class Necromancer extends A_Monster {
   private int magicDamage;
   
   public Necromancer(){
   
   }
   public void setDefaultStats(){
      health = 14;
      magicDamage = 7;
      defense = 3;
      magicResist = 5;
   }
   public void setHealth(int health){
      this.health = health;
   }
   public void setMagicDamage(int magicDamage){
      this.magicDamage = magicDamage;
   }
   public void setDefense(int defense){
      this.defense = defense;
   }
   public void setMagicResist(int magicResist){
      this.magicResist = magicResist;
   }
   public int getHealth(){
      return health;
   }
   public int getMagicDamage(){
      return magicDamage;
   }  
   public int getDefense(){
      return defense;
   }
   public int getMagicResist(){
      return magicResist;
   }


   
}