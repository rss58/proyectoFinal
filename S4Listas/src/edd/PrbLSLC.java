/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author Mauro
 */
public class PrbLSLC
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        LSLC ls =new LSLC();
        
        
        Nodo n1 = new Nodo(null, "7");
        Nodo n2 = new Nodo(null, "8");
        Nodo n3 = new Nodo(null, "1");
        Nodo n4 = new Nodo(null, "6");
        
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        
        ls.inserta(n1);
        System.out.println(ls.desp(ls.getR().getSig()));
        ls.inserta(n2);
        System.out.println(ls.desp(ls.getR().getSig()));
        ls.inserta(n3);
        System.out.println(ls.desp(ls.getR().getSig()));
        ls.inserta(n4);
        System.out.println(ls.desp(ls.getR().getSig()));
        
        System.out.println(ls.eliminar("4"));
        System.out.println(ls.desp(ls.getR()));
        System.out.println(ls.eliminar("9"));
        System.out.println(ls.desp(ls.getR()));
        System.out.println(ls.eliminar("6"));
        System.out.println(ls.desp(ls.getR()));
        System.out.println(ls.eliminar("7"));
        System.out.println(ls.desp(ls.getR()));
        System.out.println(ls.eliminar("1"));
        System.out.println(ls.desp(ls.getR()));
        System.out.println(ls.eliminar("8"));
        System.out.println(ls.desp(ls.getR()));
        
    }
    
}
