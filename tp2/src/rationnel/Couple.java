/*______________________________*/
/**
 * 
 */
package rationnel;

/**
 * @author qfdk
 * Cree le 2014年11月12日
 * @param <T1> type 1
 * @param <T2> type 2
 */
public class Couple<T1,T2>
{
	private T1 first;
	private T2 second;
	
	/**
	 * Classe Couple
	 * @param t1
	 * @param t2
	 */
	public Couple(T1 t1,T2 t2)
	{
		setFirst(t1);
		setSecond(t2);
	}

	/**
	 * Pour obtenir  la valeur de first
	 * @return la valeur de first
	 */
	public T1 getFirst()
	{
		return first;
	}

	/**
	 * Pour modifier la valeur de first
	 * @param first la nouvelle valeur de first
	 */
	public void setFirst(T1 first)
	{
		this.first = first;
	}

	/**
	 * Pour obtenir  la valeur de second
	 * @return la valeur de second
	 */
	public T2 getSecond()
	{
		return second;
	}

	/**
	 * Pour modifier la valeur de second
	 * @param second la nouvelle valeur de second
	 */
	public void setSecond(T2 second)
	{
		this.second = second;
	}


}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/