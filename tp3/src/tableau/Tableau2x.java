/*______________________________*/
/**
 * 
 */
package tableau;
import types.Array;
import types.Tableau;

/**
 * @author qfdk
 * Cree le 2014年11月17日
 */
public class Tableau2x<T> implements Tableau<T>
{

	private Array<T> monTableau;
	private int taille;

	/**
	 * le constucteur
	 * @param i la capacite
	 * @return 
	 */
	public Tableau2x(int i)
	{
		assert i>0 : "Taille du tableau non valide";
		this.taille = 0;
		this.monTableau = new Array<T>(i);
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
		return this.size()==0;
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
		assert 0<=i&&i<this.size():"la taille n''est pas valide";
		return monTableau.get(i);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#set(int, java.lang.Object)
	 */
	@Override
	public void set(int i, T v)
	{
		assert 0<=i&&i<this.size():"la taille n''est pas valide";
		monTableau.set(i, v);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#push_back(java.lang.Object)
	 */
	@Override
	public void push_back(T x)
	{
		if(monTableau.length()==taille)
		{
			Array<T> tmp = new Array<T>(monTableau.length()*2);
			for(int i=0;i<taille;i++)
			{
				tmp.set(i, monTableau.get(i));
			}
			monTableau = tmp;
		}
		monTableau.set(taille, x);
		taille++;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#pop_back()
	 */
	@Override
	public void pop_back()
	{		
		assert !this.empty():"Erreur : le tableau est vide.";
		taille--;
	}

}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/