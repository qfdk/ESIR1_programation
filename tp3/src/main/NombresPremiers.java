/*______________________________*/
/**
 * 
 */
package main;

import java.util.Random;

import tableau.Block;
import types.Tableau;

/**
 * @author qfdk Cree le 2014年11月17日
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
<<<<<<< HEAD
		for (int i = 0; i < nombresPremiers.size(); i++)
		{
			if(n%nombresPremiers.get(i)==0)
=======
		for(int i=0; i<nombresPremiers.size();i++)
		{
			if(n % nombresPremiers.get(i)==0)
>>>>>>> FETCH_HEAD
			{
				return false;
			}
		}
		return true;
	}

<<<<<<< HEAD
	public static boolean isPrime(int a)
	{

		boolean flag = true;

		if (a < 2)
		{// 素数不小于2
			return false;
		} else
		{
			for (int i = 2; i <= Math.sqrt(a); i++)
			{
				if (a % i == 0)
				{// 若能被整除，则说明不是素数，返回false
					flag = false;
					break;// 跳出循环
				}
			}
		}
		return flag;
	}
=======
	
>>>>>>> FETCH_HEAD

	/**
	 * @param n
	 * @param nombresPremiers
	 * @return
	 */
	public static int calculerNombresPremiers(int n,
			Tableau<Integer> nombresPremiers)
	{
<<<<<<< HEAD
		assert nombresPremiers.empty():"le tableua doit etre initialement vide";
		int i;
		for(i=2;i<n;i++)
		{
			if(isPrime(i)){
				if(nombresPremiers.full())
=======
		assert nombresPremiers.empty() : "Le tableau doit etre initialement vide";

		int i;
		for(i=2;i<=n;i++)
		{
			if(isPrime(i)) 
			{
				// Si le tableau est plein on arrête et on retourne l'entier testé
				if(nombresPremiers.full()) 
>>>>>>> FETCH_HEAD
				{
					return i;
				}
				else
				{
					nombresPremiers.push_back(i);
				}
			}
		}
		return i;
	}

	public static boolean isPrime(int a) 
	{		  
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
	 * remplire le tableu ah hasard
	 * @param nb nombre d'element
	 * @return un tableu
	 */
	public static Tableau<Integer> remplirHasard(int nb)
	{
<<<<<<< HEAD
		Tableau<Integer> monTab=new Block<Integer>(nb);
		Random r=new Random();
=======
		Tableau<Integer> monTab = new Block<Integer>(nb);
		Random r = new Random();
>>>>>>> FETCH_HEAD
		for(int i=0;i<nb;i++)
		{
			monTab.push_back(r.nextInt(nb));
		}
		return monTab;
	}

	/**
	 * eliminer present
	 * @param t
	 * @param nombresPremiers
	 * @return nombre supprimer
	 */
	public static int eliminerPresents(Tableau<Integer> t,
			Tableau<Integer> nombresPremiers)
	{
		int cpt=0;
		for (int i = 0; i < t.size(); i++)
		{
			if(estPremier(t.get(i), nombresPremiers))
			{
				t.set(i, null);
				cpt++;
			}
		}
		return cpt;
	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */