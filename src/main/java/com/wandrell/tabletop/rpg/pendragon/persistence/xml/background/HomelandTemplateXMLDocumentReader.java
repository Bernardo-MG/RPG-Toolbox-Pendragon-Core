package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.background.DefaultHomeland;
import com.wandrell.tabletop.rpg.pendragon.character.background.Homeland;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class HomelandTemplateXMLDocumentReader implements
	XMLDocumentReader<Homeland> {

    @Override
    public Homeland getValue(final Document doc) {
	final DefaultHomeland holder;
	final Element root;

	root = doc.getRootElement();
	holder = new DefaultHomeland();

	// Homeland's name
	holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// TODO
	// PersistenceFactory.getTemplatesContainerService().readXMLTree(root,
	// holder);

	return holder;
    }

}
