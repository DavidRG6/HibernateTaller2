package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public class CommonDaoImpl<Obj extends AbstractEntity> implements CommonDaoI<Obj> {
	/** Vista de la clase */
	private Class<Obj> clase;
	/** Conexion de la BD */
	private Session session;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setClase((Class<Obj>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(Obj paramObj) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramObj);
		session.flush();

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void update(Obj paramObj) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramObj);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(Obj paramObj) {
		// TODO Auto-generated method stub

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramObj);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public Obj searchById(Long id) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por ID.
		Obj result = session.get(this.clase, id);

		return result;
	}

	@Override
	public List<Obj> searchAll() {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<Obj> list = session.createQuery("FROM "+this.clase.getName()).list();

		return list;
	}

	/**
	 * @return the clase
	 */
	public Class<Obj> getClase() {
		return clase;
	}

	/**
	 * @param clase
	 *            the clase to set
	 */
	public void setClase(Class<Obj> clase) {
		this.clase = clase;
	}

}
