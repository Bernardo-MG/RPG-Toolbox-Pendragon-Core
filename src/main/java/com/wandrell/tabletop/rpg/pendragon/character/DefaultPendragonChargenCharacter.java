package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;

import com.wandrell.tabletop.rpg.pendragon.character.background.FamilyCharacteristic;
import com.wandrell.tabletop.rpg.pendragon.character.background.FatherClass;
import com.wandrell.tabletop.rpg.pendragon.character.background.Homeland;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.Culture;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
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

    private Culture culture;
    private FatherClass fatherClass;
    private final StatusFlags holderStatusFlags = new StatusFlags();
    private Homeland homeland;

    public DefaultPendragonChargenCharacter(
	    final Collection<PendragonAttribute> attributes,
	    final Collection<PendragonTrait> traits) {
	super(attributes, traits);
    }

    public DefaultPendragonChargenCharacter(
	    final DefaultPendragonChargenCharacter character) {
	super(character);

	culture = character.culture.createNewInstance();
	homeland = character.homeland.createNewInstance();
    }

    @Override
    public DefaultPendragonChargenCharacter createNewInstance() {
	return new DefaultPendragonChargenCharacter(this);
    }

    @Override
    public final Culture getCulture() {
	return culture;
    }

    @Override
    public final FatherClass getFatherClass() {
	return fatherClass;
    }

    @Override
    public final Homeland getHomeland() {
	return homeland;
    }

    @Override
    public final Boolean isKnightChosen() {
	return getCharFlags().flagKnightChosen;
    }

    @Override
    public final void setCulture(final Culture culture) {
	if (culture == null) {
	    throw new NullPointerException();
	}

	this.culture = culture;

	addTextValue(PendragonLabels.TEXT_CULTURE_NAME, culture.getName());
    }

    @Override
    public final void setFamilyCharacteristic(
	    final FamilyCharacteristic characteristic) {
	if (!holderStatusFlags.flagFamilyCharChosen) {
	    // TODO: Quizás sea mejor hacer esto fuera
	    // ValueHandlerServicesFactory.getTemplateService().loadBonusTemplate(
	    // this, characteristic);

	    if (characteristic == null) {
		throw new NullPointerException();
	    }

	    addTextValue(PendragonLabels.TEXT_FAMILY_CHARACTERISTIC,
		    characteristic.getName());
	    holderStatusFlags.flagFamilyCharChosen = true;
	}
    }

    @Override
    public final void setFatherClassData(final FatherClass fatherClass) {
	if (this.fatherClass == null) {
	    this.fatherClass = fatherClass;

	    if (fatherClass == null) {
		throw new NullPointerException();
	    }

	    addTextValue(PendragonLabels.TEXT_FATHER_CLASS,
		    fatherClass.getName());
	    // ValueHandlerServicesFactory.getTemplateService()
	    // .loadBaseValuesTemplate(this,
	    // dataFatherClass.getBaseValuesTemplate());
	    // ValueHandlerServicesFactory.getTemplateService().loadBonusTemplate(
	    // this, dataFatherClass.getBonusValuesTemplate());
	}
    }

    @Override
    public final void setHomelandData(final Homeland homeland) {
	if (this.homeland == null) {
	    this.homeland = homeland;
	    addTextValue(PendragonLabels.TEXT_HOMELAND, homeland.getName());
	}
    }

    @Override
    public final void setKnight(final Boolean isKnight) {
	super.setKnight(isKnight);
	getCharFlags().flagKnightChosen = isKnight;
    }

    private final StatusFlags getCharFlags() {
	return holderStatusFlags;
    }

}
