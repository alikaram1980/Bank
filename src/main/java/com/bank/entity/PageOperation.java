package com.bank.entity;

import java.io.Serializable;
import java.util.List;

public class PageOperation implements Serializable{
	private List<Operation> Operations;
	private int page;
	private int numberOperations;
	private int totalOperations;
	private int totalPages;
	public List<Operation> getOperations() {
		return Operations;
	}
	public void setOperations(List<Operation> operations) {
		Operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNumberOperations() {
		return numberOperations;
	}
	public void setNumberOperations(int numberOperations) {
		this.numberOperations = numberOperations;
	}
	public int getTotalOperations() {
		return totalOperations;
	}
	public void setTotalOperations(int totalOperations) {
		this.totalOperations = totalOperations;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
