package teamvoid.weapons;

public abstract class A_PhysicalWeapon extends A_Weapon {
   
   /**
    * Basic constructor.
    *
    * @param damageAdd The damage increase provided by this weapon
    * @param isArmorPiercing Whether or not this weapon pierces armor
    */
   public A_PhysicalWeapon(int damageAdd, boolean isArmorPiercing) {
      super(damageAdd, isArmorPiercing, false);
   }
}