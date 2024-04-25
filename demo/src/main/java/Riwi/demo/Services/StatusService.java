package Riwi.demo.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Riwi.demo.Entitys.State;
import Riwi.demo.Repositories.StateRepository;

@Service
public class StatusService {

    @Autowired
    public StateRepository stateRepository;

    public List<State> findAll(){
        return this.stateRepository.findAll();
    }


    
}
