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
	
	private int num;
	private int deno;
	
	/**
	 * @param num
	 * @param deno
	 */
	public RationnelCouple(int num, int deno)
	{
		assert deno!=0:"le den ne peut pas etre 0";
        int g =getPGCD(num, deno);
        this.num = num   / g;
        this.deno = deno / g;
        monCouple=new Couple<Integer, Integer>(this.num, this.deno);
        if (deno < 0) 
        { 
        	this.deno = -deno/g; this.num = -num/g;
        	monCouple=new Couple<Integer, Integer>(this.num, this.deno);
        }	
	}


	/**
	 * @param num
	 */
	public RationnelCouple(int num)
	{
		this.num = num;
		this.deno = 1;
		
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
		return ((this.num == r.getNumerateur())&& (this.deno == r
				.getDenominateur()));
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#somme(types.Rationnel)
	 */
	@Override
	public Rationnel somme(Rationnel r)
	{
		// TODO Auto-generated method stub
		return new RationnelCouple(this.num*r.getDenominateur()+this.deno*r.getNumerateur(),this.deno*r.getDenominateur());
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#inverse()
	 */
	@Override
	public Rationnel inverse()
	{
		assert this.num!=0:"inpossible";
		return new RationnelCouple(deno, num);
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#valeur()
	 */
	@Override
	public double valeur()
	{
		return this.num*1.00/this.deno;
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#getNumerateur()
	 */
	@Override
	public int getNumerateur()
	{
		return this.num;
	}

	/* (non-Javadoc)
	 * @see types.Rationnel#getDenominateur()
	 */
	@Override
	public int getDenominateur()
	{
		return this.deno;
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