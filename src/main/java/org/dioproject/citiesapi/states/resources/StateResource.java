package org.dioproject.citiesapi.states.resources;

import org.dioproject.citiesapi.states.entities.State;
import org.dioproject.citiesapi.states.services.StateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateService stateService;

    public StateResource(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public Page<State> states(Pageable page){
        return  stateService.findAll(page);
    }
}
