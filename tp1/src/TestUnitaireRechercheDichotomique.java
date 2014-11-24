import org.junit.Assert;
import org.junit.Test;

import tp1.src.TriDicho;

// tests recherche dichotomique
public class TestUnitaireRechercheDichotomique {

  public int AppelAlgo(int x, int [] t) {
    //------------------------------------------------
    // À modifier selon le nom de la classe à tester
    //------------------------------------------------
    return TriDicho.rechercheDichotomique(x, t, t.length);
  }

  //------------------------------------------------------------
  // normalement, rien à modifier plus bas
  //------------------------------------------------------------

  // 1. tableau vide
  @Test(timeout=2000)
  public void test_vide() {
    int [] tnb = { };
    System.out.print("\nrecherche dans un tableau vide				     : ");
    int res = AppelAlgo(-7, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 2.1 tableau d'un élément
  @Test(timeout=2000)
  public void test_1element_inferieur() {
    int [] tnb = { -7 };
    System.out.print("\nrecherche dans un tableau d'un élément (élt inférieur)	     : ");
    int res = AppelAlgo(-8, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 2.2 tableau d'un élément
  @Test(timeout=2000)
  public void test_1element_present() {
    int [] tnb = { -7 };
    System.out.print("\nrecherche dans un tableau d'un élément (élt présent)	     : ");
    int res = AppelAlgo(-7, tnb);
    Assert.assertTrue("0 attendu, " + res + " reçu", res == 0);
    System.out.println("Test réussi");
  }

  // 2.3 tableau d'un élément
  @Test(timeout=2000)
  public void test_1element_superieur() {
    int [] tnb = { -7 };
    System.out.print("\nrecherche dans un tableau d'un élément (élt supérieur)	     : ");
    int res = AppelAlgo(-6, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 3. élément cherché inférieur à tous les éléments du tableau
  @Test(timeout=2000)
  public void test_inferieur() {
    int [] tnb = {
      0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément inférieur à tous les éléments	     : ");
    int res = AppelAlgo(-7, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }


  // 4. élément cherché supérieur à tous les éléments du tableau
  @Test(timeout=2000)
  public void test_superieur() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément supérieur à tous les éléments	     : ");
    int res = AppelAlgo(1000, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 5. élément cherché absent (ni inférieur ni supérieur à tous les éléments du tableau)
  @Test(timeout=2000)
  public void test_absent_apres_premier() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément absent (après 1er)		     : ");
    int res = AppelAlgo(4, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 6. 
  @Test(timeout=2000)
  public void test_absent_quelconque() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément absent (position qque)		     : ");
    int res = AppelAlgo(651, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 7.
  @Test(timeout=2000)
  public void test_absent_avant_dernier() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément absent (avant dernier)		     : ");
    int res = AppelAlgo(940, tnb);
    Assert.assertTrue("-1 attendu, " + res + " reçu", res == -1);
    System.out.println("Test réussi");
  }

  // 8. élément cherché  = premier du tableau
  @Test(timeout=2000)
  public void test_present_premier() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément présent (le premier)		     : ");
    int res = AppelAlgo(0, tnb);
    Assert.assertTrue("0 attendu, " + res + " reçu", res == 0);
    System.out.println("Test réussi");
  }

  // 9. élément cherché  = dernier du tableau
  @Test(timeout=2000)
  public void test_present_dernier() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément présent (le dernier)		     : ");
    int res = AppelAlgo(946, tnb);
    Assert.assertTrue("" + (tnb.length - 1) + " attendu, " + res + " reçu", res == tnb.length - 1);
    System.out.println("Test réussi");
  }

  // 10. élément cherché présent à une position quelconque
  @Test(timeout=2000)
  public void test_present_quelconque() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément présent (position qque)		     : ");
    int res = AppelAlgo(23, tnb);
    Assert.assertTrue("49 attendu, " + res + " reçu", res == 49);
    System.out.println("Test réussi");
  }

  // 11. élément cherché présent plusieurs fois
  @Test(timeout=2000)
  public void test_present_plusieurs_fois() {
    int [] tnb = {
      0, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 18, 19, 20, 21, 21, 22, 22, 23, 24, 25, 27, 28, 29, 29, 30, 31, 35, 43, 45, 48, 51, 55, 77, 88, 88, 88, 482, 579, 609, 617, 650, 650, 669, 702, 725, 738, 778, 797, 802, 802, 802, 805, 813, 823, 830, 848, 871, 896, 921, 933, 946
    };
    System.out.print("\nrecherche d'un élément présent (plusieurs fois)		     : ");
    int res = AppelAlgo(13, tnb);
    Assert.assertTrue("13 <= r <= 29 et non " + res, 13 <= res && res <= 29);
    System.out.println("Test réussi");
  }
}
