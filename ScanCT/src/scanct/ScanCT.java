/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanct;
<<<<<<< HEAD

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



=======
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
>>>>>>> e984f57eeeba7e49564299c93379a22b2fb1530d
/**
 *
 * @author enriquedg
 */
public class ScanCT {
 List<ObDocumento> listaDocs = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD
    //clasificar(){
public ScanCT(){}
 
Configuracion config= new Configuracion();

public void obtenerArchivosRemotos(String numero){
    
        ArrayList<ObDocumento> listaDocs = new ArrayList<>();

        // Se construye la ruta        
        
        String ruta = config.carpetaRemota+"aceptados\\"+numero;
        // Para pruebas
        //String ruta = "C:\\abc\\"+Integer.toString(numero);
        
        File f = new File(ruta);
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
                      
        for (int i=0; i<names.size() ; i++){

            // Se crea al edocumento para ser agregado individualmente a la lista
            ObDocumento doc = new ObDocumento();
            // Se agrega el nombre del elemento
            doc.setNombre(names.get(i));
            // Se agrega la ruta
            doc.setRuta(ruta);
            
            // Se agrega el elemento a la lista
            //moverArchivo
       // añadir moverACarpetaAnalisis(numero,names.get(i));
          
        }
        
        f.delete();
                           
    }
    
    
    public ArrayList<ObDocumento> obtenerArchivosExp(String numero){
    
        ArrayList<ObDocumento> listaDocs = new ArrayList<>();

        // Se construye la ruta        
        //String ruta = config.carpetaLocal+"analisis\\"+Integer.toString(numero);
        String ruta = config.carpetaLocal+"aceptados\\"+numero;
        // Para pruebas
        //String ruta = "C:\\abc\\"+Integer.toString(numero);
        
        File f = new File(ruta);
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
                      
        for (int i=0; i<names.size() ; i++){

            // Se crea al edocumento para ser agregado individualmente a la lista
            ObDocumento doc = new ObDocumento();
            // Se agrega el nombre del elemento
            doc.setNombre(names.get(i));
            // Se agrega la ruta
            doc.setRuta(ruta);
            
            // Se agrega el elemento a la lista
            listaDocs.add(doc);
        }
        
        return listaDocs;    
    }

        
       
     
    
 

}
=======
    Configuracion conf = new Configuracion();
    public Connection connection;
    public ScanCT(){}
    public void conectarbd()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(conf.DATABASE_URL, conf.USUARIO, conf.PASSWORD);
            System.out.println("Conectado");
        }
        catch (ClassNotFoundException | SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
   
    public void clasificar(){
        this.conectarbd();
        String ruta= conf.carpetaRemota;
        File f = new File(ruta);
        System.out.println(f.list());
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
        for (String name : names) {
            System.out.println(name);
        }        
        
    }
 }
>>>>>>> e984f57eeeba7e49564299c93379a22b2fb1530d
