package com.awc.dao;

import java.util.ArrayList;
import java.util.TreeMap;

public class ExcelData {
	
	private TreeMap<Integer, ArrayList<String>> map;
	private String invoiceNumber,invoicePeriod,nature;
	
	public ExcelData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param map
	 * @param invoiceNumber
	 * @param invoicePeriod
	 * @param vendorName
	 */
	public ExcelData(TreeMap<Integer, ArrayList<String>> map, String invoiceNumber, String invoicePeriod,
			String vendorName,String nature) {
		super();
		this.map = map;
		this.invoiceNumber = invoiceNumber;
		this.invoicePeriod = invoicePeriod;
		this.nature = nature;
	}

	/**
	 * @return the map
	 */
	public TreeMap<Integer, ArrayList<String>> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(TreeMap<Integer, ArrayList<String>> map) {
		this.map = map;
	}

	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @return the invoicePeriod
	 */
	public String getInvoicePeriod() {
		return invoicePeriod;
	}

	/**
	 * @param invoicePeriod the invoicePeriod to set
	 */
	public void setInvoicePeriod(String invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	/**
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
		result = prime * result + ((invoicePeriod == null) ? 0 : invoicePeriod.hashCode());
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + ((nature == null) ? 0 : nature.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcelData other = (ExcelData) obj;
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null)
				return false;
		} else if (!invoiceNumber.equals(other.invoiceNumber))
			return false;
		if (invoicePeriod == null) {
			if (other.invoicePeriod != null)
				return false;
		} else if (!invoicePeriod.equals(other.invoicePeriod))
			return false;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (nature == null) {
			if (other.nature != null)
				return false;
		} else if (!nature.equals(other.nature))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExcelData [map=" + map + ", invoiceNumber=" + invoiceNumber + ", invoicePeriod=" + invoicePeriod
				+ ", nature=" + nature + "]";
	}

	

		
}
