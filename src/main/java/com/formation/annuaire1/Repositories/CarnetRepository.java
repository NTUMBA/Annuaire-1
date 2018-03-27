package com.formation.annuaire1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.annuaire1.canet.Carnet;


@Repository // On indique a spring qu il s agit d un repository
public interface CarnetRepository extends JpaRepository<Carnet, Long>{

}
