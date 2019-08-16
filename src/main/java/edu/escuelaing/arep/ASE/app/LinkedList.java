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
public class LinkedList<T> {
    
    public Head head;
    
    public LinkedList(){
        this.head = new Head(null,null);
    }
    
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
    
    public void add(T dato){
        Node nodo = new Node(null,null,dato);            
        if(head.getPrimero()==null){
            head.setPrimero(nodo);
            head.setUltimo(nodo);
        }
        else{
            if(head.getPrimero().getSiguiente()==null){
                head.getPrimero().setSiguiente(nodo);
            }
            else{
                head.getUltimo().setSiguiente(nodo);
                nodo.setAnterior(head.getUltimo());
                head.setUltimo(nodo);
            }
        }
    }
    
    public T get(int pos){
        if(pos>size()){
            throw new IndexOutOfBoundsException();
        }
        int c=0;
        Node nodo=head.getPrimero();
        while(pos!=c){
            nodo=nodo.getSiguiente();
            c++;
        }
        return (T)nodo.getDatos();
    }
    
    
    public int size(){
        Node nodo = head.getPrimero();
        int c=0;
        while(nodo!=null){
            nodo=nodo.getSiguiente();
            c++;
        }       
        return c;
    }

    
    
    
    
    
    
    
}
