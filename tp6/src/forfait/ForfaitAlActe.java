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
	 * prix de la base
	 */
	public static final float PRIX_BASE=40;
	/**
	 * prix de message voc
	 */
	public static final float PRIX_MV=(float) 0.07;
	/**
	 * prix sms
	 */
	public static final float PRIX_SMS=(float) 0.07;
	/**
	 * prix d'un appel
	 */
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