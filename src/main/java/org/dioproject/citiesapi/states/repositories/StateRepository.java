package org.dioproject.citiesapi.states.repositories;

import org.dioproject.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
