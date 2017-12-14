package com.ustc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlFile {
    //private static String[] acfile;

    public static List<String> getXmlValueActionName(File file) {
        List<String> list = new ArrayList<String>();
        try {
            //String[] acfile = new String[10];

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("action");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                //System.out.println("Node name: "+ node.getNodeName());
                Element ele = (Element) node;
                if (node.getNodeType() == Element.ELEMENT_NODE) {
                    //System.out.println("name: "+ ele.getAttribute("name"));

                    list.add((String) ele.getAttribute("name"));

                }
            }


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
        return list;

    }

    public static List<String> getXmlValueActionClass(File file) {
        List<String> list = new ArrayList<String>();
        try {
            //String[] acfile = new String[10];

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("action");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                //System.out.println("Node name: "+ node.getNodeName());
                Element ele = (Element) node;
                if (node.getNodeType() == Element.ELEMENT_NODE) {
                    //System.out.println("name: "+ ele.getAttribute("name"));

                    list.add((String) ele.getAttribute("class"));

                }
            }


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
        return list;

    }

    public static List<String> getXmlValueResultName(File file, String actionName) {
        List<String> list = new ArrayList<String>();
        try {
            //String[] acfile = new String[10];

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("action");//获得几个action节点
            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i); //获得每一个action
                NamedNodeMap attributes = node.getAttributes(); //获得每个action的所有属性
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node item = attributes.item(i2);//获得每一个属性

                    if (item.getNodeName().equals("name") && item.getNodeValue().equals(actionName)) {
                        NodeList childNodes = node.getChildNodes();
                        for (int i1 = 0; i1 < childNodes.getLength(); i1++) {
                            if (childNodes.item(i1) instanceof Element) {
                                Node node2 = childNodes.item(i1);
                                Element ele = (Element) node2;
                                if (node.getNodeType() == Element.ELEMENT_NODE) {
                                    //System.out.println("name: "+ ele.getAttribute("name"));

                                    list.add((String) ele.getAttribute("name"));

                                }
                            }


                        }

                    }


                }
                //System.out.println("Node name: "+ node.getNodeName());


            }


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
        return list;

    }

    public static List<String> getXmlValueResultType(File file, String actionName) {
        List<String> list = new ArrayList<String>();
        try {
            //String[] acfile = new String[10];

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("action");//获得几个action节点
            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i); //获得每一个action
                NamedNodeMap attributes = node.getAttributes(); //获得每个action的所有属性
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node item = attributes.item(i2);//获得每一个属性

                    if (item.getNodeName().equals("name") && item.getNodeValue().equals(actionName)) {
                        NodeList childNodes = node.getChildNodes();
                        for (int i1 = 0; i1 < childNodes.getLength(); i1++) {
                            if (childNodes.item(i1) instanceof Element) {
                                Node node2 = childNodes.item(i1);
                                Element ele = (Element) node2;
                                if (node.getNodeType() == Element.ELEMENT_NODE) {
                                    //System.out.println("name: "+ ele.getAttribute("name"));

                                    list.add((String) ele.getAttribute("type"));

                                }
                            }


                        }

                    }


                }
                //System.out.println("Node name: "+ node.getNodeName());


            }


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
        return list;

    }

    public static List<String> getXmlValueResultValue(File file, String actionName) {
        List<String> list = new ArrayList<String>();
        try {
            //String[] acfile = new String[10];

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("action");//获得几个action节点
            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i); //获得每一个action
                NamedNodeMap attributes = node.getAttributes(); //获得每个action的所有属性
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node item = attributes.item(i2);//获得每一个属性

                    if (item.getNodeName().equals("name") && item.getNodeValue().equals(actionName)) {
                        NodeList childNodes = node.getChildNodes();
                        for (int i1 = 0; i1 < childNodes.getLength(); i1++) {
                            if (childNodes.item(i1) instanceof Element) {
                                Node node2 = childNodes.item(i1);
                                Element ele = (Element) node2;
                                if (node.getNodeType() == Element.ELEMENT_NODE) {
                                    //System.out.println("name: "+ ele.getAttribute("name"));

                                    list.add((String) ele.getAttribute("value"));

                                }
                            }


                        }

                    }


                }
                //System.out.println("Node name: "+ node.getNodeName());


            }


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
        return list;

    }
}

		