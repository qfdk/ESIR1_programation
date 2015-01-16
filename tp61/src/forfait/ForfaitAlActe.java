/*______________________________*/
/**
 * 
 */
package forfait;

/**
 * @author qfdk
 * Cree le 2015年1月6日
 */
public class ForfaitAlActe extends AbsForfait
{

	/**
	 * @param nom
	 */
	protected ForfaitAlActe(String nom)
	{
		super(nom);
	}

	/**
	 * ForfaitAlActe
	 */
	public ForfaitAlActe()
	{
		this("ForfaitAlActe");
	}
	/* (non-Javadoc)
	 * @see forfait.AbsForfait#calculerPrix()
	 */
	@Override
	public float calculerPrix()
	{
		return 0;
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/