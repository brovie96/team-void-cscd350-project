public class DefenseBoostingPotion extends Potion {
   private int defense = 2;
   private int magicResist = 2;
   
   public DefenseBoostingPotion(){
   
   }
   public void setDefense(int defense)
   {
      this.defense = defense;
   }
   public void setMagicResist(int magicResist)
   {
      this.magicResist = magicResist;
   }
   public int getDefense()
   {
      return defense;
   }
   public int getMagicResist()
   {
      return magicResist;
   }

}