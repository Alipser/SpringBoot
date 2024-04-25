package Riwi.Partys.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "event")
@Data /* Anotación para generar getter y setter */
@AllArgsConstructor /* Anotación para crear constructor lleno */
@NoArgsConstructor /* Anotación para crear constructor vacio */
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    private LocalDate fecha;
    private String ubicacion;
    private int capacidad;
}
