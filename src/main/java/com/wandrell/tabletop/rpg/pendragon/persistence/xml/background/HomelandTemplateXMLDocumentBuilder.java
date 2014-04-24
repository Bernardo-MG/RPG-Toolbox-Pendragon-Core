package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.background.Homeland;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class HomelandTemplateXMLDocumentBuilder implements
	XMLDocumentBuilder<Homeland> {

    @Override
    public Document buildDocument(final Homeland holder) {
	final Document doc;
	Element node;

	// Main body and name of the template
	node = new Element(FileLabels.HOMELAND);
	node.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(node);

	// TODO
	// PersistenceFactory.getTemplatesContainerService().addToXMLDocument(doc,
	// holder);

	return doc;
    }

}
