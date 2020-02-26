//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.stream.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public interface XMLEventAllocator {
    XMLEvent allocate(XMLStreamReader var1) throws XMLStreamException;

    void allocate(XMLStreamReader var1, XMLEventConsumer var2) throws XMLStreamException;

    XMLEventAllocator newInstance();
}
