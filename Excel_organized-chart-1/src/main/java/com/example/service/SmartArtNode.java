package com.example.service;

import java.awt.Color;

public class SmartArtNode {
	private int row;
	private int col;
	private int shapeType;
	private Color fillColor;
	private Color lineColor;
	private double lineWidth;
	private String text;
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getShapeType() {
		return shapeType;
	}
	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	public double getLineWidth() {
		return lineWidth;
	}
	public void setLineWidth(double lineWidth) {
		this.lineWidth = lineWidth;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public SmartArtNode(int row, int col, int shapeType, Color fillColor, Color lineColor, double lineWidth,
			String text) {
		super();
		this.row = row;
		this.col = col;
		this.shapeType = shapeType;
		this.fillColor = fillColor;
		this.lineColor = lineColor;
		this.lineWidth = lineWidth;
		this.text = text;
	}
	public SmartArtNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SmartArtNode [row=" + row + ", col=" + col + ", shapeType=" + shapeType + ", fillColor=" + fillColor
				+ ", lineColor=" + lineColor + ", lineWidth=" + lineWidth + ", text=" + text + "]";
	}

	
}
