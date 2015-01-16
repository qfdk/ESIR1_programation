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

	protected CommMessageVocal(AbonneOperateur emetteur,
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
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/