package com.wandrell.tabletop.pendragon.conf.factory;

import java.nio.file.Paths;

import org.springframework.context.ApplicationContext;

import com.wandrell.framework.util.ContextUtils;
import com.wandrell.tabletop.pendragon.conf.PendragonFactoryConf;
import com.wandrell.tabletop.pendragon.glory.GloryKeeper;
import com.wandrell.tabletop.pendragon.inventory.ArmorData;
import com.wandrell.tabletop.pendragon.inventory.PendragonMoney;

public final class PendragonFactory {

    private static ApplicationContext contextArmor = null;
    private static ApplicationContext contextGlory = null;
    private static ApplicationContext contextMoney = null;
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

}
