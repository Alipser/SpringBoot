package Riwi.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Riwi.demo.Entitys.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
