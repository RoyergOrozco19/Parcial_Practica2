package Otro.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Pacientes")
@EntityListeners(PacienteListener.class)

public class Paciente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int consultorio;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int grado) {
        this.consultorio = grado;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id = " + id +
                ", nombre= '" + nombre + '\'' +
                ", consultorio = " + consultorio +

                '}';
    }
}
