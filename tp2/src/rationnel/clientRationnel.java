/*______________________________*/
/**
 * 
 */
package rationnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import types.Rationnel;

/**
 * @author qfdk Cree le 2014年10月21日
 */
public class clientRationnel
{

	/*********** premiere version *********/
	/**
	 * lireRationnel
	 * @param input Scanner
	 * @return RationnelSimple
	 */
	public static Rationnel lireRationnel(Scanner input)
	{
		// String s=input.nextLine();
		int num = input.nextInt();

		if (num == 0)
		{
			return null;
		}
		int den = input.nextInt();
		// assert den!=0:"Denominateur ne peut pas etre 0.";
		// return new RationnelSimple(num, den);
		return makeRationnel(num, den);
	}

	/**
	 * @param rationnelCouple
	 * @param lesRationnels
	 * @param i
	 */
	public static void insererRationnel(RationnelCouple rationnelCouple,
			Rationnel[] lesRationnels, int i)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * Inserer un rationnel dans le tableau leRationnels
	 * @pre : tableau trié dans(ordre croissant)
	 * @pre : 0 <=nb<=LesRationnels.length * @param r1
	 * @param lesRationnels
	 * @param i
	 */
	public static void insererRationnel(Rationnel r1,
			Rationnel[] lesRationnels, int nb)
	{
		assert 0 <= nb && nb < lesRationnels.length : "On peut pas inserer pour raison de taille";
		// on repere la position où il faut inserer
		int i = 0;

		while (i < nb && r1.compareTo(lesRationnels[i]) > 0)
		{
			i++;
		} // A ce niveau i se trouve à la position où on doit inserer
		for (int j = nb; j > i; j--)
		{
			// on decale tous les elements vers la droite
			lesRationnels[j] = lesRationnels[j - 1];
		}
		lesRationnels[i] = r1;
	}

	/**
	 * fonction affichage
	 */
	public static void affichage()
	{
		Rationnel r = new RationnelSimple(0, 1);
		StringBuilder sb = new StringBuilder();
		Rationnel tmp = null;
		List<Rationnel> list = new ArrayList<Rationnel>();
		list.add(r);
		tmp = clientRationnel.lireRationnel(new Scanner(System.in));
		while (tmp != null)
		{
			list.add(tmp);
			tmp = clientRationnel.lireRationnel(new Scanner(System.in));
		}
		int i = 1;
		while (i < list.size())
		{
			sb.append("courant = ").append(list.get(i)).append(" ; ")
					.append(list.get(i)).append(" + ").append(list.get(i - 1))
					.append(" = ").append(list.get(i).somme(list.get(i - 1)))
					.append(" ; ").append("inverse = ")
					.append(list.get(i).inverse()).append(" ; ")
					.append(" valeur = ").append(list.get(i).valeur())
					.append(" ; ");
			String equal = "?";
			if (list.get(i).compareTo(list.get(i - 1)) < 0)
			{
				equal = " < ";
			} else if (list.get(i).compareTo(list.get(i - 1)) > 0)
			{
				equal = " > ";
			} else
			{
				equal = " = ";
			}
			sb.append(list.get(i)).append(equal).append(list.get(i - 1))
					.append(" ; ");
			String meme = " ≠ ";
			if (list.get(i).equals(list.get(i - 1)))
			{
				meme = " = ";
			}
			sb.append(list.get(i)).append(meme).append(list.get(i - 1))
					.append(" ; \n");
			i++;
		}
		System.out.println(sb.toString());
		Rationnel[] lesRationnels = new Rationnel[list.size()];
		list.toArray(lesRationnels);
		afficher(lesRationnels, lesRationnels.length);
		// afficher(, nb);
	}

	/**
	 * @param num
	 * @param den
	 * @return
	 */
	public static Rationnel makeRationnel(int num, int den)
	{
		assert den != 0 : "le den ne peut pas etre 0";
		return new RationnelSimple(num, den);
	}

	/**
	 * @param lesRationnels
	 * @param nb
	 */
	public static void afficher(Rationnel[] lesRationnels, int nb)
	{
		for (int i = 0; i < nb; i++)
		{
			System.out.println(i + " : " + lesRationnels[i] + " ("
					+ lesRationnels[i].valeur() + " )");
		}
	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */