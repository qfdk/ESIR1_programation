/*______________________________*/
/**
 * 
 */
package main;

import types.Tableau;

/**
 * @author qfdk
 * Cree le 2014年11月19日
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
//		for(int i=0;i<100;i++)
//		{
//			System.out.println(i+"----"+NombresPremiers.isPrime(i)+"\n");
//		}
	    Tableau<Integer> hasard = NombresPremiers.remplirHasard(10000);
	    System.out.println(hasard);
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/