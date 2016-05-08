package TeamVoid.Weapons;

public abstract class A_MagicWeapon extends A_Weapon {
   
   /**
    * Basic constructor.
    *
    * @param damageAdd The damage increase provided by this weapon
    */
   public A_MagicWeapon(int damageAdd) {
      super(damageAdd, false, true);
   }
}