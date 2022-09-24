package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class ClientRPC {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        Scanner datos = new Scanner(System.in);

        String nom=null,apellidoP=null,apellidoM=null,sexo=null,estNacimiento=null,fechaNacimiento=null;

        System.out.println("Ingrese acción a realizar: ");
        System.out.println("1.Ingresar datos");
        System.out.println("2.Consultar");
        int opcion = datos.nextInt();
        switch (opcion){
            case 1:
                System.out.println("------------------Registro------------------");
                System.out.println("Ingrese los siguientes datos: ");
                System.out.println("Nombre: ");
                nom = datos.next();
                System.out.println("Apellido Paterno: ");
                apellidoP = datos.next();
                System.out.println("Apellido Materno: ");
                apellidoM = datos.next();
                System.out.println("Sexo: "
                        +"Hombre H\n"
                        +"Mujer M");
                sexo = datos.next().toUpperCase();
                System.out.println("Estado de nacimiento: ");
                System.out.println("AGUASCALIENTES  AS\n" +
                        "BAJA CALIFORNIA SUR  BS \n"
                        +"COAHUILA CL\n"
                        +"CHIAPAS CS\n"
                        +"DISTRITO FEDERAL DF\n"
                        +"GUANAJUATO GT\n"
                        +"HIDALGO HG\n"
                        +"MÉXICO MC\n"
                        +"MORELOS MS\n"
                        +"NUEVO LEÓN NL\n"
                        +"PUEBLA PL\n"
                        +"QUINTANA ROO QR\n"
                        +"SINALOA SL\n"
                        +"TABASCO TC\n"
                        +"TLAXCALA TL\n"
                        +"YUCATÁN YN\n"
                        +"BAJA CALIFORNIA BC\n"
                        +"CAMPECHE CC\n"
                        +"COLIMA CM\n"
                        +"CHIHUAHUA CH\n"
                        +"DURANGO DG\n"
                        +"GUERRERO GR\n"
                        +"JALISCO JC\n"
                        +"MICHOACÁN MN\n"
                        +"NAYARIT NT\n"
                        +"OAXACA OC\n"
                        +"QUERÉTARO QT\n"
                        +"SAN LUIS POTOSÍ SP\n"
                        +"SONORA SR\n"
                        +"TAMAULIPAS TS\n"
                        +"VERACRUZ VZ\n"
                        +"ZACATECAS ZS\n"
                        +"NACIDO EN EL EXTRANJERO NE");
                estNacimiento = datos.next().toUpperCase();
                System.out.println("Fecha nacimiento: ");
                System.out.println("Ejemplo: 20020127  añomesdía");
                fechaNacimiento = datos.next();

                Object[] data = {nom,apellidoP,apellidoM,sexo,estNacimiento,fechaNacimiento};
                String response = String.valueOf(client.execute("Methods.Curp", data));
                System.out.println(response);
                System.out.println(" ");
                break;
            case 2:
                System.out.println("------------------CONSULTA------------------");
                String curp = null;
                System.out.println("Ingrese Curp: ");
                curp = datos.next();
                Object[] data2 = {curp};
                String response2 = (String) client.execute("Methods.consultar",data2);
                System.out.println(response2);
                break;
            default:
                System.out.println("Ups! No seleccionaste bien");
        }


    }
}
