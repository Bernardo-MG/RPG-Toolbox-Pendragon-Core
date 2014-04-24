package com.wandrell.tabletop.rpg.pendragon.persistence.xml;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.dice.DefaultRollTable;
import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.manor.AnimalYearResult;
import com.wandrell.tabletop.rpg.pendragon.manor.DefaultAnimalYearResult;
import com.wandrell.tabletop.rpg.pendragon.manor.DefaultManorAnimal;
import com.wandrell.tabletop.rpg.pendragon.manor.ManorAnimal;
import com.wandrell.util.stream.api.xml.XMLDocumentReader;

public class ManorAnimalXMLDocumentReader implements
	XMLDocumentReader<ManorAnimal> {

    @Override
    public ManorAnimal readDocument(final Document doc) {
	final DefaultManorAnimal holder;
	final Element intervals;
	final Element root;

	root = doc.getRootElement();
	holder = new DefaultManorAnimal(new DefaultRollTable<AnimalYearResult>(
		null, null, null));

	// Acquires the different sections
	intervals = root.getChild(FileLabels.INTERVALS);

	// Pet's name
	holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Intervals and results
	readIntervalsXMLTree(intervals, holder.getAnnualCheckMap());

	return holder;
    }

    private void readIntervalsXMLTree(final Element root,
	    final RollTable<AnimalYearResult> holder) {
	DefaultAnimalYearResult result;

	// Goes through each interval
	for (final Element node : root.getChildren()) {
	    result = readYearResultNode(node.getChild(FileLabels.RESULTS));
	    result.setName(node.getAttributeValue(FileStreamerTags.NAME));
	    // TODO
	    // holder.put((ContrastInterval<Integer>) XMLUtils
	    // .readIntegerIntervalXMLNode(node), result);
	}
    }

    private DefaultAnimalYearResult readYearResultNode(final Element root) {
	final Element values, flags, files;
	final DefaultAnimalYearResult result = new DefaultAnimalYearResult();

	values = root.getChild(FileLabels.VALUE_HANDLERS);
	flags = root.getChild(FileLabels.FLAGS);
	files = root.getChild(FileLabels.SELECTORS_FILES);

	// Values
	if (values != null) {
	    // TODO
	    // result.setValues(XMLUtils.readIntegerValueHandlerXMLTree(values,
	    // new IntegerValueHandler()));
	}

	// Flags
	if (flags != null) {
	    // TODO
	    // result.setFlags(XMLUtils.readBooleanXMLTree(flags));
	}

	// Files
	if (files != null) {
	    // TODO
	    // result.setFiles(XMLUtils.readStringsDictionaryXMLTree(files));
	}

	return result;
    }

}
