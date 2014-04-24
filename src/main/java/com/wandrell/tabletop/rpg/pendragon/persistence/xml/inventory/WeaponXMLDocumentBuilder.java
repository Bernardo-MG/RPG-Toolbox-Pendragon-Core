package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonEquipment;
import com.wandrell.tabletop.rpg.pendragon.inventory.WeaponEquipment;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class WeaponXMLDocumentBuilder implements
	XMLDocumentBuilder<WeaponEquipment> {

    private final XMLDocumentBuilder<PendragonEquipment> builder = new EquipableItemXMLDocumentBuilder();

    @Override
    public Document buildDocument(final WeaponEquipment holder) {
	final Document doc;
	Element node;

	doc = builder.buildDocument(holder);

	node = new Element(FileLabels.SKILL);
	node.setText(holder.getSkill());

	doc.getRootElement().setName(FileLabels.WEAPON);

	return doc;
    }

}
