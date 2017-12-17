package com.ustc.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import water.ustc.interceptor.Interceptor;

public class ReadXmlFile {
    //private static String[] acfile;
    private static Map<String,String> interceptorMap= new HashMap<String, String>();
    public static Map<String,String> getInterceptorMap(File file){
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

                   if (item.getNodeName().equals("name")) {
                       String actionName = item.getNodeValue();
                        NodeList childNodes = node.getChildNodes();
                        for (int i1 = 0; i1 < childNodes.getLength(); i1++) {
                            if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("interceptro-ref")) {
                                Node node2 = childNodes.item(i1);
                                Element ele = (Element) node2;
                                if (node.getNodeType() == Element.ELEMENT_NODE) {
                                    interceptorMap.put(actionName,ele.getAttribute("name"));

                                }
                            }

                        }
                   }

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
        return interceptorMap;

    }
    public static List<Interceptor> getInterceptor(File file){
        List<Interceptor> list = new ArrayList<Interceptor>();
        try {
            //String[] acfile = new String[10];

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("interceptor");
            for (int i = 0; i < nList.getLength(); i++) {
                Interceptor interceptor = new Interceptor();
                Node node = nList.item(i);
                //System.out.println("Node name: "+ node.getNodeName());
                Element ele = (Element) node;
                if (node.getNodeType() == Element.ELEMENT_NODE) {
                    NodeList childNodes = node.getChildNodes();
                    for (int i1 = 0; i1 < childNodes.getLength(); i1++) {
                        if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("name")) {
                            Node node2 = childNodes.item(i1);
                            Element element = (Element) node2;
                            if (node.getNodeType() == Element.ELEMENT_NODE) {
                                interceptor.setName(element.getTextContent());
                                System.out.println(element.getTextContent());
                            }
                        }
                        if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("class")) {
                            Node node2 = childNodes.item(i1);
                            Element element = (Element) node2;
                            if (node.getNodeType() == Element.ELEMENT_NODE) {
                                interceptor.set_class(element.getTextContent());
                                System.out.println(element.getTextContent());
                            }
                        }
                        if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("predo")) {
                            Node node2 = childNodes.item(i1);
                            Element element = (Element) node2;
                            if (node.getNodeType() == Element.ELEMENT_NODE) {
                                interceptor.setPreDo(element.getTextContent());
                                System.out.println(element.getTextContent());
                            }
                        }
                        if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("afterdo")) {
                            Node node2 = childNodes.item(i1);
                            Element element = (Element) node2;
                            if (node.getNodeType() == Element.ELEMENT_NODE) {
                                interceptor.setAfterDo(element.getTextContent());
                                System.out.println(element.getTextContent());
                            }
                        }
                    }

                }
                list.add(interceptor);
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
                            if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("result")) {
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
                            if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("result")) {
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
                            if (childNodes.item(i1) instanceof Element&&((Element) childNodes.item(i1)).getTagName().equals("result")) {
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

		