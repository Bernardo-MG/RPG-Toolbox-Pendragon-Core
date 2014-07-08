package com.wandrell.tabletop.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.wandrell.tabletop.pendragon.character.background.Religion;
import com.wandrell.tabletop.pendragon.character.follower.Follower;
import com.wandrell.tabletop.pendragon.character.follower.Wife;
import com.wandrell.tabletop.pendragon.character.module.DefaultTraitsBonusSwitchsData;
import com.wandrell.tabletop.pendragon.character.module.TraitsBonusSwitchsData;
import com.wandrell.tabletop.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.pendragon.conf.factory.PendragonFactory;
import com.wandrell.tabletop.pendragon.glory.GloryKeeper;
import com.wandrell.tabletop.pendragon.inventory.ArmorData;
import com.wandrell.tabletop.pendragon.inventory.PendragonItem;
import com.wandrell.tabletop.pendragon.inventory.PendragonMoney;
import com.wandrell.tabletop.pendragon.manor.ManorAnimal;
import com.wandrell.tabletop.pendragon.util.DefaultTextValue;
import com.wandrell.tabletop.pendragon.util.PendragonValueHandlerUtils;
import com.wandrell.tabletop.pendragon.util.TextValue;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonAppearanceFeature;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonDerivedAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.pendragon.valuehandler.PendragonTrait;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public class DefaultPendragonPlayerCharacter extends
	AbstractPendragonSimpleCharacter implements PendragonPlayerCharacter {

    private final ArmorData armor;
    private final TraitsBonusSwitchsData dataTraitsBonusSwitchs;
    private final Map<String, PendragonSkill> exclusiveSkills = new LinkedHashMap<>();
    private final Map<String, PendragonAppearanceFeature> features = new LinkedHashMap<>();
    private final Set<String> flags = new LinkedHashSet<>();
    private final Set<Follower> followers = new LinkedHashSet<>();
    private final GloryKeeper glory;
    private final Set<PendragonItem> holdingsAtHome = new LinkedHashSet<>();
    private final Set<PendragonItem> holdingsCarried = new LinkedHashSet<>();
    private final Set<HorseCharacter> horses = new LinkedHashSet<>();
    private String knightKind = null;
    private final PendragonMoney money;
    private final Set<ManorAnimal> pets = new LinkedHashSet<>();
    private Religion religion;
    private final Map<String, String> textValues = new LinkedHashMap<>();
    private final Map<String, ValueHandler<Integer>> valueHandlers = new LinkedHashMap<>();
    private final Set<Wife> wives = new LinkedHashSet<>();

    public DefaultPendragonPlayerCharacter(
	    final Collection<PendragonAttribute> attributes,
	    final Collection<PendragonTrait> traits) {
	super(attributes, traits);

	// Initializes data holders
	// TODO: Don't initialize directly
	dataTraitsBonusSwitchs = new DefaultTraitsBonusSwitchsData();
	glory = PendragonFactory.getInstance().getGlory();
	money = PendragonFactory.getInstance().getMoney();
	armor = PendragonFactory.getInstance().getArmor();
    }

    public DefaultPendragonPlayerCharacter(
	    final DefaultPendragonPlayerCharacter character) {
	super(character);

	flags.addAll(character._getFlags());
	// TODO: Copy correctly
	followers.addAll(character.followers);
	horses.addAll(character.horses);
	pets.addAll(character.pets);

	for (final Entry<String, PendragonAppearanceFeature> entry : character.features
		.entrySet()) {
	    features.put(entry.getKey(), entry.getValue().createNewInstance());
	}

	for (final Entry<String, PendragonSkill> entry : character.exclusiveSkills
		.entrySet()) {
	    exclusiveSkills.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	for (final Entry<String, ValueHandler<Integer>> entry : character.valueHandlers
		.entrySet()) {
	    valueHandlers.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	for (final Entry<String, String> entry : textValues.entrySet()) {
	    textValues.put(entry.getKey(), entry.getValue());
	}

	// TODO: Copy correctly
	holdingsAtHome.addAll(character.holdingsAtHome);
	holdingsCarried.addAll(character.holdingsCarried);
	wives.addAll(character.wives);
	followers.addAll(character.followers);
	horses.addAll(character.horses);
	flags.addAll(character.flags);

	// Initializes data holders
	armor = character.armor.createNewInstance();
	glory = character.glory.createNewInstance();
	money = character.money.createNewInstance();
	dataTraitsBonusSwitchs = character.dataTraitsBonusSwitchs
		.createNewInstance();

	setKnight(character.isKnight());
	setKnightKind(character.knightKind);
	setReligionData(character.religion.createNewInstance());

	// TODO: Handle this
	// getGloryData().setReligiousAnnualGlorySwitch(
	// getTraitsBonusSwitchsData().getBonusSwitch(
	// PendragonLabels.BONUS_TRAITS_RELIGIOUS_SWITCH));
    }

    public final void addExclusiveSkill(final PendragonSkill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getExclusiveSkills().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			skill.getName(), skill.getAnnotation()), skill);
    }

    public final void addFeature(final PendragonAppearanceFeature feature) {
	if (feature == null) {
	    throw new NullPointerException();
	}

	_getFeatures().put(feature.getName(), feature);
    }

    public final void addFollower(final Follower follower) {
	if (follower == null) {
	    throw new NullPointerException();
	}

	_getFollowers().add(follower);
    }

    public final void addHoldingAtHome(final PendragonItem item) {
	if (item == null) {
	    throw new NullPointerException();
	}

	_getHoldingsAtHome().add(item);
    }

    public final void addHoldingCarried(final PendragonItem item) {
	if (item == null) {
	    throw new NullPointerException();
	}

	_getHoldingsCarried().add(item);
    }

    public final void addHorse(final HorseCharacter horse) {
	if (horse == null) {
	    throw new NullPointerException();
	}

	_getHorses().add(horse);
    }

    public final void addPet(final ManorAnimal pet) {
	if (pet == null) {
	    throw new NullPointerException();
	}

	_getPets().add(pet);
    }

    public final void addTextValue(final String key, final String value) {
	if (key == null) {
	    throw new NullPointerException();
	}
	if (value == null) {
	    throw new NullPointerException();
	}

	_getTextValues().put(key, value);
    }

    public final void addValueHandler(final ValueHandler<Integer> value) {
	if (value == null) {
	    throw new NullPointerException();
	}

	_getValueHandlers().put(value.getName(), value);
    }

    public final void addWife(final Wife wife) {
	if (wife == null) {
	    throw new NullPointerException();
	}

	_getWives().add(wife);
    }

    @Override
    public DefaultPendragonPlayerCharacter createNewInstance() {
	return new DefaultPendragonPlayerCharacter(this);
    }

    @Override
    public final boolean equals(final Object obj) {
	final DefaultPendragonPlayerCharacter received;
	boolean equals;

	if (super.equals(obj)) {
	    received = (DefaultPendragonPlayerCharacter) obj;
	    if (received.armor == null) {
		equals = (armor == null);
	    } else {
		equals = (received.armor.equals(armor));
	    }
	    if ((equals) && (received.glory == null)) {
		equals = (glory == null);
	    } else if (equals) {
		equals = (received.glory.equals(glory));
	    }
	    if ((equals) && (received.money == null)) {
		equals = (money == null);
	    } else if (equals) {
		equals = (received.money.equals(money));
	    }
	    if ((equals) && (received.knightKind == null)) {
		equals = (knightKind == null);
	    } else if (equals) {
		equals = (received.knightKind.equals(knightKind));
	    }
	    if ((equals) && (received.features == null)) {
		equals = (features == null);
	    } else if (equals) {
		equals = (received.features.equals(features));
	    }
	    if ((equals) && (received.followers == null)) {
		equals = (followers == null);
	    } else if (equals) {
		equals = (received.followers.equals(followers));
	    }
	    if ((equals) && (received.holdingsAtHome == null)) {
		equals = (holdingsAtHome == null);
	    } else if (equals) {
		equals = (received.holdingsAtHome.equals(holdingsAtHome));
	    }
	    if ((equals) && (received.holdingsCarried == null)) {
		equals = (holdingsCarried == null);
	    } else if (equals) {
		equals = (received.holdingsCarried.equals(holdingsCarried));
	    }
	    if ((equals) && (received.horses == null)) {
		equals = (horses == null);
	    } else if (equals) {
		equals = (received.horses.equals(horses));
	    }
	    if ((equals) && (received.textValues == null)) {
		equals = (textValues == null);
	    } else if (equals) {
		equals = (received.textValues.equals(textValues));
	    }
	    if ((equals) && (received.valueHandlers == null)) {
		equals = (valueHandlers == null);
	    } else if (equals) {
		equals = (received.valueHandlers.equals(valueHandlers));
	    }
	    if ((equals) && (received.wives == null)) {
		equals = (wives == null);
	    } else if (equals) {
		equals = (received.wives.equals(wives));
	    }
	    if ((equals) && (received.flags == null)) {
		equals = (flags == null);
	    } else if (equals) {
		equals = (received.flags.equals(flags));
	    }
	} else {
	    equals = false;
	}

	return equals;
    }

    @Override
    public final ArmorData getArmor() {
	return armor;
    }

    @Override
    public final Collection<PendragonAppearanceFeature> getDistinctiveFeatures() {
	return Collections.unmodifiableCollection(_getFeatures().values());
    }

    @Override
    public final PendragonDerivedAttribute getDistinctiveFeaturesCount() {
	return _getDerivedAttributes().get(
		PendragonLabels.DERIVED_ATTRIBUTE_FEATURES);
    }

    @Override
    public final PendragonSkill getExclusiveSkill(final String name,
	    final String annotation) {
	return _getExclusiveSkills().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public final Collection<PendragonSkill> getExclusiveSkills() {
	return Collections.unmodifiableCollection(_getExclusiveSkills()
		.values());
    }

    @Override
    public final Boolean getFlag(final String name) {
	return _getFlags().contains(name);
    }

    @Override
    public final Collection<String> getFlags() {
	return Collections.unmodifiableCollection(_getFlags());
    }

    @Override
    public final Collection<Follower> getFollowers() {
	return Collections.unmodifiableCollection(_getFollowers());
    }

    @Override
    public final GloryKeeper getGlory() {
	return glory;
    }

    @Override
    public final Collection<PendragonItem> getHoldingsAtHome() {
	return Collections.unmodifiableCollection(_getHoldingsAtHome());
    }

    @Override
    public final Collection<PendragonItem> getHoldingsCarried() {
	return Collections.unmodifiableCollection(_getHoldingsCarried());
    }

    @Override
    public final Collection<HorseCharacter> getHorses() {
	return Collections.unmodifiableCollection(_getHorses());
    }

    @Override
    public final String getKnightKind() {
	return knightKind;
    }

    @Override
    public final PendragonMoney getMoney() {
	return money;
    }

    @Override
    public final Collection<ManorAnimal> getPets() {
	return Collections.unmodifiableCollection(_getPets());
    }

    @Override
    public final String getPlayerName() {
	return getTextValue(PendragonLabels.TEXT_PLAYER_NAME);
    }

    @Override
    public final Religion getReligion() {
	return religion;
    }

    @Override
    public final String getTextValue(final String name) {
	final String text;

	if (hasTextValue(name)) {
	    text = _getTextValues().get(name);
	} else {
	    text = "";
	}

	return text;
    }

    @Override
    public final Collection<TextValue> getTextValues() {
	final Collection<TextValue> values;

	values = new LinkedList<>();
	for (final Entry<String, String> entry : _getTextValues().entrySet()) {
	    values.add(new DefaultTextValue(entry.getKey(), entry.getValue()));
	}

	return Collections.unmodifiableCollection(values);
    }

    @Override
    public final TraitsBonusSwitchsData getTraitsBonusSwitchsData() {
	return dataTraitsBonusSwitchs;
    }

    @Override
    public final ValueHandler<Integer> getValueHandler(final String name) {
	return _getValueHandlers().get(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getValueHandlers() {
	return Collections.unmodifiableCollection(_getValueHandlers().values());
    }

    @Override
    public final Collection<Wife> getWives() {
	return Collections.unmodifiableCollection(_getWives());
    }

    @Override
    public final Boolean hasExclusiveSkill(final String name,
	    final String annotation) {
	return _getExclusiveSkills().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((armor == null) ? 0 : armor.hashCode());
	result = prime * result + ((glory == null) ? 0 : glory.hashCode());
	result = prime * result + ((money == null) ? 0 : money.hashCode());
	result = prime * result
		+ ((knightKind == null) ? 0 : knightKind.hashCode());
	result = prime * result
		+ ((features == null) ? 0 : features.hashCode());
	result = prime * result
		+ ((followers == null) ? 0 : followers.hashCode());
	result = prime * result
		+ ((holdingsAtHome == null) ? 0 : holdingsAtHome.hashCode());
	result = prime * result
		+ ((holdingsCarried == null) ? 0 : holdingsCarried.hashCode());
	result = prime * result + ((horses == null) ? 0 : horses.hashCode());
	result = prime * result
		+ ((textValues == null) ? 0 : textValues.hashCode());
	result = prime * result
		+ ((valueHandlers == null) ? 0 : valueHandlers.hashCode());
	result = prime * result + ((wives == null) ? 0 : wives.hashCode());
	result = prime * result + ((flags == null) ? 0 : flags.hashCode());
	return result;
    }

    @Override
    public final Boolean hasTextValue(final String name) {
	return _getTextValues().containsKey(name);
    }

    @Override
    public final Boolean hasValueHandler(final String name) {
	return _getValueHandlers().containsKey(name);
    }

    @Override
    public final Boolean isKnight() {
	return getFlag(PendragonLabels.FLAGS_KNIGHT);
    }

    public final void setExclusiveSkills(final Collection<PendragonSkill> skills) {
	_getExclusiveSkills().clear();
	for (final PendragonSkill skill : skills) {
	    addExclusiveSkill(skill);
	}
    }

    public final void setFeatures(
	    final Collection<PendragonAppearanceFeature> features) {
	_getFeatures().clear();
	for (final PendragonAppearanceFeature feature : features) {
	    addFeature(feature);
	}
    }

    public final void setFlag(final String name, final Boolean value) {
	if (name == null) {
	    throw new NullPointerException();
	}
	if (value == null) {
	    throw new NullPointerException();
	}

	if ((getFlag(name)) && (!value)) {
	    _getFlags().remove(name);
	} else if (value) {
	    _getFlags().add(name);
	}
    }

    public final void setFlags(final Collection<String> flags) {
	_getFlags().clear();
	for (final String flag : flags) {
	    setFlag(flag, true);
	}
    }

    public final void setFollowers(final Collection<Follower> followers) {
	_getFollowers().clear();
	for (final Follower follower : followers) {
	    addFollower(follower);
	}
    }

    public final void setHoldingsAtHome(final Collection<PendragonItem> items) {
	_getHoldingsAtHome().clear();
	for (final PendragonItem item : items) {
	    addHoldingAtHome(item);
	}
    }

    public final void setHoldingsCarried(final Collection<PendragonItem> items) {
	_getHoldingsCarried().clear();
	for (final PendragonItem item : items) {
	    addHoldingCarried(item);
	}
    }

    public final void setHorses(final Collection<HorseCharacter> horses) {
	_getHorses().clear();
	for (final HorseCharacter horse : horses) {
	    addHorse(horse);
	}
    }

    public void setKnight(final Boolean isKnight) {
	if (isKnight == null) {
	    throw new NullPointerException();
	}

	setFlag(PendragonLabels.FLAGS_KNIGHT, isKnight);
    }

    public final void setKnightKind(final String knightKind) {
	if (knightKind == null) {
	    throw new NullPointerException();
	}

	this.knightKind = knightKind;
    }

    public final void setReligionData(final Religion religion) {
	if (religion == null) {
	    throw new NullPointerException();
	}

	this.religion = religion;

	addTextValue(PendragonLabels.TEXT_RELIGION_NAME, getReligion()
		.getName());
    }

    public final void setTextValue(final String name, final String value) {
	if (name == null) {
	    throw new NullPointerException();
	}
	if (value == null) {
	    throw new NullPointerException();
	}

	_getTextValues().put(name, value);
    }

    public final void setTextValues(final Collection<TextValue> texts) {
	_getTextValues().clear();
	for (final TextValue text : texts) {
	    _getTextValues().put(text.getKey(), text.getValue());
	}
    }

    public final void setValueHandlers(
	    final Collection<ValueHandler<Integer>> values) {
	_getValueHandlers().clear();
	for (final ValueHandler<Integer> value : values) {
	    addValueHandler(value);
	}
    }

    public final void setWives(final Collection<Wife> wives) {
	_getWives().clear();
	for (final Wife wife : wives) {
	    addWife(wife);
	}
    }

    protected final Map<String, PendragonSkill> _getExclusiveSkills() {
	return exclusiveSkills;
    }

    protected final Map<String, PendragonAppearanceFeature> _getFeatures() {
	return features;
    }

    protected final Set<String> _getFlags() {
	return flags;
    }

    protected final Set<Follower> _getFollowers() {
	return followers;
    }

    protected final Set<PendragonItem> _getHoldingsAtHome() {
	return holdingsAtHome;
    }

    protected final Set<PendragonItem> _getHoldingsCarried() {
	return holdingsCarried;
    }

    protected final Set<HorseCharacter> _getHorses() {
	return horses;
    }

    protected final Set<ManorAnimal> _getPets() {
	return pets;
    }

    protected final Map<String, String> _getTextValues() {
	return textValues;
    }

    protected final Map<String, ValueHandler<Integer>> _getValueHandlers() {
	return valueHandlers;
    }

    protected final Set<Wife> _getWives() {
	return wives;
    }

}
