package com.wandrell.tabletop.pendragon.character.module;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultTraitsBonusSwitchsData implements
        TraitsBonusSwitchsData {

    private final Map<String, ValueHandler> storeTraitsBonusSwitchs = new LinkedHashMap<>();

    public DefaultTraitsBonusSwitchsData() {
        super();
    }

    public DefaultTraitsBonusSwitchsData(
            final DefaultTraitsBonusSwitchsData traitsBonus) {
        super();

        for (final Entry<String, ValueHandler> entry : traitsBonus.storeTraitsBonusSwitchs
                .entrySet()) {
            storeTraitsBonusSwitchs.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final DefaultTraitsBonusSwitchsData createNewInstance() {
        return new DefaultTraitsBonusSwitchsData(this);
    }

    @Override
    public final boolean equals(final Object obj) {
        final boolean equals;
        final DefaultTraitsBonusSwitchsData received;

        if (obj == this) {
            equals = true;
        } else if (obj == null) {
            equals = false;
        } else if (getClass() != obj.getClass()) {
            equals = false;
        } else {
            received = (DefaultTraitsBonusSwitchsData) obj;
            if (received.storeTraitsBonusSwitchs == null) {
                equals = (storeTraitsBonusSwitchs == null);
            } else {
                equals = (received.storeTraitsBonusSwitchs
                        .equals(storeTraitsBonusSwitchs));
            }
        }

        return equals;
    }

    @Override
    public final ValueHandler getBonusSwitch(final String name) {
        return getBonusSwitchsStore().get(name);
    }

    @Override
    public final Boolean hasBonusSwitch(final String name) {
        return getBonusSwitchsStore().containsKey(name);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime
                * result
                + ((storeTraitsBonusSwitchs == null) ? 0
                        : storeTraitsBonusSwitchs.hashCode());

        return result;
    }

    public final void initializeChivaldryTraitsBonusSwitch(
            final Iterator<ValueHandler> itrTraits) {
        // final ModularValueHandler vhSwitch;
        //
        // if (!hasBonusSwitch(NameLabels.BONUS_TRAITS_CHIVALDRY_SWITCH)) {
        // vhSwitch = new
        // IntegerSecondaryValuesValueHandler<ValueHandler>(
        // NameLabels.BONUS_TRAITS_CHIVALDRY_SWITCH);
        // getBonusSwitchsStore().addInterval(vhSwitch);
        // }
        //
        // initializeTraitsBonusSwitch(
        // getBonusSwitch(NameLabels.BONUS_TRAITS_CHIVALDRY_SWITCH),
        // itrTraits);
    }

    public final void initializeGentlewomanTraitsBonusSwitch(
            final Iterator<ValueHandler> itrTraits) {
        // final ModularValueHandler vhSwitch;
        //
        // if (!hasBonusSwitch(NameLabels.BONUS_TRAITS_GENTLEWOMAN_SWITCH)) {
        // vhSwitch = new
        // IntegerSecondaryValuesValueHandler<ValueHandler>(
        // NameLabels.BONUS_TRAITS_GENTLEWOMAN_SWITCH);
        // getBonusSwitchsStore().addInterval(vhSwitch);
        // }
        //
        // initializeTraitsBonusSwitch(
        // getBonusSwitch(NameLabels.BONUS_TRAITS_GENTLEWOMAN_SWITCH),
        // itrTraits);
    }

    public final void initializeReligiousTraitsBonusSwitch(
            final Iterator<ValueHandler> itrTraits) {
        // final ModularValueHandler vhTraitsReligious = new
        // IntegerSecondaryValuesValueHandler<ValueHandler>(
        // NameLabels.BONUS_TRAITS_RELIGIOUS_SWITCH);
        // final ReligiousMarginStore vc;
        //
        // vc = new ReligiousMarginStore(
        // vhTraitsReligious,
        // Integer.parseInt(ConfigurationFactory
        // .getConstant(ConfigurationLabels.TRAIT_RELIGIOUS_TRESHOLD)));
        //
        // while (itrTraits.hasNext()) {
        // vc.addValueHandler(itrTraits.next());
        // }
        //
        // vhTraitsReligious.setStore(vc);
        //
        // getBonusSwitchsStore().addInterval(vhTraitsReligious);
    }

    private final Map<String, ValueHandler> getBonusSwitchsStore() {
        return storeTraitsBonusSwitchs;
    }

}
