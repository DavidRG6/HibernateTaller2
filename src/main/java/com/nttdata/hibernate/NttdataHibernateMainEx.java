package com.nttdata.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttdataCliente;
import com.nttdata.hibernate.persistence.NttdataContract;
import com.nttdata.hibernate.services.NttdataClienteManagementServiceI;
import com.nttdata.hibernate.services.NttdataClienteManagementServiceImpl;
import com.nttdata.hibernate.services.NttdataContractManagementServiceI;
import com.nttdata.hibernate.services.NttdataContractManagementServiceImpl;

/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class NttdataHibernateMainEx {
	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final Session session = NttdataHibernateUtil.getSessionFactory().openSession();

		final NttdataClienteManagementServiceI clienteService = new NttdataClienteManagementServiceImpl(session);
		final NttdataContractManagementServiceI contracService = new NttdataContractManagementServiceImpl(session);

		// updates

		final String updatedUser = "EVERSPORT_SYS";
		final Date updatedDate = new Date();

		// Generacion de clientes

		final NttdataCliente cliente1 = new NttdataCliente();

		cliente1.setNombre("Pepe");
		cliente1.setApellido1("Perez");
		cliente1.setApellido2("Perez");
		cliente1.setIdDocumento(1);
		cliente1.setUpdatedDate(updatedDate);
		cliente1.setUpdatedUser(updatedUser);

		final NttdataCliente cliente2 = new NttdataCliente();
		cliente2.setNombre("Manuel");
		cliente2.setApellido1("Ardañez");
		cliente2.setApellido2("Sanchez");
		cliente2.setIdDocumento(2);
		cliente2.setUpdatedDate(updatedDate);
		cliente2.setUpdatedUser(updatedUser);

		final NttdataCliente cliente3 = new NttdataCliente();

		cliente3.setNombre("Pepe");
		cliente3.setApellido1("Sanchez");
		cliente3.setApellido2("Perez");
		cliente3.setIdDocumento(13);
		cliente3.setUpdatedDate(updatedDate);
		cliente3.setUpdatedUser(updatedUser);

		// Generacion de Contratos
		final NttdataContract contract1 = new NttdataContract();
		contract1.setDateInc(new Date(121, 10, 4, 50, 10));
		contract1.setDateFin(new Date(123, 10, 4, 50, 10));
		contract1.setPrecio(124.32);
		contract1.setIdcliente(cliente1);
		contract1.setUpdatedDate(updatedDate);
		contract1.setUpdatedUser(updatedUser);

		final NttdataContract contract2 = new NttdataContract();
		contract2.setDateInc(new Date(121, 10, 4, 50, 10));
		contract2.setDateFin(new Date(123, 10, 3, 20, 12));
		contract2.setPrecio(305.32);
		contract2.setIdcliente(cliente2);
		contract2.setUpdatedDate(updatedDate);
		contract2.setUpdatedUser(updatedUser);

		final NttdataContract contract3 = new NttdataContract();
		contract3.setDateInc(new Date(121, 2, 4, 10, 18));
		contract3.setDateFin(new Date(123, 10, 3, 20, 12));
		contract3.setPrecio(215.90);
		contract3.setIdcliente(cliente3);
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);

		// Añadir clientes
		clienteService.addClientes(cliente1);
		clienteService.addClientes(cliente2);
		clienteService.addClientes(cliente3);

		// Añadir Contratos
		contracService.insertNewContract(contract1);
		contracService.insertNewContract(contract2);
		contracService.insertNewContract(contract3);

		// Update clientes
		clienteService.updateClientes(cliente1);
		clienteService.updateClientes(cliente2);
		clienteService.updateClientes(cliente3);

		// Update Contratos
		contracService.updateContract(contract1);
		contracService.updateContract(contract2);
		contracService.updateContract(contract3);

		// VER TODOS
		System.out.println("||VER TODO||");

		// Ver clientes

		for (NttdataCliente list : clienteService.showAll()) {
			System.out.println(list.getIdCliente() + " | " + list.getNombre() + " | " + list.getApellido1() + " | " + list.getApellido2() + " | "
			        + list.getIdDocumento() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}

		// Ver Contratos

		for (NttdataContract list : contracService.searchAll()) {
			System.out.println(list.getIdContract() + " | " + list.getDateInc() + " | " + list.getDateFin() + " | " + list.getPrecio() + " | "
			        + list.getIdcliente() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}

		// VER UNO CONCRETO
		System.out.println("||CONCRETOS||");

		// Ver un Cliente en concreto
		NttdataCliente rs = clienteService.showByID(1L);
		System.out.println(rs.getIdCliente() + " | " + rs.getNombre() + " | " + rs.getApellido1() + " | " + rs.getApellido2() + " | " + rs.getIdDocumento()
		        + " | " + rs.getUpdatedDate() + " | " + rs.getUpdatedDate());

		// Ver Contratos por id
		NttdataContract rs2 = contracService.searchById(5L);

		System.out.println(rs2.getIdContract() + " | " + rs2.getDateInc() + " | " + rs2.getDateFin() + " | " + rs2.getPrecio() + " | " + rs2.getIdcliente()
		        + " | " + rs2.getUpdatedDate() + " | " + rs2.getUpdatedDate());

		// QUERRYS CRITERIA
		System.out.println("||CRITERIA QUERRYS CONCRETAS||");
		// Clientes
			//Clientes con una caracteristica en el nombre
		for (NttdataCliente list : clienteService.showPerez()) {
			System.out.println(list.getIdCliente() + " | " + list.getNombre() + " | " + list.getApellido1() + " | " + list.getApellido2() + " | "
			        + list.getIdDocumento() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}
			//Clientes con una caracteristica concreta en sus contratos
		for (NttdataCliente list : clienteService.showClientsPrecios()) {
			System.out.println(list.getIdCliente() + " | " + list.getNombre() + " | " + list.getApellido1() + " | " + list.getApellido2() + " | "
			        + list.getIdDocumento() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}
		// Contratos
			// Contratos con un Precio concreto
		for (NttdataContract list : contracService.showContractsPrecios()) {
			System.out.println(list.getIdContract() + " | " + list.getDateInc() + " | " + list.getDateFin() + " | " + list.getPrecio() + " | "
			        + list.getIdcliente() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}
		
		// BORRADO
		System.out.println("||Borrado||");
		// borrar un cliente

		clienteService.deleteClientes(cliente2);

		for (NttdataCliente list : clienteService.showAll()) {
			System.out.println(list.getIdCliente() + " | " + list.getNombre() + " | " + list.getApellido1() + " | " + list.getApellido2() + " | "
			        + list.getIdDocumento() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}

		// borrar un Contrato
		contracService.deleteContract(contract2);

		for (NttdataContract list : contracService.searchAll()) {
			System.out.println(list.getIdContract() + " | " + list.getDateInc() + " | " + list.getDateFin() + " | " + list.getPrecio() + " | "
			        + list.getIdcliente() + " | " + list.getUpdatedDate() + " | " + list.getUpdatedDate());
		}

		session.close();
	}

}
