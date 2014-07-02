package com.wandrell.tabletop.pendragon.persistence.xml;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.conf.FileStreamerTags;
import com.wandrell.tabletop.pendragon.conf.FileLabels;
import com.wandrell.tabletop.pendragon.valuehandler.DefaultPendragonSpecialtySkill;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class AdvancedSkillXMLDocumentWriter implements
	XMLDocumentWriter<DefaultPendragonSpecialtySkill> {

    public AdvancedSkillXMLDocumentWriter() {
	super();
    }

    @Override
    public final Document getDocument(
	    final DefaultPendragonSpecialtySkill holder) {
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
