package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.glory.DefaultFatherClassGlory;
import com.wandrell.tabletop.rpg.pendragon.glory.FatherClassGlory;
import com.wandrell.util.stream.api.xml.XMLDocumentReader;

public class FatherClassGloryXMLDocumentReader implements
	XMLDocumentReader<FatherClassGlory> {

    @Override
    public FatherClassGlory readDocument(final Document doc) {
	final DefaultFatherClassGlory holder;
	final Element gloryBase, gloryYear;
	final Element root;

	root = doc.getRootElement();

	holder = new DefaultFatherClassGlory();

	gloryBase = root.getChild(FileLabels.FATHER_CLASS_GLORY_BASE);
	gloryYear = root.getChild(FileLabels.FATHER_CLASS_GLORY_PER_YEAR);

	// Father's class name
	holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Base glory
	if (gloryBase != null) {
	    // TODO
	    // holder.getBaseGlory().setValue(
	    // XMLUtils.readIntegerValueHandlerXMLNode(gloryBase,
	    // new IntegerValueHandler()).getStoredValue());
	}

	// Per year glory
	if (gloryBase != null) {
	    // TODO
	    // holder.getGloryPerYear().setValue(
	    // XMLUtils.readIntegerValueHandlerXMLNode(gloryYear,
	    // new IntegerValueHandler()).getStoredValue());
	}

	return holder;
    }

}
