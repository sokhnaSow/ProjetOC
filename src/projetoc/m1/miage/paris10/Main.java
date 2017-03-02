package projetoc.m1.miage.paris10;

/**
 * Created by MBM on 23/02/2017.
 */
public class Main {
    public static void main(String[] args){
        int[] poids = new int[6];
        int[] utilite = new int[6];
        Donnees donnees = new Donnees(poids,utilite);
        donnees.generateDonnees();
        AlgoGlouton glouton = new AlgoGlouton(donnees);
        glouton.generateRapportWiPi();
        glouton.TrierParRapportWiPi();
        donnees.afficheDonnees();
        glouton.afficheRapportWiPi();
        glouton.remplirSacs();

    }
}
