package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonEquipment;

public class DefaultEquipableItemXMLDocumentReader extends
	AbstractEquipableItemXMLDocumentReader<PendragonEquipment> {

    public DefaultEquipableItemXMLDocumentReader() {
	super(PendragonEquipment.class);
    }

}
