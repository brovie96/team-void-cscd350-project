package TeamVoid.Monster;

public class Dragon extends A_Monster {
   private int magicDamage;
   
   public Dragon(){
    
   }
   public void setDefaultStats(){
      health = 14;
      physicalDamage = 6;
      defense = 5;
      magicResist = 2;
      magicDamage = 6;
   }
   public void setHealth(int health){
      this.health = health;
   }
   public void setPhysicalDamage(int physicalDamage){
      this.physicalDamage = physicalDamage;
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
   public int getPhysicalDamage(){
      return physicalDamage;
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
   public boolean checkMagic(){
           return false;
   }
   public boolean checkArmorPiercing(){
            return false;
   }
   public int addBoost(){
      return 0;
   }


    public String getTypeMonster(){
      return "Dragon";
   }


   
}