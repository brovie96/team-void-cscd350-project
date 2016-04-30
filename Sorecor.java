public class Sorecor extends A_Hero{
  
   
   
   public Sorecor(){
   
   }
   public void setInitialStats(){
      health = 10;
      attackDamage = 5;
      defense = 4;
      magicResist = 6;
      magicAttack = 7;
   }
   public void setSorecorHealth(int health){
      health = health;
   }
   public void setSorecorAD(int attackDamage){
      attackDamage = attackDamage;
   }
   public void setSorecorDefense(int sorecorDefense){
      this.defense = sorecorDefense;
   }
   public void setSMR(int magicResist){
      magicResist = magicResist;
   }
   public void setSMA(int magicAttack){
      magicAttack = magicAttack;
   }
   public int getSorecorHealth(){
      return health;
   }
   public int getSorecorAD(){
      return attackDamage;
   }
   public int getSD(){
      return defense;
   }
   public int getSMR(){
      return magicResist;
   }
   public int getSMA(){
      return magicAttack;
   }

}