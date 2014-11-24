/*______________________________*/
/**
 * 
 */
package main;

import tableau.TableauBlock;
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
//	    Tableau<Integer> hasard = NombresPremiers.remplirHasard(10000);
//	    System.out.println(hasard);
		TableauBlock<Integer> x=new TableauBlock<Integer>(1);
		
	}
	static double power2(double x,int n)
	{
		assert n>=0:"Boof!";
		if(n==0){
			return 1;
		}
		double tmp=power2(x, n/2);
		if(n%2==0)
		{
			return tmp*tmp;
		}
		return tmp*tmp*x;
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/