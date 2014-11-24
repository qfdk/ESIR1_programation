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
 * @param <T> 
 */
public class Block<T> implements Tableau<T>{
	
	private Array<T> monTableu;
	private int taille;
	/**
	 * le constucteur
	 * @param capacite : Capacité du block
	 */
	public Block(int capacite)
	{
		this.taille=0;
		assert 0<=taille&&taille<=capacite&&0<capacite:"l'argument n'est pas valide";
		monTableu=new Array<T>(capacite);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#size()
	 */
	@Override
	public int size()
	{
		return this.taille;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#empty()
	 */
	@Override
	public boolean empty()
	{
		return this.size()<=0;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#full()
	 */
	@Override
	public boolean full()
	{
		return taille==monTableu.length();
	}

	/* (non-Javadoc)
	 * @see types.Tableau#get(int)
	 */
	@Override
	public T get(int i)
	{
		assert 0<=i&&i<this.size():"la taille n''est pas valide";
		return monTableu.get(i);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#set(int, java.lang.Object)
	 */
	@Override
	public void set(int i, T v)
	{
		assert 0<=i&&i<this.size():"la taille n''est pas valide";
		monTableu.set(i, v);
	}

	/* (non-Javadoc)
	 * @see types.Tableau#push_back(java.lang.Object)
	 */
	@Override
	public void push_back(T x)
	{
		assert !this.full():"Erreur : le tableau ne devrait pas être plein";
		monTableu.set(size(), x);
		taille++;
	}

	/* (non-Javadoc)
	 * @see types.Tableau#pop_back()
	 */
	@Override
	public void pop_back()
	{
		assert !this.empty():"Erreur : le tableau est vide.";
		taille=taille-1;
		monTableu.set(taille, null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<size();i++)
		{
			sb.append(monTableu.get(i)).append("\n");
		}
		return sb.toString();
	}
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/