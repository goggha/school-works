import java.util.*;  //importing java utils

	//Hard code sequence so wala ta iban nga Class outside of main

public class linkedlist{

	public static void main (String [] args){

		Scanner sc = new Scanner(System.in); //Renaming Scanncer to "sc"

		LinkedList<String> linkedlist = new LinkedList<>(); //Renaming LinkedList to "linklist"

		boolean loop = true; //Initiating boolean for loop

		do{ //do loop starts here

		System.out.println("\nUpdated linked list : " + linkedlist); //printing the value of linkedlist

		System.out.print("\nSellect an operation \n[1]Add \n[2]Modify \n[3]Remove \n[4]Search \n[5]Iterate \n[6]Exit \n:");
		//Letting the user to choose between operation

		int op = sc.nextInt(); //Initiating integer for the operation that the user selected

		switch (op){ // Swicth case starts here for what ever the user selected

			case 1: //if the user choose 1

				System.out.print("No of element: "); //asking the user of how many element he/she wants

				int noE = sc.nextInt(); //this is where the input of the user got saved

				for(int i = 1; i <= noE; i++ ){ //for loop starts here
				//for is for the input of the user to loop until it the value that the user inputed

					System.out.print("Value of element " + i + " : ");
					// asking the user on the value he will put on the linked list depends on the number of elems he/she wants
						String input = sc.next(); // this is where it will be temporaryly saved

						linkedlist.add( input ); // this is where the input will be saved

					}//for loop ends here

				System.out.println("Linked List" +  linkedlist); // Showing the user linklist inputs
			break; //stoping case 1

			case 2:// case 2 starts here

				System.out.println("\n[2]Modify");

				System.out.print("Input Index parameter: "); //asking for an input

				int par = sc.nextInt(); // the input will be saved here.

				System.out.print("Element Value: "); // asking for the subsitute for the input it want to Modify
				String Elval = sc.next();
				linkedlist.set(par, Elval);
				System.out.println("Updated linked list : " + linkedlist);
			break;
			case 3:

					System.out.println("\n[3]Remove ");
					System.out.print("Input Index paramiter : ");
					int Rpar = sc.nextInt();

					String RLlst = linkedlist.remove(Rpar);



					System.out.println("You removed " + RLlst + " From the list");


			break;
			case 4:

						System.out.println("\n[4]Search ");
					System.out.print("Enter an index to search: ");
					int IidxTSch = sc.nextInt();
					linkedlist.get(IidxTSch);
					String SLl = linkedlist.get(IidxTSch);
					System.out.println("Element: " + SLl);

			break;
			case 5:

					System.out.println("\n[5] Iterate");
					System.out.println("Updated linked list : " + linkedlist);
					System.out.println("Elements in the link list: ");

					Iterator<String> iterate = linkedlist.iterator();

					while (iterate.hasNext()){
						System.out.println("Element: " + iterate.next());
					}
			break;
			case 6:

					System.out.println("\n[6]Exit");
					System.out.print("Thank you for using me----------");
					loop = false;


				}

		}while (loop == true);








		}

	}
