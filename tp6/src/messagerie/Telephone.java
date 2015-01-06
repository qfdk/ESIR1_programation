package messagerie;
import java.io.ObjectInputStream.GetField;
import java.util.Date;

/**
 * utilisation du téléphone par l'abonné
 */

public class Telephone implements GestionCommunication
{
	private String nomPersonne;
	private String nomForfait;
	private boolean status=false;
  /**
	 * @param nomPersonne
	 * @param nomForfait
	 */
	public Telephone(String nomPersonne, String nomForfait)
	{
		setNomForfait(nomForfait);
		setNomPersonne(nomPersonne);
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
  // méthodes propres
  //------------------------------------------------------------------------

  public void allumer() {
    status=true;
    }
  public void eteindre() {
	 status=false;
  }
/**
 * Pour obtenir  la valeur de nomPersonne
 * @return la valeur de nomPersonne
 */
public String getNomPersonne()
{
	return nomPersonne;
}
/**
 * Pour modifier la valeur de nomPersonne
 * @param nomPersonne la nouvelle valeur de nomPersonne
 */
public void setNomPersonne(String nomPersonne)
{
	this.nomPersonne = nomPersonne;
}
/**
 * Pour obtenir  la valeur de nomForfait
 * @return la valeur de nomForfait
 */
public String getNomForfait()
{
	return nomForfait;
}
/**
 * Pour modifier la valeur de nomForfait
 * @param nomForfait la nouvelle valeur de nomForfait
 */
public void setNomForfait(String nomForfait)
{
	this.nomForfait = nomForfait;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString()
{
	StringBuilder sb=new StringBuilder();
	sb.append(getNomPersonne()).append(" utilise le forfait ").append(getNomForfait());
	return sb.toString();
}
} // Telephone
