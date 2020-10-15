package com.hilel.factures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hilel.factures.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
