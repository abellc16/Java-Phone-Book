/**
 * @author Camby Abell
 * @assignment assg9_Abell
 * @filename Menu.java
 */

package assg9_Abell;

import java.util.*;
import java.io.*;

public class Menu 
{
	public static void main(String[] args)
	{
		// Create a new PhoneBook
		PhoneBook pBook = new PhoneBook();
		
		// Declare other variables
		int userNum = 0;
		Scanner kbd = new Scanner(System.in);
		
		// Read in the data and store it into a PhoneBook.
		try {
			Scanner f = new Scanner(new File("phoneBook.txt"));
			
			while(f.hasNext())
			{
				String first = f.next();
				String last  = f.next();
				String num   = f.next();
				
				FullName fName = new FullName(first, last);
				pBook.add(fName, num);
			}
			
			f.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}

		// Print the original tree
		System.out.println("Original Tree:");
		pBook.printTree();
		
		//System.out.println("====================");
		System.out.println("======MAIN MENU=====");
		//System.out.println("====================");
		
		System.out.println("Choose from the following 1-5:");
		System.out.println("1: Add");
		System.out.println("2: Delete");
		System.out.println("3: Find");
		System.out.println("4: Change");
		System.out.println("5: Quit");
		
		// Loop through the main menu choices and carry them out until
		// the user wishes to quit the program.
		while(userNum != 5)
		{
			String first;
			String last;
			String num;
			
			userNum = kbd.nextInt();
			kbd.nextLine();
			
			switch(userNum)
			{
				// Add	
				case 1:
					System.out.println("Add...");
					System.out.println("Enter first name: ");
					first = kbd.next();
					System.out.println("Enter last name: ");
					last = kbd.next();
					System.out.println("Enter phone number: ");
					num = kbd.next();
					
					FullName fName = new FullName(first, last);
					pBook.add(fName, num);
					
					System.out.println("Adding entry...");
					break;
				
				// Delete
				case 2:
					System.out.println("Delete...");
					System.out.println("Enter the first name of the person you would like to delete:");
					first = kbd.next();
					System.out.println("Enter the last name of the person you would like to delete:");
					last = kbd.next();
					fName = new FullName(first, last);
					pBook.delete(fName);
					
					System.out.println("Deleting entry...");
					
					break;
				
				// Find
				case 3:
					System.out.println("Find...");
					System.out.println("Enter the first name of the person you would like to find:");
					first = kbd.next();
					System.out.println("Enter the last name of the person you would like to find:");
					last = kbd.next();
					fName = new FullName(first, last);
					System.out.println("Phone number: \n" + pBook.find(fName));
					
					break;
				
				// Change
				case 4:
					System.out.println("Change...");
					System.out.println("Enter the first name of the person you would like to change:");
					first = kbd.next();
					System.out.println("Enter the last name of the person you would like to change:");
					last = kbd.next();
					fName = new FullName(first, last);
					System.out.println("Enter the phone number you would like to change it to:");
					num = kbd.next();
					pBook.change(fName, num);
				
					System.out.println("Changin entry...");
					
					break;
				
				// Quit
				case 5:
					System.out.println("Exiting...");
					System.out.println("Thanks for using!");

					// Print Final Tree
					System.out.println("\nFinal Tree:");
					pBook.printTree();
					
					try {
						pBook.quit();
					}
					catch (IOException e) {
						System.out.println(e);
					}
					
					kbd.close();
					System.exit(0);
					
					break;
			}
			
			// Show user the menu again.
			System.out.println("Choose from the following 1-5:");
			System.out.println("1: Add");
			System.out.println("2: Delete");
			System.out.println("3: Find");
			System.out.println("4: Change");
			System.out.println("5: Quit");
		}

		
	}

}
