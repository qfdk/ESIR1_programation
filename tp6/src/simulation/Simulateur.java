package simulation;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import messagerie.MessageSMS;
import messagerie.Operateur;
import messagerie.Telephone;

public class Simulateur
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException
	{
		// les noms
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

		String[] lesForfaits =
		{ "Forfait1H", "ForfaitAlActe", "ForfaitIllimite", };
		
		// SDD pour mémoriser les téléphones
		Map<String, Telephone> lesTelephones = new TreeMap<String, Telephone>();
		
		// générateur de nombres aléatoires
		Random generateurAleatoire = new Random();
		// souscrire quelques abonnements
		// créer un opérateur
		Operateur breizhtel = new Operateur("BreizhTel");
		
		for (int i = 0; i < noms.length; ++i)
		{
			try
			{
				Telephone newtel = breizhtel.souscrire(noms[i],
						lesForfaits[generateurAleatoire
								.nextInt(lesForfaits.length)]);			
				lesTelephones.put(noms[i], newtel);
			} catch (Exception e)
			{
				System.err.println("*** Erreur : impossible d'abonner "
						+ noms[i]);
			}
		}
		afficher("État initial", breizhtel);
		// ------------------------------------------------------------------------
		// À COMPLÉTER
		// ------------------------------------------------------------------------
		afficher("Allumer les tels", "Samuel,Bastien lea n'est pas dispo");
		lesTelephones.get("Samuel").allumer();
		lesTelephones.get("Bastien").allumer();
//		lesTelephones.get("Léa").allumer();
		
	    lesTelephones.get("Samuel").appeler(lesTelephones.get("Léa").getAbonne().getNumeroTel().getNum(), "Où c'est qu't'es ?", new Date(2012, 12, 13, 15, 45, 10));
	    lesTelephones.get("Samuel").envoyerSMS(lesTelephones.get("Léa").getAbonne().getNumeroTel().getNum(), "Léa, réponds, nom d'une pipe !", new Date(2012, 12, 13, 15, 45, 10));
	    lesTelephones.get("Samuel").envoyerSMS(lesTelephones.get("Léa").getAbonne().getNumeroTel().getNum(), "Léa, alleeez, sois pas vache !", new Date(2012, 12, 13, 15, 46, 0));
	    lesTelephones.get("Samuel").envoyerSMS(lesTelephones.get("Léa").getAbonne().getNumeroTel().getNum(), "Léa, je plaisantais !!!!!!!!!!", new Date(2012, 12, 13, 15, 46, 10));
	    afficher("test lea est dispo", "allumer tel de Lea");
	    lesTelephones.get("Léa").allumer();
	    afficher("test accpte un apple", "tapyez 'o/y' pour accpte");
	    lesTelephones.get("Samuel").appeler(lesTelephones.get("Léa").getAbonne().getNumeroTel().getNum(), "Où c'est qu't'es ?", new Date(2012, 12, 13, 15, 47, 5));
	    afficher("test appel en cours", "2s Samuel va clorer cet appel");
	   Thread.sleep(2000);
	    lesTelephones.get("Samuel").cloreAppel(new Date(2012, 12, 13, 16, 50, 5));
		// ------------------------------------------------------------------------
		// FACTURATION : À FAIRE
		// ------------------------------------------------------------------------
	    //pour un client
	    afficher("test facturation pour une personne", "Samuel");
		breizhtel.facturation(lesTelephones.get("Samuel").getAbonne());
		//pour tous les modes
		afficher("test facturation pour tous", "tous les abonnes");
		breizhtel.facturation();
		
		afficher("consulter les sms de Léa", "Syc Léa");
		lesTelephones.get("Léa").getAbonne().synchroniser();
		lesTelephones.get("Léa").getAbonne().getBoiteSMS().lireSMS();
		
	}

	// afficher l'état de la simulation
	static void afficher(String msg, Object op)
	{
		System.out.println("");
		System.out.println(msg + "\n---------"+op+"------------");
	}
	
} // Simulateur
