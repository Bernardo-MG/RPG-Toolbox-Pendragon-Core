package com.wandrell.tabletop.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.conf.FileStreamerTags;
import com.wandrell.tabletop.pendragon.conf.FileLabels;
import com.wandrell.tabletop.pendragon.glory.FatherClassGlory;
import com.wandrell.tabletop.util.XMLUtils;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class FatherClassGloryXMLDocumentWriter implements
	XMLDocumentWriter<FatherClassGlory> {

    public FatherClassGloryXMLDocumentWriter() {
	super();
    }

    @Override
    public final Document getDocument(final FatherClassGlory holder) {
	final Document doc;
	Element node;

	// Main body and name of the father's class
	node = new Element(FileLabels.FATHER_CLASS_GLORY);
	node.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(node);

	node = XMLUtils.buildValueHandlerXMLNode(holder.getBaseGlory(),
		FileLabels.FATHER_CLASS_GLORY_BASE);
	doc.getRootElement().addContent(node);

	node = XMLUtils.buildValueHandlerXMLNode(holder.getGloryPerYear(),
		FileLabels.FATHER_CLASS_GLORY_PER_YEAR);
	doc.getRootElement().addContent(node);

	return doc;
    }

}