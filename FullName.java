/**
 * @author Camby Abell
 * @assignment assg9_Abell
 * @filename FullName.java
 */

package assg9_Abell;

public class FullName implements java.lang.Comparable<Object>
{
	private String firstName;
	private String lastName;
	
	/**
	 * Creates a full name of a Person.
	 * @param first - first name of the full name.
	 * @param last - last name of the full name.
	 */
	public FullName(String first, String last)
	{
		firstName = first;
		lastName = last;
	}
	
	/**
	 * compareTo() determines which name will come first lexicographically.
	 */
	public int compareTo(Object P)
	{
		FullName other = (FullName) P;
		
		if(lastName.compareTo(((FullName) other).lastName) == 0)
		{
			return firstName.compareTo(((FullName) other).firstName);
		}
		else
		{
			return lastName.compareTo(((FullName) other).lastName);
		}
	}
	
	/**
	 * printName() will print the first and last name in a FullName object.
	 * @return - a string consisting of a first name and a last name.
	 */
	public String printName()
	{
		return this.firstName + " " + this.lastName;
	}
}
