package com.wandrell.tabletop.rpg.pendragon.persistence.xml;

import java.util.Map.Entry;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.tabletop.rpg.interval.ContrastInterval;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.util.XMLUtils;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class RollTableXMLDocumentBuilder implements
	XMLDocumentBuilder<RollTable<String>> {

    @Override
    public Document buildDocument(final RollTable<String> holder) {
	final Document doc;
	final Element element;

	// Root and table's name
	element = new Element(FileLabels.ROLL_TABLE);
	// TODO
	// element.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(element);

	// Intervals and results
	doc.getRootElement().addContent(buildIntervalsXMLTree(holder));

	return doc;
    }

    private Element buildIntervalsXMLTree(final RollTable<String> holder) {
	final Element root;
	Element intervalNode;

	root = new Element(FileLabels.INTERVALS);
	for (final Entry<ContrastInterval<Integer>, String> intervals : holder
		.getValuesMap().entrySet()) {
	    intervalNode = XMLUtils.buildIntervalXMLNode(intervals.getKey(),
		    FileLabels.INTERVAL);
	    intervalNode.addContent(new Element(FileStreamerTags.VALUE)
		    .setText(intervals.getValue()));
	    root.addContent(intervalNode);
	}

	return root;
    }

}
