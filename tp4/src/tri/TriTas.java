package tri;

/**
 * @author qfdk
 * Cree le 2014年12月10日
 */
public class TriTas {

	/**
	 * ajouter tnb[p] au tas forme par les p premiers elements du tableau tnb.
	 * @param tnb : tableau 
	 * @param p : indice
	 */
	public static void ajouterTas(int [] tnb, int p){
		assert 1 <= p&&p < tnb.length  : "indice n'est pas valide";
		while (tnb[p] > tnb[getPere(p)]){
			swap(tnb, p, getPere(p));
			p = (p - 1) / 2;
		}
	}

	/**
	 * indice de l'element pere
	 * @param p 
	 */
	private static int getPere(int p){
		assert(p>=0) : "p doit etre >  0";
		return (p - 1) / 2;
	}

	/**
	 * @param p 
	 * @return indice du fils G
	 */
	private static int getFilsG(int p){
		assert 0 <= p : "p inferieur a  -1";
		return 2 * p + 1;
	}

	/**
	 * @param p
	 * @return indice du fils D
	 */
	private static int getFilsD(int p){
		assert 0 <= p : "p inferieur ‡  -1";
		return 2 * p + 2;
	}

	/**
	 * supprimer l'element maximum du tas et reorganiser le reste du tas.
	 * @param tnb : tableau dont les p premiers elements forment un tas inverse
	 * @param p : nombre d'elements dans le tas 
	 */
	public static void supprimerMax(int [] tnb, int p){
		assert p >= 1 : "Il n'y a pas assez d'elements dans le tableau";

		tnb[0] = tnb[p - 1];
		p--;
		int indice = 0;

		while(getFilsG(indice) < p){
			
			if (getFilsD(indice) < p)
				if (tnb[getFilsD(indice)] > tnb[getFilsG(indice)]){
					if (tnb[indice] >= tnb[getFilsD(indice)])
						break;

					swap(tnb, indice, getFilsD(indice));
					indice = getFilsD(indice);
				}
				else{
					if (tnb[indice] >= tnb[getFilsG(indice)])
						break;
					swap(tnb, indice, getFilsG(indice));
					indice = getFilsG(indice);
				}
			else{
				if (tnb[indice] >= tnb[getFilsG(indice)])
					break;
				swap(tnb, indice, getFilsG(indice));
				indice = getFilsG(indice);
			}
		}
	}

	/**
	 * swap deux valeurs
	 */
	private static void swap(int[] tnb, int a, int b){
		int tmp = tnb[a];
		tnb[a] = tnb[b];
		tnb[b] = tmp;
	}

	/**
	 * trier
	 * @param tnb : tableau
	 * @param nb nb d'element
	 */
	public static void trier(int[] tnb, int nb){
		for(int i = 1; i < nb; ++i)
			ajouterTas(tnb, i);

		for(int i = nb; i > 0; --i){
			int tmp = tnb[0];
			supprimerMax(tnb, i);
			tnb[i - 1] = tmp;
		}
	}

}
