package com.wandrell.tabletop.rpg.pendragon.persistence.xml.character;

import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.HorseCharacter;
import com.wandrell.tabletop.rpg.pendragon.character.PendragonPlayerCharacter;
import com.wandrell.tabletop.rpg.pendragon.character.background.FamilyCharacteristic;
import com.wandrell.tabletop.rpg.pendragon.character.follower.Child;
import com.wandrell.tabletop.rpg.pendragon.character.follower.Follower;
import com.wandrell.tabletop.rpg.pendragon.character.follower.Wife;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.glory.DefaultGloryEvent;
import com.wandrell.tabletop.rpg.pendragon.glory.GloryController;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonItem;
import com.wandrell.tabletop.rpg.util.XMLUtils;
import com.wandrell.util.file.api.xml.XMLDocumentWriter;

public class PlayerCharacterXMLDocumentBuilder implements
	XMLDocumentWriter<PendragonPlayerCharacter> {

    private static Element buildGloryEventXMLNode(final DefaultGloryEvent glory) {
	final Element gloryNode;

	gloryNode = new Element(FileLabels.GLORY_EVENT);
	gloryNode.setAttribute(FileLabels.DATE,
		String.valueOf(glory.getYear().getStoredValue()));
	gloryNode.setAttribute(FileLabels.GLORY,
		String.valueOf(glory.getGloryGained().getStoredValue()));
	gloryNode.addContent(new Element(FileLabels.GLORY_EVENT_DESCRIPTION)
		.setText(String.valueOf(glory.getInfo())));

	return gloryNode;
    }

    private static Element buildGloryXMLTree(final GloryController holder) {
	final Element nodeGlory = new Element(FileLabels.GLORY_HISTORY);
	final Iterator<DefaultGloryEvent> iteratorGlory;

	// TODO
	// iteratorGlory = holder.getGloryHistoryIterator();
	// while (iteratorGlory.hasNext()) {
	// nodeGlory.addContent(buildGloryEventXMLNode(iteratorGlory.next()));
	// }

	return nodeGlory;
    }

    @Override
    public Document getDocument(final PendragonPlayerCharacter holder) {
	final Document doc;

	// TODO
	// doc = new Document(new Element(FileLabels.CHARACTER));
	// PersistenceFactory.getCharacterService().addSimpleCharacterToDocument(
	// doc, holder);

	// Glory
	// TODO
	// doc.getRootElement().addContent(
	// buildGloryXMLTree(holder.getGloryData()));

	// ValueHandlers
	// TODO
	// doc.getRootElement().addContent(
	// XMLUtils.buildIntegerValueHandlerXMLTree(new Element(
	// FileLabels.VALUE_HANDLERS), holder
	// .getValueHandlersIterator(), FileLabels.VALUE_HANDLER));

	// Flags
	// TODO
	// doc.getRootElement().addContent(
	// XMLUtils.buildBooleansSetXMLTree(new Element(FileLabels.FLAGS),
	// holder.getFlagsIterator()));

	// Text values
	// TODO
	// doc.getRootElement().addContent(
	// XMLUtils.buildStringsDictionaryXMLTree(new Element(
	// FileLabels.TEXT_VALUES),
	// holder.getTextValuesIterator(), FileLabels.TEXT_VALUE));

	// Features
	// TODO
	// XMLUtils.buildIntegerValueHandlerXMLTree(new
	// Element(FileLabels.FEATURES),
	// holder.getFeaturesIterator(), FileLabels.FEATURE);

	// Wives
	// TODO
	// doc.getRootElement().addContent(
	// buildWivesXMLTree(holder.getWivesIterator()));

	// Items carried
	// TODO
	// doc.getRootElement().addContent(
	// buildHoldingsXMLTree(holder.getHoldingsCarriedIterator(),
	// FileLabels.ITEMS_CARRIED));

	// Items at home
	// TODO
	// doc.getRootElement().addContent(
	// buildHoldingsXMLTree(holder.getHoldingsAtHomeIterator(),
	// FileLabels.ITEMS_AT_HOME));

	// Money
	// TODO
	// doc.getRootElement().addContent(
	// PersistenceFactory.getItemService().buildMoneyXMLNode(
	// holder.getMoneyData()));

	// Horses
	// TODO
	// doc.getRootElement().addContent(
	// buildHorsesXMLTree(holder.getHorsesIterator()));

	// Followers
	// doc.getRootElement().addContent(
	// buildFollowersXMLTree(holder.getFollowersIterator()));

	return null;
    }

    private Element buildFamilyCharacteristicXMLTree(
	    final FamilyCharacteristic characteristic) {
	final Element root, bonusNode;

	root = new Element(FileLabels.FAMILY_CHARACTERISTIC);
	root.setAttribute(FileStreamerTags.NAME, characteristic.getName());

	// TODO
	// bonusNode = PersistenceFactory.getPendragonTemplateService()
	// .buildPendragonTemplateXMLNode(characteristic,
	// new Element(FileLabels.TEMPLATE_BONUS));
	// root.addContent(bonusNode);

	return root;
    }

    private Element buildFollowersXMLTree(final Iterator<Follower> itrFollowers) {
	Element root = new Element(FileLabels.FOLLOWERS);
	while (itrFollowers.hasNext()) {
	    root.addContent(buildFollowerXMLTree(itrFollowers.next()));
	}
	return root;
    }

    private Element buildFollowerXMLTree(final Follower follower) {
	final Element followerNode;

	followerNode = new Element(FileLabels.FOLLOWER);
	followerNode.setAttribute(FileLabels.FILE, follower.getFile());
	followerNode.setAttribute(FileLabels.JOB, follower.getJob());

	return followerNode;
    }

    private Element buildHoldingsXMLTree(
	    final Iterator<PendragonItem> itrHoldings, final String rootName) {
	Element root = new Element(rootName);
	while (itrHoldings.hasNext()) {
	    // TODO
	    // root.addContent(PersistenceFactory.getItemService()
	    // .buildItemXMLNode(itrHoldings.next()));
	}
	return root;
    }

    private Element buildHorsesXMLTree(final Iterator<HorseCharacter> itrHorses) {
	Element root = new Element(FileLabels.HORSES);
	while (itrHorses.hasNext()) {
	    root.addContent(buildHorseXMLTree(itrHorses.next()));
	}
	return root;
    }

    private Element buildHorseXMLTree(final HorseCharacter horse) {
	final Element horseNode;

	horseNode = new Element(FileLabels.HORSE);
	horseNode.setAttribute(FileStreamerTags.NAME, horse.getName());
	horseNode.setAttribute(FileLabels.RACE, horse.getHorseType());
	// TODO
	// horseNode.addContent(XMLUtils.buildBooleansSetXMLTree(new Element(
	// FileLabels.FLAGS), horse.getFlagsIterator()));

	return horseNode;
    }

    private Element buildWifeXMLTree(final Wife wife) {
	final Element root, children;
	final Iterator<Child> iteratorChildren;
	Child child;
	Element childNode;

	root = new Element(FileLabels.WIFE);
	root.setAttribute(FileLabels.FILE, wife.getFile());
	root.addContent(XMLUtils.buildValueHandlerXMLNode(wife.getYearWed(),
		FileLabels.YEAR_WEDDING));

	children = new Element(FileLabels.CHILDREN);
	// TODO
	// iteratorChildren = wife.getChildrenIterator();
	// while (iteratorChildren.hasNext()) {
	// child = iteratorChildren.next();
	// childNode = new Element(FileLabels.CHILD);
	// childNode.setAttribute(FileStreamerTags.NAME, child.getChildName());
	// childNode.addContent(new Element(FileLabels.GENDER).setText(String
	// .valueOf(child.getGender().name())));
	// childNode.addContent(XMLUtils.buildValueHandlerXMLNode(
	// child.getYearBorn(), FileLabels.YEAR_BORN));
	// childNode.addContent(XMLUtils.buildValueHandlerXMLNode(
	// child.getYearDeath(), FileLabels.YEAR_DEATH));
	//
	// children.addContent(childNode);
	// }
	root.addContent(children);

	return root;
    }

    private Element buildWivesXMLTree(final Iterator<Wife> itrWives) {
	Element root = new Element(FileLabels.WIVES);
	while (itrWives.hasNext()) {
	    root.addContent(buildWifeXMLTree(itrWives.next()));
	}
	return root;
    }
}