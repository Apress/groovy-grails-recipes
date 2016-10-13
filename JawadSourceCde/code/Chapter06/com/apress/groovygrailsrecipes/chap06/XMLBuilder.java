package com.apress.groovygrailsrecipes.chap06;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLBuilder {
  public static void main(String[] args) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = factory.newDocumentBuilder();
      Document doc = parser.newDocument();
      Element root = doc.createElement("authors");
      doc.appendChild(root);
      Element author = doc.createElement("author");
      author.setAttribute("name", "Bashar AbdulJawad");
      Element book = doc.createElement("book");
      book.setAttribute("title", "Groovy and Grails Recipes");
      book.setAttribute("edition", "1");
      author.appendChild(book);
      root.appendChild(author);
      author = doc.createElement("author");
      author.setAttribute("name", "Graeme Rocher");
      book = doc.createElement("book");
      book.setAttribute("title", "The Definitive Guide to Grails");
      book.setAttribute("edition", "2");
      author.appendChild(book);
      root.appendChild(author);
      TransformerFactory tranFactory = TransformerFactory.newInstance();
      Transformer aTransformer = tranFactory.newTransformer();
      Source src = new DOMSource(doc);
      Result dest = new StreamResult(System.out);
      aTransformer.transform(src, dest);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
