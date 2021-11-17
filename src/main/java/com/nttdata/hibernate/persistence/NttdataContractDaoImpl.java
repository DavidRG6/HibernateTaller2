package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class NttdataContractDaoImpl extends CommonDaoImpl<NttdataContract> implements NttdataContractDaoI{

	private Session session;
	public NttdataContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	@Override
	public List<NttdataContract> showContractsPrecios() {
	

			final CriteriaBuilder cb = session.getCriteriaBuilder();
			final CriteriaQuery<NttdataContract> cquery = cb.createQuery(NttdataContract.class);
			final Root<NttdataContract> rootP = cquery.from(NttdataContract.class);
			// Where.
			final Predicate pr1 = cb.gt(rootP.<Double>get("precio"), 100);
			final Predicate pr2 = cb.lt(rootP.<Double>get("precio"), 300);

			// Consulta.
			cquery.select(rootP).where(cb.and(pr1,pr2));

			final List<NttdataContract> results = session.createQuery(cquery).getResultList();
			return results;

		
	}




}
