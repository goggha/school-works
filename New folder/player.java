public class player extends command {
    private int playerLevel = 1;
    private int exp = 0;
    private int StatPoints = 0;
    private int baseExpRequired = 10;

    private String name = "";
    private int defense = 1;
    private int strength = 1;

    private int MaxHP = 10;
    private int CurrentHP = 10;
    private int damage = 2;
    public int Block;

    
    public void setStatPoints(int UsedstatPoints) {
        StatPoints = StatPoints - UsedstatPoints;
    }

    public int getBaseExpRequired() {
        return baseExpRequired;
    }

    public int getStatPoints() {
        return StatPoints;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int defense) {
        MaxHP = defense * 10;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        CurrentHP = hp;
    }

    public int getHp() {
        return CurrentHP;
    }

    public int getDef() {
        return defense;
    }

    public void setDef(int defense) {
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
        setDamage(strength);
    }

    public void setDamage(int damage) {
        this.damage = damage * 2;
    }

    public int getDamage() {
        return damage;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void levelUp() {
        if (exp >= baseExpRequired) {
            System.out.println("You've leveled up!");
            StatPoints += 3;
            playerLevel++;
            exp -= baseExpRequired;
            baseExpRequired = playerLevel * 10;
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("Not enough experience");
            System.out.println("---------------------------------------------------");
        }
    }

    public int attack() {
        return damage;
    }

    public int attacked(int EnemyDamage) {
        CurrentHP -= EnemyDamage;
        return CurrentHP;
    }
    public int blockAttack( int EnemyDamage) {
        double blockPercentage = 0.8; // 85% block
        double blockedDamage = (EnemyDamage * blockPercentage);
        double Blround = (blockedDamage);
        Block = (int) Math.round(EnemyDamage - Blround);
            
            CurrentHP = CurrentHP - Block; 
            
            return CurrentHP;
    }

    public int critAttack() {
        int critPercentage = 150; // 150% critical attack
        return (int) (damage * (critPercentage / 100.0)); // Calculate critical damage
    }

    public void resetPlayerStats() {
        setStrength(1);
        setDef(1);
        setMaxHP(getDef());
        setHp(MaxHP);
        setExp(0);
        baseExpRequired = 10;
        StatPoints = 0;
    }
    public void playerheal(){
        setHp(MaxHP);
    }
}
