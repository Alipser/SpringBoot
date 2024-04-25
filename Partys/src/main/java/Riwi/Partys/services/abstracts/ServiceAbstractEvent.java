package Riwi.Partys.services.abstracts;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Riwi.Partys.entitys.Event;

public interface ServiceAbstractEvent {

    public Event crearevento(Event evento);
    public List<Event> obtenerEventos();
    public Event obtenerEventoId(UUID id);
    public Event actualizarEvento(Event evento);
    public void eliminarEvento(UUID id);
    public Page<Event> obtenerEventosP(Pageable pagination);

}
