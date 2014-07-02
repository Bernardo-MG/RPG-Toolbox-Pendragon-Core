package com.wandrell.tabletop.pendragon.persistence.xml;

import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.conf.FileStreamerTags;
import com.wandrell.tabletop.pendragon.conf.FileLabels;
import com.wandrell.tabletop.pendragon.valuehandler.DefaultPendragonSpecialtySkill;
import com.wandrell.tabletop.util.XMLUtils;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class AdvancedSkillXMLDocumentReader implements
	XMLDocumentReader<DefaultPendragonSpecialtySkill> {

    public AdvancedSkillXMLDocumentReader() {
	super();
    }

    @SuppressWarnings("unused")
    @Override
    public final DefaultPendragonSpecialtySkill getValue(final Document doc) {
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
