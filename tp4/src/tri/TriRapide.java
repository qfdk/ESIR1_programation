/*______________________________*/
/**
 * 
 */
package tri;

/**
 * @author qfdk
 * Cree le 2014年12月10日
 */
public class TriRapide
{
	
	static int partager(int []T ,int binf,int bsup)
	{
	    int index = binf;
	    int pivot = T[index];
        swap(T, index, bsup);	
        for (int i = index = binf; i < bsup; ++ i) {
            if (T[i]<=pivot) {
                swap(T, index++, i);
            }
        }
        swap(T, index, bsup);	
        return (index);
	}
	
	static void triRapide(int []T,int binf,int bsup)
	{
		if (bsup > binf) {
            int index = partager(T, binf, bsup);
            triRapide(T, binf, index - 1);
            triRapide(T, index + 1,  bsup );
        }
	}
	
	/**
	 * founir au client 
	 * @param T le tableu a trier
	 * @param nb nombre d'element
	 */
	public static void trier(int []T,int nb)
	{
		 triRapide(T, 0, nb-1);
	}
	
	/*echanger deux valeurs*/
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
 
}

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/