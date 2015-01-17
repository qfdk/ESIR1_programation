/*______________________________*/
/**
 * 
 */
package messagerie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qfdk
 * Cree le 2015年1月13日
 */
public class BoiteVocale
{
	private List<MessageVocal> listMessageVocals;
	
	/**
	 * 
	 */
	public BoiteVocale()
	{
		listMessageVocals=new ArrayList<MessageVocal>();
	}

	/**
	 * @param m
	 */
	public BoiteVocale(List<MessageVocal>m)
	{
		listMessageVocals=m;
	}
	
	/**
	 * Pour obtenir  la valeur de listMessageVocals
	 * @return la valeur de listMessageVocals
	 */
	public List<MessageVocal> getListMessageVocals()
	{
		return listMessageVocals;
	}

	/**
	 * Pour modifier la valeur de listMessageVocals
	 * @param listMessageVocals la nouvelle valeur de listMessageVocals
	 */
	public void setListMessageVocals(List<MessageVocal> listMessageVocals)
	{
		this.listMessageVocals = listMessageVocals;
	}
	
	/**
	 * @param mv ajouter un message voc
	 */
	public void ajouterMessageVocal(MessageVocal mv)
	{
		listMessageVocals.add(mv);
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/