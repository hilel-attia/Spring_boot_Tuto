package com.hilel.factures;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hilel.factures.entities.Facture;
import com.hilel.factures.services.FactureService;


@SpringBootApplication
public class FacturesApplication implements CommandLineRunner {
@Autowired
FactureService factureService;




	public static void main(String[] args) {
		SpringApplication.run(FacturesApplication.class, args);
	}

@Override
public void run(String... args) throws Exception {
	factureService.saveFacture(new Facture("PC Dell", 2600.0, new Date()));
	factureService.saveFacture(new Facture("PC Asus", 2800.0, new Date()));
	factureService.saveFacture(new Facture("Imprimante Epson", 900.0, new Date()));
	
}
}