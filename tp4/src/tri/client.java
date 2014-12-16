/*______________________________*/
/**
 * 
 */
package tri;

import java.util.Scanner;

import outilsTris.OutilsTris;

/**
 * @author qfdk
 * Cree le 2014年12月9日
 */
public class client
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		testTriRapide();
		testTriTas();
	}
	
	/**
	 *  test tri tas
	 */
	public static void testTriTas()
	{
		System.out.println("Donnez un nom de fichier:");
		System.out.println(System.getProperty("user.dir"));
		Scanner s=new Scanner(System.in);
		String nomFichier=s.nextLine();
		int []tab=OutilsTris.lireTableau(nomFichier);
		int []tabOld=OutilsTris.lireTableau(nomFichier);
		TriTas.trier(tab, tab.length);
		System.out.println("Verifer:"+verifier(tab, tabOld));
		System.out.println("---Fin de trie--- un nom pour enrgistrer le resultat :");
		OutilsTris.enregistrerTableau(tab, tab.length,s.nextLine());
		System.out.println(OutilsTris.getInstantPresent());
		s.close();
	}

	/**
	 * test pour trier rapide
	 */
	public static void testTriRapide()
	{
		System.out.println("Donnez un nom de fichier:");
		System.out.println(System.getProperty("user.dir"));
		Scanner s=new Scanner(System.in);
		String nomFichier=s.nextLine();
		int[]tab=OutilsTris.lireTableau(nomFichier);
		TriRapide.trier(tab, tab.length);
		int[]tabold=OutilsTris.lireTableau(nomFichier);
		System.out.println("Verifer:"+verifier(tab, tabold));
		System.out.println("---Fin de trie--- un nom pour enrgistrer le resultat :");
		OutilsTris.enregistrerTableau(tab, tab.length,s.nextLine());
		System.out.println(OutilsTris.getInstantPresent());
		s.close();
	}
	
	/**
	 * verifier deux table
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean verifier(int []a,int []b)
	{
		int taille=a.length;
		for(int i=0;i<taille;i++)
		{
			if(a[i]!=b[i]){
				return false;
			}
		}
		return true;
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/