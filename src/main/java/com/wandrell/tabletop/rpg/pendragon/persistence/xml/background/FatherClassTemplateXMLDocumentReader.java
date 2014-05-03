package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.background.DefaultFatherClass;
import com.wandrell.tabletop.rpg.pendragon.character.background.FatherClass;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonSkill;
import com.wandrell.util.file.api.xml.XMLDocumentReader;

public class FatherClassTemplateXMLDocumentReader implements
	XMLDocumentReader<FatherClass> {

    @Override
    public FatherClass getValue(final Document doc) {
	final DefaultFatherClass holder;
	final Element skillsGroup, skillPoints, money;
	final Element root;

	root = doc.getRootElement();
	holder = new DefaultFatherClass();

	// TODO
	// PersistenceFactory.getTemplatesContainerService().readXMLTree(root,
	// holder);

	skillsGroup = root.getChild(FileLabels.SKILLS_GROUP);
	skillPoints = root.getChild(FileLabels.SKILLS_POINTS);
	money = root.getChild(FileLabels.MONEY);

	// Father's class name
	holder.setName(root.getAttributeValue(FileStreamerTags.NAME));

	// Skills groups
	if (skillsGroup != null) {
	    readSkillsGroupXMLTree(skillsGroup, holder);
	}

	// Skills points
	if (skillPoints != null) {
	    // TODO
	    // holder.setSkillPoints(XMLUtils.readIntegerValueHandlerXMLTree(
	    // skillPoints, new IntegerValueHandler()));
	}

	// Money
	if (money != null) {
	    // TODO
	    // PersistenceFactory.getItemService().readMoneyXMLNode(money,
	    // holder.getMoneyData());
	}

	return holder;
    }

    private Iterator<DefaultPendragonSkill> buildSkillsIterator(
	    final FatherClass holder, final Element skills) {
	// TODO
	// final Iterator<? extends ValueHandler<Integer>> itrSkills;
	// final List<DefaultPendragonSkill> listSkills;
	// ValueHandler<Integer> vhValue;
	// DefaultPendragonSkill vhSkill;
	//
	// listSkills = new ArrayList<>();
	//
	// itrSkills = XMLUtils.readIntegerValueHandlerXMLTree(skills,
	// new IntegerValueHandler());
	// while (itrSkills.hasNext()) {
	// vhValue = itrSkills.next();
	//
	// vhSkill = SkillsFactory.getSkill(vhValue.getName());
	// vhSkill.setValue(vhValue.getStoredValue());
	//
	// listSkills.add(vhSkill);
	// }
	//
	// return listSkills.iterator();
	return null;
    }

    private void readSkillsGroupXMLTree(final Element root,
	    final FatherClass holder) {
	// TODO
	// final Element skills, points;
	//
	// skills = root.getChild(FileLabels.SKILLS);
	// points = root.getChild(NameLabels.VH_SKILLS_POINTS);
	//
	// holder.setSkillsGroup(buildSkillsIterator(holder, skills), XMLUtils
	// .readIntegerValueHandlerXMLNode(points,
	// new IntegerValueHandler()));
    }

}