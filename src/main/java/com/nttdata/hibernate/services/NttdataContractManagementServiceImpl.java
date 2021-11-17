package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttdataContract;
import com.nttdata.hibernate.persistence.NttdataContractDaoI;
import com.nttdata.hibernate.persistence.NttdataContractDaoImpl;

/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class NttdataContractManagementServiceImpl implements NttdataContractManagementServiceI {
	private NttdataContractDaoI contractDao;

	public NttdataContractManagementServiceImpl(final Session session) {
		this.contractDao = new NttdataContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(NttdataContract newContract) {
		// Verificacion de nulidad
		if (newContract != null && newContract.getIdContract() == null) {

			// Creacion de nuevo contrato
			contractDao.insert(newContract);
		}
	}

	@Override
	public void updateContract(NttdataContract updatedContract) {
		// Verificacion de nulidad
		if (updatedContract != null && updatedContract.getIdContract() != null) {
			// Actualizacion de los contratos
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(NttdataContract deletedContract) {
		// Verificacion de nulidad
		if (deletedContract != null && deletedContract.getIdContract() != null) {
			// Creacion de nuevo contrato
			contractDao.delete(deletedContract);
		}
	}

	@Override
	public NttdataContract searchById(Long contractId) {
		NttdataContract contract = null;
		// Verificacion de nulidad
		if (contractId != null) {
			// obtencion de un contrato con una id concreta
			contract = contractDao.searchById(contractId);
		}
		return contract;
	}

	@Override
	public List<NttdataContract> searchAll() {
		// Resultado.
		List<NttdataContract> contractList = new ArrayList<NttdataContract>();
		// Obtencion de los contratos
		contractList = contractDao.searchAll();
		return contractList;

	}

	@Override
	public List<NttdataContract> showContractsPrecios() {
		// Resultado.
		List<NttdataContract> contractList = new ArrayList<NttdataContract>();
		// Obtencion de los contratos con una caracteristica concreta en el precio
		contractList = contractDao.showContractsPrecios();
		return contractList;
	}

}
