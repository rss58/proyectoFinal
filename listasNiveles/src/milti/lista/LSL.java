/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milti.lista;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mauro
 */
public class LSL
{
    private Nodo r=null;

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }
    
    public boolean insertar(Nodo n)
    {
        if (n==null)
        {
            return false;
        } else
        {
            //el dato a insertar es el primero de la lista
            if (r==null)
            {
                r=n;
            } else
            {
                //el dato es menor al primer elemento de la lista
                if (n.getEtq().compareTo(r.getEtq())<0)
                {
                    n.setSig(r);
                    r=n;
                } else
                {
                    //el dato va en medio de la lista
                    Nodo aux=r;
                    boolean b=true;
                    while (aux.getSig() !=null && b)
                    {
                        if (n.getEtq().compareTo(aux.getSig().getEtq())<0)
                        {
                            n.setSig(aux.getSig());
                            aux.setSig(n);
                            b=false;
                        } else
                        {
                            aux=aux.getSig();
                        }
                    }
                    //el dato a insertar va al final de la lista
                    if (b)
                    {
                        aux.setSig(n);
                    }
                }
            }
            return true;
        }
    }
    
    public Nodo eliminar(String etq)
    {
        if (r==null)
        {
            return null;
        } else
        {
            Nodo aux=null;
            if(etq.compareTo(r.getEtq())>=0)
            {
                if (r.getEtq().equals(etq))
                {
                    aux=r;
                    r=aux.getSig();
                    aux.setSig(null);
                } else
                {
                    Nodo aux2=r;
                    boolean b=true;
                    while (aux2.getSig() !=null && b)
                    {
                        if(etq.compareTo(aux2.getSig().getEtq())>=0)
                        {
                            if (aux2.getSig().getEtq().equals(etq))
                            {
                                aux= aux2.getSig();
                                aux2.setSig(aux.getSig());
                                aux.setSig(null);
                                b=false;
                            } else
                            {
                                aux2=aux2.getSig();
                            }
                        }else
                        {
                            break;
                        }
                    }
                }
            }
            return aux;
        }
    }
    
    public String desp(Nodo aux)
    {
        String s="";
        while (aux !=null)
        {
            s+=aux.getEtq();
            aux=aux.getSig();
        }
        return s;
    }
}
