package com.wandrell.tabletop.pendragon.persistence.xml.inventory;

import org.jdom2.Document;

import com.wandrell.tabletop.pendragon.inventory.ArmorEquipment;

public class ArmorXMLDocumentReader extends
	AbstractEquipableItemXMLDocumentReader<ArmorEquipment> {

    public ArmorXMLDocumentReader() {
	super();
    }

    @Override
    public final ArmorEquipment getValue(final Document doc) {
	return super.getValue(doc);
    }

}
