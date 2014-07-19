package com.wandrell.tabletop.pendragon.conf.factory;

import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.context.ApplicationContext;

import com.wandrell.framework.util.ContextUtils;
import com.wandrell.framework.util.FileUtils;
import com.wandrell.tabletop.pendragon.conf.PendragonFactoryConf;
import com.wandrell.tabletop.pendragon.glory.GloryKeeper;
import com.wandrell.tabletop.pendragon.inventory.ArmorData;
import com.wandrell.tabletop.pendragon.inventory.PendragonMoney;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSkill;
import com.wandrell.util.PathUtils;

public final class PendragonFactory {

    private static ApplicationContext contextArmor;
    private static ApplicationContext contextGlory;
    private static ApplicationContext contextMoney;
    private static PendragonFactory instance;

    public static final synchronized PendragonFactory getInstance() {
	if (instance == null) {
	    instance = new PendragonFactory();
	}

	return instance;
    }

    private static final synchronized ApplicationContext getArmorContext() {
	if (contextArmor == null) {
	    contextArmor = ContextUtils.getContext(Paths
		    .get(PendragonFactoryConf.CONTEXT_ARMOR));
	}

	return contextArmor;
    }

    private static final synchronized ApplicationContext getGloryContext() {
	if (contextGlory == null) {
	    contextGlory = ContextUtils.getContext(Paths
		    .get(PendragonFactoryConf.CONTEXT_GLORY));
	}

	return contextGlory;
    }

    private static final synchronized ApplicationContext getMoneyContext() {
	if (contextMoney == null) {
	    contextMoney = ContextUtils.getContext(Paths
		    .get(PendragonFactoryConf.CONTEXT_MONEY));
	}

	return contextMoney;
    }

    private PendragonFactory() {
	super();
    }

    public final ArmorData getArmor() {
	return (ArmorData) getArmorContext().getBean(
		PendragonFactoryConf.BEAN_ARMOR);
    }

    public final GloryKeeper getGlory() {
	return (GloryKeeper) getGloryContext().getBean(
		PendragonFactoryConf.BEAN_GLORY);
    }

    public final PendragonMoney getMoney() {
	return (PendragonMoney) getMoneyContext().getBean(
		PendragonFactoryConf.BEAN_MONEY);
    }

    public final PendragonMoney getMoney(final int libra, final int denarii) {
	final PendragonMoney money;

	money = getMoney();

	money.getLibra().setValue(libra);
	money.getDenarii().setValue(denarii);

	return money;
    }

    public final PendragonSkill getSkill(final String name,
	    final Boolean combat, final Boolean court, final Boolean knight,
	    final Boolean knowledge, final Boolean repeat) {
	final ApplicationContext context;
	final Properties properties;

	properties = FileUtils.getProperties(PathUtils
		.getClassPathResource(Paths
			.get(PendragonFactoryConf.PROPERTIES_SKILL)));

	// TODO: This is hardcoded
	properties.setProperty("skill.name", name);
	properties.setProperty("skill.flag.combat", combat.toString());
	properties.setProperty("skill.flag.court", court.toString());
	properties.setProperty("skill.flag.knight", knight.toString());
	properties.setProperty("skill.flag.knowledge", knowledge.toString());
	properties.setProperty("skill.flag.repeat", repeat.toString());

	// TODO: Try to reload changing only the values
	context = ContextUtils.getContext(PathUtils.getClassPathResource(Paths
		.get(PendragonFactoryConf.CONTEXT_SKILL)), properties);

	// Spring framework builds the instance

	return (PendragonSkill) context
		.getBean(PendragonFactoryConf.BEAN_SKILL);
    }

}
