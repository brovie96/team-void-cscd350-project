package teamvoid.monster;
import teamvoid.weapons.EvilPot;

public class EvilLeperachan extends A_Monster {

   private int magicDamage = 4;
   private EvilPot evil;
   
   public EvilLeperachan(EvilPot evils){
      this.evil = evils;
   }
   public void setDefaultStats(){
      health = 12;
      defense = 3;
      magicResist = 4;
      magicDamage = 4;
   }
   public void setHealth(int health){
      this.health = health;
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
   public int getDefense(){
      return defense;
   }
   public int getEvilLeperachanMD(){
      return magicDamage;
   }
   public int getMagicResist(){
      return magicResist;
   }
   public boolean checkMagic(){
      if(evil.getMagicPowerBoost() > 0){
         return true;
      }
      return false;
   }
   public boolean checkArmorPiercing(){
      if(evil.isArmorPiercing()){
         return true;
      }
      return false;
   }
   public int addBoost(){
      return evil.getMagicPowerBoost() + getEvilLeperachanMD();
   }
   public String getTypeMonster(){
      return "Evil Leperchan";
   }


}