package edu.escuelaiing.arep.ASE.app;

import edu.escuelaing.arep.ASE.app.App;
import edu.escuelaing.arep.ASE.app.LinkedList;
import java.io.IOException;
import java.text.DecimalFormat;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Prueba de la funcionalidad con conjunto de datos numero 1.
     */
    public void testApp1() throws IOException
    {
        LinkedList<Double> respuesta = App.read("C:\\Users\\Nicolas\\Downloads\\LAB1-AREP\\src\\main\\java\\edu\\escuelaing\\arep\\ASE\\app\\prueba1.txt");
        DecimalFormat round= new DecimalFormat("#.00");                
        assertEquals(round.format(respuesta.get(0)),"550,60");
        assertEquals(round.format(respuesta.get(1)),"572,03");
       
    }
    
    /**
     * Prueba de la funcionalidad con conjunto de datos numero 2.
     */
    public void testApp2() throws IOException
    {
        LinkedList<Double> respuesta = App.read("C:\\Users\\Nicolas\\Downloads\\LAB1-AREP\\src\\main\\java\\edu\\escuelaing\\arep\\ASE\\app\\prueba2.txt");
        DecimalFormat round= new DecimalFormat("#.00");                
        assertEquals(round.format(respuesta.get(0)),"60,32");
        assertEquals(round.format(respuesta.get(1)),"62,26");
    }
    
    /**
     * Prueba de la funcionalidad con conjunto de datos numero 3.
     */
    public void testApp3() throws IOException
    {
        LinkedList<Double> respuesta = App.read("C:\\Users\\Nicolas\\Downloads\\LAB1-AREP\\src\\main\\java\\edu\\escuelaing\\arep\\ASE\\app\\prueba3.txt");
        DecimalFormat round= new DecimalFormat("#.00");           
        assertEquals(round.format(respuesta.get(0)),"625,19");
        assertEquals(round.format(respuesta.get(1)),"1638,76");
    }
    
    /**
     * Prueba de la funcionalidad con conjunto de datos numero 4.
     */
    public void testApp4() throws IOException
    {
        LinkedList<Double> respuesta = App.read("C:\\Users\\Nicolas\\Downloads\\LAB1-AREP\\src\\main\\java\\edu\\escuelaing\\arep\\ASE\\app\\prueba4.txt");
        DecimalFormat round= new DecimalFormat("#.00");      
        System.out.println(round.format(respuesta.get(0)));
        System.out.println(round.format(respuesta.get(1)));
        assertEquals(round.format(respuesta.get(0)),"509,44");
        assertEquals(round.format(respuesta.get(1)),"2006,39");
    }
}
