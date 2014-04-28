package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.WeaponEquipment;

public class WeaponXMLDocumentReader extends
	AbstractEquipableItemXMLDocumentReader<WeaponEquipment> {

    public WeaponXMLDocumentReader() {
	super(WeaponEquipment.class);
    }

    @Override
    public WeaponEquipment getValue(final Document doc) {
	final Element skill;
	final WeaponEquipment weapon;
	final Element root;

	weapon = super.getValue(doc);

	root = doc.getRootElement();

	// Acquires the different sections
	skill = root.getChild(FileLabels.SKILL);
	weapon.setSkill(skill.getText());

	return weapon;
    }

}
