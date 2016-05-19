package teamvoid.monster;
import  teamvoid.weapons.*;

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
   public void setHealth(int healtha){
      this.health = healtha;
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
   public int getRawAttackDamage(){
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
   public A_Weapon getWeaponDrop(A_Monster a){
      return new FireSpellbook();
   } 
   public String carryDefaultWeapon(){
      return "no";
   }


    public String getTypeMonster(){
      return "Dragon";
   }


   
}