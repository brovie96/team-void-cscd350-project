package teamvoid.monster;

public class SlimeBall extends A_Monster {
  
   public SlimeBall(){
   
   }
   public void setDefaultStats(){
      physicalDamage = 4;
      health = 12;
      defense = 4;
      magicResist = 3;
      
   }
   public void setHealth(int health){
      health = health;
   }
   public void setSlimeBallPD(int pd){
      physicalDamage = pd;
   } 
   public void setSlimeBallD(int magicDamage){
      defense = magicDamage;
   }
   public void setSlimeBallMR(int magicResist){
      magicResist = magicResist;
   }
   public int getHealth(){
      return health;
   }
   public int getSlimePD(){
      return physicalDamage;
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
      return "SlimeBall";
   }


}