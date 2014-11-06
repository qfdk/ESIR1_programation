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
public class Test
{
	public static final int NB=10;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int []tab=new int[NB];
		System.out.println("==input tab==");
		int nb=TP1.lireTableau(tab, new Scanner(System.in));
		System.out.println("==output tab==");
		TP1.afficherTableau(tab, nb);
		System.out.println("==tri==");
		TriDicho.triInsertion(tab, nb);
		System.out.println("----------------");
		TP1.afficherTableau(tab, nb);
		System.out.println("====exo3====");
		int []tab2=new int[NB];
		int []tab3=new int[NB*2];
		System.out.println("==input tab2==");
		int nb2=TP1.lireTableau(tab2, new Scanner(System.in));
		tab3=TriDicho.fusionner(tab, nb, tab2, nb2);
		System.out.println("==output tab3=tab+tab2==");
		TP1.afficherTableau(tab3, nb+nb2);
		System.out.println("==-----==");
		for (int i=0;i<tab.length;i++)
		{
			System.out.println(TriDicho.rechercheDichotomique(tab[i], tab3, nb+nb2));
		}
		
//		 TestUnitaireTriInsertion f=new TestUnitaireTriInsertion() ;
//		 f.tableau_vide();
//		 f.tableau_un_element();
//		 f.tableau_quelconque();
//		 f.tableau_ordre_inverse();
//		 f.tableau_hasard();
//		 f.tableau_deux_elements();
//		 f.tableau_deja_trie();
//		 System.out.println("------------------");
//		 TestUnitaireFusion tuf=new TestUnitaireFusion();
//		 tuf.testFusion_t1t2_vides();
//		 tuf.testFusion_t1_vide();
//		 tuf.testFusion_t2_vide();
//		 tuf.testFusion_normal();
//		 tuf.testFusion_bizarre();
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/