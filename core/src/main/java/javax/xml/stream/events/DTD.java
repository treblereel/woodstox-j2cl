//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.stream.events;

import java.util.List;

public interface DTD extends XMLEvent {
    String getDocumentTypeDeclaration();

    Object getProcessedDTD();

    List getNotations();

    List getEntities();
}
