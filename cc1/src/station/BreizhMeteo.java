/*______________________________*/
/**
 * 
 */
package station;

import types.IReleve;

/**
 * @author qfdk
 * Cree le 2014年12月15日
 */
public class BreizhMeteo implements IReleve
{
	private String date;
	private String site;
	private float temperature;
	private float vitesse;
	
	/**
	 * @param m_date
	 * @param m_site
	 * @param m_temp
	 * @param m_vitesse
	 */
	public BreizhMeteo(String m_date,String m_site,float m_temp,float m_vitesse)
	{
		setDate(m_date);
		setSite(m_site);
		setTemperature(m_temp);
		setVitesse(m_vitesse);
	}
	/**
	 * Pour obtenir  la valeur de date
	 * @return la valeur de date
	 */
	public String getDate()
	{
		return date;
	}
	/**
	 * Pour modifier la valeur de date
	 * @param date la nouvelle valeur de date
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	/**
	 * Pour obtenir  la valeur de site
	 * @return la valeur de site
	 */
	public String getSite()
	{
		return site;
	}
	/**
	 * Pour modifier la valeur de site
	 * @param site la nouvelle valeur de site
	 */
	public void setSite(String site)
	{
		this.site = site;
	}
	/**
	 * Pour obtenir  la valeur de temperature
	 * @return la valeur de temperature
	 */
	public float getTemperature()
	{
		return temperature;
	}
	/**
	 * Pour modifier la valeur de temperature
	 * @param temperature la nouvelle valeur de temperature
	 */
	public void setTemperature(float temperature)
	{
		this.temperature = temperature;
	}
	/**
	 * Pour obtenir  la valeur de vitesse
	 * @return la valeur de vitesse
	 */
	public float getVitesse()
	{
		return vitesse;
	}
	/**
	 * Pour modifier la valeur de vitesse
	 * @param vitesse la nouvelle valeur de vitesse
	 */
	public void setVitesse(float vitesse)
	{
		this.vitesse = vitesse;
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/