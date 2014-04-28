package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonEquipment;
import com.wandrell.tabletop.rpg.pendragon.inventory.ShieldEquipment;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class ShieldXMLDocumentBuilder implements
	XMLDocumentWriter<ShieldEquipment> {

    private final XMLDocumentWriter<PendragonEquipment> builder = new EquipableItemXMLDocumentBuilder();

    @Override
    public Document getDocument(final ShieldEquipment holder) {
	final Document doc;

	doc = builder.getDocument(holder);

	doc.getRootElement().setName(FileLabels.SHIELD);

	return doc;
    }

}
