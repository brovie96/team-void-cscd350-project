package TeamVoid.Hero;

public class Sorecor extends A_Hero{
  
   
   
   public Sorecor(){
      attack = new SorecerAttackMove();
   }
   public void setInitialStats(){
      health = 10;
      attackDamage = 5;
      defense = 4;
      magicResist = 6;
      magicAttack = 7;
      armor = 0;
   }
   public void setHealth(int healtha){
      health = healtha;
   }
   public void setAttackDamage(int attackDamagea){
      attackDamage = attackDamagea;
   }
   public void setDefense(int sorecorDefensea){
      this.defense = sorecorDefensea;
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
   public String getTypeHero()
   {
      return "Sorecor";
   }

}