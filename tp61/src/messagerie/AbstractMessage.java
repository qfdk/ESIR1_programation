/*______________________________*/
/**
 * 
 */
package messagerie;

/**
 * @author qfdk
 * Cree le 2015年1月13日
 */
public abstract class AbstractMessage
{
	protected AbstractCommMessage commMessage;
	protected AbstractMessage(AbstractCommMessage com)
	{
		commMessage=com;
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/