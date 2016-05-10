package TeamVoid.Hero;

public abstract class A_Hero {
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
   
   public abstract int getHealth();
   public abstract int getAttackDamage();
   public abstract int getDefense();
   public abstract int getMagicResist();
   public abstract int getMagicAttack();
   public abstract int getArmor();
   
   public abstract void setHealth(int healtha);
   public abstract void setArmor(int armorr);
  

   
   public void getAttackMove(){
     attack.getAttackMove();
   }
   public void getSpecialAttackMove(){
      //to get the special attack move
   }


}