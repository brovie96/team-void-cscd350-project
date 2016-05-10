 package TeamVoid.Battle;
 
 import TeamVoid.party.Party;
 import TeamVoid.Hero.A_Hero;
 import TeamVoid.Monster.A_Monster;
 import TeamVoid.Hero.Warrior;
 import TeamVoid.Hero.Healer;
 import TeamVoid.Monster.Necromancer;
 import TeamVoid.Hero.Sorecor;
 import TeamVoid.Monster.Goblin;
 import TeamVoid.Weapons.GoblinClub;
 import TeamVoid.Weapons.EvilPot;
 import TeamVoid.Monster.EvilLeperachan;
 import TeamVoid.Weapons.StaffOfPain;
 import TeamVoid.Monster.SlimeBall;
 import TeamVoid.Monster.Dragon;



import java.util.*;
import java.lang.*;

public class BattleClassCopy{
 
   private Party party;
   private int deadMonsterCount = 0, count = 0;
   private ArrayList<A_Monster> list;
   private  A_Hero playerOne,playerTwo, playerThree;
   private A_Monster monster = null;
  
    
   public BattleClassCopy(Party p, A_Monster... m1){
      list = new ArrayList<A_Monster>();
      for(A_Monster q: m1){
         count++;
         q.setDefaultStats();
         list.add(q);
         
      }
      this.party = p;

   }
   public void battle(){
      int heroTurns = 0, monsterTrigger = 1, allPlayersHealth = 1;
      party.getHeroOne().setInitialStats(); 
      party.getHeroTwo().setInitialStats();
      party.getHeroThree().setInitialStats();
     
      
      int number = getMonsterCount();
      initiatePlayers(); 
               
      while(monsterTrigger != 0 && allPlayersHealth == 1|| allPlayersHealth != 0 && monsterTrigger== 1){//rename to trigger
         if(heroTurns == 0){
            if(preCheckPlayersHealth(playerOne)){
               
               preCheckMonster();
               playerAttacksMonster(playerOne, monster);
            }
            heroTurns = 1;
         }
         else if(heroTurns == 1){
            if(preCheckPlayersHealth(playerTwo)){
               
               preCheckMonster();
               playerAttacksMonster(playerTwo, monster);
            }

            heroTurns = 2;
         }
         else if(heroTurns == 2){
           if(preCheckPlayersHealth(playerThree)){
               
               preCheckMonster();
               playerAttacksMonster(playerThree, monster);
            }

            heroTurns = 0;
         }
         allPlayersHealth = preCheckAllPlayersHealth();
         monsterTrigger = preCheckAllMonstersHealth();
         if(monsterTrigger  == 0){
            //monsterdead
         }
         else if(allPlayersHealth == 0){
            //players dead
         }
         else{
            monsterBattlesPlayer();
         }
         
         
      } 
   }
   public int getMonsterCount(){
      return count;
   }
   public void preCheckMonster(){
       Scanner scan = new Scanner(System.in);
       System.out.println("Pick the monsters provided");
                        printMonsters();
                        String name = scan.nextLine();
                        findMonster(name);
                   
                        
                        while(monster == null || !preCheckMonstersHealth(monster)){
                            System.out.println("can't pick dead monsters");
                            printMonsters();
                            String namee = scan.nextLine();
                            findMonster(namee);
                          

                        }

   }
   public int preCheckAllPlayersHealth()
   {
      int health = 1;
      if(playerOne.getHealth() <= 0 && playerTwo.getHealth() <= 0 && playerThree.getHealth() <= 0){
         health = 0;
      }
      return health;
   }
   public int preCheckAllMonstersHealth(){
      int indicator = 1;
      
      for(A_Monster ms: list){
         if(ms.getHealth() <= 0){
            indicator = 0;
         }
         else{
            indicator = 1;
            return indicator;
         }
      }
      return indicator;
   }
   public void printMonsters(){
      for(A_Monster m: list){
         if(preCheckMonstersHealth(m)){
            System.out.println(m.getTypeMonster());
         }
         else{
            System.out.println(m.getTypeMonster() + "- Dead");
         }
         
      }
   }
   public void initiatePlayers(){
  
      String playerOnee = party.getHeroOne().getTypeHero();
      String playerTwoo = party.getHeroTwo().getTypeHero();
      String playerThreee = party.getHeroThree().getTypeHero();
      
      if(playerOnee.equals("Warrior")){
         playerOne = new Warrior();
         playerOne = party.getHeroOne();
      }
      else if(playerOnee.equals("Healer")){
         playerOne = new Healer();
         playerOne = party.getHeroOne();
      }
      else if(playerOnee.equals("Sorecor")){
         playerOne = new Sorecor();
         playerOne = party.getHeroOne();
      }
      if(playerTwoo.equals("Warrior")){
         playerTwo = new Warrior();
         playerTwo = party.getHeroTwo();
      }
      else if(playerTwoo.equals("Healer")){
         playerTwo = new Healer();
         playerTwo = party.getHeroTwo();
      }
      else if(playerTwoo.equals("Sorecor")){
         playerTwo = new Sorecor();
         playerTwo = party.getHeroTwo();
      }
      if(playerThreee.equals("Warrior")){
         playerThree = new Warrior();
         playerThree = party.getHeroThree();
      }
      else if(playerThreee.equals("Healer")){
         playerThree = new Healer();
         playerThree = party.getHeroThree();
      }
      else if(playerThreee.equals("Sorecor")){
         playerThree = new Sorecor();
         playerThree = party.getHeroThree();
      }
   }

   public boolean preCheckPlayersHealth(A_Hero player){
      if(player.getHealth() > 0){
         return true;
      }
      return false;
   }
   public boolean preCheckMonstersHealth(A_Monster m){
      if(m.getHealth() > 0){
         return true; 
      }
      return false;
   }
   public A_Monster findMonster(String name){
      int findMonsterIndicator = 0;
      for(A_Monster a: list){
         if(a.getTypeMonster().equals(name)){
            monster = a;
            findMonsterIndicator = 1;
         }
      }
      if(findMonsterIndicator == 0){
            monster = null;
         }

      return monster;
   }
 public void playerAttacksMonster(A_Hero player, A_Monster monster){
      //check for special attack;
      //check if hero wants to use potion
      int monstersHealth;
      monstersHealth = monster.getHealth() - player.getAttackDamage(); 
      monster.setHealth(monstersHealth);      
      
   }
   public void monsterBattlesPlayer(){
      Random rVarible = new Random();
      int i = 1;
      
      do{
         int monsterr = rVarible.nextInt(getMonsterCount()) + 1;
         for(A_Monster ma: list){
            if(monsterr == i){
               monster = ma;
               i++;
            }
            else if(monsterr != i){
               i++;
            }
         }
         i = 1;
        }while(monster.getHealth() <= 0);
        
        if(playerOne.getHealth() >= 0){
            battleCalc(playerOne, monster);
        }
        else if(playerTwo.getHealth() >= 0){
            battleCalc(playerTwo, monster);
        }
        else if(playerThree.getHealth() >= 0){
            battleCalc(playerThree, monster);
        }
   }
   public void battleCalc(A_Hero pl, A_Monster m){
      if(m.checkMagic()){
                  int heroHealth = pl.getHealth() - (m.addBoost()- pl.getMagicResist());
                   
                  pl.setHealth(heroHealth);
               }
               else if(!m.checkMagic()){
                  if(m.checkArmorPiercing()){
                     int heroHealth = pl.getHealth() - (m.addBoost() - pl.getDefense());
                    
                     pl.setHealth(heroHealth);
                  }
                  else if(!m.checkArmorPiercing()){
                     int heroHealth = 0;
                     heroHealth = pl.getHealth() - (m.addBoost() - (pl.getDefense() + pl.getArmor())); 
                    
                     pl.setHealth(heroHealth);
                  }
               }
            

   }
 
 
  
}//end of class