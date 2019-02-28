/**
 * @author Camby Abell
 * @assignment assg9_Abell
 * @filename Person.java
 */

package assg9_Abell;

public class Person extends KeyedItem <FullName>
{
	private FullName name;
	private String phoneNumber;
	
	/**
	 * Constructor for a generic Person.
	 * @param name - the name given to this person
	 * @param phone - the phone number given to this person.
	 */
	public Person(FullName name, String phone)
	{
		super(name);
		phoneNumber = phone;
	}
	
	/**
	 * getName() will return the FullName of a Person.
	 * @return - the FullName of a Person.
	 */
	public FullName getName()
	{
		return this.name;
	}
	
	/**
	 * getPhoneNumber will return the phone number of a Person.
	 * @return - the phone number of a Person.
	 */
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	/**
	 * setName(first, last) will set the full name of a Person.
	 * @param first - the first name of the full name of a Person.
	 * @param last - the last name of the full name of a Person.
	 */
	public void setName(String first, String last)
	{
		this.name = new FullName(first, last);
	}
	
	/**
	 * setPhoneNumber(phone) will set the phone number of a Person.
	 * @param phone - the phone number that will be set to a Person.
	 */
	public void setPhoneNumber(String phone)
	{
		this.phoneNumber = phone;
	}
	
	/**
	 * toString() will print the contents of a Person into a clear and readable format.
	 * @return - a Person's data into a clear and readable format.
	 */
	public String toString()
	{
		return this.getKey().printName() + "\t" + this.getPhoneNumber();
	}
}
