package com.alura.foro.topico;

import java.time.LocalDate;

public record DatosDetalleTopico(
        String titulo,
        String mensaje,
        String autor,
        String curso,
        LocalDate fechaCreacion,
        boolean status
) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getTitulo(),topico.getMensaje(),topico.getAutor(), topico.getCurso(), topico.getFechaCreacion(),topico.isStatus());
    }
}
