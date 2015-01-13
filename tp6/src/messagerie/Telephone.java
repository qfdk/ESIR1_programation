package messagerie;
import java.io.ObjectInputStream.GetField;
import java.util.Date;

/**
 * utilisation du téléphone par l'abonné
 */

public class Telephone implements GestionCommunication
{
	@SuppressWarnings("unused")
	private boolean status;
	private AbonneOperateur abonne;
	private BoiteSMS boiteSMS;
  /**
	 * @param nomPersonne
	 * @param nomForfait
	 */
	public Telephone( )
	{
		status=false;
	}
	public boolean getStatus()
	{
		return this.status;
	}
//------------------------------------------------------------------------
  // méthodes de l'interface GestionCommunication
  //------------------------------------------------------------------------
  @Override
  public boolean appeler(String numero, String msgVocalSiOccupe, Date dateDebut)
  {
    System.out.println(numero+"-->"+dateDebut);    
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
  // méthodes propres
  //------------------------------------------------------------------------

  /**
 * 
 */
public void allumer() {
    status=true;
    }
  /**
 * 
 */
public void eteindre() {
	 status=false;
  }


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString()
{
	StringBuilder sb=new StringBuilder();
	sb.append("- -");
	return sb.toString();
}

/**
 * Pour obtenir  la valeur de abonne
 * @return la valeur de abonne
 */
public AbonneOperateur getAbonne()
{
	return abonne;
}

/**
 * Pour modifier la valeur de abonne
 * @param abonne la nouvelle valeur de abonne
 */
public void setAbonne(AbonneOperateur abonne)
{
	this.abonne = abonne;
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

} // Telephone
