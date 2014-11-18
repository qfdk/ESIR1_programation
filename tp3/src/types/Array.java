package types;
/**
 * Array : tableau dont les éléments sont d'un type générique T<br>
 *
 * Created: Thu May 31 15:26:10 2007
 *
 * @author <a href="mailto:Jean-Christophe.Engel@irisa.fr">Jean-Christophe Engel</a>
 * @version 1.0
 */

public class Array<T> {

  /**
   * Initialise une nouvelle instance de <code>Array</code>.
   * @param capacite : capacité (nombre de "cases") du tableau
   *
   */
  public Array(int capacite) {
    tablo = (T []) new Object[capacite];
  }

  /**
   * Initialise une nouvelle instance de <code>Array</code> à partir d'un tableau classique.
   * @param t : tableau qui sert à initialiser la nouvelle instance
   */
  public Array(T ... t) {
    tablo = (T []) new Object[t.length];
    for (int i = 0; i < t.length; ++i) {
      tablo[i] = t[i];
    }
  }
 /**
   * Donne la capacité du tableau
   * @return nombre de "cases" du tableau
   */
  public int length() {
    return tablo.length;
  }

  /**
   * Donne l'élément d'indice i
   * @param i : indice de l'élément à consulter
   * @pre 0 <= i < this.length()
   * @return valeur de l'élément d'indice i
   */
  public T get(int i) {
    return tablo[i];
  }

  /**
   * Modifie l'élément d'indice i
   * @param i : indice de l'élément à modifier
   * @pre 0 <= i < this.length()
   * @param v : nouvelle valeur de l'élément d'indice i
   */
  public void set(int i, T v) {
    tablo[i] = v;
  }

  // représentation
  private T [] tablo;				// le tableau

} // Array<T>
