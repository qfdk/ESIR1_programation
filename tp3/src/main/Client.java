/*______________________________*/
/**
 * 
 */
package main;
import types.Tableau;
import tableau.Block;
import tableau.Tableau2x;
import tableau.TableauBlock;
/**
 * @author qfdk
 * Cree le 2014年11月17日
 */
enum TypeTableau { Block, Tableau2x, TableauBlock }

// Programme minimal de test des classes Block, Tableau2x et TableauBlock
public class Client
{
  public static void main(String[] yzgrefiuahre)
  {
    int[] t1 = { 35, 15, 10, 50, 20, 40, 37, 18, 16, 45, 60, 44, 47, 70, 80,
		 25, 49, 36, 48, 43, 35, 15, 50, 7, 20, 25, 3, 5, 6, 18, 17, 40, 70, 37,
		 8, 45, 43, 46, 47, 48, 60, 80 };
    System.out.println("Taille de t1 = " + t1.length);

    int[] t2 = { 80, 5, 70, 15, 60, 15, 50, 18, 45, 20, 45, 35, 43, 37, 40, 40,
		 50, 750, 300, 520, 100, 80, 20, 200, 50, 200, 300, 120, 500, 45, 45,
		 -1, -1, 0 };
    System.out.println("Taille de t2 = " + t2.length);

    // Tester les tableaux de type Block
    System.out.println("\n----------------------------------------------------------------");
    System.out.println("Test Block");
    System.out.println("----------------------------------------------------------------");
    //testerTableau(t1, t2, TypeTableau.Block);

    // Tester les tableaux de type Tableau2x
    System.out.println("\n----------------------------------------------------------------");
    System.out.println("Test Tableau2x");
    System.out.println("----------------------------------------------------------------");
    testerTableau(t1, t2, TypeTableau.Tableau2x);

    // Tester les tableaux de type TableauBlock
    System.out.println("\n----------------------------------------------------------------");
    System.out.println("Test TableauBlock");
    System.out.println("----------------------------------------------------------------");
 //   testerTableau(t1, t2, TypeTableau.TableauBlock);
  }

  // t1 et t2 : deux tableaux de nombres
  // ttablo : type de tableau à tester (Block, Tableau2x, TableauBlock)
  static void testerTableau(int[] t1, int[] t2, TypeTableau ttablo)
  {
    // Mettre les élts de t1 dans un tableau
    System.out.println("Tester ajout en fin (push_back)");
    Tableau<Integer> b1 = creerTableau(ttablo, t1.length);

    for (int i = 0; i < t1.length; ++i) { b1.push_back(t1[i]); }
    afficher(b1);
    if (equals(t1, b1)) { System.out.println("[OK] Init Tableau \n"); }
    else		{ System.err.println("[ÉCHEC] *** Init Tableau ***\n"); }

    // Mettre les élts de t2 dans un tableau
    Tableau<Integer> b2 = creerTableau(ttablo, t2.length);

    for (int i = 0; i < t2.length; ++i) { b2.push_back(t2[i]); }
    afficher(b2);
    if (equals(t2, b2)) { System.out.println("[OK] Init Tableau "); }
    else		{ System.err.println("[ÉCHEC] *** Init Tableau ***"); }

    // concaténer les 2 (teste full et agrandissement)
    System.out.println("\nConcaténer les 2");
    Tableau<Integer> tconc = creerTableau(ttablo, b1.size() + b2.size());

    concat(b1, b2, tconc);
    afficher(tconc);
    int[] tc = concat(t1, t2);
    if (equals(tc, tconc)) { System.out.println("[OK] Concaténation "); }
    else		   { System.err.println("[ÉCHEC] *** Concaténation ***"); }
    int tailleConc = tconc.size();

    // éliminer certains éléments (teste set)
    System.out.println("\nÉliminer du dernier tableau les multiples de 5");
    int nbelim = filtrer(tconc, 5);
    System.out.println(nbelim + " nombres éliminés");
    afficher(tconc);
    int[] tf = filtrer(tc, 5);
    if (equals(tf, tconc)) { System.out.println("[OK] Filtrage "); }
    else		   { System.err.println("[ÉCHEC] *** Filtrage ***"); }
    int tailleFiltre = tconc.size();

    // ajouter les élts en triple
    System.out.println("\nRemettre les élts de b1 (en triple) dans le tableau");
    for (int i = 0; i < b1.size() && !tconc.full(); ++i) {
      tconc.push_back(b1.get(i));
      if (!tconc.full()) { tconc.push_back(b1.get(i)); }
      if (!tconc.full()) { tconc.push_back(b1.get(i)); }
    }
    afficher(tconc);

    int[] ta;
    if (ttablo == TypeTableau.Block) { ta = ajouter(tf, b1, tconc.size()); }
    else			     { ta = ajouter(tf, b1); }
    // vérifier la taille des tableaux après ajout
    if (tconc.full() && tconc.size() != Math.min(tailleConc, 3 * b1.size())) {
      System.err.println("[ÉCHEC] *** taille Ajout : " + tconc.size() + " != "
			 + Math.min(tailleConc, 3 * b1.size()) + " ***");
    } else if (!tconc.full() && tconc.size() != tailleFiltre + 3 * b1.size()) {
      System.err.println("[ÉCHEC] *** taille Ajout : " + tconc.size() + " != "
			 + (tailleFiltre + 3 * b1.size()) + " ***");
    }
    System.out.println("Vérification égalité éléments");
    if (equals(ta, tconc)) { System.out.println("[OK] Ajout "); }
    else		   { System.err.println("[ÉCHEC] *** Ajout ***"); }

    // afficher le tableau filtré à l'envers (teste pop et empty)
    afficherVider(tconc);
  }

  // ------------------------------------------------------------------------
  // opérations tableaux
  // ------------------------------------------------------------------------
  // afficher un Tableau
  // teste get, size
  public static <T> void afficher(Tableau<T> t) {
    System.out.println("Taille du tableau : " + t.size());
    for (int i = 0; i < t.size(); ++i) {
      System.out.print(t.get(i) + " ");
    }
    System.out.println();
  }

  // égalité d'1 tableau java et d'un Tableau
  // teste get, size
  static boolean equals(int[] t, Tableau<Integer> tab) {
    boolean erreurTaille = false;
    if (t.length != tab.size()) {
      System.err.println("[ÉCHEC] *** tailles : " + t.length + " != " + tab.size() + " ***");
      erreurTaille = true;
    }
    if (!erreurTaille) {
      System.out.println("Tailles identiques");
    }
    boolean erreurValeurs = false;
    int tailleMin = Math.min(t.length, tab.size());
    for (int i = 0; i < tailleMin; ++i) {
      if (t[i] != tab.get(i)) {
	System.err.println("** t[" + i + "] != tab.get(" + i + ")");
	erreurValeurs = true;
      }
    }
    if (!erreurValeurs) {
      System.out.println("Les " + tailleMin + " éléments de tête sont identiques");
    }
    return !(erreurTaille || erreurValeurs);
  }

  // concaténer deux tableaux java
  static int[] concat(int[] t1, int[] t2) {
    int[] c = new int[t1.length + t2.length];
    for (int i = 0; i < t1.length; ++i) {
      c[i] = t1[i];
    }
    for (int i = 0; i < t2.length; ++i) {
      c[i + t1.length] = t2[i];
    }
    return c;
  }

  // éliminer d'un tableau java les multiples de val
  static int[] filtrer(int[] t, int val) {
    int taille = t.length;
    for (int i = t.length - 1; i >= 0; --i) {
      if (t[i] % val == 0) {
	t[i] = t[taille - 1]; // remplacer par le dernier
	--taille;
      }
    }
    int[] f = new int[taille];
    for (int i = 0; i < taille; ++i) {
      f[i] = t[i];
    }
    return f;
  }

  // ajouter 3 fois les élts de b à t
  static int[] ajouter(int[] t, Tableau<Integer> b) {
    int[] ta = new int[t.length + 3 * b.size()];
    int i = 0;
    for (; i < t.length; ++i) {
      ta[i] = t[i];
    }
    for (int j = 0; j < b.size(); ++j) {
      ta[i++] = b.get(j);
      ta[i++] = b.get(j);
      ta[i++] = b.get(j);
    }
    return ta;
  }

  // idem ci-dessus sans dépasser nbmax
  static int[] ajouter(int[] t, Tableau<Integer> b, int nbmax) {
    int[] ta = new int[nbmax];
    int i = 0;
    for (; i < t.length && i < nbmax; ++i) {
      ta[i] = t[i];
    }
    for (int j = 0; j < b.size() && i < nbmax; ++j) {
      ta[i++] = b.get(j);
      ta[i++] = b.get(j);
      ta[i++] = b.get(j);
    }
    return ta;
  }

  /**
   * Concaténer les éléments de deux Tableaux
   * @return nouveau tableau résultat de la concaténation
   */
  public static <T> Tableau<T> concat(Tableau<T> t1, Tableau<T> t2,
				      Tableau<T> tconc) {
    // copier les éléments de t1
    for (int i = 0; i < t1.size() && !tconc.full(); ++i) {
      tconc.push_back(t1.get(i));
    }
    // copier les éléments de t2
    for (int i = 0; i < t2.size() && !tconc.full(); ++i) {
      tconc.push_back(t2.get(i));
    }
    return tconc;
  }

  /**
     éliminer d'un Tableau les multiples de val
     @return nombre d'éléments éliminés
     test get, set, size
  */
  static int filtrer(Tableau<Integer> t, Integer val) {
    int nbelim = 0;
    for (int i = t.size() - 1; i >= 0; --i) {
      if (t.get(i) % val == 0) {
	++nbelim;
	t.set(i, t.get(t.size() - 1)); // remplacer par le dernier
	t.pop_back();
      }
    }
    return nbelim;
  }

  // Afficher à l'envers un tableau en le vidant de ses éléments
  // teste empty, size, pop_back
  static <T> void afficherVider(Tableau<T> t) {
    System.out.println("\nAfficher à l'envers");
    while (!t.empty()) {
      System.out.print(t.get(t.size() - 1) + " ");
      t.pop_back();
    }
    System.out.println();
    if (t.size() != 0) {
      System.err.println("[ÉCHEC] *** taille Vidage " + t.size() + " != 0 ***");
    } else {
      System.out.println("[OK] Vidage ");
    }
  }

  // créer un tableau en utilisant si besoin la capacité indiqué 
  // ttablo a l'une des valeurs { Block, Tableau2x, TableauBlock }
  static <T> Tableau<T> creerTableau(TypeTableau ttablo, int capacite) {
    if	    (ttablo == TypeTableau.Block)	 { return new Block<T>(capacite); }
    else if (ttablo == TypeTableau.Tableau2x)	 { return new Tableau2x<T>(5); }
    else if (ttablo == TypeTableau.TableauBlock) { return new TableauBlock<T>(5); }
    else {
      // ce cas ne devrait pas se produire
      assert false : "Erreur : ttablo doit avoir l'une des 3 valeurs { Block, Tableau2x, TableauBlock }";
      return null;
    }
  }


} // fin Test

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/