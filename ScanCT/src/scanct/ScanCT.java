/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanct;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author enriquedg
 */
public class ScanCT {

    /**
     * @param args the command line arguments
     */
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
