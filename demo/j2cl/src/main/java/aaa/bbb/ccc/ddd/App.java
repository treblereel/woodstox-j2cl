package aaa.bbb.ccc.ddd;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.function.Consumer;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLBRElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.HTMLTextAreaElement;
import org.dominokit.jacksonapt.ObjectMapper;
import org.dominokit.jacksonapt.annotation.JSONMapper;
import org.gwtproject.core.client.EntryPoint;
import org.gwtproject.xhr.client.XMLHttpRequest;

public class App implements EntryPoint {

    public static final String HELLO_WORLD = "Hello J2CL world!";
    private static final int DONE = 4;
    private static final String BPSIM_NS = "http://www.bpsim.org/schemas/1.0";
    private static final String BPMN2_NS = "http://www.omg.org/spec/BPMN/20100524/MODEL";
    private static final String BPMNDI_NS = "http://www.omg.org/spec/BPMN/20100524/DI";
    private static final String SCHEMA_LOCATION = "http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd ";
    HTMLDivElement lines = (HTMLDivElement) DomGlobal.document.createElement("div");
    private HTMLTextAreaElement generatedXML = (HTMLTextAreaElement) DomGlobal.document.createElement("textarea");

    @JSONMapper
    public interface PersonMapper extends ObjectMapper<Person> {}


    @Override
    public void onModuleLoad() {

        DomGlobal.console.log("onModuleLoad");

        addLine("Generated xml");

        DomGlobal.document.body.appendChild(generatedXML);
        generatedXML.classList.add("prettyprint", "lang-html");
        generatedXML.style.height = CSSProperties.HeightUnionType.of("20pc");
        generatedXML.style.width = CSSProperties.WidthUnionType.of("700px");
        generatedXML.style.overflow = "scroll";

        addLine("");
        addLine("Parsed xml nodes:");
        DomGlobal.document.body.appendChild(lines);

        createXML();
        readXML();

        Person person = new Person();
        person.setFirstName("Ahmad");
        person.setLastName("Bawaneh");

        Address address = new Address();
        address.setId(1);
        address.setCity("AAAAA");
        address.setStreet("BBBBB");
        person.setAddress(address);

        String personJsonString = Person_MapperImpl.INSTANCE
                .write(person);

        DomGlobal.console.log("? 1 " + personJsonString);


        Person person2 = Person_MapperImpl.INSTANCE.read("{\"firstName\":\"Ahmad\",\"lastName\":\"Bawaneh\",\"address\":{\"id\":1,\"street\":\"BBBBB\",\"city\":\"AAAAA\"}}");

        DomGlobal.console.log("? 2 " + person2.toString());
    }

    private void createXML() {
        XMLOutputFactory factory = new WstxOutputFactory();
        StringWriter sw = new StringWriter();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(sw);

            writer.writeStartDocument();

            writer.setPrefix("bpmn2", BPMN2_NS);
            writer.writeStartElement(BPMN2_NS, "definitions");

            writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeDefaultNamespace("http://www.omg.org/bpmn20");

            writer.writeNamespace("bpmn2", BPMN2_NS);
            writer.writeNamespace("bpmndi", BPMNDI_NS);
            writer.writeNamespace("bpsim", BPSIM_NS);
            writer.writeNamespace("drools", "http://www.jboss.org/drools");
            writer.writeAttribute("id", "_bxngsVbzEeqzafkuxDchIw");
            writer.writeAttribute("xsi:schemaLocation", SCHEMA_LOCATION);
            writer.writeAttribute("exporter", "jBPM Process Modeler");
            writer.writeAttribute("exporterVersion", "j2.0");
            writer.writeAttribute("targetNamespace", "http://www.omg.org/bpmn20");

            writer.setPrefix("bpmn2", BPMN2_NS);
            writer.writeStartElement(BPMN2_NS, "process");
            writer.writeAttribute("id", "asdasd.dddd");
            writer.writeAttribute("drools:packageName", "com.myspace.asdasd");
            writer.writeAttribute("drools:version", "1.0");
            writer.writeAttribute("drools:adHoc", "false");
            writer.writeAttribute("name", "dddd");
            writer.writeAttribute("isExecutable", "true");
            writer.writeAttribute("processType", "Public");
            writer.writeEndElement();

            writer.setPrefix("bpmndi", BPMNDI_NS);
            writer.writeStartElement(BPMNDI_NS, "BPMNDiagram");
            writer.writeAttribute("id", "_bxpV4FbzEeqzafkuxDchIw");
            writer.setPrefix("bpmndi", BPMNDI_NS);
            writer.writeStartElement(BPMNDI_NS, "BPMNPlane");
            writer.writeAttribute("id", "_bxpV4VbzEeqzafkuxDchIw");
            writer.writeAttribute("bpmnElement", "asdasd.dddd");
            writer.writeEndElement();
            writer.writeEndElement();

            writer.setPrefix("bpmn2", BPMN2_NS);
            writer.writeStartElement(BPMN2_NS, "relationship");
            writer.writeAttribute("id", "_bxpV4lbzEeqzafkuxDchIw");
            writer.writeAttribute("type", "BPSimData");

            writer.setPrefix("bpmn2", BPMN2_NS);
            writer.writeStartElement(BPMN2_NS, "extensionElements");

            writer.setPrefix("bpsim", BPSIM_NS);
            writer.writeStartElement(BPSIM_NS, "BPSimData");

            writer.setPrefix("bpsim", BPSIM_NS);
            writer.writeStartElement(BPSIM_NS, "Scenario");
            writer.writeAttribute("xsi:type", "bpsim:Scenario");
            writer.writeAttribute("id", "default");
            writer.writeAttribute("name", "Simulationscenario");

            writer.setPrefix("bpsim", BPSIM_NS);
            writer.writeStartElement(BPSIM_NS, "ScenarioParameters");
            writer.writeAttribute("xsi:type", "bpsim:ScenarioParameters");

            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();

            writer.setPrefix("bpmn2", BPMN2_NS);
            writer.writeStartElement(BPMN2_NS, "source");
            writer.writeCharacters("_bxngsVbzEeqzafkuxDchIw");
            writer.writeEndElement();

            writer.setPrefix("bpmn2", BPMN2_NS);
            writer.writeStartElement(BPMN2_NS, "target");
            writer.writeCharacters("_bxngsVbzEeqzafkuxDchIw");
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.close();

            DomGlobal.console.log(sw.toString());
            generatedXML.textContent = sw.toString();
        } catch (XMLStreamException e) {
            DomGlobal.console.log("XMLStreamException " + e);
        }
    }

    private void readXML() {
        StringBuffer sb = new StringBuffer();

        XMLHttpRequest request = XMLHttpRequest.create();
        request.setOnReadyStateChange(xhr -> {
            if (xhr.getReadyState() == DONE) {
                InputStream byteArrayInputStream = new ByteArrayInputStream(xhr.response.toString().getBytes());
                XMLInputFactory xmlInputFactory = new WstxInputFactory();


                try {
                    XMLStreamReader xmlStreamReader =  xmlInputFactory.createXMLStreamReader(byteArrayInputStream);

                    XMLEventReader reader = xmlInputFactory.createXMLEventReader(byteArrayInputStream);
                    while (reader.hasNext()) {
                        XMLEvent event = reader.nextEvent();

                        if (event.isStartElement()) {
                            StartElement element = (StartElement) event;
                            addLine("ELM  prefix:  " + element.getName().getPrefix() + "  " + element.getName());


                            element.getAttributes().forEachRemaining(new Consumer<Attribute>() {
                                @Override
                                public void accept(Attribute attr) {
                                    StringBuffer sb = new StringBuffer();
                                    sb.append("            Attr ");
                                    sb.append(attr.getName());
                                    sb.append(" -> ");
                                    sb.append(attr.getValue());
                                    addLine(sb.toString());
                                }
                            });

                            DomGlobal.console.log(element.getName());

                        }
                    }
                    reader.close();
                    lines.textContent = sb.toString();
                } catch (XMLStreamException e) {

                }
            }
        });
        request.open("GET", "xml/twodosubprocess.bpmn");
        request.send();
    }

    private void addLine(String value) {
        HTMLLabelElement parsed = (HTMLLabelElement) DomGlobal.document.createElement("label");
        parsed.textContent = value;
        DomGlobal.document.body.appendChild(parsed);


        HTMLBRElement br = (HTMLBRElement) DomGlobal.document.createElement("br");
        DomGlobal.document.body.appendChild(br);

    }
}
