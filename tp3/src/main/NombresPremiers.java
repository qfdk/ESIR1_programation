/*______________________________*/
/**
 * 
 */
package main;

import tableau.Block;
import types.Tableau;

/**
 * @author qfdk
 * Cree le 2014年11月17日
 */
public class NombresPremiers
{

	/**
	 * @param n
	 * @param nombresPremiers
	 * @return
	 */
	public static boolean estPremier(int n, Tableau<Integer> nombresPremiers)
	{
		for(int i=0;i<nombresPremiers.size();i++)
		{
			if(nombresPremiers.get(i)%n!=0)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * @param n
	 * @param nombresPremiers
	 * @return
	 */
	public static int calculerNombresPremiers(int n,
			Tableau<Integer> nombresPremiers)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param nb
	 * @return
	 */
	public static Tableau<Integer> remplirHasard(int nb)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param t
	 * @param nombresPremiers
	 * @return
	 */
	public static int eliminerPresents(Tableau<Integer> t,
			Tableau<Integer> nombresPremiers)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/