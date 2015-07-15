
package scanct;

/**
 *

 * @author enriquedg
 */
public class Configuracion {
    //Carpetas
    
   // final String carpetaRemota="\\\\THINKPADL430\\";
    /*final String USUARIO="root";
    final String PASSWORD="";*/
    final String carpetaRemota="c:\\escaneos\\";
    final String carpetaCT = this.carpetaRemota + "aceptadosCT\\";

    //final String carpetaLocal="/home/eli-vaio/Desktop/dsinteg/escaneos";
    //Base de Datos local
    final String USUARIO="curp";
    final String PASSWORD="curpuset";
    final String DATABASE_URL="jdbc:mysql://localhost/curp_uset";
}