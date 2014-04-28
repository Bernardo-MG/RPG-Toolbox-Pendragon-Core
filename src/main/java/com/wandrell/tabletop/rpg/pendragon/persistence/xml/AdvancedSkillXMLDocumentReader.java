package com.wandrell.tabletop.rpg.pendragon.persistence.xml;

import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonAggregatedSkill;
import com.wandrell.tabletop.rpg.util.XMLUtils;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class AdvancedSkillXMLDocumentReader implements
	XMLDocumentReader<DefaultPendragonAggregatedSkill> {

    @Override
    public DefaultPendragonAggregatedSkill getValue(final Document doc) {
	final Element skills;
	final Iterator<String> itrSkills;
	final String name;
	final Element root;

	root = doc.getRootElement();

	// Acquires the different sections
	skills = root.getChild(FileLabels.SKILLS);

	// Skill's name
	name = root.getAttributeValue(FileStreamerTags.NAME);

	// Acquires the different sections
	itrSkills = XMLUtils.readStringsListXMLTree(skills);

	// TODO
	// return new DefaultPendragonAggregatedSkill(name, itrSkills);
	return null;
    }

}
