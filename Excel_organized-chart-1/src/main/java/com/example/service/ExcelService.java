package com.example.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {
	
	
	public ByteArrayInputStream getSmartArt() throws IOException {
	    try (Workbook workbook = new XSSFWorkbook();
	         ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
	        Sheet sheet = workbook.createSheet("TreeStructure");

	        // Create some data for the tree structure
	        TreeNode root = new TreeNode("Root");
	        TreeNode child1 = new TreeNode("Child 1");
	        TreeNode child2 = new TreeNode("Child 2");
	        TreeNode child3 = new TreeNode("Child 3");
	        TreeNode subChild1 = new TreeNode("Sub-Child 1");
	        TreeNode subChild2 = new TreeNode("Sub-Child 2");

	        // Build the tree structure
	        root.addChild(child1);
	        root.addChild(child2);
	        root.addChild(child3);
	        child1.addChild(subChild1);
	        child1.addChild(subChild2);

	        // Write tree structure to Excel
	        writeTreeToExcel(root, sheet, 0, 0);

	        workbook.write(stream);
	        return new ByteArrayInputStream(stream.toByteArray());
	    }
	}

	private void writeTreeToExcel(TreeNode node, Sheet sheet, int rowNum, int colNum) {
	    Row row = sheet.createRow(rowNum);
	    Cell cell = row.createCell(colNum);
	    cell.setCellValue(node.getName());

	    int childRowNum = rowNum + 1;
	    for (TreeNode child : node.getChildren()) {
	        writeTreeToExcel(child, sheet, childRowNum, colNum + 1);
	        childRowNum += getNumRowsInSubtree(child) + 1; // Move to the next available row
	    }
	}

	private int getNumRowsInSubtree(TreeNode node) {
	    int count = 0;
	    for (TreeNode child : node.getChildren()) {
	        count += getNumRowsInSubtree(child) + 1;
	    }
	    return count;
	}

	static class TreeNode {
		private String name;
		private List<TreeNode> children;

		public void addChild(TreeNode node) {
			children.add(node);
		}
		public TreeNode(String name) {
			this.name = name;
			this.children = new ArrayList<>();
		}

		public String getName() {
			return name;
		}

		public List<TreeNode> getChildren() {
			return children;
		}

		
	}

//    public ByteArrayInputStream generateSmartArtExcel(SmartArtNode[] nodes) throws IOException {
//        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
//             Workbook workbook = new XSSFWorkbook()) {
//
//            Sheet sheet = workbook.createSheet("SmartArt Data");
//
//            // Create a drawing canvas on the worksheet
//            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
//
//            // Create nodes
//            for (SmartArtNode node : nodes) {
//                createNode(drawing, node);
//            }
//
//            // Connect nodes
//            for (int i = 1; i < nodes.length; i++) {
//                createConnectorLine(drawing, nodes[0], nodes[i]);
//            }
//
//            workbook.write(stream);
//            return new ByteArrayInputStream(stream.toByteArray());
//        }
//    }
//
//    private void createNode(XSSFDrawing drawing, SmartArtNode node) {
//        XSSFClientAnchor anchor = new XSSFClientAnchor();
//        anchor.setCol1(node.getCol());
//        anchor.setDx1(0); // No offset
//        anchor.setRow1(node.getRow());
//        anchor.setDy1(0); // No offset
//        anchor.setCol2(node.getCol() + 1);
//        anchor.setDx2(0); // No offset
//        anchor.setRow2(node.getRow() + 1);
//        anchor.setDy2(0); // No offset
//
//        XSSFSimpleShape shape = drawing.createSimpleShape(anchor);
//        shape.setShapeType(node.getShapeType());
//        shape.setFillColor(20,30,20); // Set fill color
//        shape.setLineStyleColor(20,30,20); // Set line color
//        shape.setLineWidth(node.getLineWidth()); // Set line width
//        shape.setText(node.getText());
//    }
//
//    private void createConnectorLine(XSSFDrawing drawing, SmartArtNode startNode, SmartArtNode endNode) {
//        int startX = startNode.getCol() + (endNode.getCol() - startNode.getCol()) / 2;
//        int startY = startNode.getRow() + 1;
//        int endX = endNode.getCol() + (endNode.getCol() - startNode.getCol()) / 2;
//        int endY = endNode.getRow();
//
//        XSSFClientAnchor anchor = new XSSFClientAnchor();
//        anchor.setCol1(startX);
//        anchor.setDx1(0); // No offset
//        anchor.setRow1(startY);
//        anchor.setDy1(0); // No offset
//        anchor.setCol2(endX);
//        anchor.setDx2(0); // No offset
//        anchor.setRow2(endY);
//        anchor.setDy2(0); // No offset
//
//        XSSFSimpleShape connectorLine = drawing.createSimpleShape(anchor);
//        connectorLine.setShapeType(ShapeTypes.LINE);
//        connectorLine.setLineStyleColor(20,30,20); // Set line color
//        connectorLine.setLineWidth(startNode.getLineWidth()); // Set line width
//    }
}
