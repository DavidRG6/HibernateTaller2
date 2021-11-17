package com.nttdata.hibernate.persistence;

import java.util.List;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public interface NttdataClienteDaoI extends CommonDaoI<NttdataCliente> {
	/**
	 * Muestra Los clientes con un nombre concreto que nosotros le damos
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @return NttdataCliente
	 */
	public NttdataCliente showbyName(String nombre , String apellido1 , String apellido2);
	/**
	 * Muestra los clientes que posea una caracteristica concreta en su nombre
	 * 
	 * @return List<NttdataCliente>
	 */
	public List<NttdataCliente> showPerez();
	/**
	 * Muestra los clientes que posea una caracteristica concreta en los concretos que tienen esos clientes
	 * 
	 * @return List<NttdataCliente>
	 */
	public List<NttdataCliente> showClientsPrecios();

}
