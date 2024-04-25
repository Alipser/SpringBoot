package Riwi.Partys.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Riwi.Partys.entitys.Event;
import Riwi.Partys.services.abstracts.ServiceAbstractEvent;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private final ServiceAbstractEvent EventService;

    @PostMapping
    public Event insert(@RequestBody Event evento) {
        return  this.EventService.crearevento(evento);
    }

    @GetMapping
    
    public Page<Event> getMethodName( @RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "5") int size) {
        Pageable prueba = PageRequest.of(page, size);
        Page<Event> list = this.EventService.obtenerEventosP(prueba);
        return list;
    }
    

    @GetMapping(path = "/event/{id}")
    public ResponseEntity<Event> get(@PathVariable UUID id) {
        return ResponseEntity.ok(this.EventService.obtenerEventoId(id));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Event>> getall() {
        return ResponseEntity.ok(this.EventService.obtenerEventos());
    }

    

    @PutMapping(path = "/put/{id}")
    public ResponseEntity<Event> update(
            @PathVariable UUID id,
            @RequestBody Event evento)
    {
        return ResponseEntity.ok(this.EventService.actualizarEvento(evento));

    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.EventService.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }



    
}
