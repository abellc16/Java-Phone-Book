/**
 * @author Camby Abell
 * @assignment assg9_Abell
 * @filename PhoneBook.java
 */

package assg9_Abell;

import java.io.*;

public class PhoneBook 
{
	BinarySearchTree<Person, FullName> BST;
	
	/**
	 * Default constructor for a new PhoneBook
	 */
	public PhoneBook()
	{
		BST = new BinarySearchTree<Person, FullName>();
	}
	
	/**
	 * add(name, phoneNum) will add a new node to a tree.
	 * @param name - the name that will be assigned to the new node.
	 * @param phoneNum - the phone number that will be assigned to the new node.
	 */
	public void add(FullName name, String phoneNum)
	{
		Person P = new Person(name, phoneNum);
		BST.insert(P);
	}
	
	/**
	 * delete(name) will delete a given Person's name and phone number from the phone book,
	 * given only the name.
	 * @param name - the name of the Person to be deleted.
	 */
	public void delete(FullName name)
	{
		Person P = BST.retrieve(name);
		
		if(P == null)
		{
			System.out.println("Name does not exist.");
		}
		else
		{
			BST.delete(P);
		}
	}
	
	/**
	 * find(name) will locate a Person's phone number, given only the Person's name.
	 * @param name - the name that will be searched.
	 * @return - The phone number of the found name
	 * @return - a message stating that the name being searched for does not exist.
	 */
	public String find(FullName name)
	{
		Person P = BST.retrieve(name);
		
		if(P == null)
		{
			return "Name does not exist.\n";
		}
		else
		{
			return P.getPhoneNumber();
		}
	}
	
	/**
	 * change(name, num) will change a Person's phone number, given the Person's name and
	 * new phone number.
	 * @param name - the Person to be changed's name.
	 * @param num - the new phone number of the Person.
	 */
	public void change(FullName name, String num)
	{
		Person P = BST.retrieve(name);
		
		if(P == null)
		{
			System.out.println("Name does not exist.");
		}
		else
		{
			P.setPhoneNumber(num);
		}
	}
	
	/**
	 * quit() will quit the application, after writing the phone book to a text file.
	 * @throws IOException
	 */
	public void quit() throws IOException
	{
		Writer wr = new FileWriter(new File("phoneBook.txt"));
		
		if(!BST.isEmpty())
		{
			TreeIterator<Person> iter = new TreeIterator<Person>(BST);
			iter.setInorder();
			
			while(iter.hasNext())
			{
				wr.write(iter.next().toString() + "\n");
				wr.flush();
			}
		}
		else
		{
			wr.close();
			throw new IOException();
		}
		wr.close();
	}
	
	/**
	 * printTree() will print the contents of a tree in a clear, readable format.
	 */
	public void printTree()
	{
		if (!BST.isEmpty())
		{
			TreeIterator<Person> iter = new TreeIterator<Person>(BST);
			iter.setInorder();
			
			while(iter.hasNext())
			{
				System.out.println(iter.next().toString());
			}
		}
	}
}
