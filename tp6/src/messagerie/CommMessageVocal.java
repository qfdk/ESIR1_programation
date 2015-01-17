/*______________________________*/
/**
 * 
 */
package messagerie;

import java.text.DateFormat;
import java.util.Date;

import forfait.AbsForfait;

/**
 * @author qfdk
 * Cree le 2015年1月13日
 */
public class CommMessageVocal extends AbstractCommMessage
{

	/**
	 * @param emetteur
	 * @param recepteur
	 * @param dateD
	 */
	public CommMessageVocal(AbonneOperateur emetteur,
			AbonneOperateur recepteur, Date dateD) {
		super(emetteur, recepteur, dateD);
	}
	public String toString()
	{
		AbsForfait forfait=appelant.getAbonne().getForfait();
	
		StringBuilder sb=new StringBuilder();
		sb.append(appele.getNum()).append("--")
		.append("VOC").append("--(")
		.append(DateFormat.getDateTimeInstance().format(debutComm)).append(")--(")
		.append(DateFormat.getDateTimeInstance().format(debutComm)).append(")");
		if(forfait.getNom().equals("ForfaitIllimite"))
		{
			sb.append("-- inclus");
		}else
		{
			sb.append("-- 0.07");
		}
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/