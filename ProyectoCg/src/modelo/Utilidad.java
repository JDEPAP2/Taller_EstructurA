/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Element;
import org.jdom2.Document;
import static modelo.Tools.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
/**
* En esta clase se crea el archivo XML donde se guarda el reporte.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class Utilidad {
    public static boolean crearArchivoXML(Orquestador orq[]){
        boolean t = false;
        
        Document doc = new Document();
        doc.setRootElement(new Element("Orquestadores"));
        for (int i = 0; i < orq.length; i++) {
            Orquestador orquestador = orq[i];
            Element o = new Element("Orquestador");
            o.setAttribute("Nombre", orquestador.getTitle());
            o.addContent(new Element("totalPosts").setText("" + orquestador.getPostsAtendidos()));
            o.addContent(new Element("tiempoTotal").setText("" + countOrq(orquestador.getTiempoAtendido())));
            o.addContent(new Element("tiempoPromedio").setText(orquestador.getTiempoPromedio() + " seg"));
            o.addContent(new Element("postMasTiempo").setText("" + orquestador.getPostMayor()));
            o.addContent(new Element("postMenosTiempo").setText("" + orquestador.getPostMenor()));
            doc.getRootElement().addContent(o);
        }
        Element oMayor = new Element("OrquestadorMasDemorado").setText(orqMasDemorado(orq).getTitle());
        doc.getRootElement().addContent(oMayor);
        
        XMLOutputter xmlOutputter = new XMLOutputter();
        try{
            FileOutputStream file = new FileOutputStream("fileOrquestador.xml");
            xmlOutputter.setFormat(Format.getCompactFormat().getPrettyFormat());
            xmlOutputter.output(doc, file);
            
            t = true;
        }catch(IOException e){
            System.out.println("no se guardo");
        }
        
        return t;
    }
}
