package TeamVoid.Monster;
import TeamVoid.Weapons.*;

public class Necromancer extends A_Monster {
   private int magicDamage;
   private StaffOfPain staff;
   
   public Necromancer(StaffOfPain s){
      this.staff =s;
   }
   public void setDefaultStats(){
      health = 14;
      magicDamage = 7;
      defense = 3;
      magicResist = 5;
   }
   public void setHealth(int healtha){
      this.health = healtha;
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
      return magicDamage;
   }  
   public int getDefense(){
      return defense;
   }
   public int getMagicResist(){
      return magicResist;
   }
    public boolean checkMagic(){
      if(staff.getMagicPowerBoost() > 0){
         return true;
      }
      return false;
   }
   public boolean checkArmorPiercing(){
      if(staff.isArmorPiercing()){
         return true;
      }
      return false;
   }
    public String carryDefaultWeapon(){
      return "Yes";
   } 
    public A_Weapon getWeaponDrop(A_Monster a){
      return new StaffOfPain();
   } 

   public int addBoost(){
      return staff.getMagicPowerBoost() + getRawAttackDamage();
   }

   public String getTypeMonster(){
      return "Necromancer";
   }


   
}