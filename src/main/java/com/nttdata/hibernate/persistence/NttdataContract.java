package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * drg-hibernate-taller2
 *
 * @author driverog
 */
@Entity
@Table(name = "NTTDATA_CONTRACT")
public class NttdataContract extends AbstractEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idContract;
	private Date dateInc;
	private Date dateFin;
	private Double precio;
	private NttdataCliente idcliente;

	public NttdataContract() {

	}

	/**
	 * @return the idContract
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdContract() {
		return idContract;
	}

	/**
	 * @param idContract the idContract to set
	 */
	public void setIdContract(Long idContract) {
		this.idContract = idContract;
	}

	/**
	 * @return the dateInc
	 */
	@Column(name = "FECHA_INCICIO")
	public Date getDateInc() {
		return dateInc;
	}

	/**
	 * @param dateInc the dateInc to set
	 */
	public void setDateInc(Date dateInc) {
		this.dateInc = dateInc;
	}

	/**
	 * @return the dateFin
	 */
	@Column(name = "FECHA_FINAL")
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the precio
	 */
	@Column(name = "PRECIO")
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return the idcliente
	 */
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	public NttdataCliente getIdcliente() {
		return idcliente;
	}

	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(NttdataCliente idcliente) {
		this.idcliente = idcliente;
	}

	@Transient
	public Class<?> getClase() {
		return NttdataContract.class;
	}

}
