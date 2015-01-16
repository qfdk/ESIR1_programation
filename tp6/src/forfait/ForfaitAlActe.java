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
	public static final float PRIX_BASE=40;
	public static final float PRIX_MV=(float) 0.07;
	public static final float PRIX_SMS=(float) 0.07;
	public static final float PRIX_APPEL=(float) 0.15;
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

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/