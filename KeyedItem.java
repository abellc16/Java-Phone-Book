/**
 * @author Camby Abell
 * @assignment assg9_Abell
 * @filename KeyedItem.java
 */

package assg9_Abell;

public abstract class KeyedItem<KT extends Comparable<? super KT>>
{
	private KT searchKey;
	
	public KeyedItem(KT Key)
	{
		searchKey = Key;
	}
	
	public KT getKey()
	{
		return searchKey;
	}
}
