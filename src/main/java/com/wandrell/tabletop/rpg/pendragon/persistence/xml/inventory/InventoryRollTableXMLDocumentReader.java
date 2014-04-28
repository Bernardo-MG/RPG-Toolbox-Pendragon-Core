package com.wandrell.tabletop.rpg.pendragon.persistence.xml.inventory;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.AdditionalBelongingsSetData;
import com.wandrell.tabletop.rpg.pendragon.inventory.DefaultAdditionalBelongingsSetData;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class InventoryRollTableXMLDocumentReader implements
	XMLDocumentReader<RollTable<AdditionalBelongingsSetData>> {

    @Override
    public RollTable<AdditionalBelongingsSetData> getValue(final Document doc) {
	final RollTable<AdditionalBelongingsSetData> holder;
	final Element intervals;
	final Element root;

	root = doc.getRootElement();
	// TODO
	// holder = ClassInstanceFactory.getNewValue(InventoryRollTable.class);

	// Acquires the different sections
	intervals = root.getChild(FileLabels.INTERVALS);

	// Table's name
	// TODO
	// holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Intervals and results
	// TODO
	// readIntervalsXMLTree(intervals, holder);

	return null;
    }

    private void readIntervalsXMLTree(final Element root,
	    final RollTable<AdditionalBelongingsSetData> holder) {
	Element belongings;
	DefaultAdditionalBelongingsSetData items;

	for (final Element node : root.getChildren()) {
	    items = new DefaultAdditionalBelongingsSetData();

	    belongings = node.getChild(FileLabels.BELONGINGS);

	    readItemsXMLTree(belongings, items);

	    // TODO
	    // holder.put((ContrastInterval<Integer>) XMLUtils
	    // .readIntegerIntervalXMLNode(node), items);
	}

    }

    private void readItemsXMLTree(final Element root,
	    final DefaultAdditionalBelongingsSetData holder) {
	final Element flags, horses, equipment, pets, reroll, rerolls, weapons, shields, money, name;

	flags = root.getChild(FileLabels.FLAGS);
	horses = root.getChild(FileLabels.HORSES);
	equipment = root.getChild(FileLabels.ITEMS);
	weapons = root.getChild(FileLabels.WEAPONS);
	shields = root.getChild(FileLabels.SHIELDS);
	reroll = root.getChild(FileLabels.REROLL);
	pets = root.getChild(FileLabels.PETS);
	money = root.getChild(FileLabels.MONEY);
	name = root.getChild(FileStreamerTags.NAME);

	// Name
	if (name != null) {
	    holder.setMoneyName(name.getText());
	}

	// Flags
	if (flags != null) {
	    if (flags.getChildren().size() > 0) {
		holder.setHasToChoose(flags.getChildren().get(0)
			.getAttributeValue(FileStreamerTags.VALUE)
			.equalsIgnoreCase("true"));
	    }
	}

	// List of horses
	if (horses != null) {
	    // TODO
	    // holder.setHorsesFiles(XMLUtils.readStringsListXMLTree(horses));
	}

	// List of pets
	if (pets != null) {
	    // TODO
	    // holder.setPetsFiles(XMLUtils.readStringsListXMLTree(pets));
	}

	// List of equipment
	if (equipment != null) {
	    // TODO
	    // holder.setEquippableItemsFiles(XMLUtils
	    // .readStringsListXMLTree(equipment));
	}

	// List of weapons
	if (weapons != null) {
	    // holder.setWeaponsFiles(XMLUtils.readStringsListXMLTree(weapons));
	}

	// List of shields
	if (shields != null) {
	    // holder.setWeaponsFiles(XMLUtils.readStringsListXMLTree(shields));
	}

	// Re-roll
	if (reroll != null) {
	    rerolls = reroll.getChild(FileLabels.REROLLS_LIST);
	    if (rerolls != null) {
		// TODO
		// holder.setReroll(reroll
		// .getAttributeValue(FileLabels.ROLL_TABLE), XMLUtils
		// .readIntegerValueHandlerXMLTree(rerolls,
		// new IntegerValueHandler()));
	    }
	}

	// Money
	if (money != null) {
	    // TODO
	    // PersistenceFactory.getItemService().readMoneyXMLNode(money,
	    // holder.getMoneyData());
	}

    }

}
