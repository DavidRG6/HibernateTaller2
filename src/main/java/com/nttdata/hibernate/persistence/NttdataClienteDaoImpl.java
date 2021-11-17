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

public class NttdataClienteDaoImpl extends CommonDaoImpl<NttdataCliente> implements NttdataClienteDaoI {

	private Session session;

	public NttdataClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public NttdataCliente showbyName(String nombre, String apellido1, String apellido2) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza equipo en función del nombre.
		final List<NttdataCliente> clientList = session
		        .createQuery("FROM EverisTeam WHERE nombreCliente=" + nombre + " AND apellido1=" + apellido1 + " AND apellido2=" + apellido2).list();

		// Resultado.
		NttdataCliente client = null;
		if (clientList != null && clientList.size() > 0) {
			client = clientList.get(0);
		}

		return client;
	}

	@Override
	public List<NttdataCliente> showPerez() {
		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttdataCliente> cquery = cb.createQuery(NttdataCliente.class);
		final Root<NttdataCliente> rootP = cquery.from(NttdataCliente.class);

		// Where.
		final Predicate pr1 = cb.equal(rootP.get("apellido1"), "Perez");
		final Predicate pr2 = cb.equal(rootP.get("apellido2"), "Perez");

		// Consulta.
		cquery.select(rootP).where(cb.or(pr1, pr2));

		final List<NttdataCliente> results = session.createQuery(cquery).getResultList();
		return results;
	}

	@Override
	public List<NttdataCliente> showClientsPrecios() {

		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttdataCliente> cquery = cb.createQuery(NttdataCliente.class);
		final Root<NttdataCliente> rootP = cquery.from(NttdataCliente.class);
		final Join<NttdataCliente, NttdataContract> pJoinT = rootP.join("listContracts");

		// Where.
		final Predicate pr1 = cb.gt(pJoinT.<Double> get("precio"), 100);
		final Predicate pr2 = cb.lt(pJoinT.<Double> get("precio"), 300);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		final List<NttdataCliente> results = session.createQuery(cquery).getResultList();
		return results;

	}

}
