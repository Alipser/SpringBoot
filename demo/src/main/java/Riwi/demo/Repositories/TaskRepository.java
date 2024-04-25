package Riwi.demo.Repositories;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Riwi.demo.Entitys.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    // public List<Task> findBetweenFechaCreacion(LocalDate inicio, LocalDate fiDate);
}
