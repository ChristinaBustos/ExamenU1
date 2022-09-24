package server;

import org.apache.commons.lang3.RandomStringUtils;
public class Methods {

    DaoCurp daoCurp = new DaoCurp();
    BeanCurp beanCurp = new BeanCurp();

    public String Curp(String nom,String apellidoP,String apellidoM,String sexo,String estNacimiento,String fechaNacimiento){
        String curp= null,apellidoUno,apellidoDos,nombre;
        nombre = nom.toUpperCase();
        apellidoUno=apellidoP.toUpperCase();
        apellidoDos=apellidoM.toUpperCase();

        System.out.println(nombre+apellidoUno+apellidoDos);

        String primero = apellidoUno.charAt(0)+"";
        String pri = apellidoUno.charAt(1)+"";
        String segundo =  apellidoDos.charAt(0)+"";
        char tercero =  nombre.charAt(0);
        String fecha = fechaNacimiento.charAt(2)+"";
        String nacimiento = fechaNacimiento.charAt(3)+"";
        String mes = fechaNacimiento.charAt(4)+"";
        String mes2 = fechaNacimiento.charAt(5)+"";
        String dia = fechaNacimiento.charAt(6)+"";
        String dia2 = fechaNacimiento.charAt(7)+"";
        System.out.println(fecha);


        curp = primero+pri+segundo+tercero+fecha+nacimiento+mes+mes2+dia+dia2+generarSexo(sexo)+estNacimiento.toUpperCase()+generarRandom(apellidoP,apellidoM);
        System.out.println(curp);
        datos(curp,nombre,apellidoP,apellidoM,sexo,estNacimiento,fechaNacimiento);
        return curp;
    }

    public String generarSexo(String sexo){
        String sexoN=null;
        String sexoHombre="H",sexoMujer="M";
        if(sexoHombre.equals(sexo)){
            sexoN = "H";
        }else if(sexoMujer.equals(sexo)){
            sexoN = "M";
        }
        return sexoN;
    }

    public String generarRandom(String apellidoP,String apellidoM){
        String random;
        String consonanteApellidoP = null;
        String consonanteApellidoM = null;
        int cont =0;
        for(int i=0; i <= apellidoP.length()-1;i++){
            char[] consonantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
            for(int o = 0; o < consonantes.length; o++){
                if(cont < 2){
                    if(apellidoP.charAt(i) == consonantes[o]){
                        consonanteApellidoP = String.valueOf(apellidoP.charAt(i));
                        cont ++;
                    }
                }
            }
        }
        int cont2 = 0;
        for(int i=0; i <= apellidoM.length()-1;i++){
            char[] consonantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
            for(int o = 0; o < consonantes.length; o++){
                if(cont2 < 2){
                    if(apellidoM.charAt(i) == consonantes[o]){
                        consonanteApellidoM = String.valueOf(apellidoP.charAt(i));
                        cont2 ++;
                    }
                }
            }
        }

        int num =  (int)(Math.random()*9+1);
        String randomizedString = RandomStringUtils.randomAlphanumeric(2);
        String randomCharacter = String.valueOf(randomizedString.charAt(0));
        random = consonanteApellidoP.toUpperCase()+consonanteApellidoM.toUpperCase()+randomCharacter.toUpperCase()+num;
        return random;
    }

   public void datos(String curp,String nom,String apellidoP,String apellidoM,String sexo,String estNacimiento,String fechaNacimiento){
        daoCurp.saveCurp(curp,nom,apellidoP,apellidoM,sexo,estNacimiento,fechaNacimiento);
   }

   public String consultar(String curp){
        daoCurp.findCurp(curp);
        String show = null;
        System.out.println(beanCurp.getInformacion());
        show = beanCurp.getInformacion();
        return show;
   }

}
