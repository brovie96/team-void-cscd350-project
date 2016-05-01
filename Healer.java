public class Healer extends A_Hero {
   public Healer(){
   
   }
   public void setInitialStats(){
      health = 15;
      attackDamage = 5;
      defense = 4;
      magicResist = 6;
      magicAttack = 7;
   }
   public void setHealerHealth(int health){
      health = health;
   }
   public void setHealerAD(int attackDamage){
      attackDamage = attackDamage;
   }
   public void setHealerDefense(int healerDefense){
      defense = healerDefense;
   }
   public void setHMR(int magicResist){
      magicResist = magicResist;
   }
   public void setHMA(int magicAttack){
      magicAttack = magicAttack;
   }
   public int getHealerHealth(){
      return health;
   }
   public int getHealerAD(){
      return attackDamage;
   }
   public int getHD(){
      return defense;
   }
   public int getHMR(){
      return magicResist;
   }
   public int getHMA(){
      return magicAttack;
   }
}