package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultArmorData implements ArmorData {

    private final Map<String, ValueHandler<Integer>> armorValues = new LinkedHashMap<>();

    public DefaultArmorData() {
	super();

	// Initializes ValueHandles
	// entrygetArmorStore().addInterval(
	// new IntegerValueHandler(NameLabels.VH_ARMOR));
	// getArmorStore().addInterval(
	// new IntegerValueHandler(NameLabels.VH_SHIELD));

	// Puts all the armor values on the total armor ValueHandler
	// ValueHandler<Integer> vh;
	// vh = new IntegerSecondaryValuesValueHandler<ValueHandler<Integer>>(
	// NameLabels.VH_TOTAL_ARMOR);
	// Iterator<ValueHandler<Integer>> itr = getArmorStore().getIterator();
	// while (itr.hasNext()) {
	// ((SecondaryValuesValueHandler<Integer, ValueHandler<Integer>>) vh)
	// .addValueHandler(itr.next());
	// }
	// getArmorStore().addInterval(vh);

    }

    public DefaultArmorData(final DefaultArmorData armor) {
	super();

	for (final Entry<String, ValueHandler<Integer>> entry : armor.armorValues
		.entrySet()) {
	    armorValues.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

    }

    public final void addArmorValue(final ValueHandler<Integer> armor) {
	if (armor == null) {
	    throw new NullPointerException();
	}

	_getArmorValues().put(armor.getName(), armor);
    }

    @Override
    public final DefaultArmorData createNewInstance() {
	return new DefaultArmorData(this);
    }

    @Override
    public final ValueHandler<Integer> getArmorValue(final String name) {
	return _getArmorValues().get(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getArmorValues() {
	return Collections.unmodifiableCollection(_getArmorValues().values());
    }

    @Override
    public final Boolean hasArmorValue(final String name) {
	return _getArmorValues().containsKey(name);
    }

    public final void initializeReligiousArmor(final Integer armorValue) {
	// TODO: ¿Y esto qué es?
	// ModularValueHandler<Integer> vh;
	//
	// if (!hasArmor(NameLabels.VH_RELIGIOUS_ARMOR)) {
	// vh = new IntegerValueHandler(NameLabels.VH_RELIGIOUS_ARMOR);
	// getArmorStore().addInterval(vh);
	//
	// ((IntegerSecondaryValuesValueHandler)
	// getArmor(NameLabels.VH_TOTAL_ARMOR))
	// .addValueHandler(getArmor(NameLabels.VH_RELIGIOUS_ARMOR));
	// }
	//
	// vh = ((ModularValueHandler<Integer>)
	// getArmor(NameLabels.VH_RELIGIOUS_ARMOR));
	//
	// vh.setStore(new IntegerSwitchStore(vh, set, 0, armorValue));
    }

    public final void setChivaldryArmorSwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// final StatusEventThrower set;
	// final int chivaldryArmor;
	// DelegateValueHandler<Integer> vh;
	//
	// if (!hasArmor(NameLabels.VH_CHIVALDRY_ARMOR)) {
	// vh = new IntegerValueHandler(NameLabels.VH_CHIVALDRY_ARMOR);
	// getArmorStore().addInterval(vh);
	//
	// ((IntegerSecondaryValuesValueHandler)
	// getArmor(NameLabels.VH_TOTAL_ARMOR))
	// .addValueHandler(getArmor(NameLabels.VH_CHIVALDRY_ARMOR));
	// }
	//
	// set = (StatusEventThrower) vhSwitch.getStore();
	// vh = ((ModularValueHandler<Integer>)
	// getArmor(NameLabels.VH_CHIVALDRY_ARMOR));
	// chivaldryArmor = Integer.parseInt(ConfigurationFactory
	// .getConstant(ConfigurationLabels.CHIVALDRY_ARMOR));
	//
	// vh.setStore(new IntegerSwitchStore(vh, set, 0, chivaldryArmor));
    }

    private final Map<String, ValueHandler<Integer>> _getArmorValues() {
	return armorValues;
    }

}
