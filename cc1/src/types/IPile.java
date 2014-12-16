/*______________________________*/
/**
 * 
 */
package types;

/**
 * @author qfdk
 * Cree le 2014年12月15日
 */
public interface IPile<T>
{
	/**
	 * @return
	 */
	public boolean estVide();
	/**
	 * @return
	 */
	public boolean estPleine();
	/**
	 * @return
	 */
	public int getTaille();
	/**
	 * 
	 */
	public void empiler();
	/**
	 * @return
	 */
	public T getsommet();
	/**
	 * 
	 */
	public void depiler();
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/