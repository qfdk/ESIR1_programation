/*______________________________*/
/**
 * Rationnel.java : spécification du TA Rationnel
 */
package types;

/**
 * @author qfdk
 * Cree le 2014年10月21日
 */
/**
 * Rationnel.java : spécification du TA Rationnel
 */
public interface Rationnel extends Comparable<Rationnel> {

  /**
   * initialiser un rationnel à partir d'un entier : nb/1
   * @param num : valeur du numérateur
   */
  // public Rationnel(int num);

  /**
   * initialiser un rationnel avec numerateur et dénominateur
   * @param num : valeur du numérateur
   * @param den : valeur du dénominateur
   * @pre den != 0
   * @post fraction irréductible et dénominateur > 0
   */
  // public Rationnel(int num, int den):

  /**
   * initialiser un rationnel à partir d'un autre
   * @param r : rationnel à dupliquer
   */
  // public Rationnel(Rationnel r);

  /**
   * comparer (égalité) deux rationnels
   * @param r : rationnel à comparer au rationnel courant
   * @return vrai si le rationnel courant est égal au rationnel paramètre
   */
  public boolean equals(Rationnel r);

  /**
   * additionner deux rationnels
   * @param r : rationnel à additionner avec le rationnel courant
   * @return nouveau Rationnel somme du rationnel courant et du rationnel paramètre
   */
  public Rationnel somme(Rationnel r);

  /**
   * inverser le rationnel courant
   * @return nouveau Rationnel inverse du rationnel courant
   * @pre numérateur != 0
   */
  public Rationnel inverse();

  /**
   * calculer la valeur réelle du rationnel courant
   * @return valeur réelle du rationnel courant
   */
  public double valeur();

  /**
   *  @return représentation affichable d'un rationnel
   */
  public String toString();

  // accesseurs
  public int getNumerateur();   // consulter le numérateur
  public int getDenominateur(); // consulter le dénominateur

  // méthode de l'interface Comparable<Rationnel>
  public int compareTo(Rationnel autre);
}// Rationnel

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/