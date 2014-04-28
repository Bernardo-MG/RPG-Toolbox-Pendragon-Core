package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.interval.ContrastInterval;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.Culture;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.CultureCharacterTemplate;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.DefaultCulture;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class CultureXMLDocumentReader implements XMLDocumentReader<Culture> {

    public static CultureCharacterTemplate loadAttributesLimitsTemplateXMLNode(
	    final Element root) {
	final Element attributesLimits;
	// TODO
	//
	// TODO: Hacer mejor. Que pida para cada parte solo el valuehandler que
	// necesite
	// attributesLimits = root.getChild(FileLabels.ATTRIBUTES_LIMITS);
	//
	// PersistenceFactory.getPendragonTemplateService()
	// .readPendragonTemplateXMLTree(root, new
	// DefaultCultureCharacterTemplate());
	//
	// Attributes limits
	// if (attributesLimits != null) {
	// holder.setAttributeLimits(readAttributesLimits(attributesLimits));
	// }
	//
	return null;
    }

    private static Iterator<ContrastInterval<Integer>> readAttributesLimits(
	    final Element nodeLimits) {
	// TODO
	// final List<NamedContrastInterval<Integer>> listLimits;
	// NamedContrastInterval<Integer> interval;
	//
	// listLimits = new ArrayList<NamedContrastInterval<Integer>>(nodeLimits
	// .getChildren().size());
	// for (final Element node : nodeLimits.getChildren()) {
	// TODO: Vigilar esto
	// interval = (NamedContrastInterval<Integer>) XMLUtils
	// .readIntegerIntervalXMLNode(node);
	// listLimits.addInterval(interval);
	// }
	//
	// return listLimits.iterator();
	return null;
    }

    @Override
    public Culture getValue(final Document doc) {
	final DefaultCulture holder;
	final Element root;
	final Element files, templateFemale, templateMale, templateRandomFemale, templateRandomMale;

	root = doc.getRootElement();

	holder = new DefaultCulture();

	// Acquires the different sections
	files = root.getChild(FileLabels.SELECTORS_FILES);
	templateFemale = root.getChild(FileLabels.TEMPLATE_FEMALE);
	templateMale = root.getChild(FileLabels.TEMPLATE_MALE);
	templateRandomFemale = root.getChild(FileLabels.TEMPLATE_FEMALE_RANDOM);
	templateRandomMale = root.getChild(FileLabels.TEMPLATE_MALE_RANDOM);

	// Culture's name
	holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Files
	if (files != null) {
	    // TODO
	    // holder.setFiles(XMLUtils.readStringsDictionaryXMLTree(files));
	}

	// Female template
	if (templateFemale != null) {
	    // TODO
	    // holder.getFemaleTemplate().copy(
	    // loadAttributesLimitsTemplateXMLNode(templateFemale));
	}

	// Male template
	if (templateMale != null) {
	    // TODO
	    // holder.getMaleTemplate().copy(
	    // loadAttributesLimitsTemplateXMLNode(templateMale));
	}

	// Random generation templates

	// Female template
	if (templateRandomFemale != null) {
	    // TODO
	    // holder.getFemaleRandomTemplate().copy(
	    // loadAttributesLimitsTemplateXMLNode(templateRandomFemale));
	}

	// Male template
	if (templateRandomMale != null) {
	    // TODO
	    // holder.getMaleRandomTemplate().copy(
	    // loadAttributesLimitsTemplateXMLNode(templateRandomMale));
	}

	return holder;
    }

}
