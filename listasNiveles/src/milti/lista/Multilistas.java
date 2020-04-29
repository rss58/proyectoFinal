package milti.lista;

/**
 *
 * @author manue
 */
public class Multilistas
{

  
    public static Nodo inserta(Nodo r, Nodo n, int nivel, String etqs[])
    {
        if (nivel == etqs.length - 1)
        {
            LSL ls = new LSL();
            ls.setR(r);
            ls.insertar(n);
            r = ls.getR();
            return r;
        } else
        {
            Nodo aux = busca(r, etqs[nivel]);
            if (aux != null)
            {
                aux.setAnt(inserta(aux.getAnt(), n, nivel + 1, etqs));
            } else
            {
                System.out.println("no encontre" + etqs[nivel] + " en el nivel " + nivel);
            }
            return r;
        }
    }
    
    
    
    
    public static Nodo busca(Nodo r, String e)
    {
        Nodo aux = null;
        while (r != null)
        {
            if (r.getEtq().equals(e))
            {
                aux = r;
                break;
            } else
            {
                r = r.getSig();
            }
        }
        return aux;
    }

    public static Nodo[] eliminar(Nodo r, int nivel, String etqs[], Nodo er[])
    {
        if (nivel == etqs.length - 1)
        {
            LSL ls = new LSL();
            ls.setR(r);
            er[1] = ls.eliminar(etqs[nivel]);
            r = ls.getR();
            er[0] = r;
            return er;
        } else
        {
            Nodo aux = busca(r, etqs[nivel]);
            if (aux != null)
            {
                aux.setAnt(eliminar(aux.getAnt(), nivel + 1, etqs, er)[0]);
            } else
            {
                System.out.println("No encontre: " + etqs[nivel] + " en el nivel " + nivel);
            }
            er[0] = r;
            return er;
        }
    }

    public static String despM(Nodo aux)
    {
        String s = "";
        while (aux != null)
        {
            s += aux.getEtq();
            aux = aux.getSig();
        }
        return s;
    }

}
