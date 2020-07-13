package com.example.demo.entities;

import java.util.List;

public class RowCol {
	
	private String row;
	private List<Cols> cols;
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public List<Cols> getCols() {
		return cols;
	}
	public void setCols(List<Cols> cols) {
		this.cols = cols;
	}
	public RowCol(String row, List<Cols> cols) {
		super();
		this.row = row;
		this.cols = cols;
	}
	public RowCol() {
		super();
	}
	
	
}
