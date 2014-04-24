package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.background.DefaultReligion;
import com.wandrell.tabletop.rpg.pendragon.character.background.Religion;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.util.XMLUtils;
import com.wandrell.util.stream.api.xml.XMLDocumentReader;

public class ReligionTemplateXMLDocumentReader implements
	XMLDocumentReader<Religion> {

    @Override
    public Religion readDocument(final Document doc) {
	final DefaultReligion holder;
	final Element traits, bonus;
	final Element root;

	root = doc.getRootElement();
	holder = new DefaultReligion();

	// Acquires the different sections
	traits = root.getChild(FileLabels.TRAITS);
	bonus = root.getChild(FileLabels.TEMPLATE_BONUS);

	// Religion's name
	holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Religious traits
	holder.setReligiousTraits(XMLUtils.readStringsListXMLTree(traits));

	// Religious bonus
	// TODO
	// if (bonus != null) {
	// holder.setBonusTemplate(PersistenceFactory
	// .getPendragonTemplateService()
	// .readPendragonTemplateXMLTree(bonus,
	// new DefaultPendragonTemplate()));
	// }

	return holder;
    }

}
