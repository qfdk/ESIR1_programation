/*______________________________*/
/**
 * 
 */
package tp1.src;

import java.util.Scanner;

/**
 * @author qfdk
 * Cree le 2014年10月6日
 */
public class TP1
{
	/*
	 * initialiser un tableau avec les valeurs d’une suite de nombres entiers lus au clavier
	 * la suite est terminée par −1
	 * */
	static int lireTableau(int [ ] tnb, Scanner entree){
		int i=0;
		int tmp;
		while(i<tnb.length)
		{
			tmp=entree.nextInt();
			if(tmp!=-1){
				tnb[i]=tmp;
				i++;
			}else{
				return i;
			}
		}
		return i;
	}
	
	/**
	* afficher les nb premiers éléments d’un tableau.
	* @param tnb : tableau ( initialisé )
	* @param nb : nombre d ’ éléments du tableau
	* @pre 0 <= nb <= tnb.length
	* @post le tableau n ’ est pas modifié 
	* */
	static void afficherTableau(int [ ] tnb, int nb)
	{
		int i=0;
		if(nb>tnb.length)
		{
			return;
		}
		while(i<nb)
		{
			System.out.println(tnb[i]);
			i++;
		}
	}
	
	
	
	
	
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/