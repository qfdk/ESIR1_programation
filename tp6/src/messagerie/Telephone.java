package messagerie;
import java.util.Date;

/**
 * utilisation du téléphone par l'abonné
 */

public class Telephone implements GestionCommunication
{
	private boolean estEteind;
	private AbonneOperateur abonne;
	private BoiteSMS boiteSMS;
  /**
	 * @param nomPersonne
	 * @param nomForfait
	 */
	public Telephone( )
	{
		setEteind(true);
		boiteSMS=new BoiteSMS();
	}
	
//------------------------------------------------------------------------
  // méthodes de l'interface GestionCommunication
  //------------------------------------------------------------------------
  @Override
  public boolean appeler(String numero, String msgVocalSiOccupe, Date dateDebut)
  {
	 return abonne.appeler(numero, msgVocalSiOccupe, dateDebut);
  }
  @Override
  public void envoyerSMS(String numero, String sms, Date dateSMS)
  {
     abonne.envoyerSMS(numero, sms, dateSMS);
  }
  @Override
  public void recevoirSMS(MessageSMS message)
  {
	  abonne.recevoirSMS(message);
  }
  @Override
  public boolean accepterAppel(String numeroAppelant)
  {
	  return accepterAppel(numeroAppelant);
  }
  @Override
  public void cloreAppel(Date fin)
  {
	  abonne.cloreAppel(fin);
  }

  //------------------------------------------------------------------------
  // méthodes propres
  //------------------------------------------------------------------------

/**
 * 
 */
public void allumer() {
    setEteind(false);
    abonne.setStatTel(true);
    abonne.synchroniser();
    System.out.println(abonne.getNom()+" ("+abonne.getNumeroTel()+")-->allumer");
    }
  /**
 * 
 */
public void eteindre() {
	 setEteind(true);
	 abonne.setStatTel(false); 
	 System.out.println(abonne.getNom()+": Tel-->eteindre");
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




/**
 * Pour obtenir  la valeur de estEteind
 * @return la valeur de estEteind
 */
public boolean isEteind()
{
	return estEteind;
}




/**
 * Pour modifier la valeur de estEteind
 * @param estEteind la nouvelle valeur de estEteind
 */
public void setEteind(boolean estEteind)
{
	this.estEteind = estEteind;
}

} // Telephone
