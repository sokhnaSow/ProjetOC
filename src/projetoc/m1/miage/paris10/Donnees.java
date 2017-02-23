package projetoc.m1.miage.paris10;

import java.util.Random;

/**
 * Created by MBM on 23/02/2017.
 */
public class Donnees {
    private int[] poids;
    private int[] utilites;

    public Donnees(int[] poids, int[] utilites) {
        this.poids = poids;
        this.utilites = utilites;
    }

    public int[] getPoids() {
        return poids;
    }

    public void setPoids(int[] poids) {
        this.poids = poids;
    }

    public int[] getUtilites() {
        return utilites;
    }

    public void setUtilites(int[] utilites) {
        this.utilites = utilites;
    }
    public int genratePi(){
        int pi;
        Random rand = new Random();
        pi = rand.nextInt(9-1+1)+1; // Un entier compris entre 1 et 9
        while(pi%2 != 0){ // Tant que le nombre n'est pas paire
            pi = rand.nextInt(9-1+1)+1;
        }
        return pi;
    }
    public int genrateWi(){
        int wi;
        Random rand = new Random();
        wi = rand.nextInt(61-10+1)+10; // Un entier compris entre 10 et 61
        while(wi%2 != 0){ // Tant que le nombre n'est pas paire
            wi = rand.nextInt(61-10+1)+10;
        }
        return wi;
    }
    public void generateDonnees(){  // Rempli avec le poids et l'utilité de chaque objet
        int nbreObjet = this.poids.length; // Le nombre d'objets est égale à la taille du tableau
        for(int i=0; i<nbreObjet; i++){
             this.poids[i] = genratePi();
             this.utilites[i] = genrateWi();
        }
    }
    public void afficheDonnees(){
        int nbreObjet = this.poids.length;
        System.out.print("i\t");
        for (int i = 0; i<nbreObjet; i++){
            System.out.print(i+1 +"\t");
        }
        System.out.println("");
        System.out.print("Pi\t");
        for (int i = 0; i<nbreObjet; i++){
            System.out.print(poids[i]+"\t");
        }
        System.out.println("");
        System.out.print("Wi\t");
        for (int i = 0; i<nbreObjet; i++){
            System.out.print(utilites[i]+"\t");
        }
    }
}
