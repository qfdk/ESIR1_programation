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
public class CommSMS extends AbstractCommMessage
{

	/**
	 * @param dateD
	 */
	protected CommSMS(AbonneOperateur eme, AbonneOperateur rec,Date dateD)
	{
		super(eme,rec,dateD);
	}
	
	public String toString()
	{
		AbsForfait forfait=appelant.getAbonne().getForfait();
	
		StringBuilder sb=new StringBuilder();
		sb.append(appele.getNum()).append("--")
		.append("SMS").append("--(")
		.append(DateFormat.getDateTimeInstance().format(debutComm)).append(")--(")
		.append(DateFormat.getDateTimeInstance().format(debutComm)).append(")--")
		.append("0.1");
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/