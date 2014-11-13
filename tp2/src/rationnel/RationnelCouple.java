/*______________________________*/
/**
 * 
 */
package rationnel;

import java.util.List;

import types.Rationnel;

/**
 * @author qfdk
 * Cree le 2014年10月21日
 */
public class RationnelCouple implements Rationnel
{
	private Couple<Integer,Integer> monCouple;
	
//	private int num;
//	private int deno;
	
	/**
	 * @param num
	 * @param deno
	 */
	public RationnelCouple(int num, int deno)
	{
		assert deno!=0:"le den ne peut pas etre 0";
        int g =getPGCD(num, deno);
        monCouple=new Couple<Integer, Integer>(num/ g,deno / g);
        if (deno < 0) 
        { 
        	monCouple=new Couple<Integer, Integer>(-deno/g, -num/g);
        }	
	}


	/**
	 * @param num
	 */
	public RationnelCouple(int num)
	{		
		monCouple=new Couple<Integer, Integer>(num, 1);
	}

	/**
	 * @param r1
	 */
	public RationnelCouple(Rationnel r)
	{
		this(r.getNumerateur(),r.getDenominateur());
	}

	@SuppressWarnings("unused")
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
		// TODO Auto-generated method stub
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

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/