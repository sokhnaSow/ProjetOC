package projetoc.m1.miage.paris10;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mouna on 02/03/2017.
 */
public class RapportDonnees {

    public static void main(String [] args) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("ma feuille");

        HSSFRow rowtitre = sheet.createRow(0);
        rowtitre.createCell(0).setCellValue("Objets");
        rowtitre.createCell(1).setCellValue("Poids");
        rowtitre.createCell(2).setCellValue("Utilité");
        rowtitre.createCell(3).setCellValue("Resultat algo glouton");
        rowtitre.createCell(4).setCellValue("Resultat evalutaion par exces");



        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("C:\\\\Users\\\\mouna\\\\Desktop\\\\DonneesAleatoires.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
