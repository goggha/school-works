
public class encounter extends command {

 protected boolean UsedShield; 
 //skelleton combat

 public void fightSkeleton() {
    CurrentEnemyIsDead = false;
        this.IsSkellDead = false;
        
		 displayIntroSkell();
    // Introduction to the fight
    // Main fight loop
    while (!CurrentEnemyIsDead && !GameOver) {
        UsedShield = false;
        displayPlayerStats();
        displaySkellStats();

        // Player's action
        String Paction = getPlayerActionFoSkell();

        // Handle player's action
        handlePlayerActionSkell(Paction);

        // Check if the skeleton is defeated
        if (skelle.hp <= 0) {
            ZKC++;
            CurrentEnemyIsDead = true;
            defeatSkeleton();
            isPlayerDead();

        } else {
            // Enemy attacks
            SkeletonAttacks();
            isPlayerDead();    
        }
    } 
}

     public void fightZombie() {
            CurrentEnemyIsDead = false;
           this.IsZombieDead = false;
			displayIntroZombie();

        while (!CurrentEnemyIsDead && !GameOver) {

        displayPlayerStats();
        displayZombieStats();
        // Handle player's action
        String answer = getPlayerActionFoZombie();

        handlePlayerActionZombie(answer);
        if (zombie.hp <= 0) {
            CurrentEnemyIsDead = true;
            defeatZombie();
            isPlayerDead();
        } else {
            // Enemy attacks
            ZombieAttacks();
            isPlayerDead();
           }
        }
    }

    public void fightGhost() {
        CurrentEnemyIsDead = false;
       this.IsGhostDead = false;
        displayIntroGhost();
    
    while (!CurrentEnemyIsDead && !GameOver) {
    
    displayPlayerStats();
    displayGhostStats();
    // Handle player's action
    String answer = getPlayerActionFoGhost();
    
    handlePlayerActionGhost(answer);
    if (Ghost.hp <= 0) {
        CurrentEnemyIsDead = true;
        defeatGhost();
        isPlayerDead();
    
    } else {
        // Enemy attacks
       GhostAttacks();
      
        isPlayerDead();
       }
    }
    }

    // Display player's stats
private void displayPlayerStats() {
    System.out.println("------------------------------------------------------------------------------------------");
    slowPrint("[Knight]: " + player.getname() + "  [HP]: " + player.getHp() + "/" + player.getMaxHP() +
            " [Damage]: " + player.getDamage() + " [EXP]: " + player.getExp() + "/" + player.getBaseExpRequired());
}

// Check if the player is dead

// Check if the player's action is valid
private boolean isValidAction(String VAanswer) {
    return VAanswer.equalsIgnoreCase("A") || VAanswer.equalsIgnoreCase("B") || VAanswer.equalsIgnoreCase("C");
}

//all bellow if player encounter skelleton
// Display skeleton's stats
// Display introductory messages for incountering skelleton
private void displayIntroSkell() {
    System.out.println("------------------------------------------------------------------------------------------");
    skelle.spawn();
     slowPrint("As you traveling in the corridor you can hear \nthe skeletons rattle as they patrol the corridors, their bone-clad forms wielding ancient rusted weapons");
    slowPrint("You and that skeleton Crossed path, you Unsheath you sword and ready your shield");
     System.out.println("What do you do next?");
}

private void displaySkellStats() {
    slowPrint(skelle.Name() + " [HP]:" + skelle.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for incountering skelleton
private String getPlayerActionFoSkell() {
    String answer;
    input.nextLine();
    do {
        slowPrint("A) Use your sword to break its bones" );
        slowPrint("B) Use your shield to knock it down");
        slowPrint("C) Use your bow and arrow to pierce its skull");
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for incountering skelleton
private void handlePlayerActionSkell(String HSanswer) {
    if (HSanswer.equalsIgnoreCase("B")) {
        shieldAttackforSkell();
      
    } else {
        swordOrBowAttackforSkell(HSanswer);
    }
}

// Player attacks using shield for incountering skelleton
private void shieldAttackforSkell() {
    slowPrint("You slam your shield into the skeleton, and you've dealt a critical attack of " + player.critAttack());
    skelle.attacked(player.critAttack());
      UsedShield = true;
}

// Player attacks using sword or bow for incountering skelleton
private void swordOrBowAttackforSkell(String answer) {
    slowPrint("You hit the skeleton! and you've dealt " + player.attack());
    skelle.attacked(player.attack());
}

// Skeleton defeated
private void defeatSkeleton() {
    delayPrint("It falls and shattered", 500);
    slowPrint("You've gained 10 exp");
    player.setExp(player.getExp()+10);
}

// Skeleton attacks the player
private void SkeletonAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
     player.blockAttack(skelle.attack());
    delayPrint(skelle.Name() + " Dealt " + skelle.attack() + " damage but blocked \nthe dammage to the user is "+ player.Block , 500);
       

    }else{
    delayPrint(skelle.Name() + " Dealt " + skelle.attack() + " damage to " + player.getname(), 500);
    player.attacked(skelle.attack());
    }
}



//skell


// Display introductory messages for incountering Zombie
private void displayIntroZombie() {
            zombie.spawn();
        System.out.println("------------------------------------------------------------------------------------------");

        slowPrint("You noticed a old coffin as you move closer \nyou encountered a zombie that moans and bites that move's very clumsily ");
        slowPrint("You Unsheath your sword and ready your shield");
            System.out.println("What do you do next?");

}

//Display ZombieStats
private void displayZombieStats() {
    System.out.println(zombie.Name() + " [HP]:" + zombie.getHp() + "/32");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for incountering zombie
private String getPlayerActionFoZombie() {
    String answer;
    do {
        delayPrint("A) Use your sword to chop its head off", 1000);
        delayPrint("B) Use your shield to push it away", 700);
        delayPrint("C) Use your torch to set it on fire", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for incountering Zombie
private void handlePlayerActionZombie(String answer) {

    if (answer.equalsIgnoreCase("A")) {
        CritAttackForZombie();
    } else if (answer.equalsIgnoreCase("C")){
        TorchAttacktoZombie(answer);
    }else if (answer.equalsIgnoreCase("B")){
    pushedshieldZom(answer);
    }
}

// scenario
//CritAttack to zombie
private void CritAttackForZombie() {
    System.out.println("You use your sword to chop the zombie, and you've dealth a critical attack of "+ player.critAttack());
            zombie.attacked(player.critAttack());
    }
//normal attack of zombie
private void ZombieAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
                System.out.println(zombie.Name()+ "Dealt " + zombie.attack() + " damage to " +  player.getname());
                player.attacked(zombie.attack());
}
// Player attacks using torch on zombie
private void TorchAttacktoZombie(String answer) {
    slowPrint("You set the zombie on fire its burning , You dealth " + player.attack()+ " Dammage");
    zombie.attacked(player.attack());
}
//Player push
private void pushedshieldZom(String answer) {
    slowPrint("You pushed the zombie but you dealt nothing to it, \nInstead it scratch you and dealth 1 dammge");
    player.attacked(1);
}

private void defeatZombie() {
    System.out.println("------------------------------------------------------------------------------------------");
    delayPrint("It stop moving, You defeated the zombie.", 500);
    slowPrint("You've gained 20 exp");
    player.setExp(player.getExp()+20);
    
}

//Ghost

private void displayIntroGhost() {
    System.out.println("------------------------------------------------------------------------------------------");
    Ghost.spawn();
     slowPrint("You enter a room, A Ghostly apparitions manifest in spectral forms");
    slowPrint("You've Encounter a ghost");
    slowPrint("You poured the holy water in you Inventory to your sword and shield ");
 
     System.out.println("What do you do next?");
}

private void displayGhostStats() {
    System.out.println(Ghost.Name() + " [HP]:" + Ghost.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}


private String getPlayerActionFoGhost() {
    String answer;
    do {
        delayPrint("A) Use your sword to cut its form", 1000);
        delayPrint("B) Use your shield to block its attack", 700);
        delayPrint("C) Use your torch to shoo it away", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}


private void handlePlayerActionGhost(String answer) {
    if (answer.equalsIgnoreCase("B")) {
        UsedShield = true;
        GhostAttacks();
    }else if(answer.equalsIgnoreCase("A")) {
        
            slowPrint("You dealth "+ player.critAttack()+ " Holy Dammage to the ghost");
        Ghost.attacked(player.critAttack());
        
    }
}




private void defeatGhost() {
    delayPrint("The Ghost turned iinto ashes as he left in the world", 500);
    slowPrint("You've gained 50 exp");
    player.setExp(player.getExp()+50);
}


private void GhostAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
    delayPrint(Ghost.Name() + " dealt " + Ghost.attack() + " damage but blocked \nthe damage to the user is " + player.Block , 500);
    player.blockAttack(Ghost.attack());
    }else{
    delayPrint(Ghost.Name() + " dealt " + Ghost.attack() + " damage to " + player.getname(), 500);
    player.attacked(Ghost.attack());
    }
}
private void displayIntroWitch() {
    System.out.println("------------------------------------------------------------------------------------------");
    witch.spawn();
     slowPrint("As you travel through the enclave, the atmosphere is charged with an otherworldly aura. Wisps of dark magic dance in the air, and the sound of cackling laughter or distant howls sends a shiver down the spine.");
    slowPrint("You encounter a witch that casts spells");
     System.out.println("What do you do next?");
}

private void displayWitchStats() {
    System.out.println(witch.Name() + " [HP]:" + witch.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}


private String getPlayerActionFoWitch() {
    String answer;
    do {
        delayPrint("A) Use your sword to cut her head off", 1000);
        delayPrint("B) Use your shield to reflect her spells", 700);
        delayPrint("C) Use your bow and arrow to shoot her heart", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}


private void handlePlayerActionWitch(String answer) {
    if (answer.equalsIgnoreCase("B")) {
        shieldAttackforWitch();
      
    } else {
        swordOrBowAttackforWitch(answer);
    }
}


private void shieldAttackforWitch() {
    slowPrint("You use your shield to bounce back her spells and they hit her instead, and you've dealt a critical attack of " + player.critAttack());
    witch.attacked(player.critAttack());
      UsedShield = true;
}


private void swordOrBowAttackforWitch(String answer) {
    slowPrint("You hit the witch! and you've dealt " + player.attack());
    witch.attacked(player.attack());
}


private void defeatWitch() {
    delayPrint("The witch turned into a frog", 500);
    slowPrint("You've gained 40 exp");
    player.setExp(player.getExp()+40);
}

private void WitchAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
    delayPrint(witch.Name() + " dealt " + witch.attack() + " damage but blocked \nthe damage to the user is "+ player.Block, 500);
    player.blockAttack(witch.attack());
    }else{
    delayPrint(witch.Name() + " dealt " + witch.attack() + " damage to " + player.getname(), 500);
    player.attacked(witch.attack());
    }
}




public void fightWitch() {
    CurrentEnemyIsDead = false;
   this.IsWitchDead = false;
    displayIntroWitch();

while (!CurrentEnemyIsDead && !GameOver) {

displayPlayerStats();
displayWitchStats();

String answer = getPlayerActionFoWitch();

handlePlayerActionWitch(answer);
if (witch.hp <= 0) {
    CurrentEnemyIsDead = true;
    defeatWitch();
    isPlayerDead();

} else {
   
   WitchAttacks();
    isPlayerDead();
   }
}
}

//The Shadowy Enclave

//WEREWOLF

//all bellow if player encounter werewolf
// Display werewolf's stats
// Display introductory messages for encountering werewolf
private void displayIntroWerewolf() {
    System.out.println("------------------------------------------------------------------------------------------");
    werewolf.spawn();
     slowPrint("As you continue to travel the enclave, there's a loud howling");
    slowPrint("You encounter a werewolf that howls and claws");
     System.out.println("What do you do next?");
}

private void displayWerewolfStats() {
    System.out.println(werewolf.Name() + " [HP]:" + werewolf.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for encountering werewolf
private String getPlayerActionFoWerewolf() {
    String answer;
    do {
        delayPrint("A) Use your sword to slash its fur", 1000);
        delayPrint("B) Use your shield to bash its head", 700);
        delayPrint("C) Use your bow and arrow to shoot its eye", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for encountering werewolf
private void handlePlayerActionWerewolf(String answer) {
    if (answer.equalsIgnoreCase("B")) {
        shieldAttackforWerewolf();
      
    } else {
        swordOrBowAttackforWerewolf(answer);
    }
}

// Player attacks using shield for encountering werewolf
private void shieldAttackforWerewolf() {
    slowPrint("You use your shield to bash its head, and you've dealt a critical attack of " + player.critAttack());
    werewolf.attacked(player.critAttack());
      UsedShield = true;
}

// Player attacks using sword or bow for encountering werewolf
private void swordOrBowAttackforWerewolf(String answer) {
    slowPrint("You hit the werewolf! and you've dealt " + player.attack());
    werewolf.attacked(player.attack());
}

// werewolf defeated
private void defeatWerewolf() {
    delayPrint("You used your shield to smash the werewolf's skull and it falls to the ground, dead", 500);
    slowPrint("You've gained 150 exp");
    player.setExp(player.getExp()+150);
}

// werewolf attacks the player
private void WerewolfAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
       
    delayPrint(werewolf.Name() + " dealt " + werewolf.attack() + " damage but blocked \nthe damage to the user is "+ player.Block, 500);
    player.blockAttack(werewolf.attack());
    }else{
    delayPrint(werewolf.Name() + " dealt " + werewolf.attack() + " damage to " + player.getname(), 500);
    player.attacked(werewolf.attack());
    }
}


// FOR FIGHTING WEREWOLF    

public void fightWerewolf() {
    CurrentEnemyIsDead = false;
   this.IsWerewolfDead = false;
    displayIntroWerewolf();

while (!CurrentEnemyIsDead && !GameOver) {

displayPlayerStats();
displayWerewolfStats();
// Handle player's action
String answer = getPlayerActionFoWerewolf();

handlePlayerActionWerewolf(answer);
if (werewolf.hp <= 0) {
    CurrentEnemyIsDead = true;
    defeatWerewolf();
    isPlayerDead();

} else {
    // Enemy attacks
    WerewolfAttacks();
    isPlayerDead();
   }
}
}



//The Shadowy Enclave

//VAMPIRE

//all bellow if player encounter vampire
// Display vampire's stats
// Display introductory messages for encountering vampire
private void displayIntroVampire() {
    System.out.println("------------------------------------------------------------------------------------------");
    vampire.spawn();
     slowPrint("As you continue to travel the enclave, you can hear an echoing laugh");
    slowPrint("You encounter a vampire that sucks blood");
     System.out.println("What do you do next?");
}

private void displayVampireStats() {
    System.out.println(vampire.Name() + " [HP]:" + vampire.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for encountering vampire
private String getPlayerActionFoVampire() {
    String answer;
    do {
        delayPrint("A) Use your sword to stab its heart", 1000);
        delayPrint("B) Use your shield to block its fangs", 700);
        delayPrint("C) Use your torch to set the vampire ablaze", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for encountering vampire
private void handlePlayerActionVampire(String answer) {
    if (answer.equalsIgnoreCase("B")) {
        shieldAttackforVampire();
      
    } else {
        swordOrBowAttackforVampire(answer);
    }
}

// Player attacks using shield for encountering Vampire
private void shieldAttackforVampire() {
    slowPrint("You use your torch to set the vampire ablaze, and you've dealt a critical attack of " + player.critAttack());
    vampire.attacked(player.critAttack());
      UsedShield = true;
}

// Player attacks using sword or bow for encountering vampire
private void swordOrBowAttackforVampire(String answer) {
    slowPrint("You hit the vampire! and you've dealt " + player.attack());
    vampire.attacked(player.attack());
}

// Vampire defeated
private void defeatVampire() {
    delayPrint("You watch as the vampire turns into ashes. You are victorious", 500);
    slowPrint("You've gained 120 exp");
    player.setExp(player.getExp()+120);
}

// Vampire attacks the player
private void VampireAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
       
    delayPrint(vampire.Name() + " dealt " + vampire.attack() + " damage but blocked \nthe damage to the user is "+ player.Block, 500);
    player.blockAttack(vampire.attack());
    }else{
    delayPrint(vampire.Name() + " dealt " + vampire.attack() + " damage to " + player.getname(), 500);
    player.attacked(vampire.attack());
    }
}


// FOR FIGHTING VAMPIRE

public void fightVampire() {
    CurrentEnemyIsDead = false;
   this.IsVampireDead = false;
    displayIntroVampire();

while (!CurrentEnemyIsDead && !GameOver) {

displayPlayerStats();
displayVampireStats();
// Handle player's action
String answer = getPlayerActionFoVampire();

handlePlayerActionVampire(answer);
if (vampire.hp <= 0) {
    CurrentEnemyIsDead = true;
    defeatVampire();
    isPlayerDead();

} else {
    // Enemy attacks
    VampireAttacks();
    isPlayerDead();
   }
}
}

//The Treacherous Mountain Pass

//dragon

//all bellow if player encounter dragon
// Display dragon's stats
// Display introductory messages for incountering dragon
private void displayIntroDragon() {
    System.out.println("------------------------------------------------------------------------------------------");
    dragon.spawn();
     slowPrint("As you ascent the mountain, the air gets thin and biting, the winds howl through the craggy cliffs, and ominous rumblings resonate from the mountain depths.");
    slowPrint("You encounter the gigantic dragon.");
     System.out.println("What do you do next?");
}

private void displayDragonStats() {
    System.out.println(dragon.Name() + " [HP]:" + dragon.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for incountering dragon
private String getPlayerActionFoDragon() {
    String answer;
    do {
        delayPrint("A) Shoot its throat with an arrow", 1000);
        delayPrint("B) Charge and slash its feet", 700);
        delayPrint("C) Shoot its eye with an arrow", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for incountering skelleton
private void handlePlayerActionDragon(String answer) {
    if (answer.equalsIgnoreCase("C")) {
        shieldAttackforDragon();
      
    } else {
        swordOrBowAttackforDragon(answer);
    }
}

// Player attacks using shield for incountering skelleton
private void shieldAttackforDragon() {
    slowPrint("You accurately hit its eye, and you've dealt a critical attack of " + player.critAttack());
    dragon.attacked(player.critAttack());
      UsedShield = true;
}

// Player attacks using sword or bow for incountering skelleton
private void swordOrBowAttackforDragon(String answer) {
    slowPrint("You hit the dragon! and you've dealt " + player.attack());
    dragon.attacked(player.attack());
}

// Skeleton defeated
private void defeatDragon() {
    delayPrint("You stand amid the silent lair. The once-majestic creature, now still and scarred, marks the end of its reign. The world breathes freedom in the aftermath of your triumph.", 500);
    slowPrint("You've gained 180 exp");
    player.setExp(player.getExp()+180);
}

// Skeleton attacks the player
private void DragonAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
        int blockdmg = player.blockAttack(dragon.attack());
    delayPrint(dragon.Name() + " dealt " + dragon.attack() + " damage but blocked \nthe damage to the user is "+ blockdmg, 500);
    player.blockAttack(dragon.attack());
    }else{
    delayPrint(dragon.Name() + " dealt " + dragon.attack() + " damage to " + player.getname(), 500);
    player.attacked(dragon.attack());
    }
}


// FOR FIGHTING DRAGON

public void fightDragon() {
    CurrentEnemyIsDead = false;
   this.IsDragonDead = false;
    displayIntroDragon();

while (!CurrentEnemyIsDead && !GameOver) {

displayPlayerStats();
displayDragonStats();
// Handle player's action
String answer = getPlayerActionFoDragon();

handlePlayerActionDragon(answer);
if (dragon.hp <= 0) {
    CurrentEnemyIsDead = true;
    defeatDragon();
    isPlayerDead();

} else {
    // Enemy attacks
   DragonAttacks();
    isPlayerDead();
   }
}
}


//The Treacherous Mountain Pass

//drake

//all bellow if player encounter drake
// Display drake's stats
// Display introductory messages for incountering drake
private void displayIntroDrake() {
    System.out.println("------------------------------------------------------------------------------------------");
    drake.spawn();
     slowPrint("As you ascent the mountain, the air gets thin and biting, the winds howl through the craggy cliffs, and ominous rumblings resonate from the mountain depths.");
    slowPrint("You encounter a drake that breathes fire.");
     System.out.println("What do you do next?");
}

private void displayDrakeStats() {
    System.out.println(drake.Name() + " [HP]:" + drake.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for incountering drake
private String getPlayerActionFoDrake() {
    String answer;
    do {
        delayPrint("A) Shoot its throat with an arrow", 1000);
        delayPrint("B) Use your shield to deflect its fire", 700);
        delayPrint("C) Shoot its eye with an arrow", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for incountering skelleton
private void handlePlayerActionDrake(String answer) {
    if (answer.equalsIgnoreCase("C")) {
        shieldAttackforDrake();
      
    } else {
        swordOrBowAttackforDrake(answer);
    }
}

// Player attacks using shield for incountering skelleton
private void shieldAttackforDrake() {
    slowPrint("You accurately hit its eye, and you've dealt a critical attack of " + player.critAttack());
    drake.attacked(player.critAttack());
      UsedShield = true;
}

// Player attacks using sword or bow for incountering skelleton
private void swordOrBowAttackforDrake(String answer) {
    slowPrint("You hit the drake! and you've dealt " + player.attack());
    drake.attacked(player.attack());
}

// Skeleton defeated
private void defeatDrake() {
    delayPrint("Your arrow pierces through its eye. Deafening roars of agony is heard as it drops to the ground.", 500);
    slowPrint("You've gained 180 exp");
    player.setExp(player.getExp()+180);
}

// Skeleton attacks the player
private void DrakeAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
        int blockdmg = player.blockAttack(drake.attack());
    delayPrint(drake.Name() + " dealt " + drake.attack() + " damage but blocked \nthe damage to the user is "+ blockdmg, 500);
    player.blockAttack(drake.attack());
    }else{
    delayPrint(drake.Name() + " dealt " + drake.attack() + " damage to " + player.getname(), 500);
    player.attacked(drake.attack());
    }
}


// FOR FIGHTING DRAKE

public void fightDrake() {
    CurrentEnemyIsDead = false;
   this.IsDrakeDead = false;
    displayIntroDrake();

while (!CurrentEnemyIsDead && !GameOver) {

displayPlayerStats();
displayDrakeStats();
// Handle player's action
String answer = getPlayerActionFoDrake();

handlePlayerActionDrake(answer);
if (drake.hp <= 0) {
    CurrentEnemyIsDead = true;
    defeatDrake();
    isPlayerDead();

} else {
    // Enemy attacks
   DrakeAttacks();
    isPlayerDead();
   }
}
}

//The Treacherous Mountain Pass

//troll

//all bellow if player encounter troll
// Display troll's stats
// Display introductory messages for incountering troll
private void displayIntroTroll() {
    System.out.println("------------------------------------------------------------------------------------------");
    troll.spawn();
     slowPrint("As you ascent the mountain, Towering, snow-capped peaks dominate the landscape, casting daunting shadows over treacherous paths and rocky terrain.");
    slowPrint("You encounter a troll that swings a club.");
     System.out.println("What do you do next?");
}

private void displayTrollStats() {
    System.out.println(troll.Name() + " [HP]:" + troll.getHp() + "/8");
    System.out.println("------------------------------------------------------------------------------------------");
}

// Get player's action for incountering troll
private String getPlayerActionFotroll() {
    String answer;
    do {
        delayPrint("A) Use your sword to slash his arms", 1000);
        delayPrint("B) Parry the club swing and strike back", 700);
        delayPrint("C) Charge him with your shield", 700);
        System.out.println("------------------------------------------------------------------------------------------");
        answer = input.nextLine();
    } while (!isValidAction(answer));
    return answer;
}

// Handle player's action for incountering skelleton
private void handlePlayerActionTroll(String answer) {
    if (answer.equalsIgnoreCase("B")) {
        shieldAttackforTroll();
      
    } else {
        swordOrBowAttackforTroll(answer);
    }
}

// Player attacks using shield for incountering skelleton
private void shieldAttackforTroll() {
    slowPrint("You parried his club and swiftly striked back, and you've dealt a critical attack of " + player.critAttack());
    troll.attacked(player.critAttack());
      UsedShield = true;
}

// Player attacks using sword or bow for incountering skelleton
private void swordOrBowAttackforTroll(String answer) {
    slowPrint("You hit the troll! and you've dealt " + player.attack());
    troll.attacked(player.attack());
}

// Skeleton defeated
private void defeatTroll() {
    delayPrint("You've struck the troll with a killing blow, ending its life", 500);
    slowPrint("You've gained 180 exp");
    player.setExp(player.getExp()+180);
}

// Skeleton attacks the player
private void TrollAttacks() {
    System.out.println("------------------------------------------------------------------------------------------");
    if(UsedShield){
        int blockdmg = player.blockAttack(troll.attack());
    delayPrint(troll.Name() + " dealt " + troll.attack() + " damage but blocked \nthe damage to the user is "+ blockdmg, 500);
    player.blockAttack(troll.attack());
    }else{
    delayPrint(troll.Name() + " dealt " + troll.attack() + " damage to " + player.getname(), 500);
    player.attacked(troll.attack());
    }
}


// FOR FIGHTING TROLL

public void fightTroll() {
    CurrentEnemyIsDead = false;
   this.IsTrollDead = false;
    displayIntroTroll();

while (!CurrentEnemyIsDead && !GameOver) {

displayPlayerStats();
displayTrollStats();
// Handle player's action
String answer = getPlayerActionFotroll();

handlePlayerActionTroll(answer);
if (troll.hp <= 0) {
    CurrentEnemyIsDead = true;
    defeatTroll();
    isPlayerDead();

} else {
    // Enemy attacks
   TrollAttacks();
    isPlayerDead();
   }
}
}


}