package com.hbv.appz1_hbv_l5.composite;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {
    private Node root;

    public Manager() {
        this.root = new Node("", "Root");
    }

    public void addComposite(String parentCode, String name) {
        Node parent = findNodeByCode(root, parentCode);
        if (parent != null) {
            Node newCategory = new Node(parentCode + "01", name);
            parent.add(newCategory);
        }
    }

    public void addProduct(String parentCode, String name, double price) {
        Node parent = findNodeByCode(root, parentCode);
        if (parent != null) {
            Product newProduct = new Product(parentCode + "01", name, price);
            parent.add(newProduct);
        }
    }

    public void removeComponent(String absoluteCode) {
        IComponent component = findComponentByCode(root, absoluteCode);
        if (component != null) {
            Node parent = findParentNode(root, absoluteCode);
            if (parent != null) {
                parent.remove(component);
            }
        }
    }

    private Node findNodeByCode(Node node, String code) {
        if (node.getAbsoluteCode().equals(code)) {
            return node;
        }
        for (IComponent child : node.getChildren()) {
            if (child instanceof Node) {
                Node found = findNodeByCode((Node) child, code);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private IComponent findComponentByCode(Node node, String code) {
        if (node.getAbsoluteCode().equals(code)) {
            return node;
        }
        for (IComponent child : node.getChildren()) {
            if (child.getAbsoluteCode().equals(code)) {
                return child;
            }
            if (child instanceof Node) {
                IComponent found = findComponentByCode((Node) child, code);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private Node findParentNode(Node node, String code) {
        for (IComponent child : node.getChildren()) {
            if (child.getAbsoluteCode().equals(code)) {
                return node;
            }
            if (child instanceof Node) {
                Node found = findParentNode((Node) child, code);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    public void writeToXMLFile(String fileName) {

        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(Node.class);
        xstream.processAnnotations(Product.class);
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("Node", Node.class);
        xstream.alias("Product", Product.class);
        try {
            xstream.toXML(root, new FileWriter(fileName));
        } catch (IOException e) {
            System.err.println("File could not be written to file " + fileName);
        }
    }

    public void getElementsFromXMLFile(String fileName) {
        try {
            root = new Node("", "Root");

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement();
            parseElement(rootElement, root);
        } catch (ParserConfigurationException e) {
            System.err.println("Parser configuration error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File could not be read from file " + fileName);
        } catch (SAXException e) {
            System.err.println("SAX error: " + e.getMessage());
        }
    }

    private void parseElement(Element element, Node parent) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element) {
                Element childElement = (Element) children.item(i);

                if ("Node".equals(childElement.getTagName())) {
                    String code = childElement.getAttribute("absoluteCode");
                    String name = childElement.getAttribute("name");
                    Node newNode = new Node(code, name);
                    parent.add(newNode);

                    parseElement(childElement, newNode);
                } else if ("Product".equals(childElement.getTagName())) {
                    String code = childElement.getAttribute("absoluteCode");
                    String name = childElement.getAttribute("name");
                    double price = Double.parseDouble(childElement.getAttribute("price"));
                    Product newProduct = new Product(code, name, price);
                    parent.add(newProduct);
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }
}
