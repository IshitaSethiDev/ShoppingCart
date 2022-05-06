
package com.shopping.cart.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "id";

	@Id

	@Column(unique = true, nullable = false, precision = 10)
	private int id;

	@Column(name = "product_id", precision = 10)
	private int productId;
	@Column(length = 45)
	private String genre;
	@Column(length = 45)
	private String author;
	@Column(length = 45)
	private String publications;

	/** Default constructor. */
	public Book() {
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
	 * Access method for genre.
	 *
	 * @return the current value of genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Setter method for genre.
	 *
	 * @param aGenre the new value for genre
	 */
	public void setGenre(String aGenre) {
		genre = aGenre;
	}

	/**
	 * Access method for author.
	 *
	 * @return the current value of author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Setter method for author.
	 *
	 * @param aAuthor the new value for author
	 */
	public void setAuthor(String aAuthor) {
		author = aAuthor;
	}

	/**
	 * Access method for publications.
	 *
	 * @return the current value of publications
	 */
	public String getPublications() {
		return publications;
	}

	/**
	 * Setter method for publications.
	 *
	 * @param aPublications the new value for publications
	 */
	public void setPublications(String aPublications) {
		publications = aPublications;
	}

}
