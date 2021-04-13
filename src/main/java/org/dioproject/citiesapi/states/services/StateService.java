package org.dioproject.citiesapi.states.services;

import org.dioproject.citiesapi.states.entities.State;
import org.dioproject.citiesapi.states.repositories.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public Page<State> findAll(Pageable page) {
        return stateRepository.findAll(page);
    }
}
