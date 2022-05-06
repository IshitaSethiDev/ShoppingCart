
package com.shopping.cart.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "apparal")
public class Apparal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(unique = true, nullable = false, precision = 10)
	private int id;

	@Column(name = "product_id", precision = 10)
	private int productId;
	@Column(length = 45)
	private String type;
	@Column(length = 45)
	private String brand;
	@Column(length = 45)
	private String design;

	/** Default constructor. */
	public Apparal() {
		super();
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */

	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for productId.
	 *
	 * @return the current value of productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Setter method for productId.
	 *
	 * @param aProductId the new value for productId
	 */
	public void setProductId(int aProductId) {
		productId = aProductId;
	}

	/**
	 * Access method for type.
	 *
	 * @return the current value of type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter method for type.
	 *
	 * @param aType the new value for type
	 */
	public void setType(String aType) {
		type = aType;
	}

	/**
	 * Access method for brand.
	 *
	 * @return the current value of brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter method for brand.
	 *
	 * @param aBrand the new value for brand
	 */
	public void setBrand(String aBrand) {
		brand = aBrand;
	}

	/**
	 * Access method for design.
	 *
	 * @return the current value of design
	 */
	public String getDesign() {
		return design;
	}

	/**
	 * Setter method for design.
	 *
	 * @param aDesign the new value for design
	 */
	public void setDesign(String aDesign) {
		design = aDesign;
	}

	/**
	 * Compares the key for this instance with another Apparal.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Apparal and the key objects
	 *         are equal
	 */
	/*
	 * private boolean equalKeys(Object other) { if (this == other) { return true; }
	 * if (!(other instanceof Apparal)) { return false; } Apparal that = (Apparal)
	 * other; if (this.getId() != that.getId()) { return false; } return true; }
	 */

	/**
	 * Compares this instance with another Apparal.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	/*
	 * @Override public boolean equals(Object other) { if (!(other instanceof
	 * Apparal)) return false; return this.equalKeys(other) && ((Apparal)
	 * other).equalKeys(this); }
	 */

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	/*
	 * @Override public int hashCode() { int i; int result = 17; i = getId(); result
	 * = 37 * result + i; return result; }
	 */
	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	/*
	 * @Override public String toString() { StringBuffer sb = new
	 * StringBuffer("[Apparal |"); sb.append(" id=").append(getId());
	 * sb.append("]"); return sb.toString(); }
	 */

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	/*
	 * public Map<String, Object> getPrimaryKey() { Map<String, Object> ret = new
	 * LinkedHashMap<String, Object>(6); ret.put("id", Integer.valueOf(getId()));
	 * return ret; }
	 */

}
