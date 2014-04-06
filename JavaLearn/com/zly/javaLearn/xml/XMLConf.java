package com.zly.javaLearn.xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


/**
 * @author zenglingying
 * @version 创建时间：2013-10-19 下午4:55:53
 * 类说明
 */
public class XMLConf {
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	String path;
	File confFile;
	Document doc;
	Element root;
	NodeList children;
	
	XMLConf(String path)
	{
		try {
			this.path = path;  
			builder = factory.newDocumentBuilder();
			confFile = new File(path);
			doc = builder.parse(confFile);
			root = doc.getDocumentElement();
			children = root.getChildNodes();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String readAttr(String attrName)
	{
		for(int i = 0; i < children.getLength(); i++)
		{

				Node child = children.item(i);
				NodeList childNodes = child.getChildNodes();
				Node key = childNodes.item(1);
				Node value = childNodes.item(3);
				Element keyElement;
				Element valueElement;
				String keyStr = new String();
				String valueStr = new String();
				if(key instanceof Element)
				{
					keyElement = (Element) key;
					Text keyText = (Text) keyElement.getFirstChild();
					keyStr = keyText.getData().trim();
				}
				if(value instanceof Element)
				{
					valueElement = (Element) value;
					Text valueText = (Text) valueElement.getFirstChild();
					valueStr = valueText.getData().trim();
				}
				if(keyStr.equals(attrName))
					return valueStr;
		}
		return null;
	}
	static public boolean writeAttr(String file, String attrName, String attrValue) throws IOException
	{
		File inFile = new File(file);
		File outFile = new File(inFile.getAbsolutePath()+".bak");
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		
		inFile.setWritable(true);
		String line;
		String outValue = "\t  <value>"+attrValue+"</value>";
		while((line = reader.readLine()) != null)
		{
			writer.write(line);
			writer.newLine();
			if(line.matches(".*"+attrName+".*"))
			{
				writer.write(outValue);
				writer.newLine();
				reader.readLine();
			}
		}
		writer.flush();
		reader.close();
		writer.close();
		inFile.delete();
		outFile.renameTo(new File(file));
		return true;
	}
	public static void main(String[] args)
	{
		String conFilePath = args[1];
		String confKey = args[2];
		String confValue = args[3];
		try {
			writeAttr(conFilePath,confKey,confValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		System.exit(0);
	}
}
