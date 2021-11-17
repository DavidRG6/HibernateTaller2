package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttdataCliente;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public interface NttdataClienteManagementServiceI {
	/**
	 * Insertar un nuevo cliente
	 * 
	 * @param newCliente
	 */
	public void addClientes(NttdataCliente newCliente);
	/**
	 * Obtienes todos los Clientes
	 * 
	 * @return list<NttdataCliente>
	 */
	public List<NttdataCliente> showAll();
	/**
	 * Obtienes los clientes segun una id
	 * 
	 * @param idCliente
	 */
	public NttdataCliente showByID(Long clienteId);
	/**
	 * Borra un cliente existente
	 * 
	 * @param deletedCliente
	 */
	public void deleteClientes(NttdataCliente deletedCliente);
	/**
	 * Actualiza un cliente existente
	 * 
	 * @param updateClientes
	 */
	public void updateClientes(NttdataCliente updateClientes);
	/**
	 * Obtienes clientes Mediante el nombre completo
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 */
	public NttdataCliente showbyName(String nombre , String apellido1 , String apellido2);
	/**
	 * Muestra los clientes que se llamen de una forma en concreta
	 * 
	 * @return list<NttdataCliente>
	 */
	public List<NttdataCliente> showPerez();
	/**
	 * Muestras los clientes que tengan un contrato especifico
	 * 
	 * @return list<NttdataCliente>
	 */
	public List<NttdataCliente> showClientsPrecios();
}
