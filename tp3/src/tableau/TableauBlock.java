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

	private final int N=4;
	private Tableau2x<Block<Integer>> monTableau;
	private int taille;
	
	/**
	 * le constructeur
	 * @param i
	 */
	public TableauBlock(int i)
	{
		assert i>0:"Merci  de donner une taille positive";
		this.taille=0;
//		monTableau=new Tableau2x[10]<Block<Integer>>(N) ;

			monTableau=new Tableau2x<Block<Integer>>(i);

	}

	/**
	 * @param capinit
	 * @param i
	 */
	public TableauBlock(int capinit, int i)
	{
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see types.Tableau#size()
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#empty()
	 */
	@Override
	public boolean empty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#full()
	 */
	@Override
	public boolean full()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#get(int)
	 */
	@Override
	public T get(int i)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#set(int, java.lang.Object)
	 */
	@Override
	public void set(int i, T v)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see types.Tableau#push_back(java.lang.Object)
	 */
	@Override
	public void push_back(T x)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see types.Tableau#pop_back()
	 */
	@Override
	public void pop_back()
	{
		// TODO Auto-generated method stub
		
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/