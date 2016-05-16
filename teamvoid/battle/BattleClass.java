 package teamvoid.battle;
 import teamvoid.party.Party;
 import teamvoid.hero.A_Hero;
 import teamvoid.monster.A_Monster;
 import teamvoid.hero.Warrior;
 import teamvoid.hero.Healer;
 import teamvoid.monster.Necromancer;
 import teamvoid.hero.Sorecor;
 import teamvoid.monster.Goblin;
 import teamvoid.weapons.GoblinClub;
 import teamvoid.weapons.EvilPot;
 import teamvoid.monster.EvilLeperachan;
 import teamvoid.weapons.StaffOfPain;
 import teamvoid.monster.SlimeBall;
 import teamvoid.monster.Dragon;

import java.util.*;

public class BattleClass
{
   private int count;
   private Party party;
   private String message="", messageOne="",messageTwo="", messageThree="", messageFour="", messageFive="";
   private ArrayList<A_Monster> list;
   private  A_Hero playerOne,playerTwo, playerThree;
   private A_Monster monster = null;
   private A_Monster monsterOne = null, monsterTwo = null, monsterThree = null, monsterFour = null, monsterFive = null;
   
   public BattleClass(Party p, A_Monster... m1)//add Party as a second parameter
   {
      list = new ArrayList<A_Monster>();
      for(A_Monster q: m1)
      {
         count++;
         q.setDefaultStats();
         list.add(q);
         
      }
      this.party = p;
      
   }
   public void battle()
   {
      party.getHeroOne().setInitialStats(); 
      party.getHeroTwo().setInitialStats();
      party.getHeroThree().setInitialStats();   
      
      int numberMonsters = getCount();
      if(count == 1){
         fightOneMonster();
      }
      else if(count == 2){
         fightTwoMonsters();
      }
      else if(count == 3){
         fightThreeMonsters();
      } 
      else if(count == 4){
         fightFourMonsters();
      }
      else if(count == 5){
         fightFiveMonsters();
      }
   }
   public int getCount()
   {
      return count;
   }
   public void fightOneMonster(){
      int heroTurns = 0, indicator = 0;
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
         
       for(A_Monster mon: list){
               if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monster = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monster = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monster = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monster = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monster = new Dragon();
               }
            }
            monster.setDefaultStats();
            
      while(playerOne.getHealth() > 0 && playerTwo.getHealth() > 0 && playerThree.getHealth() > 0 ||!message.equals("Monster defeated")){
         if(heroTurns == 0){
            if(preCheckPlayersHealth(playerOne)){
                 playerAttacksMonster(playerOne, monster); 
            }
            heroTurns = 1;
         }
         else if(heroTurns == 1){
            if(preCheckPlayersHealth(playerTwo)){
               playerAttacksMonster(playerTwo, monster);
            }
            heroTurns = 2;
         }
         else if(heroTurns == 2){
            if(preCheckPlayersHealth(playerThree)){
               playerAttacksMonster(playerThree, monster);
            }
            heroTurns = 0;
         }
         monsterBattlesPlayer(monster);       
        
      }
      
     
     
    
   }//end of method
   public void fightTwoMonsters(){
       int heroTurns = 0, indicator = 0;
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
       for(A_Monster mon: list){
         if(indicator == 0){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterOne = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterOne = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterOne = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterOne = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterOne = new Dragon();
               }
               indicator = 1;
         }
         else if(indicator == 1){
               if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterTwo = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterTwo = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterTwo = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterTwo = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterTwo = new Dragon();
               }

         }
       }
            monsterOne.setDefaultStats();
            monsterTwo.setDefaultStats();
            
       while(playerOne.getHealth() > 0 && playerTwo.getHealth() > 0 && playerThree.getHealth() > 0 ||!messageOne.equals("Monster defeated") && !messageTwo.equals("Monster defeated")){
         if(heroTurns == 0){
            if(preCheckPlayersHealth(playerOne)){
                if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerOne, monsterOne); 
                }
                else {
                  playerAttacksMonster(playerOne, monsterTwo);
                }
                                
            }
            heroTurns = 1;
         }
         else if(heroTurns == 1){
            if(preCheckPlayersHealth(playerTwo)){
               if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerTwo, monsterOne); 
                }
                else{
                  playerAttacksMonster(playerTwo, monsterTwo);
                }

              
            }
            heroTurns = 2;
         }
         else if(heroTurns == 2){
            if(preCheckPlayersHealth(playerThree)){
             if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerThree, monsterOne); 
                }
                else{
                  playerAttacksMonster(playerThree, monsterTwo);
                }

            }
            heroTurns = 0;
         }
         if(!preCheckMonstersHealth(monsterOne) && preCheckMonstersHealth(monsterTwo)){
            messageOne = "Monster defeated";
            messageTwo = "Monster defeated";
         }
         else if(preCheckMonstersHealth(monsterOne)){
              monsterBattlesPlayer(monster);  
         }
         else if(preCheckMonstersHealth(monsterTwo)){
            monsterBattlesPlayer(monsterTwo);
         }
            
        
      }
      

      

   }
   public void fightThreeMonsters(){
      int heroTurns = 0, indicator = 0;
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
       for(A_Monster mon: list){
         if(indicator == 0){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterOne = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterOne = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterOne = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterOne = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterOne = new Dragon();
               }
               indicator = 1;
         }
         else if(indicator == 1){
               if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterTwo = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterTwo = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterTwo = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterTwo = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterTwo = new Dragon();
               }

         }
         else if(indicator == 2){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterThree = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterThree = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterThree = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterThree = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterThree = new Dragon();
               }

         }
       }
            monsterOne.setDefaultStats();
            monsterTwo.setDefaultStats();
            monsterThree.setDefaultStats();
            
       while(playerOne.getHealth() > 0 && playerTwo.getHealth() > 0 && playerThree.getHealth() > 0 ||!messageOne.equals("Monster defeated") && !messageTwo.equals("Monster defeated")&& !messageThree.equals("Monster defeated")){
         if(heroTurns == 0){
            if(preCheckPlayersHealth(playerOne)){
                if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerOne, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerOne, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerOne, monsterThree);
                }

                                
            }
            heroTurns = 1;
         }
         else if(heroTurns == 1){
            if(preCheckPlayersHealth(playerTwo)){
               if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerTwo, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerTwo, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerTwo, monsterThree);
                }


              
            }
            heroTurns = 2;
         }
         else if(heroTurns == 2){
            if(preCheckPlayersHealth(playerThree)){
             if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerThree, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerThree, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerThree, monsterThree);
                }
            }
            heroTurns = 0;
         }
         if(!preCheckMonstersHealth(monsterOne) && preCheckMonstersHealth(monsterTwo) && preCheckMonstersHealth(monsterThree)){
            messageOne = "Monster defeated";
            messageTwo = "Monster deafeated";
            messageThree = "Monster deafeated";
         }
         else if(preCheckMonstersHealth(monsterOne)){
              monsterBattlesPlayer(monster);  
         }
         else if(preCheckMonstersHealth(monsterTwo)){
            monsterBattlesPlayer(monsterTwo);
         }
           else if(preCheckMonstersHealth(monsterThree)){
            monsterBattlesPlayer(monsterThree);
         }
              
        
      }
      

   }
   public void fightFourMonsters(){
      int heroTurns = 0, indicator = 0;
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
       for(A_Monster mon: list){
         if(indicator == 0){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterOne = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterOne = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterOne = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterOne = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterOne = new Dragon();
               }
               indicator = 1;
         }
         else if(indicator == 1){
               if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterTwo = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterTwo = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterTwo = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterTwo = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterTwo = new Dragon();
               }

         }
         else if(indicator == 2){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterThree = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterThree = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterThree = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterThree = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterThree = new Dragon();
               }

         }
          else if(indicator == 3){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterFour = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterFour = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterFour = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterFour = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterFour = new Dragon();
               }

         }

       }
            monsterOne.setDefaultStats();
            monsterTwo.setDefaultStats();
            monsterThree.setDefaultStats();
            monsterFour.setDefaultStats();
            
       while(playerOne.getHealth() > 0 && playerTwo.getHealth() > 0 && playerThree.getHealth() > 0 ||!messageOne.equals("Monster defeated") && !messageTwo.equals("Monster defeated")&& !messageThree.equals("Monster defeated")&& !messageFour.equals("Monster defeated")){
         if(heroTurns == 0){
            if(preCheckPlayersHealth(playerOne)){
                if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerOne, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerOne, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerOne, monsterThree);
                }
                else if(preCheckMonstersHealth(monsterFour)){
                  playerAttacksMonster(playerOne, monsterFour);
                }


                                
            }
            heroTurns = 1;
         }
         else if(heroTurns == 1){
            if(preCheckPlayersHealth(playerTwo)){
               if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerTwo, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerTwo, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerTwo, monsterThree);
                }
                else if(preCheckMonstersHealth(monsterFour)){
                  playerAttacksMonster(playerTwo, monsterFour);
                }

              
            }
            heroTurns = 2;
         }
         else if(heroTurns == 2){
            if(preCheckPlayersHealth(playerThree)){
             if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerThree, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerThree, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerThree, monsterThree);
                }
                else if(preCheckMonstersHealth(monsterFour)){
                  playerAttacksMonster(playerThree, monsterFour);
                }
            
            }
            heroTurns = 0;
         }
         if(!preCheckMonstersHealth(monsterOne) && preCheckMonstersHealth(monsterTwo) && preCheckMonstersHealth(monsterThree)&& preCheckMonstersHealth(monsterFour)){
            messageOne = "Monster defeated";
            messageTwo = "Monster deafeated";
            messageThree = "Monster deafeated";
             messageFour = "Monster deafeated";
         }
         else if(preCheckMonstersHealth(monsterOne)){
              monsterBattlesPlayer(monster);  
         }
         else if(preCheckMonstersHealth(monsterTwo)){
            monsterBattlesPlayer(monsterTwo);
         }
           else if(preCheckMonstersHealth(monsterThree)){
            monsterBattlesPlayer(monsterThree);
         }
          else if(preCheckMonstersHealth(monsterFour)){
            monsterBattlesPlayer(monsterFour);
         }
                  
        
      }
      

   }
   public void fightFiveMonsters(){
      int heroTurns = 0, indicator = 0;
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
       for(A_Monster mon: list){
         if(indicator == 0){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterOne = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterOne = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterOne = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterOne = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterOne = new Dragon();
               }
               indicator = 1;
         }
         else if(indicator == 1){
               if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterTwo = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterTwo = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterTwo = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterTwo = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterTwo = new Dragon();
               }

         }
         else if(indicator == 2){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterThree = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterThree = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterThree = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterThree = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterThree = new Dragon();
               }

         }
          else if(indicator == 3){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterFour = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterFour = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterFour = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterFour = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterFour = new Dragon();
               }

         }
              else if(indicator == 3){
            if(mon.getTypeMonster().equals("Goblin")){
                 // mon.setDefaultStats();
                  monsterFive = new Goblin(new GoblinClub());
                
               }
               else if(mon.getTypeMonster().equals("EvilLeperachan")){
                 // mon.setDefaultStats();
                  monsterFive = new EvilLeperachan(new EvilPot());
               }
               else if(mon.getTypeMonster().equals("Necromancer")){
                  //mon.setDefaultStats();
                  monsterFive = new Necromancer(new StaffOfPain());
               }
               else if(mon.getTypeMonster().equals("SlimeBall")){
                 // mon.setDefaultStats();
                  monsterFive = new SlimeBall();
               }
               else if(mon.getTypeMonster().equals("Dragon")){
                  //mon.setDefaultStats();
                  monsterFive = new Dragon();
               }

         }

       }
            monsterOne.setDefaultStats();
            monsterTwo.setDefaultStats();
            monsterThree.setDefaultStats();
            monsterFour.setDefaultStats();
            monsterFive.setDefaultStats();
            
       while(playerOne.getHealth() > 0 && playerTwo.getHealth() > 0 && playerThree.getHealth() > 0 ||!messageOne.equals("Monster defeated") && !messageTwo.equals("Monster defeated")&& !messageThree.equals("Monster defeated")&& !messageFour.equals("Monster defeated")&& !messageFive.equals("Monster defeated")){
         if(heroTurns == 0){
            if(preCheckPlayersHealth(playerOne)){
                if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerOne, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerOne, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerOne, monsterThree);
                }
                else if(preCheckMonstersHealth(monsterFour)){
                  playerAttacksMonster(playerOne, monsterFour);
                }
                else if(preCheckMonstersHealth(monsterFive)){
                  playerAttacksMonster(playerOne, monsterFive);
                }

                                
            }
            heroTurns = 1;
         }
         else if(heroTurns == 1){
            if(preCheckPlayersHealth(playerTwo)){
               if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerTwo, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerTwo, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerTwo, monsterThree);
                }
                else if(preCheckMonstersHealth(monsterFour)){
                  playerAttacksMonster(playerTwo, monsterFour);
                }
                else if(preCheckMonstersHealth(monsterFive)){
                  playerAttacksMonster(playerTwo, monsterFive);
                }


              
            }
            heroTurns = 2;
         }
         else if(heroTurns == 2){
            if(preCheckPlayersHealth(playerThree)){
             if(preCheckMonstersHealth(monsterOne)){
                  playerAttacksMonster(playerThree, monsterOne); 
                }
                else if(preCheckMonstersHealth(monsterTwo)){
                  playerAttacksMonster(playerThree, monsterTwo);
                }
                else if(preCheckMonstersHealth(monsterThree)){
                  playerAttacksMonster(playerThree, monsterThree);
                }
                else if(preCheckMonstersHealth(monsterFour)){
                  playerAttacksMonster(playerThree, monsterFour);
                }
                else if(preCheckMonstersHealth(monsterFive)){
                  playerAttacksMonster(playerThree, monsterFive);
                }

            
            }
            heroTurns = 0;
         }
         if(!preCheckMonstersHealth(monsterOne) && preCheckMonstersHealth(monsterTwo) && preCheckMonstersHealth(monsterThree)&& preCheckMonstersHealth(monsterFour)&& preCheckMonstersHealth(monsterFive)){
            messageOne = "Monster defeated";
            messageTwo = "Monster deafeated";
            messageThree = "Monster deafeated";
             messageFour = "Monster deafeated";
              messageFive = "Monster deafeated"; 
         }
         else if(preCheckMonstersHealth(monsterOne)){
              monsterBattlesPlayer(monster);  
         }
         else if(preCheckMonstersHealth(monsterTwo)){
            monsterBattlesPlayer(monsterTwo);
         }
           else if(preCheckMonstersHealth(monsterThree)){
            monsterBattlesPlayer(monsterThree);
         }
          else if(preCheckMonstersHealth(monsterFour)){
            monsterBattlesPlayer(monsterFour);
         }
          else if(preCheckMonstersHealth(monsterFive)){
            monsterBattlesPlayer(monsterFive);
         }
         
        
      }
      


   }
   public void monsterBattlesPlayer(A_Monster m){
      if(preCheckMonstersHealth(m)){
            if(preCheckPlayersHealth(playerOne)){
               if(m.checkMagic()){
                  int heroHealth = playerOne.getHealth() - m.addBoost();
                  if(heroHealth < 0){
                     heroHealth = 0;
                  }  
                  playerOne.setHealth(heroHealth);
               }
               else if(!m.checkMagic()){
                  if(m.checkArmorPiercing()){
                     int heroHealth = playerOne.getHealth() - m.addBoost();
                     if(heroHealth < 0){
                        heroHealth = 0;
                     }
                     playerOne.setHealth(heroHealth);
                  }
                  else if(!m.checkArmorPiercing()){
                     int heroHealth = 0;
                     heroHealth = playerOne.getHealth() - m.addBoost(); 
                     if(heroHealth < 0){
                        heroHealth = 0;
                     } 
                     playerOne.setHealth(heroHealth);
                  }
               }
            }
            else if(preCheckPlayersHealth(playerTwo)){
            
               if(preCheckMonstersHealth(m)){
                  if(preCheckPlayersHealth(playerTwo)){
                     if(m.checkMagic()){
                        int heroHealth = playerTwo.getHealth() - (m.addBoost() - m.getMagicResist());  
                        if(heroHealth < 0){
                           heroHealth = 0;
                        }
                        playerTwo.setHealth(heroHealth);
                     }
                     else if(!m.checkMagic()){
                          if(m.checkArmorPiercing()){
                             int heroHealth = playerTwo.getHealth() - m.addBoost();
                             if(heroHealth < 0){
                               heroHealth = 0;
                             }
                             playerTwo.setHealth(heroHealth);
                          }
                     else if(!m.checkArmorPiercing()){
                         int heroHealth = playerTwo.getHealth() - (m.addBoost() - playerTwo.getDefense()); 
                         if(heroHealth < 0){
                            heroHealth = 0;
                         }
                         playerTwo.setHealth(heroHealth); 
                     }
                    }
                  }

            }
            else if(preCheckPlayersHealth(playerThree)){
                  if(preCheckMonstersHealth(m)){
                  if(preCheckPlayersHealth(playerThree)){
                   if(m.checkMagic()){
                        int heroHealth = playerThree.getHealth() - (m.addBoost() - m.getMagicResist());  
                        if(heroHealth < 0){
                           heroHealth = 0;
                        }
                        playerThree.setHealth(heroHealth);
                   }
                   else if(!m.checkMagic()){
                        if(m.checkArmorPiercing()){
                           int heroHealth = playerThree.getHealth() - m.addBoost();
                           if(heroHealth < 0){
                              heroHealth = 0;
                           }
                           playerThree.setHealth(heroHealth);
                        }
                   else if(!m.checkArmorPiercing()){
                     int heroHealth = playerThree.getHealth() - (m.addBoost() - playerThree.getDefense());
                     if(heroHealth < 0){
                        heroHealth = 0;
                     } 
                     playerThree.setHealth(heroHealth); 
                   }
                  }
                }

            }

            }  
         }
         
     }
      
   }
   public void playerAttacksMonster(A_Hero player, A_Monster monster){
      //check for special attack;
      //check if hero wants to use potion
      int monstersHealth;
      monstersHealth = monster.getHealth() - player.getAttackDamage(); 
      monster.setHealth(monstersHealth);      
      
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
      else if(m.getHealth() < 0){
         message = "Monster defeated";
         
      }
      return false;
   }
}