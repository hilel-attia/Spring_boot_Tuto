package com.hilel.factures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hilel.factures.entities.Facture;
import com.hilel.factures.repos.FactureRepository;
import com.hilel.factures.services.FactureService;

@SpringBootTest
class FacturesApplicationTests {

	@Autowired
	private FactureRepository factureRepository;
	private FactureService   factureService;
	@Test
	public void testCreateProduit() {
	Facture fac = new Facture("fac 1",10.500,new Date());
	factureRepository.save(fac);
	}
	@Test
	public void testFindFacture()
	{
	Facture f = factureRepository.findById(8L).get();
	System.out.println(f);
	}
	@Test
	public void testUpdateFacture()
	{
	Facture f = factureRepository.findById(7L).get();
	f.setTvaFacture(20.5);
	factureRepository.save(f);
	}
	
	@Test
	public void testDeleteFacture()
	{
		factureRepository.deleteById(13L);
	}
	
	@Test
	public void testListerTousFactures()
	{
	List<Facture> facs = factureRepository.findAll();
	for (Facture f : facs)
	{
	System.out.println(f);
	}
	}
	@Test
	public void testFindByNomFactureContains()
	{
	Page<Facture> facs = factureService.getAllFActuresParPage(0,2);
	System.out.println(facs.getSize());
	System.out.println(facs.getTotalElements());
	System.out.println(facs.getTotalPages());
	facs.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	}

