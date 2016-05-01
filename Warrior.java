public class Warrior extends A_Hero {
    

   
   public Warrior(){
   
   }
   public void setInitialStats(){
      health = 10;
      attackDamage = 5;
      defense = 6;
      magicResist = 4;
      magicAttack = 4;
   }
   public void setWarriorHealth(int health){
      health = health;
   }
   public void setWarriorAD(int attackDamage){
     attackDamage = attackDamage;
   }
   public void setWarriorDefense(int warriorDefense){
      defense = warriorDefense;
   }
   public void setWMR(int magicResist){
      magicResist = magicResist;
   }
   public void setWMA(int magicAttack){
      magicAttack = magicAttack;
   }
   public int getWarriorHealth(){
      return health;
   }
   public int getWarriorAD(){
      return attackDamage;
   }
   public int getWD(){
      return defense;
   }
   public int getWMR(){
      return magicResist;
   }
   public int getWMA(){
      return magicAttack;
   }
   
}