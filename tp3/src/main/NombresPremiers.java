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
			if(!(nombresPremiers.get(i)%n==0))
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime(int a) {  
		  
        boolean flag = true;  
  
        if (a < 2) {// 素数不小于2  
            return false;  
        } else {  
  
            for (int i = 2; i <= Math.sqrt(a); i++) {  
  
                if (a % i == 0) {// 若能被整除，则说明不是素数，返回false  
  
                    flag = false;  
                    break;// 跳出循环  
                }  
            }  
        }  
        return flag;  
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