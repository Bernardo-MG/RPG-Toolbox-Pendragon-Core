package com.wandrell.tabletop.rpg.pendragon.inventory;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultArmorData implements ArmorData, NewInstantiable {

    private final Map<String, ValueHandler<Integer>> storeArmor = new LinkedHashMap<>();

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

	for (final Entry<String, ValueHandler<Integer>> entry : armor.storeArmor
		.entrySet()) {
	    storeArmor
		    .put(entry.getKey(), entry.getValue().createNewInstance());
	}

    }

    @Override
    public DefaultArmorData createNewInstance() {
	return new DefaultArmorData(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final boolean equals;
	final DefaultArmorData received;

	if (obj == this) {
	    equals = true;
	} else if (obj == null) {
	    equals = false;
	} else if (getClass() != obj.getClass()) {
	    equals = false;
	} else {
	    received = (DefaultArmorData) obj;
	    if (received.storeArmor == null) {
		equals = (storeArmor == null);
	    } else {
		equals = (received.storeArmor.equals(storeArmor));
	    }
	}

	return equals;
    }

    @Override
    public ValueHandler<Integer> getArmorPiece(final String name) {
	return getArmorStore().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getArmorPieces() {
	return Collections.unmodifiableCollection(getArmorStore().values());
    }

    @Override
    public Boolean hasArmorPiece(final String name) {
	return getArmorStore().containsKey(name);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;

	result = prime * result
		+ ((storeArmor == null) ? 0 : storeArmor.hashCode());

	return result;
    }

    public void initializeReligiousArmor(final Integer armorValue) {
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

    public void setChivaldryArmorSwitch(final ValueHandler<Integer> vhSwitch) {
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

    private Map<String, ValueHandler<Integer>> getArmorStore() {
	return storeArmor;
    }

}
