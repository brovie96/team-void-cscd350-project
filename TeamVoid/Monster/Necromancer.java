package TeamVoid.Monster;
import TeamVoid.Weapons.StaffOfPain;

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
   public int addBoost(){
      return staff.getMagicPowerBoost() + getMagicDamage();
   }

   public String getTypeMonster(){
      return "Necromancer";
   }


   
}