package messagerie;
import java.util.Date;

import forfait.AbsForfait;

/**
 * Informations d'Abonné gérées par l'opérateur
 */
public class AbonneOperateur implements GestionCommunication
{
	private String nom;
	private Operateur operateur;
	private AbsForfait forfait;
	private Telephone telephone;
	private NumeroTelephone numeroTel;
	private BoiteSMS boiteSMS;
	private BoiteVocale boiteVocale;
	
	 /**
	 * 
	 */
	public AbonneOperateur(String nom)
	{
		setNom(nom);
	}
  //------------------------------------------------------------------------
  // méthodes de l'interface GestionCommunication
  //------------------------------------------------------------------------

  @Override
  public boolean appeler(String numero, String msgVocalSiOccupe, Date dateDebut)
  {
    // TODO
    return false;
  }
  @Override
  public void envoyerSMS(String numero, String sms, Date dateSMS)
  {
    // TODO
  }
  @Override
  public void recevoirSMS(MessageSMS message)
  {
    // TODO
  }
  @Override
  public boolean accepterAppel(String numeroAppelant)
  {
    // TODO
    return false;
  }
  @Override
  public void cloreAppel(Date fin)
  {
    // TODO
  }

  //------------------------------------------------------------------------
  // autres méthodes
  //------------------------------------------------------------------------

  // transférer sur le téléphone les SMS du serveur
  public void synchroniser()
  {
    // TODO
  }

  boolean estHorsLigne()
  {
	  return telephone.getStatus();
  }

  boolean estLibre()
  {
	  if(!estHorsLigne())
	  {
//		  if(operateur.get)
	  }
	 return false;
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
/**
 * Pour obtenir  la valeur de operateur
 * @return la valeur de operateur
 */
public Operateur getOperateur()
{
	return operateur;
}
/**
 * Pour modifier la valeur de operateur
 * @param operateur la nouvelle valeur de operateur
 */
public void setOperateur(Operateur operateur)
{
	this.operateur = operateur;
}

/**
 * Pour obtenir  la valeur de forfait
 * @return la valeur de forfait
 */
public AbsForfait getForfait()
{
	return forfait;
}

/**
 * Pour modifier la valeur de forfait
 * @param forfait la nouvelle valeur de forfait
 */
public void setForfait(AbsForfait forfait)
{
	this.forfait = forfait;
}

/**
 * Pour obtenir  la valeur de telephone
 * @return la valeur de telephone
 */
public Telephone getTelephone()
{
	return telephone;
}

/**
 * Pour modifier la valeur de telephone
 * @param telephone la nouvelle valeur de telephone
 */
public void setTelephone(Telephone telephone)
{
	this.telephone = telephone;
}

/**
 * Pour obtenir  la valeur de numeroTel
 * @return la valeur de numeroTel
 */
public NumeroTelephone getNumeroTel()
{
	return numeroTel;
}

/**
 * Pour modifier la valeur de numeroTel
 * @param numeroTel la nouvelle valeur de numeroTel
 */
public void setNumeroTel(NumeroTelephone numeroTel)
{
	this.numeroTel = numeroTel;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString()
{
	
	return getNom()+" " +getNumeroTel();
}

/**
 * Pour obtenir  la valeur de boiteSMS
 * @return la valeur de boiteSMS
 */
public BoiteSMS getBoiteSMS()
{
	return boiteSMS;
}

/**
 * Pour modifier la valeur de boiteSMS
 * @param boiteSMS la nouvelle valeur de boiteSMS
 */
public void setBoiteSMS(BoiteSMS boiteSMS)
{
	this.boiteSMS = boiteSMS;
}

/**
 * Pour obtenir  la valeur de boiteVocale
 * @return la valeur de boiteVocale
 */
public BoiteVocale getBoiteVocale()
{
	return boiteVocale;
}

/**
 * Pour modifier la valeur de boiteVocale
 * @param boiteVocale la nouvelle valeur de boiteVocale
 */
public void setBoiteVocale(BoiteVocale boiteVocale)
{
	this.boiteVocale = boiteVocale;
}
} // AbonneOperateur
