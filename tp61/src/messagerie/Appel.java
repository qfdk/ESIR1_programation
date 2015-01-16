/*______________________________*/
/**
 * 
 */
package messagerie;

import javax.xml.crypto.Data;

/**
 * @author qfdk
 * Cree le 2015年1月8日
 */
public class Appel extends AbstractCommunication
{
	/**
	 * @param dateD
	 */
	
	public Appel(Data dateD)
	{
		super(dateD);
	}

	private AbonneOperateur emeteur,recepteur;
	private Data finComm;
	

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
	 * Pour obtenir  la valeur de dateCom
	 * @return la valeur de dateCom
	 */
	public Data getDateCom()
	{
		return finComm;
	}

	/**
	 * Pour modifier la valeur de dateCom
	 * @param dateCom la nouvelle valeur de dateCom
	 */
	public void setDateCom(Data dateCom)
	{
		this.finComm = dateCom;
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/