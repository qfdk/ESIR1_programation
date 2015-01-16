/* ______________________________ */
/**
 * 
 */
package forfait;

/**
 * @author qfdk Cree le 2015年1月6日
 */
public class Forfait1H extends AbsForfait
{
	public static final float PRIX_BASE=20;
	public static final float PRIX_SMS=(float) 0.07;
	public static final float PRIX_MV=(float) 0.07;
	public static final float PRIX_APPEL=(float) 0.15;
	public static final int F1H=60;
	/**
	 * @param nom
	 */
	private Forfait1H(String nom)
	{
		super(nom);
	}

	/**
	 * Forfait1H
	 */
	public Forfait1H()
	{
		this("Forfait1H");
	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */