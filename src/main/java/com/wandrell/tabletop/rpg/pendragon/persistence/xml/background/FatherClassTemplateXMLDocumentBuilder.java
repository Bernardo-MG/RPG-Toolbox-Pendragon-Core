package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.background.FatherClass;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class FatherClassTemplateXMLDocumentBuilder implements
	XMLDocumentWriter<FatherClass> {

    @Override
    public Document getDocument(final FatherClass holder) {
	final Document doc;
	Element node;

	// Main body and name of the father's class
	node = new Element(FileLabels.FATHER_CLASS);
	node.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(node);

	// TODO
	// PersistenceFactory.getTemplatesContainerService().addToXMLDocument(doc,
	// holder);

	// Skills group
	node = buildSkillsGroupXMLTree(holder);
	if (node.getChildren().size() > 0) {
	    doc.getRootElement().addContent(node);
	}

	// Skills points
	// TODO
	// node = XMLUtils.buildIntegerValueHandlerXMLTree(new Element(
	// FileLabels.SKILLS_POINTS), holder.getSkillsPointsIterator(),
	// FileLabels.SKILL_POINTS);
	if (node.getChildren().size() > 0) {
	    doc.getRootElement().addContent(node);
	}

	// Money
	// TODO
	// node = PersistenceFactory.getItemService().buildMoneyXMLNode(
	// holder.getMoneyData());
	if (node.getChildren().size() > 0) {
	    doc.getRootElement().addContent(node);
	}

	return doc;
    }

    private Element buildSkillsGroupXMLTree(final FatherClass holder) {
	// TODO
	// final Iterator<DefaultPendragonSkill> iterator;
	// Element root, nodeVH, skillsRoot;
	//
	// root = new Element(FileLabels.SKILLS_GROUP);
	//
	// iterator = holder.getSkillsGroupIterator();
	// skillsRoot = new Element(FileLabels.SKILLS);
	// while (iterator.hasNext()) {
	// nodeVH = XMLUtils.buildValueHandlerXMLNode(iterator.next(),
	// FileLabels.SKILL);
	// nodeVH.removeAttribute(FileStreamerTags.VALUE);
	// skillsRoot.addContent(nodeVH);
	// }
	//
	// if (skillsRoot.getChildren().size() > 0) {
	// root.addContent(new Element(NameLabels.VH_SKILLS_POINTS)
	// .setAttribute(
	// FileStreamerTags.VALUE,
	// holder.getSkillsGroupPoints().getStoredValue()
	// .toString()).setAttribute(
	// FileStreamerTags.NAME, NameLabels.VH_SKILLS_POINTS));
	// root.addContent(skillsRoot);
	// }
	//
	return null;
    }

}
