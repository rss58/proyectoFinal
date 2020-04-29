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
    
    public boolean inserta(Nodo n)
    {
        if (n==null)
        {
            return false;
        } else
        {
            //el primero en la lista
            if (r==null)
            {
                r=n;
            } else
            {
                //menor al primero de la lista
                if (n.getEtq().compareTo(r.getEtq())<0)
                {
                    n.setSig(r);
                    r=n;
                } else
                {
                    //cuando el dato va en medio de la lista
                    Nodo aux=r;
                    boolean b=true;
                    while (aux.getSig()!=null && b)
                    {
                        if(n.getEtq().compareTo(aux.getSig().getEtq())<0)
                        {
                            n.setSig(aux.getSig());
                            aux.setSig(n);
                            b=false;
                        }else
                        {
                            aux=aux.getSig();
                        }
                    }
                    //va al final de la lista
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
                    r=r.getSig();
                    aux.setSig(null);
                } else
                {
                    Nodo aux2=r;
                    boolean b=true;
                    while (aux2.getSig() != null && b)
                    {
                        if (aux2.getSig().getEtq().equals(etq))
                        {
                            aux=aux2.getSig();
                            aux2.setSig(aux.getSig());
                            aux.setSig(null);
                            b=false;
                        } else
                        {
                            aux2=aux2.getSig();
                        }
                    }
                }  
            }
            return aux;
        }
    }
    
    public String desp(Nodo r)
    {
        String s="";
        while (r!=null)
        {
            s+=r.getEtq();
            r=r.getSig();
        }
        return s;
    }
}
