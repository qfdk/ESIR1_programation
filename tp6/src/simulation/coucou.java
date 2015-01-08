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
        
        Operateur Vous= new Operateur("coucou",listeNum,listeAb);
       
        // add some subscribers to the list for the operator
        for (int i=0; i<10;i=i+1){
                Vous.souscrire("Sébastien", "Forfait1H");
        }// create 10 subscriber having the "A l'acte" package
        
        for(AbonneOperateur a: Vous.getA())
        {
        	System.out.println(a);
        }
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/