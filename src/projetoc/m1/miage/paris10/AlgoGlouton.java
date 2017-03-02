package projetoc.m1.miage.paris10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MBM on 02/03/2017.
 */
public class AlgoGlouton {
    private Donnees donnees;
    private int[] rapportUtilitePoids;

    public AlgoGlouton(Donnees donnees) {
        this.donnees = donnees;
    }
    public void generateRapportWiPi(){
        int[] poids = donnees.getPoids();
        int[] utilites = donnees.getUtilites();
        int result;
        rapportUtilitePoids = new int[poids.length];
        for(int i = 0; i<rapportUtilitePoids.length; i++){
            result = utilites[i]/poids[i];
            rapportUtilitePoids[i]= result;
        }
    }
    public void TrierParRapportWiPi(){
        int tmpPi,tmpWi,tmpR; // variabes temporaires
        int[] poids = donnees.getPoids();
        int[] utilites = donnees.getUtilites();
        for(int i = 1; i<rapportUtilitePoids.length; i++){
            for(int j = 0; j<rapportUtilitePoids.length;j++){
                if(rapportUtilitePoids[j]<rapportUtilitePoids[i]){
                    tmpR = rapportUtilitePoids[j];
                    rapportUtilitePoids[j] = rapportUtilitePoids[i];
                    rapportUtilitePoids[i] = tmpR;
                    tmpPi = poids[j];
                    poids[j] = poids[i];
                    poids[i] = tmpPi;
                    tmpWi = utilites[j];
                    utilites[j] = utilites[i];
                    utilites[i] = tmpWi;
                }
            }
        }
        donnees.setPoids(poids);
        donnees.setUtilites(utilites);
    }
    public void afficheRapportWiPi(){
        System.out.println("");
        System.out.print("Wi/Pi\t");
        for (int i=0; i<rapportUtilitePoids.length;i++){
            System.out.print(rapportUtilitePoids[i]+"\t");
        }
    }
    public void remplirSacs(){
        int tailleMax = donnees.getPoids().length;
        int[] poids = donnees.getPoids();
        int[] utilites = donnees.getUtilites();
        List sac1 = new ArrayList<Integer>();
        List sac2 = new ArrayList<Integer>();
        int utiliteTotal,indice,objet=0;
        int Ps1=1, wisac1=0; // Poids total des objets dans le sac 1 et l'utilité total
        int Ps2=1, wisac2=0;
        for(int i=0; i<tailleMax;i++ ){
            if(Ps1 < donnees.getP() || Ps2 < donnees.getQ()){
                Ps1+=poids[i];
                if(Ps1<=donnees.getP()){
                    sac1.add(i+1);
                    wisac1+=utilites[i];
                }else {
                    Ps2+=poids[i];
                    if(Ps2 <= donnees.getQ()){
                        sac2.add(i+1);
                        wisac2+=utilites[i];
                    }
                }
            }
        }
        utiliteTotal = wisac1 + wisac2;
        System.out.println("");
        System.out.println("Utilité total des objets amenés : "+utiliteTotal);
        System.out.println("Les objets dans le sac 1");
        System.out.print("SAC 1 => \t");
        for(int i=0;i<sac1.size(); i++){
            System.out.print(sac1.get(i)+"\t");
        }
        System.out.println("");
        System.out.println("Les objets dans le sac 2");
        System.out.print("SAC 2 => \t");
        for(int i=0;i<sac2.size(); i++){
            System.out.print(sac2.get(i)+"\t");
        }
    }

}
