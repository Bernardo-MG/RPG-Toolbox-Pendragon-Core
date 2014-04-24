package com.wandrell.tabletop.rpg.pendragon.persistence.xml;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.util.stream.api.xml.XMLDocumentReader;

public class TemplateRollableTableXMLDocumentReader implements
	XMLDocumentReader<RollTable<?>> {

    @Override
    public RollTable<?> readDocument(final Document doc) {
	final Element intervals;
	final RollTable<?> holder;
	final Element root;

	root = doc.getRootElement();
	holder = null;

	// TODO
	// holder = ClassInstanceFactory.getNewValue(TemplateRollTable.class);

	// Acquires the different sections
	intervals = root.getChild(FileLabels.INTERVALS);

	// Table's name
	// TODO
	// holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Intervals and results
	readIntervalsXMLTree(intervals, holder);

	return holder;
    }

    private void readIntervalsXMLTree(final Element root,
	    final RollTable<?> holder) {
	String name;

	// Goes through each interval
	for (final Element node : root.getChildren()) {
	    name = node.getAttributeValue(FileStreamerTags.NAME);

	    // TODO
	    // holder.put(
	    // (ContrastInterval<Integer>) XMLUtils
	    // .readIntegerIntervalXMLNode(node),
	    // PersistenceFactory.getPendragonTemplateService()
	    // .readPendragonTemplateXMLTree(
	    // node.getChild(FileLabels.TEMPLATE_BONUS),
	    // new DefaultPendragonTemplate(name)));
	}
    }

}
