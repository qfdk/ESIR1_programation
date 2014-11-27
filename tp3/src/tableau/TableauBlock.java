/*______________________________*/
/**
 * 
 */
package tableau;

import types.Tableau;

/**
 * @author qfdk
 * Cree le 2014年11月17日
 */
public class TableauBlock<T> implements Tableau<T>
{

	private static final int N=128;
	private Tableau2x<Block<T>> monTableau;
	private int taille;
	private int capa;
	
	/**
	 * le constructeur
	 * @param i
	 */
	public TableauBlock(int i)
	{
		this(N,i);
	}

	/**
	 * le constucteur
	 * @param capinit capacite
	 * @param i
	 */
	public TableauBlock(int capinit, int i)
	{
		assert i>0 && capinit>0 : "Merci  de donner une taille positive";
		this.taille=0;
		monTableau=new Tableau2x<Block<T>>(i);
		this.capa=capinit;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#size()
	 */
	@Override
	public int size()
	{
		return taille;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#empty()
	 */
	@Override
	public boolean empty()
	{
		return taille==0;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#full()
	 */
	@Override
	public boolean full()
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#get(int)
	 */
	@Override
	public T get(int i)
	{
		assert i<taille:"boom";
		return monTableau.get(i/capa).get(i%capa);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#set(int, java.lang.Object)
	 */
	@Override
	public void set(int i, T v)
	{
		int numBloc=i/capa;
		monTableau.get(numBloc).set(i%capa, v);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#push_back(java.lang.Object)
	 */
	@Override
	public void push_back(T x)
	{
		int positionBloc=taille/capa;
		
		if(monTableau.empty()||size()>=capa&&monTableau.get((size()/capa)-1).full())
		{
			monTableau.push_back(new Block<T>(capa));
		}
		
		monTableau.get(positionBloc).push_back(x);
		taille++;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#pop_back()
	 */
	@Override
	public void pop_back()
	{
		assert !this.empty() : "C'est vide le tableau";
		if(monTableau.get((taille-1)/capa).size()==1)
		{
			monTableau.pop_back();
		}
		else
		{
			monTableau.get((taille-1)/capa).pop_back();
		}
		taille--;
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/