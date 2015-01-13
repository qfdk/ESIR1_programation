package messagerie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import forfait.AbsForfait;
import forfait.Forfait1H;
import forfait.ForfaitAlActe;
import forfait.ForfaitIllimite;

/**
 * Un Opérateur gère des abonnés et des communications
 */
public class Operateur
{
	private String nom;
	private List<AbonneOperateur> abonnes;
	private List<AbsForfait> listForfait;
	private List<NumeroTelephone> listNum;
	private List<AbstractCommunication> historique;
	private List<Appel> appelsEnCours;

	/**
	 * @param string
	 */
	public Operateur(String string)
	{
		setNom(string);
		abonnes = new ArrayList<AbonneOperateur>();
		listForfait = new ArrayList<AbsForfait>();
		listNum = new ArrayList<NumeroTelephone>();

		setHistorique(new ArrayList<AbstractCommunication>());
		setAppelsEnCours(new ArrayList<Appel>());
		fabriqueNum(100);
	}

	/**
	 * @param nom
	 * @param listNum
	 * @param listClient
	 * @param listforfait
	 */
	public Operateur(String nom, List<NumeroTelephone> listNum,
			List<AbonneOperateur> listClient)
	{
		setNom(nom);
		this.listNum = listNum;
		this.abonnes = listClient;
		setHistorique(new ArrayList<AbstractCommunication>());
		setAppelsEnCours(new ArrayList<Appel>());
	}

	/**
	 * obtenir liste abonnes
	 * 
	 * @return
	 */
	@SuppressWarnings("javadoc")
	public List<AbonneOperateur> getListAbonnes()
	{
		return abonnes;
	}

	/**
	 * Une personne souscrit un abonnement et reçoit un téléphone
	 */
	public Telephone souscrire(String nomPersonne, String nomForfait)
	{
		AbonneOperateur client = new AbonneOperateur(nomPersonne);
		Telephone telephone = new Telephone();
		NumeroTelephone numeroTel = listNum.get(getNbClient());

		client.setForfait(proposeUnForfait(nomForfait));
		client.setOperateur(this);
		client.setTelephone(telephone);

		client.setNumeroTel(numeroTel);

		numeroTel.setAbonne(client);

		telephone.setAbonne(client);

		abonnes.add(client);

		return telephone;
	}

	public int getNbClient()
	{
		return abonnes.size();
	}

	/**
	 * Établir une communication
	 * 
	 * @param emetteur
	 * @param numeroDestinataire
	 * @param msgVocal : message en cas d'indisponibilité
	 * @param dateAppel
	 * @return vrai si la communication a été établie
	 */
	@SuppressWarnings("static-method")
	public boolean etablirCommunication(AbonneOperateur emetteur,
			String numeroDestinataire, String msgVocal, Date dateAppel)
	{
		int positon =rechercherNumero(numeroDestinataire);
		if(positon!=-1&&positon<getNbClient())
		{
			AbonneOperateur recepteur=abonnes.get(positon);
			if(recepteur.estLibre())
			{
				recepteur.accepterAppel(emetteur.getNumeroTel().getNum());
				System.out.println("appler");
			}
			else {
				
			}
		}
		return false;
	}
	private int rechercherNumero(String num)
	{
		int position=0;
		NumeroTelephone numeroTelephone=new NumeroTelephone(num);
		for(NumeroTelephone n:listNum)
		{
			if(numeroTelephone.getNum().equals(n.getNum()))
			{
				return position;
			}
			position++;
		}
		return -1;
	}
	

	/**
	 * poster un SMS
	 * 
	 * @param emetteur
	 * @param numeroDestinataire
	 * @param sms : le texte du SMS
	 * @pamra dateEnvoi
	 */
	public void posterSMS(AbonneOperateur emetteur, String numeroDestinataire,
			String sms, Date dateEnvoi)
	{
		// TODO
	}

	/**
	 * un abonné met fin à une communication
	 * 
	 * @param abonne : celui qui clôt
	 * @param date de fin de communication
	 */
	public void cloreAppel(AbonneOperateur abonne, Date fin)
	{
		// TODO
	}

	/**
	 * @param nb
	 */
	public void fabriqueNum(int nb)
	{
		Random r = new Random();
		for (int i = 0; i < nb; i++)
		{
			int s = 1000000 + (int) (r.nextFloat() * 899900);
			listNum.add(new NumeroTelephone("0706" + String.valueOf(s)));
		}
	}

	/**
	 * @param nom du forfait
	 * @return un forfait
	 */
	@SuppressWarnings("static-method")
	public AbsForfait proposeUnForfait(String nom)
	{
		switch (nom)
		{
		case "Forfait1H":
			return new Forfait1H();
		case "ForfaitAlActe":
			return new ForfaitAlActe();
		case "ForfaitIllimite":
			return new ForfaitIllimite();
		}
		return null;
	}

	/**
	 * Pour obtenir la valeur de nom
	 * 
	 * @return la valeur de nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Pour modifier la valeur de nom
	 * 
	 * @param nom la nouvelle valeur de nom
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void ajouterUnForfait(String nom)
	{
		listForfait.add(new Forfait1H());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(getNom()).append("->");
		return sb.toString();
	}

	/**
	 * Pour obtenir la valeur de historique
	 * 
	 * @return la valeur de historique
	 */
	public List<AbstractCommunication> getHistorique()
	{
		return historique;
	}

	/**
	 * Pour modifier la valeur de historique
	 * 
	 * @param historique la nouvelle valeur de historique
	 */
	public void setHistorique(List<AbstractCommunication> historique)
	{
		this.historique = historique;
	}

	/**
	 * Pour obtenir la valeur de appelsEnCours
	 * 
	 * @return la valeur de appelsEnCours
	 */
	public List<Appel> getAppelsEnCours()
	{
		return appelsEnCours;
	}

	/**
	 * Pour modifier la valeur de appelsEnCours
	 * 
	 * @param appelsEnCours la nouvelle valeur de appelsEnCours
	 */
	public void setAppelsEnCours(List<Appel> appelsEnCours)
	{
		this.appelsEnCours = appelsEnCours;
	}
} // Operateur
