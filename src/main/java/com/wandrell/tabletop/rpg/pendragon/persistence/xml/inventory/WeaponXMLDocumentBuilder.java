package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonEquipment;
import com.wandrell.tabletop.rpg.pendragon.inventory.WeaponEquipment;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class WeaponXMLDocumentBuilder implements
	XMLDocumentWriter<WeaponEquipment> {

    private final XMLDocumentWriter<PendragonEquipment> builder = new EquipableItemXMLDocumentBuilder();

    @Override
    public Document getDocument(final WeaponEquipment holder) {
	final Document doc;
	Element node;

	doc = builder.getDocument(holder);

	node = new Element(FileLabels.SKILL);
	node.setText(holder.getSkill());

	doc.getRootElement().setName(FileLabels.WEAPON);

	return doc;
    }

}
