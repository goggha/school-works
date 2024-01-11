import java.util.*;

public class command {
    private boolean Graveyard = true;
    private boolean IsGraveYardMobsKill = false;
    private boolean TheShadowyEnclave = false;
    private boolean TheShadowyEnclaveMobsKill = false;
    private boolean TheShadowyEnclaveUnlock = false;
    private boolean TheTreacherousMountainPass = true;
    private boolean TheTreacherousMountainPassKill = false;
    private boolean TheTreacherousMountainPassUnlock = false;
     boolean IsWitchDead = false;
     boolean IsVampireDead = false;
     boolean IsWerewolfDead = false;
     boolean IsZombieDead = false;
     boolean IsSkellDead = false;
    boolean IsGhostDead = false;
     boolean IsDragonDead = false;
     boolean IsDrakeDead = false;
     boolean IsTrollDead = false;
    public boolean CurrentEnemyIsDead;
     boolean GameOver;
    static Scanner input = new Scanner(System.in);
    static player player = new player();
    static encounter encounter = new encounter();
    static enemy skelle = new skelle();
     static enemy zombie = new zombie();
     static enemy Ghost = new Ghost();
     static enemy witch = new witch();
     static enemy werewolf = new werewolf();
     static enemy troll = new troll();
     static enemy drake = new drake();
     static enemy dragon = new dragon();
    static enemy vampire = new vampire();
    
     static int SKC = 0;
     static int ZKC = 0;
     static int SpKC = 0;

    public void ShowPlayerStats() {
        delayPrint("                   [Player Stats] ", 800);
        System.out.println("Name: " + player.getname());
        System.out.print("Health Points: " + player.getHp() + "/" + player.getMaxHP());
        System.out.println("        | Defense    : " + player.getDef());
        System.out.print("Damage       : " + player.getDamage());
        System.out.println("            | Strength   : " + player.getStrength());
        System.out.print("Level        : " + player.getPlayerLevel());
        System.out.println("            | Experience : " + player.getExp() + "/" + player.getBaseExpRequired());

        System.out.println("Stat Points  : " + player.getStatPoints());
        delayPrint("[1]: lvlup [2]: Distribute Statpoint [3]: Back", 600);

        int goback = input.nextInt();
        switch (goback) {
            case 1:
                player.levelUp();
                ShowPlayerStats();
                break;
            case 2:
                distributeStatPoint();
                break;
            case 3:
                menu();
                break;
            default:
                ShowPlayerStats();
                break;
        }
    }

    private void distributeStatPoint() {
        if (player.getStatPoints() <= 0) {
            slowPrint(" No stat point remaining");
            menu();
        } else {
            System.out.println("Choose a stat to increase\n[1]: Defense [2]: Strength [3]: Back");
            int statInc = input.nextInt();
            switch (statInc) {
                case 1:
                    increaseDefense();
                    break;
                case 2:
                    increaseStrength();
                    break;
                default:
                    menu();
                    break;
            }
        }
    }

    private void increaseDefense() {
        int defUp = player.getDef() + 1;
        player.setDef(defUp);
        player.setMaxHP(player.getDef());
        player.setHp(player.getMaxHP());
        slowPrint("Defense stat increased to " + player.getDef());
        slowPrint("HP increased to " + player.getHp() + "/" + player.getMaxHP());
        player.setStatPoints(1);
        distributeStatPoint();
    }

    private void increaseStrength() {
        int prevDamage = player.getDamage();
        int strUp = player.getStrength() + 1;
        player.setStrength(strUp);
        player.setDamage(player.getStrength());
        slowPrint("Strength stat increased to " + player.getStrength());
        slowPrint("Damage increased from " + prevDamage + " to " + player.getDamage());
          player.setStatPoints(1);
        distributeStatPoint();
    }



    public void looby(){
        if(IsGraveYardMobsKill && TheShadowyEnclaveMobsKill && TheShadowyEnclaveMobsKill){
            slowPrint("You've Cleared all maps Congratulations");
        }else{
        try {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("        [Medieval Adventure]");
            slowPrint("[1]: Explore \n[2]: Restart Game" );
            int menuInput = input.nextInt();
            switch (menuInput) {
                case 1:
                        if(GameOver){
                                slowPrint("You're Dead you cant explore");
                                revive();
                                looby();
                            }
                      System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("            [Maps]");
                    
                    slowPrint("[1]: The Cursed Catacombs ");
                    if(TheShadowyEnclaveUnlock ){
                    slowPrint("[2]: The Shadowy Enclave");
                    }else{
                        slowPrint("[2]: [Locked]");
                    }if(TheTreacherousMountainPassUnlock ){
                    slowPrint("[3]: The Treacherous MountainPass Unlock");
                    }else{
                        slowPrint("[3]: [Locked]");
                    }
                    int mapInput = input.nextInt();
                        switch (mapInput) {
                        case 1:
                       
                         System.out.println("------------------------------------------------------------------------------------------");
                            slowPrint("Entering The Cursed Catacombs");
                            if(CurrentEnemyIsDead){
                                System.out.print("Complete");
                            }
                             System.out.println("------------------------------------------------------------------------------------------");
                             if(Graveyard == true){
                             
                             enterGraveyard();
                             }
                                break;
                                case 2:
                                if(TheShadowyEnclaveUnlock == true){
                             TheShadowyEnclave();
                             }
                                    System.out.println("------------------------------------------------------------------------------------------");
                            slowPrint("The Shadowy Enclave");
                            if(CurrentEnemyIsDead){
                                System.out.print("Complete");
                            }
                             System.out.println("------------------------------------------------------------------------------------------");
                             
                             break;
                             }
                    break;
                case 2:
                         restartGame();
                            break;
                default:
                    System.out.println("Enter a valid command");
                  
                    looby();
                    break;
                            }
        }catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
            // Clear the invalid input from the scanner
            looby(); // Restart the lobby
        }
    }

}

    
    public void restartGame() {
        
        Graveyard = true;
        player.resetPlayerStats();
        game();
    }
    public void GameIntro(){
        slowPrint("Welcome to the Medieval Adventure game!");
              System.out.println("------------------------------------------------------------------------------------------");
        if(player.getname().isBlank()){
        slowPrint("What is your name brave Knight? ");
        player.setname(input.nextLine());
               System.out.println("------------------------------------------------------------------------------------------");
        slowPrint("You, " + player.getname() + ", a brave knight who must face 10 enemies in order to save the princess.");
        /*slowPrint("For each enemy, you will be given 2 or 3 choices on how to fight them.");
        slowPrint("Choose wisely, as only one choice will lead you to victory.");
        slowPrint("If you choose the wrong option, you will lose the game.");
        */
        slowPrint("Good luck!");
        
        }
    }
   public void Ending(){
        slowPrint("You've Cleared and kill all the mobs");

   }
    public void game() {
      GameIntro();
      looby();
      Ending();
    }

    public void slowPrint(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(50); // Adjust the delay time (in milliseconds) as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Print a new line after the text is displayed

    }
    public void delayPrint(String text, int delayTime){
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
        }
        try{
            Thread.sleep(delayTime);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
    }
    public void slowPrintAdj(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay); // Adjust the delay time (in milliseconds) as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Print a new line after the text is displayed

    }
    public void EncounterARoom(){
        slowPrint("You reach the end of the corridor.\nYou see a door do you want to open and enter it?\n[1]: Yes \n[2]: No \n[3]: Go back to Menu");
        enterroom(input.nextLine());
    }
    public void enterroom(String answer) {
        if (answer.equalsIgnoreCase("1")) {
            slowPrint("You Entered a room");
            Graveyard = false;
            if (IsZombieDead) {

            }
        } else if (answer.equalsIgnoreCase("2")) {
            slowPrint("Walk into the corridors again");
            if (IsSkellDead) {
                IsSkellDead = false;
            }
            if (!IsSkellDead && IsZombieDead) {
                IsZombieDead = false;
                IsZombieDead = false;
            }
            Graveyard = false;
            enterGraveyard();
        } else if (answer.equalsIgnoreCase("3")) {
            isPlayerDead();
        } else {
            EncounterARoom();
        }
         // Consume the newline character
    }
    public void isPlayerDead() {
        if (player.getHp() <= 0) {
            System.out.println("You've died");
            revive();
        }
        if (CurrentEnemyIsDead) {
            menu();
        }
    }
    
        public void enterGraveyard() {
            while (!GameOver) {
                if (Graveyard) {
                    slowPrint("Welcome to The Cursed Catacombs");
                    slowPrint("The air is thick with musty dampness and a faint scent of decay.");
                    slowPrint("Whispers echo through the halls, and an unnerving silence lingers");
                    slowPrint("between occasional distant moans or bone-chilling sounds.");
                    Graveyard = false;
                }
        
        
                while (!IsSkellDead) {
                    if (SKC <= 0) {
                        System.out.println("------------------------------------------------------------------------------------------");
                        slowPrint("You've entered the Cursed Catacombs corridor");
                    }
                    encounter.fightSkeleton();
                    
                    if (skelle.getHp() <= 0) {
                        IsSkellDead = true;
                        SKC++;
                    } else {
                        IsSkellDead = false;
                    }
                }
                EncounterARoom();  
               
        
                while (!IsZombieDead && !GameOver) {
                    encounter.fightZombie();
                    if (zombie.getHp() <= 0) {
                        IsZombieDead = true;
                    } else {
                        IsZombieDead = false;
                    }
                }
        
                while (!IsGhostDead && !GameOver) {
                    encounter.fightGhost();
                    
                    if (Ghost.getHp() <= 0) {
                        IsGhostDead = true;
                    } else {
                        IsGhostDead = false;
                    }
                }
        
               
            }
            
        }
        
         public void TheShadowyEnclave() {
            while (!GameOver) {
                if (TheShadowyEnclave) {
                    slowPrint("Welcome to The Shadowy Enclave");
                    slowPrint(": This mysterious area is shrouded in perpetual twilight, with twisted trees looming overhead.");
                    slowPrint("their branches entangled like grasping claws. Secluded huts dot the landscape, surrounded by thick fog and veils of mystical energy");
                    slowPrint("between occasional distant moans or bone-chilling sounds.");
                    TheShadowyEnclave = false;
                }
        
        
                while (!IsWitchDead) {
                    if (SKC <= 0) {
                        System.out.println("------------------------------------------------------------------------------------------");
                        slowPrint("You've entered the forest");
                    }
                    encounter.fightWitch();
                    IsWitchDead = true;
                }
          
               
        
                while (!IsVampireDead && !GameOver) {
                    encounter.fightVampire();
                    if (zombie.getHp() <= 0) {
                        IsZombieDead = true;
                    } else {
                        IsZombieDead = false;
                    }
                }
        
                while (!IsWerewolfDead && !GameOver) {
                    encounter.fightWerewolf();
                    
                    if (Ghost.getHp() <= 0) {
                        IsGhostDead = true;
                    } else {
                        IsGhostDead = false;
                    }
                }
        
            }
                if (IsVampireDead && IsWerewolfDead && IsWitchDead) {
                    System.out.println("You've Cleared The Shadowy Enclave");
                    TheShadowyEnclaveMobsKill = true;
                    TheTreacherousMountainPassUnlock = true;
                    looby();
                }
        }
      
        
        
                public void TheTreacherousMountainPass() {
                    while (!GameOver) {
                        if (TheTreacherousMountainPass) {
                            slowPrint("Welcome to The Treacherous Mountain Pass Towering,");
                            slowPrint("snow-capped peaks dominate the landscape,casting daunting");
                            slowPrint(" shadows over treacherous paths and rocky terrain enormous stone bridge");
                            slowPrint("sspan over chasms, leading to foreboding caves and hidden alcoves.s.");
                            TheTreacherousMountainPass = false;
                        }
                
                
                        while (!TheTreacherousMountainPass) {
                            if (SKC <= 0) {
                                System.out.println("------------------------------------------------------------------------------------------");
                                slowPrint("You've entered The  entrance of the Treacherous Mountain Pass");
                            }
                            encounter.fightTroll();
            
                            
                            if (troll.getHp() <= 0) {
                                IsTrollDead = true;
                                SKC++;
                            } else {
                                IsTrollDead = false;
                            }
                        }
                        EncounterARoom();  
                       
                
                        while (!IsDrakeDead) {
                            encounter.fightDrake();
                            if (zombie.getHp() <= 0) {
                                IsDrakeDead = true;
                            } else {
                                IsDrakeDead = false;
                            }
                        }
                
                        while (!IsDragonDead && !GameOver) {
                            encounter.fightDragon();
                            
                            if (Ghost.getHp() <= 0) {
                                IsDragonDead = true;
                            } else {
                                IsDragonDead = false;
                            }
                        }
                
                    }
                       if (IsDragonDead && IsZombieDead && IsGhostDead) {
                            System.out.println("You've Cleared The Treacherous Mountain Pass");
                            TheTreacherousMountainPassKill = true;
                            looby();
                        }
                
        
            
               if (IsSkellDead && IsZombieDead && IsGhostDead) {
                    System.out.println("You've Cleared The Cursed Cotacombs");
                    TheTreacherousMountainPassKill = true;
                    looby();
                }
            }

  public void revive(){
    slowPrint("Do you want to revive?\n[1]: Yes \n[2]: Go back to lobby");
     String answer = input.nextLine();
        if(answer.equalsIgnoreCase("1")){
            player.setHp(player.getMaxHP());
            GameOver = false;
            slowPrint("Revied");
        }else if(answer.equalsIgnoreCase("2")){
            GameOver = true;
            looby();
            
        }else{
            slowPrint("Enter valid response");
            revive();
        }
  }
  public void menu() {
    try {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("        [Menu:]");
        slowPrint("[1]: Show Player Stats \n[2]: Heal \n[3]: Continue");
        int menuInput = input.nextInt();
        switch (menuInput) {
            case 1:
                ShowPlayerStats();
                break;
            case 2:
                slowPrint("You've Healed ");
                player.playerheal();
                break;
            case 3:
                int halfhp = player.getMaxHP() / 2;
                if (player.getHp() <= halfhp) {
                    System.out.println("You need to heal first.");
                    menu();
                }
                break;
            default:
                System.out.println("Enter a valid command");
        }
    } catch (InputMismatchException e) {
        System.out.println("Please enter a valid number.");
         // Clear the invalid input from the scanner
        menu(); // Restart the menu
    }
}

}
