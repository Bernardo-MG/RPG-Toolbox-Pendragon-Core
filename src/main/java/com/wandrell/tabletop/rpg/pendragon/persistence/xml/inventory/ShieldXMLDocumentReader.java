package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.rpg.pendragon.inventory.ShieldEquipment;

public class ShieldXMLDocumentReader extends
	AbstractEquipableItemXMLDocumentReader<ShieldEquipment> {

    public ShieldXMLDocumentReader() {
	super(ShieldEquipment.class);
    }

    @Override
    public ShieldEquipment readDocument(final Document doc) {
	return super.readDocument(doc);
    }

}
