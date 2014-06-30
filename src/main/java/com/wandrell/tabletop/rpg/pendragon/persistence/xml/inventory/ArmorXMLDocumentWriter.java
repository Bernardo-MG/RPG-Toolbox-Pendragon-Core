package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.ArmorEquipment;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonEquipment;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class ArmorXMLDocumentWriter implements
	XMLDocumentWriter<ArmorEquipment> {

    private final XMLDocumentWriter<PendragonEquipment> builder = new EquipableItemXMLDocumenWriter();

    public ArmorXMLDocumentWriter() {
	super();
    }

    @Override
    public final Document getDocument(final ArmorEquipment holder) {
	final Document doc;

	doc = builder.getDocument(holder);

	doc.getRootElement().setName(FileLabels.ARMOR);

	return doc;
    }

}
