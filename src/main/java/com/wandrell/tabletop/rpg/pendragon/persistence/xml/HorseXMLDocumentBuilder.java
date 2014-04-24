package com.wandrell.tabletop.rpg.pendragon.persistence.xml;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.HorseCharacter;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class HorseXMLDocumentBuilder implements
	XMLDocumentBuilder<HorseCharacter> {

    @Override
    public Document buildDocument(final HorseCharacter holder) {
	final Document doc;
	Element node;

	doc = new Document(new Element(FileLabels.HORSE));
	// TODO
	// PersistenceFactory.getCharacterService().addBaseCharacterToDocument(
	// doc, holder);

	// Horse race
	doc.getRootElement().setAttribute(FileStreamerTags.NAME,
		holder.getHorseType());
	doc.getRootElement().addContent(0,
		new Element(FileLabels.RACE).setText(holder.getHorseType()));

	// Secondary attributes
	// TODO
	// doc.getRootElement().addContent(
	// XMLUtils.buildIntegerValueHandlerXMLTree(new Element(
	// FileLabels.SECONDARY_ATTRIBUTES), holder
	// .getSecondaryAttributesIterator(),
	// FileLabels.SECONDARY_ATTRIBUTE));

	// Flags
	// TODO
	// node = XMLUtils.buildBooleansSetXMLTree(new
	// Element(FileLabels.FLAGS),
	// holder.getFlagsIterator());
	// if (node.getChildren().size() > 0) {
	// doc.getRootElement().addContent(node);
	// }

	return doc;
    }

}
