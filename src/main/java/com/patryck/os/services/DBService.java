package com.patryck.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patryck.os.domain.Cliente;
import com.patryck.os.domain.OS;
import com.patryck.os.domain.Tecnico;
import com.patryck.os.domain.Enums.Prioridade;
import com.patryck.os.domain.Enums.Status;
import com.patryck.os.repositories.ClienteRepository;
import com.patryck.os.repositories.OSRepository;
import com.patryck.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	
	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Patryck Vieira", "373.944.890-35", "(21) 99999-9999");
		Cliente c1 = new Cliente(null, "Tania Regina", "758.375.300-70", "(21) 98999-8888");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create os", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
