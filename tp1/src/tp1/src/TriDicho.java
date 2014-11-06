/*______________________________*/
/**
 * 
 */
package tp1.src;

/**
 * @author qfdk Cree le 2014年10月17日
 */
public class TriDicho
{

	/**
	 * @param t1
	 * @param length
	 * @param t2
	 * @param length2
	 * @return
	 */
	public static int[] fusionner(int[] t1, int length, int[] t2, int length2)
	{
		int[] tmp = new int[length + length2];
		int k = 0;
		int i = 0;
		int j = 0;
		while (i < t1.length && j < t2.length)
		{
			if (t1[i] < t2[j])
				tmp[k++] = t1[i++];
			else
				tmp[k++] = t2[j++];
		}
		while (i < t1.length)
			tmp[k++] = t1[i++];
		while (j < t2.length)
			tmp[k++] = t2[j++];
		return tmp;
	}

	/**
	 * @param x
	 * @param t
	 * @param length
	 * @return
	 */
	public static int rechercheDichotomique(int x, int[] t, int length)
	{
		int inf = 0;
		int sup = t.length - 1;
		while (inf <= sup)
		{
			int m = (sup + inf) / 2;
			if (x == t[m])
			{
				return m;
			} else if (x < t[m])
			{
				sup = m - 1;
			} else
			{
				inf = m + 1;
			}
		}
		return -1;
	}

	/**
	 * @param t
	 * @param length
	 */
	public static void triInsertion(int[] t, int length)
	{
		for (int i = 1; i < t.length; i++)
		{
			int val = t[i];
			int position = i;
			while (position > 0 && t[position - 1] > val)
			{
				t[position] = t[position - 1];
				position--;
			}
			t[position] = val;
		}

	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */