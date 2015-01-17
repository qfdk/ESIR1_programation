/*______________________________*/
/**
 * 
 */
package messagerie;

import java.util.Date;

/**
 * @author qfdk
 * Cree le 2015年1月13日
 */
public abstract class AbstractCommMessage extends AbstractCommunication
{

	protected AbstractCommMessage(AbonneOperateur emetteur,
			AbonneOperateur recepteur, Date dateD) {
		super(emetteur, recepteur, dateD);
	}


}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/