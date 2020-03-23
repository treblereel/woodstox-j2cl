//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.stream.events;

public interface EntityDeclaration extends XMLEvent {
    String getPublicId();

    String getSystemId();

    String getName();

    String getNotationName();

    String getReplacementText();

    String getBaseURI();
}
