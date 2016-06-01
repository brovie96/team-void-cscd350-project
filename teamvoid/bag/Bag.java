package teamvoid.bag;
import  teamvoid.monster.*;
import  teamvoid.weapons.*;

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
   public String getWeapon(int position){
      String weapon="";
      if(weaponArray[position] != null){
         weapon = weaponArray[position].getClass().getSimpleName();
      }
       return weapon;
   }
   public void listWeapons(){
      String weapons="";
      for(int i = 0; i < weaponArray.length; i++){
         System.out.println("Weapon: " + getWeapon(i));
         
        
      }
   }
   public A_Weapon findWeapon(String name){
       A_Weapon s = null;
       for(int i = 0; i < weaponArray.length; i++){
         if(name.equals(getWeapon(i))){
            s = weaponArray[i];
         }
       }
       return s;
   }

   
   public int getWeaponCounter(){
      return weaponArrayCounter;
   }
}
