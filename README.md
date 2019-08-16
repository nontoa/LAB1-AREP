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

## Código encargado para operaciones lógicas.

```java
package edu.escuelaing.arep.ASE.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Esta clase se encarga de las operaciones logicas.
 * @author Nicolas Nontoa.
 */
public class App {

    public static void main(String[] args) {
    }

    /**
     * Este metodo se encarga de leer los datos y crear el linkedList correspondiente.
     * @param path Es la ruta para los archivos de prueba.
     * @return Retorna un LinkedList con las respuestas.
     * @throws FileNotFoundException Error al encontrar el archivo.
     * @throws IOException Error en Input/Output.
     */
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

    /**
     * Este metodo se encarga de realizar las operaciones para hayar la media y la desviacion estandar.
     * @param c1 Es el LinkedList con los datos.
     * @return Retorna Un ArrayList con las respuestas.
     */
    public static ArrayList<Double> operation(LinkedList<Double> c1) {        
        double promedio = 0;
        for (int x = 0; x < c1.size(); x++) {
            promedio += (c1.get(x));
        }        
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

    }
}

```
## Código implementación de LinkedList.
### Clase LinkedList:
```java
package edu.escuelaing.arep.ASE.app;

/**
 * Esta clase representa la implementación de un LinkedList.
 * @author Nicolas Nontoa.
 */
public class LinkedList<T> {

    private Head head;

    /**
     * Constructor de la clase.
     */
    public LinkedList() {
        this.head = new Head(null, null);
    }

    
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    /**
     * Este metodo se encarga de adicionar elementos al LinkedList.
     * @param dato Es el valor del nodo a ingresar.
     */
    public void add(T dato) {
        Node nodo = new Node(null, null, dato);
        if (head.getPrimero() == null) {
            head.setPrimero(nodo);
            head.setUltimo(nodo);
        } else {
            if (head.getPrimero().getSiguiente() == null) {
                head.getPrimero().setSiguiente(nodo);
            }

            head.getUltimo().setSiguiente(nodo);
            nodo.setAnterior(head.getUltimo());
            head.setUltimo(nodo);

        }
    }

    /**
     * Este método se encarga de devolver el valor de una posicion especifica del nodo.
     * @param pos Es la posicion de la cual yo quiero saber el valor.
     * @return Retorna el valor del LinkedList en esa posicion.
     */
    public T get(int pos) {
        if (pos > size()) {
            throw new IndexOutOfBoundsException();
        }
        int c = 0;
        Node nodo = head.getPrimero();
        while (pos != c) {
            nodo = nodo.getSiguiente();
            c++;
        }
        return (T) nodo.getDatos();
    }

    /**
     * Este metodo se encarga de calcular el tamaño del LinkedList.
     * @return Retorna el tamaño del LinkedList.
     */
    public int size() {
        Node nodo = head.getPrimero();
        int c = 0;
        while (nodo != null) {
            nodo = nodo.getSiguiente();
            c++;
        }
        return c;
    }

}
```
### Clase Node:

```java
package edu.escuelaing.arep.ASE.app;

/**
 * Esta clase representa el nodo del LinkedList.
 * @author Nicolas Nontoa.
 */
class Node<T> {

    public Node anterior;    
    public Node siguiente;
    public T datos;

    /**
     * Constructor de la clase
     * @param a Nodo anterior.
     * @param s Nodo siguiente.
     * @param d Valor del nuevo nodo.
     */
    public Node(Node a, Node s, T d) {
        this.anterior = a;
        this.siguiente = s;
        this.datos = d;
    }
    
    public Node getAnterior() {
        return anterior;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }

    public Node getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }

    public T getDatos() {
        return datos;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }
}
```
### Clase Head:
```java
package edu.escuelaing.arep.ASE.app;

/**
 * Esta clase representa la cabeza del LinkedList.
 * @author Nicolas Nontoa.
 */
class Head {
    
    public Node primero;
    public Node ultimo;
    
    /**
     * Constructor de la clase.
     * @param p Valor para el primer nodo.
     * @param u Valor para el ultimo nodo.
     */
    public Head(Node p,Node u){
        this.primero=p;
        this.ultimo=u;
    }

    public Node getPrimero() {
        return primero;
    }

    public void setPrimero(Node primero) {
        this.primero = primero;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void setUltimo(Node ultimo) {
        this.ultimo = ultimo;
    } 
}
```

## Autor


* **Juan Nicolas Nontoa Caballero**  LAB1-AREP - [nontoa] (https://github.com/nontoa)

## licencia

Este proyecto está licenciado bajo la Licencia GNU - vea el archivo [LICENSE](LICENSE) para más detalles.

