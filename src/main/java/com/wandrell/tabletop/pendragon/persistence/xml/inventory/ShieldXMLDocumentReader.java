package com.wandrell.tabletop.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.pendragon.inventory.ShieldEquipment;

public final class ShieldXMLDocumentReader extends
	AbstractEquipableItemXMLDocumentReader<ShieldEquipment> {

    public ShieldXMLDocumentReader() {
	super();
    }

    @Override
    public final ShieldEquipment getValue(final Document doc) {
	return super.getValue(doc);
    }

}
