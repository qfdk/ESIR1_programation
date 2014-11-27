/*______________________________*/
/**
 * 
 */
package main;

import java.util.Scanner;

import tableau.Tableau2x;
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
		
		Scanner entree = new Scanner(System.in);
		int N =100;
		
		System.out.print("Veuillez donner un nombre :");
		N = entree.nextInt();
		
		Tableau<Integer> tab = new Tableau2x<>(1);
		tab = nombres(N);
		
		for(int i=0;i<tab.size();i++)
		{
			System.out.println(tab.get(i));
		}

		
	}
	
	static Tableau<Integer> nombres(int N)
	{
		System.out.println("*** Nombre premier entre 2 et "+N);
		Tableau<Integer> result = new Tableau2x<>(1);
		result.push_back(2);

		for(int i=3;i<N;i=i+2)
		{
			if(NombresPremiers.isPrime(i))
			{
				result.push_back(i);
				
			}
		}
		return result;	
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/