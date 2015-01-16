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
	 * @see forfait.AbsForfait#getPrixSMS()
	 */
	@Override
	public float getPrixSMS()
	{
		return (float) 0.07;
	}

	/* (non-Javadoc)
	 * @see forfait.AbsForfait#getPrixAppel()
	 */
	@Override
	public float getPrixAppel()
	{
		return (float) 0.15;
	}

	/* (non-Javadoc)
	 * @see forfait.AbsForfait#estHorsforfait()
	 */
	@Override
	public boolean estHorsforfait()
	{
		return false;
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/