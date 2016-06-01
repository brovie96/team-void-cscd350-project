package teamvoid.hero;

import java.io.Serializable;

public abstract class A_Hero implements Serializable {
   protected int health;
   protected int attackDamage;
   protected int defense;
   protected int magicResist;
   protected int magicAttack;
   protected int armor;
   protected I_HeroAttackMove attack;
   
   public A_Hero(){
   
   }
   public abstract void setInitialStats();
   public abstract String getTypeHero();
    public abstract void equipWeapon(A_Weapon w);
   
   public abstract int getHealth();
   public abstract int getAttackDamage();
   public abstract int getDefense();
   public abstract int getMagicResist();
   public abstract int getMagicAttack();
   public abstract int getArmor();
   public abstract A_Weapon getWeapon(); 
   
   public abstract void setHealth(int healtha);
   public abstract void setArmor(int armorr);
   public abstract void setDefense(int defensee);
   public abstract void setMagicResist(int m);
   public abstract void setAttackDamage(int a);
   public abstract void setMagicAttack(int ad);
   
   public void getAttackMove(A_Hero p){
     attack.getAttackMove(p);
   }
  


}
