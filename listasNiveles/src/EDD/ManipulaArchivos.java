/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

import Ventanas.vtnChat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;

/**
 *
 * @author josea
 */
public class ManipulaArchivos {
    
    public static void guardar(ColaDinamica colaProductos,  JFrame jf) throws FileNotFoundException
    {

        try
        {
            FileOutputStream fos = new FileOutputStream("datos.dat");
            ObjectOutputStream arch = new ObjectOutputStream(fos);

           
            arch.writeObject(colaProductos);
           
            arch.close();
        } catch (FileNotFoundException ex)
        {
//            Mensaje.error(jf, "No se encontro el archivo");
        } catch (Exception er)
        {
//            Mensaje.error(jf, "Error..." + er.toString());
        }
    }

    public static void carga(JFrame jf) throws IOException, ClassNotFoundException
    {
        try
        {
            FileInputStream fis = new FileInputStream("datos.dat");
            ObjectInputStream arch = new ObjectInputStream(fis);

           
            //
            vtnChat.cd = (ColaDinamica) arch.readObject();
            

            arch.close();
            
        } catch (FileNotFoundException ex)
        {
//            Mensaje.error(jf, "No se encontró el archivo para carga");
        } catch (Exception er)
        {
//            Mensaje.error(jf, "Error..." + er.toString());
        }
    }
    
}
