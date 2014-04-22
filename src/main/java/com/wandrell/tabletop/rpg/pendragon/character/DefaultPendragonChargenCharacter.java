package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;

import com.wandrell.tabletop.rpg.pendragon.character.background.FamilyCharacteristic;
import com.wandrell.tabletop.rpg.pendragon.character.background.FatherClass;
import com.wandrell.tabletop.rpg.pendragon.character.background.Homeland;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.Culture;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonTrait;

public class DefaultPendragonChargenCharacter extends
	DefaultPendragonPlayerCharacter implements PendragonChargenCharacter {

    private class StatusFlags {
	public boolean flagFamilyCharChosen = false;
	// TODO: Quitar esto de aquí
	public boolean flagKnightChosen = false;

	public StatusFlags() {
	    super();
	}
    }

    private Culture dataCulture = null;
    private FatherClass dataFatherClass = null;
    private Homeland dataHomeland = null;
    private final StatusFlags holderStatusFlags = new StatusFlags();

    public DefaultPendragonChargenCharacter(
	    final Collection<PendragonAttribute> attributes,
	    final Collection<PendragonTrait> traits) {
	super(attributes, traits);
    }

    public DefaultPendragonChargenCharacter(
	    final DefaultPendragonChargenCharacter character) {
	super(character);

	setCultureData(character.dataCulture.createNewInstance());
	setHomelandData(character.dataHomeland.createNewInstance());
    }

    @Override
    public void addSkill(final PendragonSkill vhSkill) {
	super.addSkill(vhSkill);
    }

    @Override
    public DefaultPendragonChargenCharacter createNewInstance() {
	return new DefaultPendragonChargenCharacter(this);
    }

    @Override
    public Culture getCultureData() {
	return dataCulture;
    }

    @Override
    public FatherClass getFatherClassData() {
	return dataFatherClass;
    }

    @Override
    public Homeland getHomelandData() {
	return dataHomeland;
    }

    @Override
    public boolean isKnightChosen() {
	return getCharFlags().flagKnightChosen;
    }

    @Override
    public void setCultureData(final Culture culture) {
	dataCulture = culture;

	addTextValue(PendragonLabels.TEXT_CULTURE_NAME, culture.getName());
    }

    @Override
    public void setFamilyCharacteristic(
	    final FamilyCharacteristic characteristic) {
	if (!holderStatusFlags.flagFamilyCharChosen) {
	    // TODO: Quizás sea mejor hacer esto fuera
	    // ValueHandlerServicesFactory.getTemplateService().loadBonusTemplate(
	    // this, characteristic);
	    addTextValue(PendragonLabels.TEXT_FAMILY_CHARACTERISTIC,
		    characteristic.getName());
	    holderStatusFlags.flagFamilyCharChosen = true;
	}
    }

    @Override
    public void setFatherClassData(final FatherClass fatherClass) {
	if (dataFatherClass == null) {
	    dataFatherClass = fatherClass;
	    addTextValue(PendragonLabels.TEXT_FATHER_CLASS,
		    dataFatherClass.getName());
	    // ValueHandlerServicesFactory.getTemplateService()
	    // .loadBaseValuesTemplate(this,
	    // dataFatherClass.getBaseValuesTemplate());
	    // ValueHandlerServicesFactory.getTemplateService().loadBonusTemplate(
	    // this, dataFatherClass.getBonusValuesTemplate());
	}
    }

    @Override
    public void setHomelandData(final Homeland homeland) {
	if (dataHomeland == null) {
	    dataHomeland = homeland;
	    addTextValue(PendragonLabels.TEXT_HOMELAND, dataHomeland.getName());
	}
    }

    @Override
    public void setKnight(final Boolean isKnight) {
	super.setKnight(isKnight);
	setKnightChosen(true);
    }

    private StatusFlags getCharFlags() {
	return holderStatusFlags;
    }

    protected void setKnightChosen(boolean knightChosen) {
	getCharFlags().flagKnightChosen = knightChosen;
    }

}
