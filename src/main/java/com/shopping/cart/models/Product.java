
package com.shopping.cart.models;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

    /** Primary key. */
    protected static final String PK = "productid";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int productid;
    @Column(name = "product_name",length=45)
    private String productName;
    @Column(precision=22)
    private double price;

	/*
	 * @OneToMany(mappedBy="product") private Set<CartProduct> cartProduct;
	 */
    /** Default constructor. */
    public Product() {
        super();
    }

    /**
     * Access method for productid.
     *
     * @return the current value of productid
     */
    public int getProductid() {
        return productid;
    }

    /**
     * Setter method for productid.
     *
     * @param aProductid the new value for productid
     */
    public void setProductid(int aProductid) {
        productid = aProductid;
    }

    /**
     * Access method for productName.
     *
     * @return the current value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter method for productName.
     *
     * @param aProductName the new value for productName
     */
    public void setProductName(String aProductName) {
        productName = aProductName;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(double aPrice) {
        price = aPrice;
    }

    /**
     * Access method for cart.
     *
     * @return the current value of cart
     */

    /**
     * Access method for cartProduct.
     *
     * @return the current value of cartProduct
     */
	/*
	 * public Set<CartProduct> getCartProduct() { return cartProduct; }
	 */
    /**
     * Setter method for cartProduct.
     *
     * @param aCartProduct the new value for cartProduct
     */
	/*
	 * public void setCartProduct(Set<CartProduct> aCartProduct) { cartProduct =
	 * aCartProduct; }
	 */

    /**
     * Compares the key for this instance with another Product.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Product and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product that = (Product) other;
        if (this.getProductid() != that.getProductid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Product.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Product)) return false;
        return this.equalKeys(other) && ((Product)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getProductid();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Product |");
        sb.append(" productid=").append(getProductid());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("productid", Integer.valueOf(getProductid()));
        return ret;
    }

}
