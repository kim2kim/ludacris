package com.ludacris.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode().
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public abstract class BaseObject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Version
	protected Integer version;

	@Column(name = "created_on", nullable = false)
	protected Date createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Returns a multi-line String with key=value pairs.
	 * 
	 * @return a String representation of this class.
	 */
	public abstract String toString();

	/**
	 * Compares object equality. When using Hibernate, the primary key should
	 * not be a part of this comparison.
	 * 
	 * @param o
	 *            object to compare to
	 * @return true/false based on equality tests
	 */
	public abstract boolean equals(Object o);

	/**
	 * When you override equals, you should override hashCode. See "Why are
	 * equals() and hashCode() importation" for more information:
	 * http://www.hibernate.org/109.html
	 * 
	 * @return hashCode
	 */
	public abstract int hashCode();
}
