package TeamVoid.Bag;
import  TeamVoid.Monster.*;
import  TeamVoid.Weapons.*;

public class Bag{
   private A_Weapon[] weaponArray;
   private int weaponArrayCounter = 0;
    
   public Bag(){
      weaponArray = new A_Weapon[3];  
   }
   public void addWeaponArray(A_Monster a){
      if(getWeaponCounter() <= 3){
         weaponArray[weaponArrayCounter] = a.getWeaponDrop(a);
         weaponArrayCounter++;
      }
   }
   
   
   public int getWeaponCounter(){
      return weaponArrayCounter;
   }
}