package main;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import outilsHuffman.*;
import types.ABinHuffman;
import types.Couple;
import types.ListeABH;


/**
 * Réalisation du codage d'un texte par la méthode de Huffman
 */

public class CodageHuffman
{
	/**
	 *  nombre total
	 */
	public static final int nombreTotalCara  = 256;
	
	/**
	 * main
	 * @param args
	 */
	public static void main (String[] args)
	{
		//------------------------------------------------------------------------
		// 0. Saisir le nom du fichier à coder (À FAIRE)
		//------------------------------------------------------------------------
		System.out.println("Donner le nom du fichier à coder");
		Scanner s = new Scanner(System.in);
		String nomFichier = System.getProperty("user.dir") + "/donnees/"
				+ s.nextLine();
		//------------------------------------------------------------------------
		// 1. Lire le texte (DONNÉ)
		//------------------------------------------------------------------------
		char [] texte = OutilsHuffman.lireFichier(nomFichier);

		//------------------------------------------------------------------------
		// 2. Calculer la table des fréquences des caractères (À FAIRE)
		//------------------------------------------------------------------------
		int [] tableFrequences = calculerFrequences(texte);

		//------------------------------------------------------------------------
		// 3. Enregistrer la table de fréquences dans le fichier de sortie (DONNÉ)
		//------------------------------------------------------------------------
		OutilsHuffman.enregistrerTableFrequences(tableFrequences, nomFichier + ".code");

		//------------------------------------------------------------------------
		// 4. Construire l'arbre de codage de Huffman (DONNÉ - À FAIRE)
		//------------------------------------------------------------------------
		ABinHuffman arbreCodageHuffman = construireArbreHuffman(tableFrequences);

		//------------------------------------------------------------------------
		// Afficher l'arbre de codage de Huffman (DÉJÀ FAIT)
		//------------------------------------------------------------------------
		System.out.println("Arbre de Huffman associé au texte " + nomFichier);
		DecodageHuffman.afficherHuffman(arbreCodageHuffman);

		//------------------------------------------------------------------------
		// 5. Construire la table de codage associée (À FAIRE)
		//------------------------------------------------------------------------
		String [] tablecodage = construireTableCodage(arbreCodageHuffman);

		//------------------------------------------------------------------------
		// 5.1. afficher la table de codage (À FAIRE)
		//------------------------------------------------------------------------
		System.out.println("Table de codage associée au texte " + nomFichier);
		afficherTableCodage(tablecodage);

		//------------------------------------------------------------------------
		// 6. coder le texte avec l'arbre de Huffman (À FAIRE)
		//------------------------------------------------------------------------
		StringBuilder texteCode = coderTexte(texte, tablecodage);

		//------------------------------------------------------------------------
		// 7. enregistrer le texte codé (DONNÉ)
		//------------------------------------------------------------------------
		OutilsHuffman.enregistrerTexteCode(texteCode, nomFichier + ".code");

		//------------------------------------------------------------------------
		// xx. calculer et afficher les stats (À FAIRE)
		//------------------------------------------------------------------------
		// calculer la taille du fichier non codé
		// calculer la taille du fichier codé

		

		s.close();
	}

	/**
	 * 2. calculer la fréquence d'apparition de chaque caractère
	 * @param  tcar tableau des carBruz - 3517actères du texte
	 * @return tableau de fréquence des caractères, indicé par les caractères
	 */
	public static int [] calculerFrequences(char [] tcar)
	{
		int[] tab = new int [nombreTotalCara];
		for(int i = 0;i<tcar.length;i++)
		{
			tab[(int)tcar[i]]++; 
		}
		return tab;
	}

	/**
	 * 4. construire un arbre de codage de Huffman par sélection et combinaison
	 * des éléments minimaux
	 * @param tableFrequences table des fréquences des caractères
	 * @return arbre de codage de Huffman
	 */
	public static ABinHuffman construireArbreHuffman(int [] tableFrequences)
	{
		ListeABH liste = new ListeABH(); 
		liste = faireListeAbinHuffman(tableFrequences);

		while(liste.size()>1)
		{
			ABinHuffman minimaux = new ABinHuffman();

			Iterator<ABinHuffman> it = liste.iterator();

			int c = it.next().getValeur().deuxieme() +
					it.next().getValeur().deuxieme();
			minimaux.setValeur(new Couple<Character, Integer>('.', c));

			minimaux.setGauche(liste.getFirst());
			liste.removeFirst();

			minimaux.setDroit(liste.getFirst());
			liste.removeFirst();

			if(liste.size()==0) 
			{
				return minimaux;
			}

			liste.add(minimaux);
			Collections.sort(liste, new comparatorABH());
		}

		return liste.getFirst();
	}

	/**
	 * 4.1 Faire une liste triée dont chaque élément est un arbreBinaire<br>
	 * comprenant un unique sommet dont l'étiquette est un couple
	 * <caractère, fréquence>, trié par fréquence croissante
	 * @param tableFrequences : table des fréquences des caractères
	 * @return		      la liste triée
	 */
	private static ListeABH faireListeAbinHuffman(int [] tableFrequences)
	{
		ListeABH liste = new ListeABH() ;

		for(int i=0;i<tableFrequences.length;i++)
		{
			if(tableFrequences[i]!=0)
			{
				Couple<Character, Integer> c = new Couple<Character, Integer>((char)i, tableFrequences[i]);

				ABinHuffman arbreTemp = new ABinHuffman();
				arbreTemp.setValeur(c);

				liste.add(arbreTemp);		  
			}
		} 

		Collections.sort(liste,new comparatorABH());
		return liste ;
	}



	/**
	 * 5. construire la table de codage correspondant à l'arbre de Huffman
	 * @param abinHuff : arbre de Huffman
	 * @return table de (dé)codage indicé par lex caractères
	 */
	public static String [] construireTableCodage(ABinHuffman abinHuff)
	{
		String[] tableResult = new String[nombreTotalCara];
		String code = "";
		if(!abinHuff.estVide())
		{
			construireTableCodage(abinHuff,code,tableResult);
		}
		return tableResult;
	}

	/**
	 * sera utilisé par la vraie fonction 
	 * @param abinHuff
	 * @param code
	 * @param table
	 */
	public static void construireTableCodage(ABinHuffman abinHuff,String code,String[] table)
	{
		if (abinHuff.estFeuille())
		{
			char c = abinHuff.getValeur().premier();
			table[c] = code;
		}

		if(abinHuff.existeGauche()) 
		{
			construireTableCodage(abinHuff.filsGauche(),code.concat("0"),table);
		}
		if(abinHuff.existeDroit())
		{
			construireTableCodage(abinHuff.filsDroit(), code.concat("1"),table);
		}
	}

	/**
	 * 5.1. Afficher la table de codage associée au texte
	 * @param tablecodage : table de codage associée au texte
	 */
	public static void afficherTableCodage(String [] tablecodage)
	{
		for(int i=0;i<tablecodage.length;i++)
		{
			if(tablecodage[i]==null)
			{
				//System.out.println((char)i + " : NULL");
			}
			else
			{
				System.out.println((char)i + " : "+tablecodage[i]);
			}
		}
	}

	/**
	 * 6. Coder un texte à l'aide de la table de codage
	 * @param texte à coder
	 * @param tablecodage : table de codage associée au texte
	 * @return texte codé
	 */
	public static StringBuilder coderTexte(char [] texte, String [] tablecodage)
	{
		StringBuilder result = new StringBuilder();
		for(int i=0;i<texte.length;i++)
		{
			result.append(tablecodage[(char)texte[i]]);
		}
		return result;
	}

	/**
	 * pour trier la liste
	 */
	public static class comparatorABH implements Comparator<ABinHuffman>
	{

		@Override
		public int compare(ABinHuffman o1, ABinHuffman o2) 
		{
			return o1.getValeur().deuxieme()-o2.getValeur().deuxieme();

		}	
	}
}// CodageHuffman
