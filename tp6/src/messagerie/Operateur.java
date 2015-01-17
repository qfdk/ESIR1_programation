package messagerie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		if(positon!=-1&&positon<getNbClient())
		{
			AbonneOperateur recepteur=abonnes.get(positon);
			if(recepteur.estLibre()&&recepteur.accepterAppel(emetteur.getNumeroTel().getNum()))
			{
				System.out.println("Apple en cours ....");
				tmpAppel=new Appel(emetteur, recepteur, dateAppel);
				ajouterHisto(emetteur, tmpAppel);
				appelsEnCours.put(emetteur, tmpAppel);
				appelsEnCours.put(recepteur, tmpAppel);
				return true;
			}
			else {
				System.out.println("recepteur non libre, il faut envoyer SMS");
				System.out.println("Patientez environ, 3 S ....");
				posterMessageVocal(emetteur, numeroDestinataire, msgVocal, dateAppel);
				posterSMS(emetteur, numeroDestinataire, "Vous avez recu un MessageVocal", dateAppel);
				return false;
			}
		}
		return false;
	}
	
	private void ajouterHisto(AbonneOperateur client,AbstractCommunication comm)
	{
		if(historique.containsKey(client))
		{
			historique.get(client).add(comm);
		}else{
			historique.put(client, new ArrayList<AbstractCommunication>());
			historique.get(client).add(comm);
		}
	
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
//		historique.get(emetteur).add(tmp);
		ajouterHisto(emetteur, tmp);
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
		ajouterHisto(emetteur, tmp);
//		historique.get(emetteur).add(tmp);
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
		Appel appel=appelsEnCours.get(abonne);
		if(!abonne.estLibre())
		if(appel.getEmeteur().equals(abonne))
		{
			appelsEnCours.remove(abonne);
			appelsEnCours.remove(appel.getRecepteur().getTelephone().getAbonne());
			appel.setDateFinComm(fin);
			historique.get(abonne).remove(nbHisto(abonne)-1);
			historique.get(abonne).add(appel);
		}else
		{
			appelsEnCours.remove(abonne);
			appelsEnCours.remove(appel.getEmeteur().getTelephone().getAbonne());
		}
		
		System.out.println(abonne.getNom()+ " clore cet appel.");
	}

	/**
	 * @param abonne
	 * @return
	 */
	private int nbHisto(AbonneOperateur abonne)
	{
		return historique.get(abonne).size();
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
	return new ForfaitIllimite();
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
		sb.append(getNom());
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
		return appelsEnCours.containsKey(moi);
	}

	/**
	 * facture pour tous abs
	 */
	public void facturation()
	{
		for (AbonneOperateur a:abonnes)
		{
			facturation(a);
//			System.out.println("-----FAC de "+a.getNom()+"("+a.getForfait()+")------");
//			List<AbstractCommunication> maListe=historique.get(a);
//			if(maListe!=null)
//			{
//				for(AbstractCommunication abs:maListe)
//				{
//					if(abs instanceof Appel){
//						System.out.println(abs);
//					}
//					if(abs instanceof CommSMS){
//						System.out.println(abs);
//					}
//					if(abs instanceof CommMessageVocal){
//						System.out.println(abs);
//					}
//				}
//				System.out.println("Total: "+calculerPrix(a)+" EURO");
//				System.out.println("**********************************");
//			}else{
//				System.out.println("->Pas de communication histo");
//				System.out.println("Total: "+calculerPrix(a)+" EURO");
//				System.out.println("**********************************");
//			}
		}
	}
	
	@SuppressWarnings("static-method")
	private float getPrixForfait1H(List<AbstractCommunication> histo)
	{
		float minAppel=0;
		int nbSMS=0;
		int nbMV=0;
		if(histo!=null)
		{
			for(AbstractCommunication abs:histo)
			{
				if(abs instanceof Appel){
					float tmp=(float) (((Appel) abs).getDuree());
					minAppel=minAppel+tmp;
				}
				if(abs instanceof CommSMS){
					nbSMS++;
				}
				if(abs instanceof CommMessageVocal){
					nbMV++;
				}
			}
			
		}
		if(minAppel/60-Forfait1H.F1H>0)
		{
			System.out.println("Appel Hors Forfait :"+(minAppel/60-Forfait1H.F1H)+" minutes");
			return Forfait1H.PRIX_BASE
					+Forfait1H.PRIX_MV*nbMV
					+Forfait1H.PRIX_SMS*nbSMS
					+((minAppel/60)-Forfait1H.F1H)*Forfait1H.PRIX_APPEL;
		}	
		return Forfait1H.PRIX_BASE
				+Forfait1H.PRIX_MV*nbMV
				+Forfait1H.PRIX_SMS*nbSMS;
	}
	
	@SuppressWarnings("static-method")
	private float getPrixForfaitAlActe(List<AbstractCommunication> histo)
	{
		float minAppel=0;
		int nbSMS=0;
		int nbMV=0;
		if(histo!=null)
		{
			for(AbstractCommunication abs:histo)
			{
				if(abs instanceof Appel){
					float tmp=(float) (((Appel) abs).getDuree());
					minAppel=minAppel+tmp;
				}
				if(abs instanceof CommSMS){
					nbSMS++;
				}
				if(abs instanceof CommMessageVocal){
					nbMV++;
				}
			}
		}
		return (minAppel/60)*ForfaitAlActe.PRIX_APPEL+nbMV*ForfaitAlActe.PRIX_MV+nbSMS*ForfaitAlActe.PRIX_SMS;
	}
	private float calculerPrix(AbonneOperateur client)
	{
		switch (client.getForfait().getNom())
		{
		case "Forfait1H":
			return getPrixForfait1H(historique.get(client));
		case "ForfaitAlActe":
			return getPrixForfaitAlActe(historique.get(client));
		case "ForfaitIllimite":
			return ForfaitIllimite.PRIX_BASE;
		}
		return ForfaitIllimite.PRIX_BASE;
	}
	
	/**
	 * facturation pour un ab
	 * @param client nom ab
	 */
	public void facturation(AbonneOperateur client)
	{
		System.out.println("-----FAC de "+client.getNom()+"("+client.getForfait()+")------");
		if(historique.get(client)!=null)
			for(AbstractCommunication abs:historique.get(client))
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
		System.out.println("* Total: "+String.format("%.2f",calculerPrix(client))+" EURO");
		System.out.println("");
	}

	/**
	 * @param client client qui utilise forfait 1h
	 * @return la dure total de forfait 1h
	 */
	public float getDureeTotal(AbonneOperateur client)
	{
		float minAppel=0;
		List<AbstractCommunication> histo=historique.get(client);
		if(histo!=null)
		{
			for(AbstractCommunication abs:histo)
			{
				if(abs instanceof Appel){
					float tmp=(float) (((Appel) abs).getDuree());
					minAppel=minAppel+tmp;
				}
			}
		}
		return minAppel/60;
	}

	
	
} // Operateur
