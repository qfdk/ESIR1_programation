package messagerie;
import java.util.Date;

/**
 * Informations d'Abonné gérées par l'opérateur
 */
public class AbonneOperateur implements GestionCommunication
{
	private String nom;
	private Operateur operateur;
	
	 /**
	 * 
	 */
	public AbonneOperateur(String nom,Operateur o)
	{
		setNom(nom);
		setOperateur(o);
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
    // TODO
    return true;
  }

  boolean estLibre()
  {
    // TODO
    return true;
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

} // AbonneOperateur
