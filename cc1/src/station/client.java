/* ______________________________ */
/**
 * 
 */
package station;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import types.*;

/**
 * @author qfdk Cree le 2014年12月15日
 */
public class client
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		List<IReleve> list = new ArrayList<IReleve>();
		list.add(new BreizhMeteo("2013", "coucou", 12, 12));
		list.add(new BreizhMeteo("2013", "coucou1", 13, 23));
		list.add(new BreizhMeteo("2013", "coucou1", 15, 23));
		list.add(new BreizhMeteo("2013", "coucou", 15, 12));
		// System.out.println(moyenne(list, "coucou"));

		List<Couple<String, Float>> coucou = new ArrayList<Couple<String, Float>>();
		coucou = listMoyenne(list);
		System.out.println(coucou);

	}

	/**
	 * calcule la moyenne de vitesse
	 * 
	 * @param maListe ma liste
	 * @param nom nom de station
	 * @return la moyenne de vitesse
	 */
	public static float moyenne(List<IReleve> maListe, String nom)
	{
		float somme = 0;
		int cpt = 0;
		for (IReleve i : maListe)
		{
			if (i.getSite().equals(nom))
			{
				somme = i.getVitesse() + somme;
				cpt++;
			}
		}
		return somme / cpt;
	}

	public static List<Couple<String, Float>> listMoyenne(List<IReleve> maListe)
	{
		List<Couple<String, Float>> list = new ArrayList<Couple<String, Float>>();
		ListIterator<IReleve> it = maListe.listIterator();
		int cpt = 0;
		float somme = 0;
		for(int i=0;i<maListe.size();i++)
		{
			Couple<String, Float> site=new Couple<String, Float>("", (float) 0);
			if(i<list.size()-1&&maListe.get(i).getSite().equals(maListe.get(i+1).getSite()))
			{
					site.modifierPremier(maListe.get(i).getSite());
					site.modifierDeuxieme(maListe.get(i).getVitesse()+maListe.get(i+1).getVitesse());
					cpt++;
			}else{
				site.modifierDeuxieme(site.deuxieme()/cpt);
				list.add(site);
				cpt=0;
			}
		}
		
//		while (it.hasNext())
//		{
//			IReleve m = it.next();
//			Couple<String, Float> site = new Couple<String, Float>(m.getSite(),
//					m.getVitesse());
//			if (m.getSite().equals(it.next().getSite()))
//			{
//				somme = somme + m.getVitesse();
//				cpt++;
//			} else
//			{
//				site.modifierDeuxieme(somme / cpt);
//				list.add(site);
//				somme = 0;
//				cpt = 0;
//			}
//		}

		return list;

	}

}

/* ______________________________ */
/* ___________FIN_______________ */
/* ______________________________ */