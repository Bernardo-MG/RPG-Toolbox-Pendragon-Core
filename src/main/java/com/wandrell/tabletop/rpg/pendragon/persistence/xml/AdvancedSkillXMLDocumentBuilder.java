package com.wandrell.tabletop.rpg.pendragon.persistence.xml;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonAggregatedSkill;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class AdvancedSkillXMLDocumentBuilder implements
	XMLDocumentWriter<DefaultPendragonAggregatedSkill> {

    @Override
    public Document getDocument(final DefaultPendragonAggregatedSkill holder) {
	final Document doc;
	Element element;

	// Root and skill name
	element = new Element(FileLabels.ADVANCED_SKILL);
	element.setAttribute(FileStreamerTags.NAME, holder.getName());

	doc = new Document(element);

	// Skills list
	// TODO
	// doc.getRootElement().addContent(
	// XMLUtils.buildStringListXMLTree(new Element(FileLabels.SKILLS),
	// holder.getSkillsNames(), FileLabels.SKILL));

	return doc;
    }

}