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
public abstract class AbstractCommunication
{
	protected Data debutComm;
	
	protected AbstractCommunication(Data dateD)
	{
		this.debutComm=dateD;
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/