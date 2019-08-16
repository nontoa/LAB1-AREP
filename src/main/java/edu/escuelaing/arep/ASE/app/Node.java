/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.ASE.app;

/**
 *
 * @author 2137516
 */
class Node<T> {

    public Node anterior;    
    public Node siguiente;
    public T datos;

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
