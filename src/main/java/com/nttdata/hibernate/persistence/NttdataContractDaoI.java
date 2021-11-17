package com.nttdata.hibernate.persistence;

import java.util.List;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public interface NttdataContractDaoI extends CommonDaoI<NttdataContract> {
	/**
	 * Busca contratos con Valores concretos
	 * 
	 * @return List<NttdataContract>
	 */
	public List<NttdataContract> showContractsPrecios();

}
