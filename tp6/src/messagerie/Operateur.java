package messagerie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
	private List<NumeroTelephone> listNum;
	private Map<AbonneOperateur, List<AbstractCommunication>> historique;
	private Map<AbonneOperateur, Appel> appelsEnCours;
	private Appel tmpAppel;

	/**
	 * @param string
	 */
	public Operateur(String string)
	{
		setNom(string);
		this.abonnes = new ArrayList<AbonneOperateur>();
		new ArrayList<AbsForfait>();
		this.listNum = new ArrayList<NumeroTelephone>();
		this.historique=new HashMap<AbonneOperateur, List<AbstractCommunication>>();
		this.appelsEnCours=new HashMap<AbonneOperateur, Appel>();
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
		this.historique=new HashMap<AbonneOperateur, List<AbstractCommunication>>();
		this.appelsEnCours=new HashMap<AbonneOperateur, Appel>();
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
	 * @param nomPersonne 
	 * @param nomForfait 
	 * @return  un telephone
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

	/**
	 * get nb abonnes
	 * @return nb de client
	 */
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
	public boolean etablirCommunication(AbonneOperateur emetteur,
			String numeroDestinataire, String msgVocal, Date dateAppel)
	{
		int positon =rechercherNumero(numeroDestinataire);
		Scanner scanner=new Scanner(System.in);
		if(positon!=-1&&positon<getNbClient())
		{
			AbonneOperateur recepteur=abonnes.get(positon);
			historique.put(emetteur, new ArrayList<AbstractCommunication>());
			if(recepteur.estLibre()&&recepteur.accepterAppel(emetteur.getNumeroTel().getNum()))
			{
				tmpAppel=new Appel(emetteur, recepteur, dateAppel);
				historique.get(emetteur).add(tmpAppel);
				appelsEnCours.put(emetteur, tmpAppel);
				return true;
			}
			else {
				System.out.println("recepteur non libre, il faut envoyer SMS");
				posterMessageVocal(emetteur, numeroDestinataire, msgVocal, dateAppel);
				posterSMS(emetteur, numeroDestinataire, "Vous avez recu un MessageVocal", dateAppel);
				return false;
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
	 * @param dateEnvoi 
	 */
	public void posterSMS(AbonneOperateur emetteur, String numeroDestinataire,
			String sms, Date dateEnvoi)
	{
		int position=rechercherNumero(numeroDestinataire);
		if(position<0||position>getNbClient())
		{
			return ;
		}
		CommSMS tmp=new CommSMS(emetteur, abonnes.get(position), dateEnvoi);
		historique.get(emetteur).add(tmp);
		abonnes.get(position).getBoiteSMS().ajouterSMS(new MessageSMS(tmp,sms));
	}

	/**
	 * poster un message vocal
	 * 
	 * @param emetteur
	 * @param numeroDestinataire
	 * @param mv : message vocal
	 * @param dateEnvoi 
	 */
	public void posterMessageVocal(AbonneOperateur emetteur, String numeroDestinataire,
			String mv, Date dateEnvoi)
	{
		int position=rechercherNumero(numeroDestinataire);
		if(position<0||position>getNbClient())
		{
			return ;
		}
		CommMessageVocal tmp=new CommMessageVocal(emetteur, abonnes.get(position), dateEnvoi);
		historique.get(emetteur).add(tmp);
		abonnes.get(position).getBoiteVocale().ajouterMessageVocal(new MessageVocal(tmp,mv));
		
	}
	/**
	 * un abonné met fin à une communication
	 * 
	 * @param abonne : celui qui clôt
	 * @param fin date de fin de communication
	 */
	public void cloreAppel(AbonneOperateur abonne, Date fin)
	{
		AbstractCommunication abs=historique.get(abonne).get(historique.get(abonne).size()-1);
		if(abs instanceof Appel)
		{
			((Appel) abs).setDateCom(fin);
			appelsEnCours.remove(abonne);
		}
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
	 *  cree un forfait par rapport au nom de forfait
	 *  par defaut c'est 1h
	 * @param nom d'un forfait
	 * @return un forfait
	 * 
	 */
	public static  AbsForfait proposeUnForfait(String nom)
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
	return new Forfait1H();
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
	 * Pour obtenir la valeur de appelsEnCours
	 * 
	 * @return la valeur de appelsEnCours
	 */
	public Collection<List<AbstractCommunication>> getAppelsEnCours()
	{
		return historique.values();
	}
	
	/**
	 * test si je suis en cours ...
	 * @param moi
	 * @return est en cours de com
	 */
	public boolean estApplesEnCours(AbonneOperateur moi)
	{
		Collection<Appel> appels=appelsEnCours.values();
		for(Appel a:appels)
		{
			if(a.getEmeteur().equals(moi)||a.getRecepteur().equals(moi))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * facture pour tous abs
	 */
	public void facturation()
	{
		for (AbonneOperateur a:abonnes)
		{
			System.out.println("-----FAC de "+a.getNom()+"------");
			List<AbstractCommunication> maListe=historique.get(a);
			if(maListe!=null)
			{
				for(AbstractCommunication abs:maListe)
				{
					if(abs instanceof Appel){
						System.out.println(abs);
					}
					if(abs instanceof CommSMS){
						System.out.println(abs);
					}
					if(abs instanceof CommMessageVocal){
						System.out.println(abs);
					}
				}
				System.out.println("Total: "+a.getForfait());
			}else{
				System.out.println("-> PAS DE FACTURE");
			}
		}
	}
	
	/**
	 * facturation pour un ab
	 * @param nom nom ab
	 */
	public void facturation(AbonneOperateur nom)
	{
			for(AbstractCommunication abs:historique.get(nom))
			{
				if(abs instanceof Appel){
					System.out.println(abs);
				}
				if(abs instanceof CommSMS){
					System.out.println(abs);
				}
				if(abs instanceof CommMessageVocal){
					System.out.println(abs);
				}
			}
	}
	
	
} // Operateur
