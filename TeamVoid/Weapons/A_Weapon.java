package TeamVoid.Weapons;

public abstract class A_Weapon {
   
   /**
    * The damage increase provided by this weapon.
    */
   private int damageAdd;
   
   /**
    * Whether or not this weapon pierces armor.
    */
   private boolean isArmorPiercing;
   
   /**
    * Whether or not this weapon is magic (adds to magic power instead of attack).
    */
   private boolean isMagic;
   
   /**
    * Basic constructor.
    *
    * @param damageAdd The damage increase provided by this weapon
    * @param isArmorPiercing Whether or not this weapon pierces armor
    * @param isMagic Whether or not this weapon is magic (adds to magic power instead of attack)
    */
   public A_Weapon(int damageAdd, boolean isArmorPiercing, boolean isMagic) {
      this.damageAdd = damageAdd;
      this.isArmorPiercing = isArmorPiercing;
      this.isMagic = isMagic;
   }
   
   /**
    * Returns the attack boost provided by this weapon.
    *
    * @return The value of {@code damageAdd} if this is not a magic weapon, 0 otherwise
    */
   public int getAttackBoost() {
      if(!isMagic)
         return damageAdd;
      else
         return 0;
   }
   
   /**
    * Returns the magic power boost provided by this weapon.
    *
    * @return The value of {@code damageAdd} if this is a magic weapon, 0 otherwise
    */
   public int getMagicPowerBoost() {
      if(isMagic)
         return damageAdd;
      else
         return 0;
   }
   
   /**
    * Returns whether this weapon pierces armor.
    *
    * @return The value of isArmorPiercing
    */
   public boolean isArmorPiercing() {
      return isArmorPiercing;
   }
}