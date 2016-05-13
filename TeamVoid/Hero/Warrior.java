package TeamVoid.Hero;

public class Warrior extends A_Hero {
    

   
   public Warrior(){
      attack = new WarriorAttackMove();
   }
   public void setInitialStats(){
      health = 10;
      attackDamage = 5;
      defense = 6;
      magicResist = 4;
      magicAttack = 4;
      armor = 0;
   }
   public void setHealth(int healtha){
      health = healtha;
   }
   public void setAttackDamage(int attackDamagea){
     attackDamage = attackDamagea;
   }
   public void setDefense(int warriorDefense){
      defense = warriorDefense;
   }
   public void setMagicResist(int magicResista){
      magicResist = magicResista;
   }
   public void setMagicAttack(int magicAttacka){
      magicAttack = magicAttacka;
   }
   public void setArmor(int armorr){
      armor = armorr;
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
   public int getArmor(){
      return armor;
   }
   public String getTypeHero(){
      return "Warrior";
   }
   
}