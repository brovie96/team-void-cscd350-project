package TeamVoid.Hero;
import TeamVoid.Weapons.*;

public class Healer extends A_Hero {
   private A_Weapon heroWeapon;
   
   public Healer(){
      attack = new HealerAttackMove();
   }
   public void setInitialStats(){
      health = 15;
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
   public void setDefense(int healerDefense){
      defense = healerDefense;
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
      return "Healer";
   }
   public A_Weapon getWeapon(){
      return heroWeapon;
   }
   public void equipWeapon(A_Weapon w){
      this.heroWeapon = w;
   }
}