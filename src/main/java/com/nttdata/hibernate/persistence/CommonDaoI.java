package com.nttdata.hibernate.persistence;

import java.util.List;
/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
public interface CommonDaoI<Obj> {
	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final Obj paramObj);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final Obj paramObj);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final Obj paramObj);
	
	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public Obj searchById(final Long id);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<Obj> searchAll();

}
