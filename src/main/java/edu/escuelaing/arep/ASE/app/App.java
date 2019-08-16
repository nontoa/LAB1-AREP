package edu.escuelaing.arep.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
    }

    public static LinkedList<Double> read(String path)throws FileNotFoundException, IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        archivo = new File(path);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        String linea;
        LinkedList<Double> c1 = new LinkedList<Double>();
        while ((linea = br.readLine()) != null) {
            c1.add(Double.parseDouble(linea));
        }
        ArrayList<Double> op = new ArrayList<Double>();
        op = operation(c1);
        LinkedList<Double> respuesta = new LinkedList<Double>();
        respuesta.add(op.get(0));
        respuesta.add(op.get(1));
        return respuesta;

    }

    public static ArrayList<Double> operation(LinkedList<Double> c1) {        
        double promedio = 0;
        for (int x = 0; x < c1.size(); x++) {
            promedio += (c1.get(x));
        }

        //System.out.println("Mean Column " + df.format(promedio1/c1.size()));        
        double numerador1 = 0;
        double result1 = 0;
        for (int x = 0; x < c1.size(); x++) {
            numerador1 += Math.pow((c1.get(x) - (promedio / c1.size())), 2);

        }
        result1 = numerador1 / (c1.size() - 1);

        ArrayList<Double> ret = new ArrayList<Double>();
        ret.add(promedio/c1.size());
        ret.add(Math.sqrt(result1));
        return ret;
        //System.out.println("Standart Deviation Column1 " + df.format(Math.sqrt(result1)));        

    }
}
