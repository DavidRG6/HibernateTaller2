package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttdataContract;

/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public interface NttdataContractManagementServiceI {
	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final NttdataContract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final NttdataContract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final NttdataContract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public NttdataContract searchById(final Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<NttdataContract>
	 */
	public List<NttdataContract> searchAll();
	/**
	 * Obtiene todos los contratos con unos valores concretos.
	 * 
	 * @return List<NttdataContract>
	 */
	public List<NttdataContract> showContractsPrecios();


}
