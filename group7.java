import java.util.*;

public class group7{
    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        boolean loop = true;
        do{
        System.out.println("\t [Menu]");
        System.out.println("[1]: Integer");
        System.out.println("[2]: String");
        System.out.println("[3]: Exit");
        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                intHash();
                break;
                case 2:
                StringHash();
                break;
                case 3:
                System.out.println("Thank you!!");
                loop = false;
                break;
                
            default:
                break;
        } 

    }while(loop);
       
       
    }
    public static void StringHash(){
        int count = 1;

        System.out.print("Enter table size: ");
        int tableSize = sc.nextInt();

       Hashtable<String, String> table = new Hashtable<>(tableSize);
       
       System.out.print("How many key-value: ");
       int keyval = sc.nextInt();

       for(int i = 0; i < keyval; i++){
        System.out.print("Enter key "+ count +": ");
        String keys = sc.next();
        System.out.print("Enter value "+ count +": ");
        String val = sc.next();
        table.put(keys, val);
        count ++;
    }

        System.out.println("Result:");
        System.out.println("[Final Index] \t[HashKey] \t [Key] \t[Data]");
    for(String key: table.keySet()){
       
        System.out.println("\t"+key.hashCode() % tableSize  + "\t" + key.hashCode()  + "\t" + "\t" + key + "\t" + table.get(key));
    }
    table.clear();
    }
    public static void intHash(){
        int count = 1;

        System.out.print("Enter table size: ");
        int tableSize = sc.nextInt();
       Hashtable<Integer, String> table = new Hashtable<>(tableSize);
       System.out.print("How many key-value: ");
       int keyval = sc.nextInt();
       for(int i =0; i < keyval; i++){
        System.out.print("Enter key "+ count +": ");
        int keys = sc.nextInt();
        System.out.print("Enter value "+ count +": ");
        String val = sc.next();
        table.put(keys, val);
        count ++;

    }
        System.out.println("Result:");
        System.out.println("[Final Index] \t[HashKey] \t [Key] \t[Data]");
    for(Integer key: table.keySet()){
        System.out.println("\t"+key.hashCode() % tableSize  + "\t" + key.hashCode()  + "\t" + "\t" + key + "\t" + table.get(key));
    }
    table.clear();
    

    }

}
