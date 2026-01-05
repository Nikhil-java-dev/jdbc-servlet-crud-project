package com.hcl.jdbc_and_servlet_crud_project.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 
 * 
		                     ┌──────────────────────────────────────┐
		                     │               PRODUCT                │
		                     ├──────────────────────────────────────┤
		                     │ id : int                             │
		                     │ name : String                        │
		                     │ color : String                       │
		                     │ price : double                       │
		                     │ mfd : LocalDate                      │
		                     │ expd : LocalDate                     │
		                     └──────────────────────────────────────┘
		                               ▲              ▲
		                               │              │
		                ┌──────────────┘              └──────────────┐
		                │                                            │
		     ┌──────────────────────────┐                 ┌─────────────────────────┐
		     │      SET METHODS         │                 │      GET METHODS        │
		     ├──────────────────────────┤                 ├─────────────────────────┤
		     │ setId(id)                │   writes →      │ getId()                 │  reads →
		     │ setName(name)            │   value  →      │ getName()               │  value  →
		     │ setColor(color)          │   inside →      │ getColor()              │  from   →
		     │ setPrice(price)          │   Product       │ getPrice()              │  Product
		     │ setMfd(mfd)              │                 │ getMfd()                │
		     │ setExpd(expd)            │                 │ getExpd()               │
		     └──────────────────────────┘                 └─────────────────────────┘
		                        ▲                              ▲
                                │                              │
                 ┌──────────────┘                              └──────────────┐
                 │                                                            │
           ┌────────────────────────────┐            ┌────────────────────────────┐
           │         toString()         │            │         equals()           │
           ├────────────────────────────┤            ├────────────────────────────┤
           │ Converts whole Product     │            │ Compares all fields to     │
           │ into a readable string     │            │ another Product object     │
           │ "Product[id=..., ...]"     │            │ returns true/false         │
           └────────────────────────────┘            └────────────────────────────┘
                                ▲
                                │
                     ┌────────────────────────────┐
                     │        hashCode()          │
                     ├────────────────────────────┤
                     │ Creates numeric signature  │
                     │ based on all fields        │
                     │ used in HashMap/HashSet    │
                     └────────────────────────────┘

 * 
 * 
 */

@SuppressWarnings("serial")
public class Product implements Serializable {
	private int id;
	private String name;
	private String color;
	private double price;
	private LocalDate mfd;
	private LocalDate expd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public LocalDate getExpd() {
		return expd;
	}

	public void setExpd(LocalDate expd) {
		this.expd = expd;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + "\tname=" + name + "\tcolor=" + color + "\tprice=" + price + "\tmfd=" + mfd
				+ "\texpd=" + expd + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, expd, id, mfd, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)       
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(color, other.color) && Objects.equals(expd, other.expd) && id == other.id
				&& Objects.equals(mfd, other.mfd) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

}
