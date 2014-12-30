package main;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import types.ABinHuffman;
import outilsHuffman.OutilsHuffman;

/**
 * Réalisation du décodage d'un texte par la méthode de Huffman
 */

public class DecodageHuffman
{
	@SuppressWarnings("javadoc")
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
		
		enregistrerTexte(texteDecode, nomFichier + ".decode");
	}

	/**
	 * 4. décoder une chaîne (non vide) encodée par le codage de Huffman
	 * 
	 * @param texteCode : chaîne de "0/1" à décoder
	 * @param arbreHuffman : arbre de (dé)codage des caractères
	 * @return le text
	 */
	public static StringBuilder decoderTexte(String texteCode,
			ABinHuffman arbreHuffman)
	{
		StringBuilder sb = new StringBuilder();
		ABinHuffman arbreCourant = arbreHuffman;
		int cpt = 0;

		while (cpt < texteCode.length())
		{
			char binaire = texteCode.charAt(cpt);
			if (binaire == '0')
			{
				arbreCourant = arbreCourant.filsGauche();
			} else
			{
				arbreCourant = arbreCourant.filsDroit();
			}
			if (arbreCourant.estFeuille())
			{
				sb.append(arbreCourant.getValeur().premier());
				arbreCourant = arbreHuffman;
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
		List<String> tableResult = new ArrayList<String>();
		String code = "";
		if (!a.estVide())
		{
			construireAffichage(a, code, tableResult);
		}

		for (String s : tableResult)
		{
			if (!s.equals(null))
			{
				System.out.println(s);
			}
		}

	}

	/**
	 * une fonction pour affichers
	 * @param abinHuff
	 * @param code
	 * @param table
	 */
	public static void construireAffichage(ABinHuffman abinHuff, String code,
			List<String> table)
	{
		if (abinHuff.estFeuille())
		{
			char c = abinHuff.getValeur().premier();
			table.add("<" + c + "," + abinHuff.getValeur().deuxieme()
					+ ">  :  " + code);
		}

		if (abinHuff.existeGauche())
		{
			construireAffichage(abinHuff.filsGauche(), code.concat("0"), table);
		}
		if (abinHuff.existeDroit())
		{
			construireAffichage(abinHuff.filsDroit(), code.concat("1"), table);
		}
	}

	/**
	 * mon enrgistre
	 * 
	 * @param texte
	 * @param nomFichierDecode
	 */
	public static void enregistrerTexte(StringBuilder texte,
			String nomFichierDecode)
	{
		try
		{
			Writer sortie = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(nomFichierDecode), "ISO-8859-1"));
			sortie.write(texte.toString());
			sortie.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("fichier non trouvé : " + e.getMessage());
		} catch (UnsupportedEncodingException e)
		{
			System.out.println(" l'encodage du texte n'est pas reconnu : "
					+ e.getMessage());
		} catch (IOException e)
		{
			System.out.println("erreur d'entrée/sortie : " + e.getMessage());
		}
	}
}
// DecodageHuffman
