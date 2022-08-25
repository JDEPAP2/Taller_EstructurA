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
 *
 * @author PC
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
