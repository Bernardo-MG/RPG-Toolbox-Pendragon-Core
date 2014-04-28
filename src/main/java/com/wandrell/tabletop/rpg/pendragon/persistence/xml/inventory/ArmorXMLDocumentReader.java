package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.rpg.pendragon.inventory.ArmorEquipment;

public class ArmorXMLDocumentReader extends
	AbstractEquipableItemXMLDocumentReader<ArmorEquipment> {

    public ArmorXMLDocumentReader() {
	super(ArmorEquipment.class);
    }

    @Override
    public ArmorEquipment getValue(final Document doc) {
	return super.getValue(doc);
    }

}
