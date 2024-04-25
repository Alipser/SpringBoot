package Riwi.demo.Entitys;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="state")
public class State {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    
    public State() {
    }

    public State(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "state [stateId=" + id + ", name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
