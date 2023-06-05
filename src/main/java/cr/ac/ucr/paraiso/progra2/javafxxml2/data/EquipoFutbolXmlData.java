package cr.ac.ucr.paraiso.progra2.javafxxml2.data;

import cr.ac.ucr.paraiso.progra2.javafxxml2.domain.EquipoFutbol;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class EquipoFutbolXmlData
{

    private String rutaDocumento;
    private Element raiz;
    private Document documento;

    private EquipoFutbolXmlData(String rutaDocumento) throws IOException, JDOMException {
        File file = new File(rutaDocumento);
        if (!file.exists()) {
            //se encarga de crear el DOM y el Documento XML
            this.rutaDocumento = rutaDocumento;
            this.raiz = new Element("equipos");
            this.documento = new Document(raiz);
            guardar();
        } else {
            //se encarga de parsear el Documento XML a un DOM
            SAXBuilder saBuilder = new SAXBuilder();
            saBuilder.setIgnoringElementContentWhitespace(true);
            //parseo
            this.documento = saBuilder.build(new File(rutaDocumento));
            this.raiz = documento.getRootElement();

            this.rutaDocumento = rutaDocumento;
        }
    }

    public void guardar() throws FileNotFoundException, IOException {
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(this.documento,
                new PrintWriter(this.rutaDocumento));
        // imprimir en la consola el DOM
        xmlOutputter.output(this.documento, System.out);
    }

    public static EquipoFutbolXmlData abrirDocumento(String rutaDocumento)
            throws JDOMException, IOException {
        return new EquipoFutbolXmlData(rutaDocumento);
    }
    public void insertarEquipo(EquipoFutbol equipoFutbol) throws  IOException{
        Element eEquipo = new Element("equipoFutbol");
        eEquipo.setAttribute("codEquipo", equipoFutbol.getCodEquipo());
        Element eNombre = new Element("nombre");
        eNombre.addContent(equipoFutbol.getNombre());

        Element eCantidadJugadoresInscritos = new Element("cantidadJugadoresInscritos");
        eCantidadJugadoresInscritos.addContent(
                String.valueOf(equipoFutbol.getCantidadJugadoresInscritos()));

        eEquipo.addContent(eNombre);
        eEquipo.addContent(eCantidadJugadoresInscritos);

        raiz.addContent(eEquipo);
        guardar();
    }//insertarEquipo
    public List<EquipoFutbol> getEquipos(){
        List<Element> eEquipos = raiz.getChildren();
        List<EquipoFutbol> equipos = new LinkedList<EquipoFutbol>();
        for (Element eEquipo : eEquipos) {
            EquipoFutbol equipo = new EquipoFutbol();
            equipo.setCodEquipo(eEquipo.getAttributeValue("codEquipo").toString());
            equipo.setNombre(eEquipo.getChildText("nombre"));
            equipo.setCantidadJugadoresInscritos(Integer.parseInt(eEquipo.getChildText("cantidadJugadoresInscritos")));
            equipos.add(equipo);
        }
        return equipos;
    }
}
