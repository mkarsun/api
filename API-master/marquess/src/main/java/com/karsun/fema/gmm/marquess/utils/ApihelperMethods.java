package com.karsun.fema.gmm.marquess.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ApihelperMethods {
	
	
	public static String generateStringFromResource(String filePath) throws IOException {
		@SuppressWarnings("deprecation")
		String retStrValue = FileUtils.readFileToString(new File(filePath)).trim();
	
		return retStrValue;
	}

	public String getXpathValue(String xpathval, String filepath) {
		String rtn = "";
		try {
			File inputFile = new File(filepath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = xpathval;
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			if (nodeList.getLength() == 0) {
				rtn = "No xpath exist";
//			} else if(nodeList.getLength() > 1) {
//				rtn = "Multiple xpaths";
			} else /*if(nodeList.getLength()== 1)*/{
					Node nNode = nodeList.item(0);
					rtn = nNode.getTextContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}
	
	public boolean isValidPath(String path) {
		boolean flag = false;
		try {
			File f = new File(path);
			if (f.exists()) {
				flag = true;
			}
			// Paths.get(path);
		} catch (InvalidPathException | NullPointerException ex) {
			return false;
		}

		return flag;
	}
	
	public int contains(int[] httperrorcode, int statusCode) {
		for (int n : httperrorcode) {
			if (statusCode == n)
				return statusCode;
		}
		return ReusableConstants.HTTPSUCCESSCODE;
	}

	
	
}
