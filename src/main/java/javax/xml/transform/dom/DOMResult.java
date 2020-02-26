//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.transform.dom;

import javax.xml.transform.Result;

import elemental2.dom.Node;

public class DOMResult implements Result {
    public static final String FEATURE = "http://javax.xml.transform.dom.DOMResult/feature";
    private Node node = null;
    private Node nextSibling = null;
    private String systemId = null;

    public DOMResult() {
        this.setNode((Node)null);
        this.setNextSibling((Node)null);
        this.setSystemId((String)null);
    }

    public DOMResult(Node node) {
        this.setNode(node);
        this.setNextSibling((Node)null);
        this.setSystemId((String)null);
    }

    public DOMResult(Node node, String systemId) {
        this.setNode(node);
        this.setNextSibling((Node)null);
        this.setSystemId(systemId);
    }

    public DOMResult(Node node, Node nextSibling) {
        if (nextSibling != null) {
            if (node == null) {
                throw new IllegalArgumentException("Cannot create a DOMResult when the nextSibling is contained by the \"null\" node.");
            }

            if ((node.compareDocumentPosition(nextSibling) & 16) == 0) {
                throw new IllegalArgumentException("Cannot create a DOMResult when the nextSibling is not contained by the node.");
            }
        }

        this.setNode(node);
        this.setNextSibling(nextSibling);
        this.setSystemId((String)null);
    }

    public DOMResult(Node node, Node nextSibling, String systemId) {
        if (nextSibling != null) {
            if (node == null) {
                throw new IllegalArgumentException("Cannot create a DOMResult when the nextSibling is contained by the \"null\" node.");
            }

            if ((node.compareDocumentPosition(nextSibling) & 16) == 0) {
                throw new IllegalArgumentException("Cannot create a DOMResult when the nextSibling is not contained by the node.");
            }
        }

        this.setNode(node);
        this.setNextSibling(nextSibling);
        this.setSystemId(systemId);
    }

    public void setNode(Node node) {
        if (this.nextSibling != null) {
            if (node == null) {
                throw new IllegalStateException("Cannot create a DOMResult when the nextSibling is contained by the \"null\" node.");
            }

            if ((node.compareDocumentPosition(this.nextSibling) & 16) == 0) {
                throw new IllegalArgumentException("Cannot create a DOMResult when the nextSibling is not contained by the node.");
            }
        }

        this.node = node;
    }

    public Node getNode() {
        return this.node;
    }

    public void setNextSibling(Node nextSibling) {
        if (nextSibling != null) {
            if (this.node == null) {
                throw new IllegalStateException("Cannot create a DOMResult when the nextSibling is contained by the \"null\" node.");
            }

            if ((this.node.compareDocumentPosition(nextSibling) & 16) == 0) {
                throw new IllegalArgumentException("Cannot create a DOMResult when the nextSibling is not contained by the node.");
            }
        }

        this.nextSibling = nextSibling;
    }

    public Node getNextSibling() {
        return this.nextSibling;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemId() {
        return this.systemId;
    }
}
