package com.alura.foro.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")// 2 objetos son iguales solo si sus id lo son

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    private LocalDate fechaCreacion;
    private boolean status;

    public Topico(DatosAgregarTopico datos){
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.fechaCreacion = LocalDate.now();
        this.status = true;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void actualizar(DatosActualizarTopico datos) {
        if(datos.titulo()!=null){
            this.titulo = datos.titulo();
        }
        if(datos.autor()!=null){
            this.autor = datos.autor();
        }
        if(datos.mensaje()!=null){
            this.mensaje = datos.mensaje();
        }
        if(datos.curso() != null){
            this.curso = datos.curso();
        }
    }
}
