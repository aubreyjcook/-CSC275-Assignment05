import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Random;

public class Assignment05 {
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		new Assignment05();
	}

	// This will act as our program switchboard
	public Assignment05() throws FileNotFoundException {
		
		ArrayList<Item> cargohold = new ArrayList<Item>();
		java.io.File file = new java.io.File("data.txt");
		if(file.exists()) {loadData(file, cargohold);};
		
		System.out.println("Welcome to the BlackStar Cargo Hold interface.");
		System.out.println("Please select a number from the options below");
		System.out.println("");
		
		while (true) {
			// Give the user a list of their options
			System.out.println("1: Add an item to the cargo hold.");
			System.out.println("2: Remove an item from the cargo hold.");
			System.out.println("3: Sort the contents of the cargo hold.");
			System.out.println("4: Search for an item.");
			System.out.println("5: Display the items in the cargo hold.");
			System.out.println("6: Erase the cargo hold data manifest.");
			System.out.println("9: Output optimal value for items currently held in the cargohold at maximum weight capacity.");
			System.out.println("0: Exit the BlackStar Cargo Hold interface.");

			// Get the user input
			int userChoice = input.nextInt();
			input.nextLine();
			
			switch (userChoice) {
				case 1:
					addItem(cargohold);
					storeData(file, cargohold);
					break;
				case 2:
					removeItem(cargohold);
					eraseFile(file);
					storeData(file, cargohold);
					break;
				case 3:
					sortItems(cargohold);
					storeData(file, cargohold);
					break;
				case 4:
					searchItems(cargohold);
					break;
				case 5:
					displayItems(cargohold);
					break;
				case 6:
					cargohold.clear();
					eraseFile(file);
					break;
				case 7:
					storeData(file, cargohold);
					break;
				case 8:
					loadData(file, cargohold);
					break;
				case 9:
					ransackConstructor(file, cargohold);
					break;
				case 0:
					System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
					System.exit(0);
				default:
					System.out.println("Invalid value. Choose a number 0-5 only.");
					break;
			}
		}

	}

	private void addItem(ArrayList<Item> cargohold) {
		Item tempItem = new Item();
		System.out.println("Enter the Item's name");
		String userInput = input.next();
		tempItem.setItemName(userInput);
		System.out.println("Enter the Item's weight");
		userInput = input.next();
		while(!isNumeric(userInput)) {
			System.out.println("Invalid data, retry");
			userInput = input.next();
		}
		if ((getCargoholdWeight(cargohold) + Float.parseFloat(userInput)) > 25) {
			System.out.println("The cargohold cannot hold the additional Item's weight.");
			System.out.println("Remove an item from the cargohold to lower it's weight below 25 or add an item of lower weight.");
			return;
		};
		tempItem.setItemWeight(Float.parseFloat(userInput));
		System.out.println("Enter the Item's value");
		userInput = input.next();
		while(!isNumeric(userInput)) {
			System.out.println("Invalid data, retry");
			userInput = input.next();
		}
		tempItem.setItemValue(Float.parseFloat(userInput));
		System.out.println("Enter the Item's durability");
		userInput = input.next();
		tempItem.setItemDurability(userInput);
		
		tempItem.setItemID("0" + (cargohold.size() + 1));
		
		cargohold.add(tempItem);
		System.out.println("Item added successfully");
		return;
	}

	private void removeItem(ArrayList<Item> cargohold) {
		if(cargohold.size() == 0) {
			System.out.println("The cargohold has no items to remove!");
			return;
		} else {
			System.out.println("Enter the name of the item to be removed.");
			String userInput = input.nextLine();
			
			for(int i = 0; i < cargohold.size(); i++) {
				if(cargohold.get(i).name.equals(userInput)) {
					cargohold.remove(i);
					
					System.out.println("Item removed.");
					break;
				} else if (i == cargohold.size() - 1) {
					System.out.println("That item is not in the cargohold.");
				}
			}
			return;		
		}
	}
	
	public static <T> void sort(List<T> list, Comparator<? super T> c) {
		Object[] a = list.toArray();
		Arrays.sort(a, (Comparator)c);
		ListIterator i = list.listIterator();
		for (int j=0; j<a.length; j++) {
			i.next();
			i.set(a[j]);
		}
	}
	
	private void sortItems(ArrayList<Item> cargohold) {
		
		sort(cargohold, Item.ItemNameComparator);
		
		System.out.println("cargohold sorted.");
		return;
	}

	private void searchItems(ArrayList<Item> cargohold) {
		while(true) {
			// Give the user a list of their options
			System.out.println("1: Search: Name");      
			System.out.println("2: Search: Value");
			System.out.println("3: Partial Search: Name");
                                                                              
			// Get the user input                                             
			int userChoice = input.nextInt();                                 
			input.nextLine();                                                 
			switch(userChoice) {
				case 1:
					System.out.println("Enter the name of the item.");
					String userInput = input.nextLine();
					
					for(int i = 0; i < cargohold.size(); i++) {
						if(cargohold.get(i).name.equals(userInput)) {
							System.out.println("The item was found at section number " + (i + 1));
							break;
						} else if (i == cargohold.size() - 1) {
							System.out.println("That item is not in the cargohold.");
						}
					}
					return;
				case 2:
					System.out.println("Enter the value of the item.");
					float userInput1 = (Float.parseFloat(input.nextLine()));
					
					for(int i = 0; i < cargohold.size(); i++) {					
						if(cargohold.get(i).value == userInput1) {
							System.out.println("The item was found at section number " + (i + 1));
							break;
						} else if (i == cargohold.size() - 1) {
							System.out.println("That item is not in the cargohold.");
						}
					}
					return;
				case 3:
					System.out.println("Enter the name of the item.");
					String userInput2 = input.nextLine();
					
					for(int i = 0; i < cargohold.size(); i++) {
						if(cargohold.get(i).name.contains(userInput2)) {
							System.out.println("The item was found at section number " + (i + 1));
							break;
						} else if (i == cargohold.size() - 1) {
							System.out.println("That item is not in the cargohold.");
						}
					}
					return;
				default:
					System.out.println("Invalid value. Choose a number 1-2 only.");
					break;
			}
		}
	}

	private void displayItems(ArrayList<Item> cargohold) {
		if(cargohold.size() <= 0) {
			System.out.println("No items in the cargohold to display.");
			return;
		}
		else {
			System.out.println("--------------------------------");
			for(int i = 0; i < cargohold.size(); i++) {
					System.out.println("Item ID: "         + cargohold.get(i).ID);
					System.out.println("Item Name: "       + cargohold.get(i).name);
					System.out.println("Item Weight: "     + cargohold.get(i).weight);
					System.out.println("Item Value: "      + cargohold.get(i).value);
					System.out.println("Item Durability: " + cargohold.get(i).durability);
					System.out.println("--------------------------------");
			}
			return;
		}
	}
	
	private float getCargoholdWeight(ArrayList<Item> cargohold) {
		float cargoholdWeight = 0;
		for(int i = 0; i < cargohold.size(); i++) {
			cargoholdWeight = cargoholdWeight + cargohold.get(i).weight;
		};
		
		return cargoholdWeight;
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	public static void storeData(File file, ArrayList<Item> cargohold) {
		if(cargohold.size() <= 0) {
			return;
		}
		else {
				eraseFile(file);
				try(
					java.io.PrintWriter output = new java.io.PrintWriter(file);
				) {
					for(int i = 0; i < cargohold.size(); i++) {
						output.println(cargohold.get(i).ID);
						output.println(cargohold.get(i).name);
						output.println(cargohold.get(i).weight);
						output.println(cargohold.get(i).value);
						output.println(cargohold.get(i).durability);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			System.out.println("Data Stored.");
			return;
		}
	}
	
	public static void loadData(File file, ArrayList<Item> cargohold) throws FileNotFoundException {
		if(file.exists()) {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				Item tempItem = new Item();
				tempItem.setItemID(input.nextLine());
				tempItem.setItemName(input.nextLine());
				tempItem.setItemWeight(Float.parseFloat(input.nextLine()));
				tempItem.setItemValue(Float.parseFloat(input.nextLine()));
				tempItem.setItemDurability(input.nextLine());
				cargohold.add(tempItem);
			}
			input.close();
		} else {
			System.out.println("No file to load.");
		}
	}
	
	public static void eraseFile(File file) {
		if(file.delete())
        {return;}
        else
        {
            System.out.println("Failed to delete the file");
        }
	}

	public static void ransackConstructor(File file, ArrayList<Item> cargohold) {
		int[] val = new int[cargohold.size()];
		int[] wt = new int[cargohold.size()];;
		String[] names = new String[cargohold.size()];
				
		for (int i = 0; i < cargohold.size(); i++) {
			val[i]   = (int) cargohold.get(i).value;
			wt[i]    = (int) cargohold.get(i).weight;
			names[i] = cargohold.get(i).name;
		}
		
        int W = 25;

        System.out.println(ransack(val, wt, W, names));
	}
	
	public static int ransack(int val[], int wt[], int W, String names[]) {
		//gets the number of items
		int N = wt.length;
		
		//builds a matrix of items
		int[][] V = new int[N + 1][W + 1];
		
		//for capacity of zero
		for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
	
		//for no items in home row
		for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
		
		for (int item=1;item<=N;item++){
			//fill values in each row
			for (int weight=1;weight<=W;weight++){
				//check if current items weight less than or equal to comparison weight
				if (wt[item-1]<=weight){
					//compare current item + value of item with remaining value of current item
					V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
				} else {
					//skips item if it overrides weight requirements
					V[item][weight]=V[item-1][weight];
				}
				
				/*
				for (int[] rows : V) {
		            for (int col : rows) {

		                System.out.format("%5d", col);
		            }
		            System.out.println();
		        }
				*/
		        
			}
		}
		return V[N][W];
	}

}
