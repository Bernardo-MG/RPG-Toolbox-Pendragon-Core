package com.wandrell.tabletop.pendragon.inventory;

import java.util.Collection;

import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultArmorEquipment implements ArmorEquipment {

    private final PendragonEquipment item;

    public DefaultArmorEquipment(final DefaultArmorEquipment armor) {
	super();

	item = armor.item.createNewInstance();
    }

    public DefaultArmorEquipment(final PendragonEquipment item) {
	super();

	this.item = item;
    }

    @Override
    public final DefaultArmorEquipment createNewInstance() {
	return new DefaultArmorEquipment(this);
    }

    @Override
    public final String getDescription() {
	return getBaseItem().getDescription();
    }

    @Override
    public final Boolean getFlag(final String name) {
	return getBaseItem().getFlag(name);
    }

    @Override
    public final Collection<String> getFlags() {
	return getBaseItem().getFlags();
    }

    @Override
    public final ValueHandler<Integer> getMiscelanyValue(final String name) {
	return getBaseItem().getMiscelanyValue(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getMiscelanyValues() {
	return getBaseItem().getMiscelanyValues();
    }

    @Override
    public final PendragonMoney getMoney() {
	return getBaseItem().getMoney();
    }

    @Override
    public final String getName() {
	return getBaseItem().getName();
    }

    @Override
    public final ValueHandler<Integer> getQuantity() {
	return getBaseItem().getQuantity();
    }

    @Override
    public final Boolean hasFlag(final String name) {
	return getBaseItem().hasFlag(name);
    }

    @Override
    public final Boolean hasValue(final String name) {
	return getBaseItem().hasValue(name);
    }

    @Override
    public final void setDescription(final String description) {
	getBaseItem().setDescription(description);
    }

    @Override
    public final void setName(final String name) {
	getBaseItem().setName(name);
    }

    private final PendragonEquipment getBaseItem() {
	return item;
    }

}
