package com.wandrell.tabletop.pendragon.inventory;

public class DefaultArmorEquipment extends DefaultPendragonEquipment implements
	ArmorEquipment {

    public DefaultArmorEquipment() {
	super();
    }

    public DefaultArmorEquipment(final DefaultArmorEquipment armor) {
	super(armor);
    }

    @Override
    public DefaultArmorEquipment createNewInstance() {
	return new DefaultArmorEquipment(this);
    }

}
