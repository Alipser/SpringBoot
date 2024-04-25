package Riwi.Partys.services;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Riwi.Partys.entitys.Event;
import Riwi.Partys.repositories.EventRepository;
import Riwi.Partys.services.abstracts.ServiceAbstractEvent;

@Service
public class EventService implements ServiceAbstractEvent {

    @Autowired
    public EventRepository eventRepository;

    public Event crearevento(Event evento) {
        LocalDate todayDate = LocalDate.now();
        if (evento.getCapacidad() > 0 && evento.getFecha().isAfter(todayDate)) {
            return this.eventRepository.save(evento);
        } else {
            throw new IllegalArgumentException("Check Capcity or Date");
        }
    }

    public List<Event> obtenerEventos() {
        return this.eventRepository.findAll();
    }

   
    public Page<Event> obtenerEventosP(Pageable pagination) {
        return this.eventRepository.findAll(pagination);
    }

    public Event obtenerEventoId(UUID id) {
        return this.eventRepository.findById(id).orElseThrow();
    }

    public Event actualizarEvento(Event evento) {
        this.obtenerEventoId(evento.getId());
        return this.crearevento(evento);
    }

    public void eliminarEvento(UUID id) {
        this.obtenerEventoId(id);
        this.eventRepository.deleteById(id);
    }

}
