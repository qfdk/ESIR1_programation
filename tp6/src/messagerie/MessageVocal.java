/*______________________________*/
/**
 * 
 */
package messagerie;

import java.text.DateFormat;

/**
 * @author qfdk
 * Cree le 2015年1月13日
 */
public class MessageVocal extends AbstractMessage
{

	private String message;
	/**
	 * @param com
	 */
	protected MessageVocal(AbstractCommMessage com)
	{
		super(com);
	}

	/**
	 * @param tmp
	 * @param mv
	 */
	public MessageVocal(CommMessageVocal tmp, String mv)
	{
		this(tmp);
		setMessage(mv);
	}

	/**
	 * Pour obtenir  la valeur de message
	 * @return la valeur de message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Pour modifier la valeur de message
	 * @param message la nouvelle valeur de message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb =new StringBuilder();
		sb.append(commMessage.appelant)
		.append("[Message Vocal] -->(").append(DateFormat.getDateTimeInstance().format(commMessage.debutComm)).append(") ")
		.append(" : ")
		.append(getMessage());
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/