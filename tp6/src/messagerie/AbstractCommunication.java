/*______________________________*/
/**
 * 
 */
package messagerie;

import java.util.Date;


/**
 * @author qfdk
 * Cree le 2015年1月8日
 */
public abstract class AbstractCommunication
{
	protected Date debutComm;
	protected NumeroTelephone appele,appelant;
	
	protected AbstractCommunication(AbonneOperateur emetteur, AbonneOperateur recepteur, Date dateD)
	{
		this.appele=recepteur.getNumeroTel();
		this.appelant=emetteur.getNumeroTel();
		this.debutComm=dateD;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(appele.getNum()).
		append("--").append(debutComm);
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/