package projetoc.m1.miage.paris10;

import java.util.Random;

/**
 * Created by MBM on 23/02/2017.
 */
public class Donnees {
    private int[] poids;
    private int[] utilites;
    private int P; // Poids du sac 1
    private int Q; // Poids du sac 2

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
    public int sommePoids(){ // Somme des poids de tout les objets
        int pMax = 0, i;
        for(i=0;i<this.poids.length;i++){
            pMax+=poids[i];
        }
        return pMax;
    }
    public int PoidsMin(){ // Somme des poids de tout les objets
        int pMin = 10; // On initialise le poids min au poids max pouvant être générer
        for(int i=0;i<this.poids.length;i++){
            if(poids[i] < pMin){
                pMin = poids[i];
            }
        }
        return pMin;
    }
    public int generateP(){ // génère un nb aléatoire compris entre le poids min parmis les objets et le poids total
        int p, pMin, totalPoids;
        pMin = PoidsMin();
        totalPoids = sommePoids() - 4;
        Random rand = new Random();
        p = rand.nextInt(totalPoids - pMin + 1)+ pMin;
        return p;
    }
    public int generatePi(){
        int pi;
        Random rand = new Random();
        pi = rand.nextInt(9-1+1)+1; // Un entier compris entre 1 et 9
        while(pi%2 != 0){ // Tant que le nombre n'est pas paire
            pi = rand.nextInt(9-1+1)+1;
        }
        return pi;
    }
    public int generateWi(){
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
        int wi;
        for(int i=0; i<nbreObjet; i++){
             this.poids[i] = generatePi();
             this.utilites[i] = generateWi();
        }
        int P = generateP(); // Poids maximum pour le sac 1
        int Q = generateP(); // Poids maximum pour le sac 2
        this.P = P;
        this.Q = Q;
    }
    public void afficheDonnees(){
        int nbreObjet = this.poids.length;
        System.out.println("P = "+this.P+"\t"+"Q = "+this.Q);
        System.out.print("i\t\t");
        for (int i = 0; i<nbreObjet; i++){
            System.out.print(i+1 +"\t");
        }
        System.out.println("");
        System.out.print("Pi\t\t");
        for (int i = 0; i<nbreObjet; i++){
            System.out.print(poids[i]+"\t");
        }
        System.out.println("");
        System.out.print("Wi\t\t");
        for (int i = 0; i<nbreObjet; i++){
            System.out.print(utilites[i]+"\t");
        }
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    public int getQ() {
        return Q;
    }

    public void setQ(int q) {
        Q = q;
    }
}
