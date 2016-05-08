package teamvoid.hero;

public class Healer extends A_Hero {
   public Healer(){
      attack = new HealerAttackMove();
   }
   public void setInitialStats(){
      health = 15;
      attackDamage = 5;
      defense = 4;
      magicResist = 6;
      magicAttack = 7;
   }
   public void setHealth(int health){
      health = health;
   }
   public void setAttackDamage(int attackDamagea){
      attackDamage = attackDamagea;
   }
   public void setDefense(int healerDefense){
      defense = healerDefense;
   }
   public void setMagicResist(int magicResista){
      magicResist = magicResista;
   }
   public void setMagicAttack(int magicAttacka){
      magicAttack = magicAttacka;
   }
   public int getHealth(){
      return health;
   }
   public int getAttackDamage(){
      return attackDamage;
   }
   public int getDefense(){
      return defense;
   }
   public int getMagicResist(){
      return magicResist;
   }
   public int getMagicAttack(){
      return magicAttack;
   }
   public String getTypeHero(){
      return "Healer";
   }
}