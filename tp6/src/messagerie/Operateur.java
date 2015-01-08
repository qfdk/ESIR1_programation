package messagerie;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import forfait.AbsForfait;
import forfait.Forfait1H;
import forfait.ForfaitAlActe;
import forfait.ForfaitIllimite;
import types.*;
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
		abonnes= new ArrayList<AbonneOperateur>();
		listForfait=new ArrayList<AbsForfait>();
		listNum=new ArrayList<NumeroTelephone>();
		
		historique=new ArrayList<AbstractCommunication>();
		appelsEnCours=new ArrayList<Appel>();
	}
	
	/**
	 * @param nom
	 * @param listNum
	 * @param listClient
	 * @param listforfait
	 */
	public Operateur(String nom,List<NumeroTelephone>listNum,List<AbonneOperateur>listClient){
		setNom(nom);
		this.listNum=listNum;
		this.abonnes=listClient;
//		this.listForfait=listforfait;
		historique=new ArrayList<AbstractCommunication>();
		appelsEnCours=new ArrayList<Appel>();
	}
	public List<AbonneOperateur> getA()
	{
		return abonnes;
	}
/**
   * Une personne souscrit un abonnement et reçoit un téléphone
   */
  public Telephone souscrire(String nomPersonne,
			     String nomForfait)
  {
	  AbonneOperateur client = new AbonneOperateur(nomPersonne);
	  client.setForfait(proposeUnForfait(nomForfait));
	  client.setOperateur(this);
	  
	  Telephone telephone=new Telephone();
	  telephone.setAbonne(client);
	  
	  client.setTelephone(telephone);
	  abonnes.add(client);
	  
    return telephone;
  }

  /**
   * Établir une communication
   * @param emetteur
   * @param numeroDestinataire
   * @param msgVocal : message en cas d'indisponibilité
   * @param dateAppel
   * @return vrai si la communication a été établie
   */
  public boolean
  etablirCommunication(AbonneOperateur emetteur, 
		       String numeroDestinataire,
		       String msgVocal,
		       Date dateAppel)
  {
    // TODO
    return false;
  }

  /**
   * poster un SMS
   * @param emetteur
   * @param numeroDestinataire
   * @param sms : le texte du SMS
   * @pamra dateEnvoi
   */
  public void
    posterSMS(AbonneOperateur emetteur,
	      String numeroDestinataire,
	      String sms,
	      Date dateEnvoi)
  {
    // TODO
  }

  /**
   * un abonné met fin à une communication
   * @param abonne : celui qui clôt
   * @param date de fin de communication
   */
  public void cloreAppel(AbonneOperateur abonne, Date fin)
  {
    // TODO
  }

  /**
 * @param nom du forfait
 * @return un forfait
 */
@SuppressWarnings("static-method")
public  AbsForfait proposeUnForfait(String nom)
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
 * Pour obtenir  la valeur de nom
 * @return la valeur de nom
 */
public String getNom()
{
	return nom;
}

/**
 * Pour modifier la valeur de nom
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
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString()
{
	StringBuilder sb=new StringBuilder();
	sb.append(getNom()).append("->");
	return sb.toString();
}
} // Operateur
