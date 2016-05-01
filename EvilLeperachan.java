public class EvilLeperachan extends A_Monster {

   private int magicDamage = 4;
   
   public EvilLeperachan(){
   
   }
   public void setDefaultStats(){
      health = 12;
      defense = 3;
      magicResist = 4;
      magicDamage = 4;
   }
   public void setELHealth(int health){
      health = health;
   }
   public void setEvilLeperachanD(int defense){
      defense = defense;
   } 
   public void setevilLeperachanMD(int magicDamage){
      this.magicDamage = magicDamage;
   }
   public void setEvilLeperachanMR(int magicResist){
     magicResist = magicResist;
   }
   public int getHealth(){
      return health;
   }
   public int getEvilLeperachanD(){
      return defense;
   }
   public int getEvilLeperachanMD(){
      return magicDamage;
   }
   public int getEvilLeperachanMR(){
      return magicResist;
   }


}