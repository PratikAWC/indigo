package com.awc.dao;

import java.util.ArrayList;
import java.util.TreeMap;

public class ExcelData {
	
	private TreeMap<Integer, ArrayList<String>> map;
	private String invoiceNumber,invoicePeriod,vendorName;
	
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
			String vendorName) {
		super();
		this.map = map;
		this.invoiceNumber = invoiceNumber;
		this.invoicePeriod = invoicePeriod;
		this.vendorName = vendorName;
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
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
		result = prime * result + ((vendorName == null) ? 0 : vendorName.hashCode());
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
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExcelData [map=" + map + ", invoiceNumber=" + invoiceNumber + ", invoicePeriod=" + invoicePeriod
				+ ", vendorName=" + vendorName + "]";
	}
	
}
