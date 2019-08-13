# Laboratorio 1 AREP


## Empezando

>Para clonar el archivo 

git clone https://github.com/nontoa/LAB1-AREP.git
>
### Prerrequisitos
* Maven
* Java
* Git


## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias

### Código para cálculos de la media y la desviación estandar.

```java
package edu.escuelaing.arep.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Calcular media y desviación estandar.
 */
public class App {    

    public static void main(String[] args) {
        read();
    }

    /**
     * Este método se encarga de leer los datos del archivo de texto y llama al método operation.     
     */
    public static void read() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("C:\\Users\\Nicolas\\Downloads\\Lab1-Arep\\src\\main\\java\\edu\\escuelaing\\arep\\ASE\\app\\prueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);            
            String linea;
            ArrayList<String> c1 = new ArrayList<String>();
            ArrayList<String> c2 = new ArrayList<String>();
            while ((linea = br.readLine()) != null) {                
                String[] parts = linea.split(" ");                                        
                c1.add(parts[0]);
                c2.add(parts[1]);                
            }
            operation(c1,c2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * Este método se encarga de realizar todas las operaciones correspondientes para calcular la media y la desviación estandar.
     * @param c1 Lista de números de la columna 1.
     * @param c2 Lista de números de la columna 2.
     */
    public static void operation(ArrayList<String> c1,ArrayList<String> c2){ 
        DecimalFormat df = new DecimalFormat("#.00");
        double promedio1=0;
        double promedio2=0;
        for(int x=0;x<c1.size();x++){
            promedio1+= Double.parseDouble(c1.get(x));
            promedio2+= Double.parseDouble(c2.get(x));            
        }        
        
        System.out.println("Mean Column1 " + df.format(promedio1/c1.size()));
        System.out.println("Mean Column2 " + df.format(promedio2/c2.size()));
        
        double numerador1=0;
        double numerador2=0;
        double result1=0;
        double result2=0;
        for(int x=0;x<c1.size();x++){
            numerador1+=Math.pow((Double.parseDouble(c1.get(x))-(promedio1/c1.size())),2);
            numerador2+=Math.pow((Double.parseDouble(c2.get(x))-(promedio2/c2.size())),2);
        }    
        
        result1= numerador1/(c1.size()-1);
        result2= numerador2/(c2.size()-1);                        
        
        System.out.println("Standart Deviation Column1 " + df.format(Math.sqrt(result1)));
        System.out.println("Standart Deviation Column2 " + df.format(Math.sqrt(result2)));
        
    }
}


```



## Autor


* **Juan Nicolas Nontoa Caballero**  LAB1-AREP - [nontoa] (https://github.com/nontoa)

## licencia

Este proyecto está licenciado bajo la Licencia GNU - vea el archivo [LICENSE](LICENSE) para más detalles.

