package test;

import tableau.Block;
import types.Tableau;

public class TU_NombresPremiersBlock extends ATU_NombresPremiers {

  // création de tableau
  public Tableau<Integer> makeTableau(int capinit) {
    return new Block<Integer>(capinit);
  }

  // Fonctions à tester : À changer selon signature

  boolean estPremier(int n, Tableau<Integer> nombresPremiers) {
    return main.NombresPremiers.estPremier(n, nombresPremiers);
  }
  int calculerNombresPremiers(int N, Tableau<Integer> nombresPremiers) {
    return main.NombresPremiers.calculerNombresPremiers(N, nombresPremiers);
  }
  Tableau<Integer> remplirHasard(int nb) {
    return main.NombresPremiers.remplirHasard(nb);
  }
  int eliminerPremiers(Tableau<Integer> t, Tableau<Integer> nombresPremiers) {
    return main.NombresPremiers.eliminerPresents(t, nombresPremiers);
  }
}
