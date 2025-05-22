package com.ceatformacion.colegio.modell;



public class Alumnos {
    private static int id;
    private int idAlumno;
    private String nombre;
    private int edad;
    private String curso;

    //dos metodos constructores...uno vacio, y otro con todos menos el idAlumno


    public Alumnos(int idAlumno,String nombre, String curso, int edad) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.curso = curso;
        this.edad = edad;
    }

    public Alumnos() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }
//temporal si no hay bbdd
    public void setIdAlumno(int idAlumno)
    {
        this.idAlumno = idAlumno;
    }
    public void asignarIdAlumno()
    {
        this.idAlumno = ++id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

   //toString


    @Override
    public String toString() {
        return "Alumnos{" +
                "idAlumno=" + idAlumno +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", curso='" + curso + '\'' +
                '}';
    }
}
