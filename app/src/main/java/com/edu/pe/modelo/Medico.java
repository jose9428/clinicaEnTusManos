package com.edu.pe.modelo;

public class Medico {
   int id_medico ;
    String nom_medico ;
    String apep_medico;
    String apem_medico ;
    String  dni_medico ;
    String imagen ;

    @Override
    public String toString() {
        return "Medico{" +
                "id_medico=" + id_medico +
                ", nom_medico='" + nom_medico + '\'' +
                ", apep_medico='" + apep_medico + '\'' +
                ", apem_medico='" + apem_medico + '\'' +
                ", dni_medico='" + dni_medico + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNom_medico() {
        return nom_medico;
    }

    public void setNom_medico(String nom_medico) {
        this.nom_medico = nom_medico;
    }

    public String getApep_medico() {
        return apep_medico;
    }

    public void setApep_medico(String apep_medico) {
        this.apep_medico = apep_medico;
    }

    public String getApem_medico() {
        return apem_medico;
    }

    public void setApem_medico(String apem_medico) {
        this.apem_medico = apem_medico;
    }

    public String getDni_medico() {
        return dni_medico;
    }

    public void setDni_medico(String dni_medico) {
        this.dni_medico = dni_medico;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
