package teamvoid.monster;
import  teamvoid.weapons.*;

public abstract class A_Monster {
   protected int health;
   protected int defense;
   protected int magicResist;
   protected int physicalDamage;
   
   public A_Monster() {
     
   }
   public abstract void setDefaultStats();
   public abstract String getTypeMonster();
   public abstract int getHealth();
   public abstract int getDefense();
   public abstract int getMagicResist();
   public abstract int getRawAttackDamage();
   public abstract boolean checkMagic();
   public abstract boolean checkArmorPiercing();
   public abstract int addBoost();
 
   public abstract void setHealth(int healtha);
   public abstract String carryDefaultWeapon();
   public abstract A_Weapon getWeaponDrop(A_Monster m);
}