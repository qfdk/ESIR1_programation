/*______________________________*/
/**
 * 
 */
package rationnel;

import java.util.Random;
import java.util.Scanner;

import types.Rationnel;

/**
 * @author qfdk Cree le 
 */
public class clientRationnel
{

	/**
	 * main
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		System.out.println("===saisie===");
		//saisie et affichage de Rationnnels par client.
		saisieEtAffichage();
		System.out.println("===aleatoire donner un nombre===");
		//creation aleatoire de RationnelSimple et de RationnelCouple
		testAleatoire(new Scanner(System.in).nextInt());
	}
	
	/**
	 * test Aleatoire
	 * @param nb nombre d'element
	 */
	public static void testAleatoire(int nb)
	{
		
		Random r=new Random();
		Rationnel []lesRationnels=new Rationnel[nb]; 
		for(int i=0;i<nb;i++)
		{
			lesRationnels[i]=makeRationnel(r.nextInt(20),r.nextInt(10)+1);
		}
		afficher(lesRationnels, nb);
		System.out.print("Somme : =>"+sommeRationnnels(lesRationnels,nb));
	}
	
	/**
	 * lireRationnel
	 * @param input Scanner
	 * @return Rationnel une instance de rationnel 
	 */
	public static Rationnel lireRationnel(Scanner input)
	{
		int num = input.nextInt();

		if (num == 0)
		{
			return null;
		}
		int den = input.nextInt();
		
		// return new RationnelSimple(num, den);
		return makeRationnel(num, den);
	}

	/**
	 *  Inserer un rationnel dans le tableau leRationnels
	 *  tableau trié dans(ordre croissant)
	 *  0 <=nb<=LesRationnels.length * 
	 * @param rationnelCouple
	 * @param lesRationnels
	 * @param nb
	 */
	public static void insererRationnel(RationnelCouple rationnelCouple,
			Rationnel[] lesRationnels, int nb)
	{
		assert 0 <= nb && nb < lesRationnels.length : "On peut pas inserer pour raison de taille";
		// on repere la position où il faut inserer
		int i = 0;

		while (i < nb && rationnelCouple.compareTo(lesRationnels[i]) > 0)
		{
			i++;
		} 
		// A ce niveau i se trouve à la position où on doit inserer
		for (int j = nb; j > i; j--)
		{
			// on decale tous les elements vers la droite
			lesRationnels[j] = lesRationnels[j - 1];
		}
		lesRationnels[i] = rationnelCouple;

	}

	/**
	 * Inserer un rationnel dans le tableau leRationnels
	 *  tableau trié dans(ordre croissant)
	 *  0 <=nb<=LesRationnels.length * 
	 * @param r1 rationnel
	 * @param lesRationnels la tab de rationnel
	 * @param nb la taille du tableu
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
		} 
		// A ce niveau i se trouve à la position où on doit inserer
		for (int j = nb; j > i; j--)
		{
			// on decale tous les elements vers la droite
			lesRationnels[j] = lesRationnels[j - 1];
		}
		lesRationnels[i] = r1;
	}

	/**
	 * fonction saisie pour tester la lecture et l'affichage.
	 */
	public static void saisieEtAffichage()
	{
		StringBuilder sb = new StringBuilder();
		Rationnel []lesRationnels = new Rationnel[100] ;
		Rationnel tmp;
		int j=1;
		lesRationnels[0]=new RationnelSimple(0);
		
		tmp = clientRationnel.lireRationnel(new Scanner(System.in));
		
		while (tmp != null)
		{
			lesRationnels[j]=tmp;
			tmp = clientRationnel.lireRationnel(new Scanner(System.in));
			j++;
		}
		
		int i=1;
		while ( i< j)
		{
			sb.append("courant = ").append(lesRationnels[i]).append(" ; ")
					.append(lesRationnels[i]).append(" + ").append(lesRationnels[i-1])
					.append(" = ").append(lesRationnels[i].somme(lesRationnels[i-1]))
					.append(" ; ").append("inverse = ")
					.append(lesRationnels[i].inverse()).append(" ; ")
					.append(" valeur = ").append(lesRationnels[i].valeur())
					.append(" ; ");
			String equal = "?";
			if (lesRationnels[i].compareTo(lesRationnels[i-1]) < 0)
			{
				equal = " < ";
			} else if (lesRationnels[i].compareTo(lesRationnels[i-1]) > 0)
			{
				equal = " > ";
			} else
			{
				equal = " = ";
			}
			sb.append(lesRationnels[i]).append(equal).append(lesRationnels[i-1])
					.append(" ; ");
			String meme = " ≠ ";
			if (lesRationnels[i].equals(lesRationnels[i-1]))
			{
				meme = " = ";
			}
			sb.append(lesRationnels[i]).append(meme).append(lesRationnels[i-1])
					.append(" ; \n");
			i++;
		}
		System.out.println(sb.toString());

		afficher(lesRationnels, j);
	}

	/**
	 * 
	 * faburiquer le rationnel
	 * @param num num
	 * @param den den
	 * @return une instance de Rationnel
	 */
	public static Rationnel makeRationnel(int num, int den)
	{
		assert den != 0 : "le den ne peut pas etre 0";
		Random r=new Random();
		
		if(r.nextInt(200)%2==0)
				return new RationnelSimple(num, den);
		else
			return new RationnelCouple(num, den);
	}

	/**
	 * fonction affichage
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
	
	/**
	 * somme de Rationnnels
	 * @param lesRationnels tableu de rationnels
	 * @param nb taille
	 * @return somme de Rationnel
	 */
	public static Rationnel sommeRationnnels(Rationnel[] lesRationnels, int nb)
	{
		Rationnel somme=new RationnelSimple(0);
		for(int i=0;i<nb;i++)
		{
			somme=somme.somme(lesRationnels[i]);
		}
		return somme;
	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */