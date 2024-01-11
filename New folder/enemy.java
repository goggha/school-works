
    abstract class enemy {
        protected int hp; // Health points of the enemy
        protected int dmg; // Damage inflicted by the enemy

        abstract String Name(); // Abstract method to get the name of the enemy

        // Constructors
        public enemy(int hp, int dmg) {
        this.hp = hp;
        this.dmg = dmg;
        }

        public enemy() {
            this(DEFAULT_HP, DEFAULT_DMG);
        }

        public int enemyspawn(int hp) {
            this.hp = hp;
            return hp;
            
        }

        // Getter methods
        public int getDmg() {
            return dmg;
            }

        public int getHp() {
            return hp;
        }
    

        // Static constants for default HP and damage
        private static final int DEFAULT_HP = 0;
        private static final int DEFAULT_DMG = 0;

        public static int getDefaultHp() {
            return DEFAULT_HP;
        }

        public static int getDefaultDmg() {
            return DEFAULT_DMG;
        }

        // Methods for attacking and taking damage
        public int attack() {
            return dmg;
        }

        public int attacked(int pdmg) {
            hp -= pdmg;
            return pdmg;
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    
    }

    class skelle extends enemy {
        private static final int DEFAULT_HP = 8;
        private static final int DEFAULT_DMG = 4;
    
        public skelle() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Skeleton Warrior";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }

    class zombie extends enemy {
        private static final int DEFAULT_HP = 32;
        private static final int DEFAULT_DMG = 4;

        public zombie() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Zombie";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }

    class Ghost extends enemy {
        private static final int DEFAULT_HP = 70;
        private static final int DEFAULT_DMG = 10;

        public Ghost() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Ghost";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }
    /* 
    class spider extends enemy {
        private static final int DEFAULT_HP = 50;
        private static final int DEFAULT_DMG = 8;

        public spider() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Spider";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }*/

    class witch extends enemy {
        private static final int DEFAULT_HP = 75;
        private static final int DEFAULT_DMG = 12;

        public witch() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Witch";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
        

    }
    class vampire extends enemy {
        private static final int DEFAULT_HP = 100;
        private static final int DEFAULT_DMG = 10;

        public vampire() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Vampire";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }


    class werewolf extends enemy {
        private static final int DEFAULT_HP = 150;
        private static final int DEFAULT_DMG = 15;

        public werewolf() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Werewolf";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }
    class troll extends enemy {
        private static final int DEFAULT_HP = 180;
        private static final int DEFAULT_DMG = 20;

        public troll() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Troll";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }


    class drake extends enemy {
        private static final int DEFAULT_HP = 200;
        private static final int DEFAULT_DMG = 25;

        public drake() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Drake";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }


    class dragon extends enemy {
        private static final int DEFAULT_HP = 500;
        private static final int DEFAULT_DMG = 30;

        public dragon() {
            super(DEFAULT_HP, DEFAULT_DMG);
        }

        public String Name() {
            return "Deathwing";
        }
        public int spawn() {
            hp = DEFAULT_HP;
            return hp;
        }
    }


