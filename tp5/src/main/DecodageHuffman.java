package main;

import java.util.Scanner;

import types.ABinHuffman;
import outilsHuffman.OutilsHuffman;

/**
 * Réalisation du décodage d'un texte par la méthode de Huffman
 */

public class DecodageHuffman
{
	public static void main(String[] args)
	{
		// ------------------------------------------------------------------------
		// 0. Saisir le nom du fichier à décoder (À FAIRE)
		// ------------------------------------------------------------------------
		System.out.println("Donnez un nom de fichier:");
		// System.out.println(System.getProperty("user.dir"));
		Scanner s = new Scanner(System.in);
		String nomFichier = System.getProperty("user.dir") + "/donnees/"
				+ s.nextLine();
		// ------------------------------------------------------------------------
		// 1. Lire et construire la table de fréquences (DONNÉ)
		// ------------------------------------------------------------------------
		int[] tableFrequences = OutilsHuffman.lireTableFrequences(nomFichier);
		// ------------------------------------------------------------------------
		// 2. Construire l'arbre de Huffman (DONNÉ)
		// ------------------------------------------------------------------------
		ABinHuffman arbreHuffman = OutilsHuffman
				.construireArbreHuffman(tableFrequences);

		// ------------------------------------------------------------------------
		// 2.1 afficher l'arbre de Huffman (À FAIRE)
		// ------------------------------------------------------------------------
		System.out.println("Arbre de Huffman associé au texte " + nomFichier);
		afficherHuffman(arbreHuffman);

		// ------------------------------------------------------------------------
		// 3. Lire le texte codé (DONNÉ)
		// ------------------------------------------------------------------------
		String texteCode = OutilsHuffman.lireTexteCode(nomFichier);
		// ------------------------------------------------------------------------
		// 4. Décoder le texte (À FAIRE)
		// ------------------------------------------------------------------------
		StringBuilder texteDecode = decoderTexte(texteCode, arbreHuffman);

		// ------------------------------------------------------------------------
		// 5. Enregistrer le texte décode (DONNÉ)
		// ------------------------------------------------------------------------
		System.out.println("texte décodé:\n\n" + texteDecode);
		OutilsHuffman.enregistrerTexte(texteDecode, nomFichier + ".decode");
	}

	/**
	 * 4. décoder une chaîne (non vide) encodée par le codage de Huffman
	 * 
	 * @param texteCode : chaîne de "0/1" à décoder
	 * @param arbreHuffman : arbre de (dé)codage des caractères
	 */
	public static StringBuilder decoderTexte(String texteCode,
			ABinHuffman arbreHuffman)
	{
		StringBuilder sb=new StringBuilder();
		ABinHuffman arbreCourant=arbreHuffman;
		int cpt=0;
		
		while(cpt<texteCode.length())
		{
//			while(!arbreCourant.estFeuille())
//			{
				char binaire=texteCode.charAt(cpt);
				if(binaire=='0')
				{
					arbreCourant=arbreCourant.filsGauche();
				}else{
					arbreCourant=arbreCourant.filsDroit();
				}
//			}
				if(arbreCourant.estFeuille())
				{
					sb.append(arbreCourant.getValeur().premier());
					arbreCourant=arbreHuffman;
				}
				cpt++;
		}
		return sb;
	}

	/**
	 * 2.1 afficher un arbre de Huffman
	 * 
	 * @param a : arbre binaire de Huffman
	 */
	public static void afficherHuffman(ABinHuffman a)
	{
		if(a.estVide())
		{
			
		}else{
			System.out.println(a.getValeur().deuxieme());
			afficherHuffman(a.filsGauche());
			afficherHuffman(a.filsDroit());
		}
	}
} // DecodageHuffman
