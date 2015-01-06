package messagerie;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import forfait.AbsForfait;
import forfait.Forfait1H;
import types.*;
/**
 * Un Opérateur gère des abonnés et des communications
 */
public class Operateur
{
	private String nom;
	private Map<AbonneOperateur, Couple<String,String>> abonnes;
	private List<AbsForfait> listForfait;
  /**
	 * @param string
	 */
	public Operateur(String string)
	{
		setNom(string);
		abonnes=new HashMap<AbonneOperateur, Couple<String,String>>();
		listForfait=new ArrayList<AbsForfait>();
	}

/**
   * Une personne souscrit un abonnement et reçoit un téléphone
   */
  public Telephone souscrire(String nomPersonne,
			     String nomForfait)
  {
	  Telephone t=new Telephone(nomPersonne,nomForfait);
	  abonnes.put(new AbonneOperateur(nomPersonne, this,new Forfait1H()), new Couple<String, String>(nomPersonne, nomForfait));
    return t;
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
