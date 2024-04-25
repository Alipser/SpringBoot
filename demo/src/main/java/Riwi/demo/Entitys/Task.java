package Riwi.demo.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;


@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255, nullable = true)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private LocalTime horaCreacion;

    @ManyToOne(optional = true)
    @JoinColumn(name = "estadoId")
    private State estado;

    public Task(String titulo, String descripcion, LocalDate fechaCreacion, LocalTime horaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.horaCreacion = horaCreacion;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public State getEstado() {
        return estado;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaCreacion="
                + fechaCreacion + ", horaCreacion=" + horaCreacion + ", estado=" + estado + "]";
    }

}
