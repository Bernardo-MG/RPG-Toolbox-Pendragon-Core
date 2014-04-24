package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.ArmorEquipment;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonEquipment;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class ArmorXMLDocumentBuilder implements
	XMLDocumentBuilder<ArmorEquipment> {

    private final XMLDocumentBuilder<PendragonEquipment> builder = new EquipableItemXMLDocumentBuilder();

    @Override
    public Document buildDocument(final ArmorEquipment holder) {
	final Document doc;

	doc = builder.buildDocument(holder);

	doc.getRootElement().setName(FileLabels.ARMOR);

	return doc;
    }

}
