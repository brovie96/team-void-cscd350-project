package teamvoid.monster;
import teamvoid.weapons.GoblinClub;

public class Goblin extends A_Monster {
   private int armor;
   private GoblinClub club;
   
   public Goblin(GoblinClub gh){
      this.club = gh;
   }
   public void setDefaultStats(){
      health = 12;
      physicalDamage = 5;
      defense = 5;
      magicResist = 2;
      armor = 2;
   }
   public void setHealth(int healthd){
      health = healthd;
   }
   public void setGoblinPD(int pd){
      physicalDamage = pd;
   } 
   public void setDefense(int defense){
      this.defense = defense;
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
   public int getMagicResist(){
      return magicResist;
   }
   public int getArmor(){
      return armor;
   }
   public int getDefense(){
      return defense;
   }
   
    public boolean checkMagic(){
      if(club.getMagicPowerBoost() > 0){
         return true;
      }
      return false;
   }
   public boolean checkArmorPiercing(){
      if(club.isArmorPiercing()){
         return true;
      }
      return false;
   }
   public int addBoost(){
      return club.getAttackBoost() + getGoblinPD();
   }
   public String getTypeMonster(){
      return "Goblin";
   }
   
 

}