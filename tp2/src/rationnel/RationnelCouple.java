/*______________________________*/
/**
 * 
 */
package rationnel;

import types.Rationnel;

/**
 * @author qfdk
 * RationnelCouple
 * @see Raionnnel
 */
public class RationnelCouple implements Rationnel
{
	// attibut private de type Couple
	private Couple<Integer,Integer> monCouple;
	
	/**
	 * Constructeur RationnelCouple
	 * @param num numerateur
	 * @param deno denominateur
	 */
	public RationnelCouple(int num, int deno)
	{
		assert deno!=0:"le denominateur ne peut pas etre 0";
        int g =getPGCD(num, deno);
        monCouple=new Couple<Integer, Integer>(num/ g,deno / g);
        if (deno < 0) 
        { 
        	monCouple=new Couple<Integer, Integer>(-num/g,-deno/g);
        }	
	}


	/**
	 * Constructeur RationnelCouple
	 * @param num numerateur
	 */
	public RationnelCouple(int num)
	{		
		monCouple=new Couple<Integer, Integer>(num, 1);
	}

	/**
	 * Constructeur RationnelCouple
	 * @param r  Rationnel
	 */
	public RationnelCouple(Rationnel r)
	{
		this(r.getNumerateur(),r.getDenominateur());
	}

	private int getPGCD(int a, int b)
	{
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        if (0 == b) return a;
        else return getPGCD(b, a % b);
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#equals(types.Rationnel)
	 */
	@Override
	public boolean equals(Rationnel r)
	{
		return ((monCouple.getFirst() == r.getNumerateur())&& (monCouple.getSecond() == r
				.getDenominateur()));
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#somme(types.Rationnel)
	 */
	@Override
	public Rationnel somme(Rationnel r)
	{
		return new RationnelCouple(monCouple.getFirst()*r.getDenominateur()+monCouple.getSecond()*r.getNumerateur(),monCouple.getSecond()*r.getDenominateur());
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#inverse()
	 */
	@Override
	public Rationnel inverse()
	{
		assert monCouple.getFirst()!=0:"inpossible";
		return new RationnelCouple(monCouple.getSecond(), monCouple.getFirst());
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#valeur()
	 */
	@Override
	public double valeur()
	{
		return monCouple.getFirst()*1.00/monCouple.getSecond();
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#getNumerateur()
	 */
	@Override
	public int getNumerateur()
	{
		return monCouple.getFirst();
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#getDenominateur()
	 */
	@Override
	public int getDenominateur()
	{
		return monCouple.getSecond();
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#compareTo(types.Rationnel)
	 */
	@Override
	public int compareTo(Rationnel autre)
	{
		if(this.valeur()-autre.valeur()==0)
		{
			return 0;
		}
		if(this.valeur()-autre.valeur()>0)
		{
			return 1;
		}else{
			return -1;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		if(monCouple.getFirst()==0)
		{
			sb.append("0");
		}
		else if(monCouple.getSecond()==1)
		{
			sb.append(monCouple.getFirst());
		}else
		{
			sb.append(monCouple.getFirst()+"/"+monCouple.getSecond());
		}
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/
