/*______________________________*/
/**
 * 
 */
package messagerie;

/**
 * @author qfdk
 * Cree le 2015年1月8日
 */
public class NumeroTelephone
{
	private String num;
	private AbonneOperateur abonne;
	
	/**
	 * @param numero
	 */
	public NumeroTelephone(String numero)
	{
		setNum(numero);
	}
	/**
	 * Pour obtenir  la valeur de num
	 * @return la valeur de num
	 */
	public String getNum()
	{
		return num;
	}
	/**
	 * Pour modifier la valeur de num
	 * @param num la nouvelle valeur de num
	 */
	public void setNum(String num)
	{
		this.num = num;
	}
	/**
	 * Pour obtenir  la valeur de abonne
	 * @return la valeur de abonne
	 */
	public AbonneOperateur getAbonne()
	{
		return abonne;
	}
	/**
	 * Pour modifier la valeur de abonne
	 * @param abonne la nouvelle valeur de abonne
	 */
	public void setAbonne(AbonneOperateur abonne)
	{
		this.abonne = abonne;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append(abonne.getNom())
		.append("(").append(getNum()).append("),")
		.append("(").append(abonne.getForfait()).append(")");
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/