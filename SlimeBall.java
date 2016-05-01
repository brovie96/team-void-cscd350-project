public class SlimeBall extends A_Monster {
  
   public SlimeBall(){
   
   }
   public void setDefaultStats(){
      physicalDamage = 4;
      health = 12;
      defense = 4;
      magicResist = 3;
      
   }
   public void setSlimeHealth(int health){
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
   public int getSlimeMD(){
      return defense;
   }
   public int getSlimeMR(){
      return magicResist;
   }

}