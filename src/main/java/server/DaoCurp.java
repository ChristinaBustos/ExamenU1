package server;

import utils.MySQLConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class DaoCurp {

    PreparedStatement pstm;
    CallableStatement cstn;
    Connection conn;
    ResultSet rs;

    private final String INSERT_CURP ="INSERT INTO datos(curp,nombre,apellidop,apellidom,sexo,estnacimiento,fechanac)values (?,?,?,?,?,?,?)";
    private final String FIND_CURP= "SELECT * FROM datos where curp = ?";

    public boolean saveCurp(String curp,String nom,String apellidoP,String apellidoM,String sexo,String estNacimiento,String fechaNacimiento){
        try{
            conn = new MySQLConnection().getConnection();
            String query =INSERT_CURP;
            pstm = conn.prepareStatement(query);
            pstm.setString(1,curp);
            pstm.setString(2,nom);
            pstm.setString(3,apellidoP);
            pstm.setString(4,apellidoM);
            pstm.setString(5,sexo);
            pstm.setString(6,estNacimiento);
            pstm.setString(7,fechaNacimiento);
            return pstm.executeUpdate()==1;
        }catch (SQLException e){
            return false;
        }finally {
            closeConnection();
        }
    }

    public BeanCurp findCurp(String curp){
        BeanCurp beanCurp = null;
        try{
            conn = new MySQLConnection().getConnection();
            String query = FIND_CURP;
            pstm = conn.prepareStatement(query);
            pstm.setString(1,curp);
            rs = pstm.executeQuery();
            while (rs.next()){
                beanCurp = new BeanCurp();
                beanCurp.setCurp(rs.getString("curp"));
                beanCurp.setNom(rs.getString("nombre"));
                beanCurp.setApellidoP(rs.getString("apellidop"));
                beanCurp.setApellidoM(rs.getString("apellidom"));
                beanCurp.setSexo(rs.getString("sexo"));
                beanCurp.setEstNacimiento(rs.getString("estnacimiento"));
                beanCurp.setFechaNacimiento(rs.getString("fechanac"));
                beanCurp.setInformacion(" Curp:"+beanCurp.getCurp()+" Nombre:"+beanCurp.getNom()+" ApellidoP:"+beanCurp.getApellidoP()+" ApellidoM:"+beanCurp.getApellidoM()+" Sexo:"+beanCurp.getSexo()+" Estado Nacimiento: "+beanCurp.getEstNacimiento()+" Fecha Nacimiento:"+ beanCurp.getFechaNacimiento());
                System.out.println("Curp: "+beanCurp.getCurp()+"\n Nombre: "+beanCurp.getNom()+"\n ApellidoP: "+beanCurp.getApellidoP()+"\n ApellidoM: "+beanCurp.getApellidoM()+"\n Sexo: "+beanCurp.getSexo()+"\n Estado Nacimiento: "+beanCurp.getEstNacimiento()+"\n Fecha Nacimiento:"+ beanCurp.getFechaNacimiento());
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCurp.class.getName())
                    .log(Level.SEVERE, "Error en findMovie -> ", e);
            System.out.println("aaa");
        }finally {
            closeConnection();
        }
        return beanCurp;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pstm != null){
                pstm.close();
            }
            if(cstn != null){
                cstn.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){

        }
    }

}
