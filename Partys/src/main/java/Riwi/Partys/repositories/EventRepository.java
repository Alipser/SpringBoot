package Riwi.Partys.repositories;

import java.util.List;
import java.util.UUID;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Riwi.Partys.entitys.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    public List<Event> findByNombre(String nombre);
}
