package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.AdditionalBelongingsSetData;
import com.wandrell.tabletop.rpg.util.XMLUtils;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class InventoryRollTableXMLDocumentBuilder implements
	XMLDocumentBuilder<RollTable<AdditionalBelongingsSetData>> {

    @Override
    public Document buildDocument(
	    final RollTable<AdditionalBelongingsSetData> holder) {
	final Document doc;
	final Element element;

	// Root and table's name
	element = new Element(FileLabels.INVENTORY_ROLL_TABLE);
	// TODO
	// element.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(element);

	// Intervals and results
	// doc.getRootElement().addContent(buildIntervalsXMLTree(holder));

	return doc;
    }

    private Element buildIntervalsXMLTree(
	    final RollTable<AdditionalBelongingsSetData> holder) {
	final Element root;
	Element intervalNode;

	root = new Element(FileLabels.INTERVALS);
	// for (final Entry<ContrastInterval<Integer>,
	// AdditionalBelongingsSetData> intervals : holder
	// .entrySet()) {
	// intervalNode = XMLUtils.buildIntervalXMLNode(intervals.getKey(),
	// FileLabels.INTERVAL);
	// intervalNode.addContent(buildItemsXMLTree(intervals.getValue()));
	// root.addContent(intervalNode);
	// }

	return root;
    }

    private Element buildItemsXMLTree(final AdditionalBelongingsSetData items) {
	final Element root;
	Element node, node2;
	List<String> listFlags;

	root = new Element(FileLabels.BELONGINGS);

	// Flag marking it has to choose instead of receiving all
	if (items.hasToChoose()) {
	    listFlags = new ArrayList<String>(1);
	    listFlags.add(PendragonLabels.FLAGS_HAS_TO_CHOOSE);
	    node = XMLUtils.buildBooleansSetXMLTree(new Element(
		    FileLabels.FLAGS), listFlags.iterator());
	    root.addContent(node);
	}

	// List of horses
	// TODO
	// node = XMLUtils.buildStringListXMLTree(new
	// Element(FileLabels.HORSES),
	// items.getHorsesFilesIterator(), FileLabels.HORSE);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// List of pets
	// TODO
	// node = XMLUtils.buildStringListXMLTree(new Element(FileLabels.PETS),
	// items.getPetsFilesIterator(), FileLabels.PET);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// List of equipments
	// TODO
	// node = XMLUtils.buildStringListXMLTree(new Element(FileLabels.ITEMS),
	// items.getEquipableItemsFilesIterator(), FileLabels.ITEM);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// List of weapons
	// TODO
	// node = XMLUtils.buildStringListXMLTree(new
	// Element(FileLabels.WEAPONS),
	// items.getWeaponsFilesIterator(), FileLabels.WEAPON);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// List of shields
	// TODO
	// node = XMLUtils.buildStringListXMLTree(new
	// Element(FileLabels.SHIELDS),
	// items.getShieldsFilesIterator(), FileLabels.SHIELD);
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	// Re-roll
	// TODO
	// if (items.getTableFile() != null) {
	// node = new Element(FileLabels.REROLL);
	// node.setAttribute(FileLabels.ROLL_TABLE, items.getTableFile());
	// node2 = XMLUtils.buildIntegerValueHandlerXMLTree(new Element(
	// FileLabels.REROLLS_LIST), items.getRerollsIterator(),
	// FileLabels.REROLL, true);
	// node.addContent(node2);
	//
	// if (node2.getChildren().size() > 0) {
	// root.addContent(node);
	// }
	// }

	// Name
	// TODO
	// if (items.getMoneyName().length() > 0) {
	// root.addContent(new Element(FileStreamerTags.NAME).setText(items
	// .getMoneyName()));
	// }

	// Money
	// TODO
	// node = PersistenceFactory.getItemService().buildMoneyXMLNode(
	// items.getMoneyData());
	// if (node.getChildren().size() > 0) {
	// root.addContent(node);
	// }

	return root;
    }

}
