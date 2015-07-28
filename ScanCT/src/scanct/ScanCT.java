/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanct;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author enriquedg :D
 */
public class ScanCT {
 List<ObDocumento> listaDocs = new ArrayList<>();
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
    public String obtenerCT(String curp){
        this.conectarbd();
        String consulta="Select ct from curp_rfc where curp =?";
        System.out.println(consulta);
        String ct="";
            
            
           
     try {
          PreparedStatement preparado;
         preparado = connection.prepareStatement(consulta);
         preparado.setString(1,curp);
            ResultSet resultado=preparado.executeQuery();
              if(resultado.next()){
                ct=resultado.getString("ct");
                System.out.println("CT :D : "+ct);
            }
                        
            preparado.close();
            connection.close(); 
            return ct.trim();
     } catch (SQLException ex) {
         Logger.getLogger(ScanCT.class.getName()).log(Level.SEVERE, null, ex);
         return ct.trim();
     }
            
            
          
    }
     public void clasificar(){  
        //creamos la ruta en la cual se van a almacenar los documentos
        String ruta = conf.carpetaRemota+"aceptados\\";
        File f = new File(ruta);   

        FileUtils Files = new FileUtils();
        FileUtils Files2 = new FileUtils();
        String ct = "";
        System.out.println(f.list());
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
        if(!names.isEmpty())
        {
            for (int i=0; i<names.size();i++) {
//____________Elifor ()
                
                
                System.out.println(names.get(i));
                ct = obtenerCT(names.get(i));
                //ct = obtenerCT(names2.get())
                if(ct.equals("")){
                    System.out.println("Se acabó");
                    
                }
                
                else
                {
                    String prueba = (String)(names.get(i).toString());
                    String rutadestino = conf.carpetaCT + "\\" + names.get(i) + "\\";
                    System.out.println("CT:"+ct);
                    System.out.println("Carpeta destino: "+rutadestino);
                    File destino = new File(conf.carpetaCT + ct + "\\");
                    File destino2 = new File(conf.carpetaCT + ct + "\\" + names.get(i) + "\\");
                    //String rutadest = conf.carpetaCT+"\\"+ct+"\\";
                    File origen = new File(ruta+names.get(i)+"\\");
                    File f3;
                    
                    File f2 = new File(origen+"\\");

                     if (destino2.exists()){
                                               
                            ArrayList<String> names2 = new ArrayList<String>(Arrays.asList(f2.list()));
                    
                            for(int j=0;j<names2.size();j++){
                             
                                f3 = new File(f2.toString()+"\\"+names2.get(j));
                                System.out.println("El fichero que estoy intentando tomar: "+f3.toString());
                                System.out.println("Destino es: "+destino2);
                                try{
                                   
                                   
                                Files2.moveFileToDirectory(f3, destino2, true);
                                
                                f2.delete();
                                          
                                            }
                                catch(IOException e){
                                    e.printStackTrace();
                                }
                               // f3 = new File(f2+"\\"+names2.get(i)+"\\");
                            }
                       // Files.moveFile(origen, destino);
                           //try{
                             //   Files.moveDirectoryToDirectory(origen, destino, true);
                               // }
                             //catch(IOException e){}
                        }
                        else{   
                            try{
                                Files.moveDirectoryToDirectory(origen, destino, true);
                                }
                             catch(IOException e){}
                            }
                           
                    
                        System.out.println("Se imprime el origen: "+origen);
                        System.out.println("Se imprime el destino: "+destino);
                        
                    }
                    
                    
                }
            JOptionPane.showMessageDialog(null, "Se han movido exitosamente los elementos de directorio");
        }
        
        else
        {
                 JOptionPane.showMessageDialog(null, "No hay mas archivos que mover");
        }  
      
     }    
        
       
  }
 

        
       
     
    
 


   
