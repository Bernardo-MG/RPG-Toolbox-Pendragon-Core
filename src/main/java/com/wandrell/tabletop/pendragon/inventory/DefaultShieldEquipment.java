package com.wandrell.tabletop.pendragon.inventory;

public class DefaultShieldEquipment extends DefaultPendragonEquipment implements
	ShieldEquipment {

    public DefaultShieldEquipment() {
	super();
    }

    public DefaultShieldEquipment(final DefaultShieldEquipment shield) {
	super(shield);
    }

    @Override
    public DefaultShieldEquipment createNewInstance() {
	return new DefaultShieldEquipment(this);
    }

}
