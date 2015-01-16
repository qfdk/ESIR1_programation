/*______________________________*/
/**
 * 
 */
package messagerie;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author qfdk
 * Cree le 2015年1月8日
 */
public class Appel extends AbstractCommunication
{	
	/**
	 * @param emetteur
	 * @param recepteur
	 * @param dateD
	 */
	public Appel(AbonneOperateur emetteur, AbonneOperateur recepteur,
			Date dateD) {
		super(emetteur, recepteur, dateD);
		setDateFinComm(dateD);
		setEmeteur(emetteur);
		setRecepteur(recepteur);
	}


	private AbonneOperateur emeteur,recepteur;
	private Date finComm;
	

	/**
	 * Pour obtenir  la valeur de emeteur
	 * @return la valeur de emeteur
	 */
	public AbonneOperateur getEmeteur()
	{
		return emeteur;
	}

	/**
	 * Pour modifier la valeur de emeteur
	 * @param emeteur la nouvelle valeur de emeteur
	 */
	public void setEmeteur(AbonneOperateur emeteur)
	{
		this.emeteur = emeteur;
	}

	/**
	 * Pour obtenir  la valeur de recepteur
	 * @return la valeur de recepteur
	 */
	public AbonneOperateur getRecepteur()
	{
		return recepteur;
	}

	/**
	 * Pour modifier la valeur de recepteur
	 * @param recepteur la nouvelle valeur de recepteur
	 */
	public void setRecepteur(AbonneOperateur recepteur)
	{
		this.recepteur = recepteur;
	}


	/**
	 * Pour modifier la valeur de dateCom
	 * @param dateFinComm la nouvelle valeur de dateCom
	 */
	public void setDateFinComm(Date dateFinComm)
	{
		this.finComm = dateFinComm;
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int getDuree()
	{
		return finComm.getSeconds()-debutComm.getSeconds();
	}
	/* (non-Javadoc)
	 * @see messagerie.AbstractCommunication#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(appele.getNum()).append("--")
		.append("APL").append("--(")
		.append(DateFormat.getDateTimeInstance().format(debutComm)).append(")--(")
		.append(DateFormat.getDateTimeInstance().format(finComm)).append(")");
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/