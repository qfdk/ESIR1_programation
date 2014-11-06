package rationnel;

import java.util.Arrays;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import types.Rationnel;

public class TestUnitaireRationnelCouple {

  @Test
  // test constructeur à un paramètre
  public void test_Constructeur1() {
    System.out.print("\nconstructeur à un paramètre : ");
    Rationnel r1 = new RationnelCouple(3);
    Assert.assertTrue(r1.getNumerateur() == 3);
    Assert.assertTrue(r1.getDenominateur() == 1);
    System.out.println("test réussi");
  }

  // test constructeur à 2 paramètres : cas d'un dénominateur nul
  @Test(expected = AssertionError.class)
  public void test_Constructeur2_EchecAssertion() {
    System.out.print("\nconstructeur à 2 paramètres : assertion dénominateur non nul");
    new RationnelCouple(3, 0);
  }

  @Test
  // test constructeur à 2 paramètres : divers cas
  public void test_Constructeur2() {
    System.out.print("\nconstructeur à 2 paramètres : vérifier simplifications : ");
    // simplification non nécessaire
    Rationnel r1 = new RationnelCouple(3, 1);
    Assert.assertTrue(r1.getNumerateur() == 3);
    Assert.assertTrue(r1.getDenominateur() == 1);
    // simplification obligatoire
    Rationnel r2 = new RationnelCouple(6, 2);
    Assert.assertTrue(r2.getNumerateur() == 3);
    Assert.assertTrue(r2.getDenominateur() == 1);
    // simplification et changement signe
    Rationnel r3 = new RationnelCouple(-21, -7);
    Assert.assertTrue(r3.getNumerateur() == 3);
    Assert.assertTrue(r3.getDenominateur() == 1);
    System.out.println("test réussi");
  }

  @Test
  // test constructeur de copie
  public void test_Constructeur3() {
    System.out.print("\nconstructeur de copie : vérifier égalité original/copie : ");    
    Rationnel r1 = new RationnelCouple(-21, -7);
    Rationnel r2 = new RationnelCouple(r1);
    Assert.assertTrue(r1.getNumerateur() == r2.getNumerateur() &&
		      r1.getDenominateur() == r2.getDenominateur());
    System.out.println("test réussi");
  }

  @Test
  public void testGetNumerateur() {
    System.out.print("\nvérifier getNumerateur : ");
    Rationnel r1 = new RationnelCouple(-21, -4);
    Assert.assertTrue(r1.getNumerateur() == 21);
    Rationnel r2 = new RationnelCouple(-21, -7);
    Assert.assertTrue(r2.getNumerateur() == 3);
    Rationnel r3 = new RationnelCouple(-5);
    Assert.assertTrue(r3.getNumerateur() == -5);
    System.out.println("test réussi");
  }

  @Test
  public void testGetDenominateur() {
    System.out.print("\nvérifier getDenominateur : ");
    Rationnel r1 = new RationnelCouple(-21, -4);
    Assert.assertTrue(r1.getDenominateur() == 4);
    Rationnel r2 = new RationnelCouple(-21, -7);
    Assert.assertTrue(r2.getDenominateur() == 1);
    Rationnel r3 = new RationnelCouple(-5);
    Assert.assertTrue(r3.getDenominateur() == 1);
    System.out.println("test réussi");
  }

  @Test
  // test de la méthode equals
  public void testEqualsRationnel() {
    System.out.print("\nTester égalité : ");
    Rationnel r1 = new RationnelCouple(-21, -7);
    Rationnel r2 = new RationnelCouple(r1);
  
    Assert.assertTrue(r1.equals(r2));
    Assert.assertTrue(r2.equals(r1));
  
    Rationnel r3 = new RationnelCouple(3);
    Assert.assertTrue(r1.equals(r3));
    Assert.assertTrue(r3.equals(r1));
  
    Rationnel r4 = new RationnelCouple(4);
    Assert.assertTrue(! r1.equals(r4));
    Assert.assertTrue(! r4.equals(r3));
    System.out.println("test réussi");
  }

  @Test
  // test de la somme de 2 rationnels
  public void testSomme() {
    System.out.print("\nTester somme : ");
    Rationnel r1 = new RationnelCouple(-21, -7);
    Rationnel r3 = new RationnelCouple(3);
    Rationnel somme = r1.somme(r3);
    Assert.assertTrue(somme.getNumerateur() == 6 && somme.getDenominateur() == 1);
  
    Rationnel r2 = new RationnelCouple(-3);
    somme = r2.somme(r1);
    Assert.assertTrue(somme.getNumerateur() == 0 && somme.getDenominateur() == 1);
    System.out.println("test réussi");
  }

  @Test(expected = AssertionError.class)
  // inversion d'une fraction de valeur 0
  public void testInverseEchecAssert() {
    System.out.print("\nTester inverse : assertion ...");
    Rationnel zero = new RationnelCouple(0);
    Rationnel inverse = zero.inverse();
  }

  @Test
  // inversion d'une fraction non nulle
  public void testInverse() {
    System.out.print("\nTester inverse : ");
    Rationnel r1 = new RationnelCouple(-21, -4);
    Rationnel inverse = r1.inverse();
    Assert.assertTrue(inverse.getNumerateur() == r1.getDenominateur() && 
		      inverse.getDenominateur() == r1.getNumerateur());
    System.out.println("test réussi");
  }

  @Test
  // valeur d'une fraction
  public void testValeur() {
    System.out.print("\nTester valeur d'une fraction : ");
    Rationnel r1 = new RationnelCouple(-21, -4);
    double val_r1 = r1.valeur();
    Assert.assertTrue(val_r1 == 5.25);
    System.out.println("test réussi");
  }

  @Test
  public void testCompareTo() {
    System.out.print("\nTester compareTo : ");
    Rationnel r1 = new RationnelCouple(-21, -4);
    Assert.assertTrue(r1.compareTo(r1) == 0);
    Rationnel r2 = new RationnelCouple(-21, -7);
    Assert.assertTrue(r1.compareTo(r2) > 0);
    Assert.assertTrue(r2.compareTo(r1) < 0);
    System.out.println("test réussi");
  }

  @Test
  public void inserer_tableau_vide() {
    System.out.print("\ninsertion dans un tableau vide              : ");
    // insertion dans un tableau vide
    Rationnel [] resu = new Rationnel[]{new RationnelCouple(1, 2)};

    Rationnel [] lesRationnels = new Rationnel[1];
    Rationnel r1 = new RationnelCouple(1, 2);
    clientRationnel.insererRationnel(r1, lesRationnels, 0);
    tester_egalite(lesRationnels, resu, 1);
    System.out.println("test réussi");
  }

  @Test
  public void inserer_tete_tableau_1elt() {
    System.out.print("\ninsertion en tête d'un tableau d'un élément : ");
    Rationnel [] resu = new Rationnel[]{new RationnelCouple(1, 3), new RationnelCouple(1, 2)};

    Rationnel [] lesRationnels = new Rationnel[2];
    lesRationnels[0] = new RationnelCouple(1, 2);
    clientRationnel.insererRationnel(new RationnelCouple(1, 3), lesRationnels, 1);
    tester_egalite(lesRationnels, resu, 2);
    
    System.out.println("test réussi");
  }

  @Test
  public void inserer_fin_tableau_1elt() {
    System.out.print("\ninsertion en fin  d'un tableau d'un élément : ");
    Rationnel [] resu = new Rationnel[]{new RationnelCouple(1, 3), new RationnelCouple(1, 2)};

    Rationnel [] lesRationnels = new Rationnel[2];
    lesRationnels[0] = new RationnelCouple(1, 3);
    clientRationnel.insererRationnel(new RationnelCouple(1, 2), lesRationnels, 1);
    tester_egalite(lesRationnels, resu, 2);
    
    System.out.println("test réussi");
  }

  @Test
  public void inserer_tete() {
    System.out.print("\ninsertion en tête                           : ");
    int [] numerateurs   = {
      15,14,13,12,11,10,9,8,7,6,
    };
    int [] denominateurs = {
      5,5,5,5,5,5,5,5,5,5,
    };
    Rationnel [] resu = new Rationnel[numerateurs.length];
    for (int i = 0 ; i < numerateurs.length;  ++i) {
      resu[resu.length - i - 1] = new RationnelCouple(numerateurs[i], denominateurs[i]);
    }

    // insérer
    Rationnel [] lesRationnels = new Rationnel[numerateurs.length];
    for (int i = 0; i < numerateurs.length; ++i) {
      clientRationnel.insererRationnel(new RationnelCouple(numerateurs[i], denominateurs[i]),
				       lesRationnels, i);
    }
    tester_egalite(lesRationnels, resu, numerateurs.length);
    System.out.println("test réussi");
  }

  @Test
  public void inserer_fin() {
    System.out.print("\ninsertion en fin                            : ");
    int [] numerateurs   = {
      15,14,13,12,11,10,9,8,7,6,
    };
    int [] denominateurs = {
      5,5,5,5,5,5,5,5,5,5,
    };
    Rationnel [] resu = new Rationnel[numerateurs.length];
    for (int i = 0 ; i < numerateurs.length;  ++i) {
      resu[resu.length - i - 1] = new RationnelCouple(numerateurs[i], denominateurs[i]);
    }

    // insérer
    Rationnel [] lesRationnels = new Rationnel[numerateurs.length];
    for (int i = numerateurs.length - 1; i >= 0; --i) {
      clientRationnel.insererRationnel(new RationnelCouple(numerateurs[i], denominateurs[i]),
				       lesRationnels, lesRationnels.length - i - 1);
    }
    tester_egalite(lesRationnels, resu, numerateurs.length);
    System.out.println("test réussi");
  }

  @Test
  public void inserer_partout() {
    System.out.print("\ninsertion partout                           : ");
    int [] numerateurs   = {
      15,3,-5,10,11,-6,-8,7,13,14,
    };
    int [] denominateurs = {
      5,5,5,5,5,5,5,5,5,5,
    };
    Rationnel [] resu = new Rationnel[numerateurs.length];
    int [] numerateurs_tris = Arrays.copyOf(numerateurs, numerateurs.length);
    Arrays.sort(numerateurs_tris);
    for (int i = 0 ; i < numerateurs_tris.length;  ++i) {
      resu[i] = new RationnelCouple(numerateurs_tris[i], denominateurs[i]);
    }

    // insérer
    Rationnel [] lesRationnels = new Rationnel[numerateurs.length];
    for (int i = 0 ; i < numerateurs.length;  ++i) {
      clientRationnel.insererRationnel(new RationnelCouple(numerateurs[i], denominateurs[i]),
				       lesRationnels, i);
    }
    tester_egalite(lesRationnels, resu, numerateurs.length);
    System.out.println("test réussi");
  }

  // vérifier l'égalité des nb premiers éléments de deux tableaux
  void tester_egalite(Rationnel [] t1, Rationnel [] t2, int nb) {
    for(int i = 0; i < nb; ++i) {
      Assert.assertTrue(t1[i].equals(t2[i]));
    }
  }
}