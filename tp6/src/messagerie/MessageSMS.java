/*______________________________*/
/**
 * 
 */
package messagerie;

import java.text.DateFormat;

/**
 * @author qfdk
 * Cree le 2015年1月6日
 */
public class MessageSMS extends AbstractMessage
{

	private String sms;
	/**
	 * @param com
	 */
	protected MessageSMS(AbstractCommMessage com)
	{
		super(com);
	}

	/**
	 * @param tmp
	 * @param sms
	 */
	public MessageSMS(CommSMS tmp, String sms)
	{
		super(tmp);
		setSms(sms);
	}

	/**
	 * Pour obtenir  la valeur de sms
	 * @return la valeur de sms
	 */
	public String getSms()
	{
		return sms;
	}

	/**
	 * Pour modifier la valeur de sms
	 * @param sms la nouvelle valeur de sms
	 */
	public void setSms(String sms)
	{
		this.sms = sms;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb =new StringBuilder();
		sb.append(commMessage.appelant)
		.append("[SMS] -->(").append(DateFormat.getDateTimeInstance().format(commMessage.debutComm)).append(") ")
		.append(" : ")
		.append(getSms());
		return sb.toString();
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/