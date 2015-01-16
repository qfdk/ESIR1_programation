/*______________________________*/
/**
 * 
 */
package simulation;

import java.util.ArrayList;

import messagerie.AbonneOperateur;
import messagerie.NumeroTelephone;
import messagerie.Operateur;

/**
 * @author qfdk
 * Cree le 2015年1月8日
 */
public class coucou
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		ArrayList <AbonneOperateur> listeAb= new ArrayList <AbonneOperateur> ();
        ArrayList <NumeroTelephone> listeNum=new ArrayList <NumeroTelephone> ();
        listeNum.add(new NumeroTelephone("123"));
        listeNum.add(new NumeroTelephone("345"));
        listeNum.add(new NumeroTelephone("3455"));
//        Operateur Vous= new Operateur("coucou",listeNum,listeAb);
        Operateur Vous= new Operateur("coucou");
		String[] noms =
		{ "Samuel", // +33(0)700000001
				"Sébastien", // 2
				"Aurélie", // 3
				"Léa", // 4
				"Pierre", // 5
				"Géraldine", // 6
				"Bastien", // 7
				"Claude", // 8
		};
        // add some subscribers to the list for the operator
        for (int i=0; i<3;i++){
                Vous.souscrire(noms[i], "Forfait1H");
        }// create 10 subscriber having the "A l'acte" package
        
        for(AbonneOperateur a: Vous.getListAbonnes())
        {
        	System.out.println(a);
        }
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/