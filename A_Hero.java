public abstract class A_Hero {
   protected int health;
   protected int attackDamage;
   protected int defense;
   protected int magicResist;
   protected int magicAttack;
   
   public A_Hero(){
   
   }
   public abstract void setInitialStats();
   
   public void getAttackMove(){
      //this method will be to get the hero attackMove
   }
   public void getSpecialAttackMove(){
      //to get the special attack move
   }


}