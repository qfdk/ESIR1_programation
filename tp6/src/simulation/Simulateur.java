package simulation;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import messagerie.Operateur;
import messagerie.Telephone;

public class Simulateur
{
  @SuppressWarnings("deprecation")
  public static void main(String [ ] args)
  {
    // les noms
    String [] noms = {
	"Samuel",	// +33(0)700000001
	"Sébastien",	//		 2
	"Aurélie",	//		 3
	"Léa",		//		 4
	"Pierre",	//		 5
	"Géraldine",	//		 6
	"Bastien", 	//		 7
	"Claude", 	//		 8
    };


    String [] lesForfaits = { "illimite", "1h", "acte",  };
    // SDD pour mémoriser les téléphones
    Map<String, Telephone> lesTelephones = new TreeMap<String, Telephone>();
    // générateur de nombres aléatoires
    Random generateurAleatoire = new Random();
    // souscrire quelques abonnements
    // créer un opérateur
    Operateur breizhtel = new Operateur("BreizhTel");
    for (int i = 0; i < noms.length; ++i) {
      try {
	Telephone newtel =
	  breizhtel.souscrire(noms[i],
			      lesForfaits[generateurAleatoire.nextInt(lesForfaits.length)]);
	lesTelephones.put(noms[i], newtel);
      }
      catch (Exception e) {
	System.err.println("*** Erreur : impossible d'abonner " + noms[i]);
      }
    }
    afficher("État initial", breizhtel);

    // ------------------------------------------------------------------------
    //			À COMPLÉTER
    // ------------------------------------------------------------------------
    lesTelephones.get("Samuel").allumer();
    lesTelephones.get("Samuel").appeler("+33(0)700000004", "Où c'est qu't'es ?", new Date(2012, 12, 13, 15, 45, 10));
    lesTelephones.get("Samuel").envoyerSMS("+33(0)700000004", "Léa, réponds, nom d'une pipe !", new Date(2012, 12, 13, 15, 45, 10));
    lesTelephones.get("Samuel").envoyerSMS("+33(0)700000004", "Léa, alleeez, sois pas vache !", new Date(2012, 12, 13, 15, 46, 0));
    lesTelephones.get("Samuel").envoyerSMS("+33(0)700000004", "Léa, je plaisantais !!!!!!!!!!", new Date(2012, 12, 13, 15, 46, 10));
    lesTelephones.get("Léa").allumer();
    System.out.println("\nÉtat de Léa: " + lesTelephones.get("Léa"));
    lesTelephones.get("Samuel").appeler("+33(0)700000004", "Où c'est qu't'es ?", new Date(2012, 12, 13, 15, 47, 5));
    afficher("État 1", breizhtel);

    // ------------------------------------------------------------------------
    //			FACTURATION : À FAIRE
    // ------------------------------------------------------------------------

  }

  // afficher l'état de la simulation
  static void afficher(String msg, Operateur op)
  {
    System.out.println(msg + "\n---------------------\n" + op + "---------------------\n");
  }
} // Simulateur
