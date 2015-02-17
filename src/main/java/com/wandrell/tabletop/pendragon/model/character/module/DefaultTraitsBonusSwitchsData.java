package com.wandrell.tabletop.pendragon.model.character.module;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.valuebox.EditableValueBox;

public final class DefaultTraitsBonusSwitchsData {

    private final Map<String, EditableValueBox> storeTraitsBonusSwitchs = new LinkedHashMap<String, EditableValueBox>();

    public DefaultTraitsBonusSwitchsData() {
        super();
    }

    public DefaultTraitsBonusSwitchsData(
            final DefaultTraitsBonusSwitchsData traitsBonus) {
        super();

        for (final Entry<String, EditableValueBox> entry : traitsBonus.storeTraitsBonusSwitchs
                .entrySet()) {
            storeTraitsBonusSwitchs.put(entry.getKey(), entry.getValue());
        }
    }

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

    public final EditableValueBox getBonusSwitch(final String name) {
        return getBonusSwitchsStore().get(name);
    }

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
            final Iterator<EditableValueBox> itrTraits) {
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
            final Iterator<EditableValueBox> itrTraits) {
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
            final Iterator<EditableValueBox> itrTraits) {
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

    private final Map<String, EditableValueBox> getBonusSwitchsStore() {
        return storeTraitsBonusSwitchs;
    }

}
