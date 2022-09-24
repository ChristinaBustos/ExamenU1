package server;

public class BeanCurp {
    private String curp;
    private String nom;
    private String apellidoP;
    private String apellidoM;
    private String sexo;
    private String estNacimiento;
    private String fechaNacimiento;

    private String informacion;

    public BeanCurp() {

    }

    public BeanCurp(String curp, String nom, String apellidoP, String apellidoM, String sexo, String estNacimiento, String fechaNacimiento,String informacion) {
        this.curp = curp;
        this.nom = nom;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.sexo = sexo;
        this.estNacimiento = estNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.informacion = informacion;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstNacimiento() {
        return estNacimiento;
    }

    public void setEstNacimiento(String estNacimiento) {
        this.estNacimiento = estNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
