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
import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.pendragon.conf.factory.PendragonFactory;
import com.wandrell.tabletop.pendragon.glory.GloryKeeper;
import com.wandrell.tabletop.pendragon.inventory.Item;
import com.wandrell.tabletop.pendragon.inventory.Money;
import com.wandrell.tabletop.pendragon.manor.ManorAnimal;
import com.wandrell.tabletop.pendragon.util.DefaultTextValue;
import com.wandrell.tabletop.pendragon.util.TextValue;
import com.wandrell.tabletop.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.pendragon.valuehandler.DerivedAttribute;
import com.wandrell.tabletop.pendragon.valuehandler.DistinctiveFeature;
import com.wandrell.tabletop.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.pendragon.valuehandler.Trait;
import com.wandrell.tabletop.util.TokenUtil;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultPendragonPlayerCharacter extends
	AbstractPendragonSimpleCharacter implements PendragonPlayerCharacter {

    private final ValueHandler<Integer> armor;
    private final TraitsBonusSwitchsData dataTraitsBonusSwitchs;
    private final Map<String, Skill> exclusiveSkills = new LinkedHashMap<>();
    private final Map<String, DistinctiveFeature> features = new LinkedHashMap<>();
    private final Set<String> flags = new LinkedHashSet<>();
    private final Set<Follower> followers = new LinkedHashSet<>();
    private final GloryKeeper glory;
    private final Set<Item> holdingsAtHome = new LinkedHashSet<>();
    private final Set<Item> holdingsCarried = new LinkedHashSet<>();
    private final Set<HorseCharacter> horses = new LinkedHashSet<>();
    private final Money money;
    private final Set<ManorAnimal> pets = new LinkedHashSet<>();
    private Religion religion;
    private final Map<String, String> textValues = new LinkedHashMap<>();
    private final Map<String, ValueHandler<Integer>> valueHandlers = new LinkedHashMap<>();
    private final Set<Wife> wives = new LinkedHashSet<>();

    public DefaultPendragonPlayerCharacter(
	    final Collection<Attribute> attributes,
	    final Collection<Trait> traits) {
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

	for (final Entry<String, DistinctiveFeature> entry : character.features
		.entrySet()) {
	    features.put(entry.getKey(), entry.getValue().createNewInstance());
	}

	for (final Entry<String, Skill> entry : character.exclusiveSkills
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
	glory = character.glory;
	money = character.money.createNewInstance();
	dataTraitsBonusSwitchs = character.dataTraitsBonusSwitchs
		.createNewInstance();

	setFlag(PendragonToken.FLAGS_KNIGHT, character.isKnight());

	religion = character.religion;

	addTextValue(PendragonToken.TEXT_RELIGION_NAME, religion.getName());

	// TODO: Handle this
	// getGloryData().setReligiousAnnualGlorySwitch(
	// getTraitsBonusSwitchsData().getBonusSwitch(
	// PendragonLabels.BONUS_TRAITS_RELIGIOUS_SWITCH));
    }

    @Override
    public final void addDistinctiveFeature(final DistinctiveFeature feature) {
	if (feature == null) {
	    throw new NullPointerException();
	}

	_getFeatures().put(feature.getName(), feature);
    }

    @Override
    public final void addExclusiveSkill(final Skill skill) {
	if (skill == null) {
	    throw new NullPointerException();
	}

	_getExclusiveSkills().put(
		TokenUtil.getNameAndDescriptorToken(skill.getName(),
			skill.getDescriptor()), skill);
    }

    @Override
    public final void addFollower(final Follower follower) {
	if (follower == null) {
	    throw new NullPointerException();
	}

	_getFollowers().add(follower);
    }

    @Override
    public final void addHoldingAtHome(final Item item) {
	if (item == null) {
	    throw new NullPointerException();
	}

	_getHoldingsAtHome().add(item);
    }

    @Override
    public final void addHoldingCarried(final Item item) {
	if (item == null) {
	    throw new NullPointerException();
	}

	_getHoldingsCarried().add(item);
    }

    @Override
    public final void addHorse(final HorseCharacter horse) {
	if (horse == null) {
	    throw new NullPointerException();
	}

	_getHorses().add(horse);
    }

    @Override
    public final void addPet(final ManorAnimal pet) {
	if (pet == null) {
	    throw new NullPointerException();
	}

	_getPets().add(pet);
    }

    @Override
    public final void addTextValue(final String key, final String value) {
	if (key == null) {
	    throw new NullPointerException();
	}
	if (value == null) {
	    throw new NullPointerException();
	}

	_getTextValues().put(key, value);
    }

    @Override
    public final void addValueHandler(final ValueHandler<Integer> value) {
	if (value == null) {
	    throw new NullPointerException();
	}

	_getValueHandlers().put(value.getName(), value);
    }

    @Override
    public final void addWife(final Wife wife) {
	if (wife == null) {
	    throw new NullPointerException();
	}

	_getWives().add(wife);
    }

    @Override
    public final DefaultPendragonPlayerCharacter createNewInstance() {
	return new DefaultPendragonPlayerCharacter(this);
    }

    @Override
    public final ValueHandler<Integer> getArmor() {
	return armor;
    }

    @Override
    public final Collection<DistinctiveFeature> getDistinctiveFeatures() {
	return Collections.unmodifiableCollection(_getFeatures().values());
    }

    @Override
    public final DerivedAttribute getDistinctiveFeaturesCount() {
	return _getDerivedAttributes().get(
		PendragonToken.DERIVED_ATTRIBUTE_FEATURES);
    }

    @Override
    public final Skill getExclusiveSkill(final String name,
	    final String annotation) {
	return _getExclusiveSkills().get(
		TokenUtil.getNameAndDescriptorToken(name, annotation));
    }

    @Override
    public final Collection<Skill> getExclusiveSkills() {
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
    public final Collection<Item> getHoldingsAtHome() {
	return Collections.unmodifiableCollection(_getHoldingsAtHome());
    }

    @Override
    public final Collection<Item> getHoldingsCarried() {
	return Collections.unmodifiableCollection(_getHoldingsCarried());
    }

    @Override
    public final Collection<HorseCharacter> getHorses() {
	return Collections.unmodifiableCollection(_getHorses());
    }

    @Override
    public final Money getMoney() {
	return money;
    }

    @Override
    public final Collection<ManorAnimal> getPets() {
	return Collections.unmodifiableCollection(_getPets());
    }

    @Override
    public final String getPlayerName() {
	return getTextValue(PendragonToken.TEXT_PLAYER_NAME);
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
		TokenUtil.getNameAndDescriptorToken(name, annotation));
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
	return getFlag(PendragonToken.FLAGS_KNIGHT);
    }

    public final void setExclusiveSkills(final Collection<Skill> skills) {
	_getExclusiveSkills().clear();
	for (final Skill skill : skills) {
	    addExclusiveSkill(skill);
	}
    }

    public final void setFeatures(final Collection<DistinctiveFeature> features) {
	_getFeatures().clear();
	for (final DistinctiveFeature feature : features) {
	    addDistinctiveFeature(feature);
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

    public final void setHoldingsAtHome(final Collection<Item> items) {
	_getHoldingsAtHome().clear();
	for (final Item item : items) {
	    addHoldingAtHome(item);
	}
    }

    public final void setHoldingsCarried(final Collection<Item> items) {
	_getHoldingsCarried().clear();
	for (final Item item : items) {
	    addHoldingCarried(item);
	}
    }

    public final void setHorses(final Collection<HorseCharacter> horses) {
	_getHorses().clear();
	for (final HorseCharacter horse : horses) {
	    addHorse(horse);
	}
    }

    @Override
    public final void setKnight(final Boolean isKnight) {
	if (isKnight == null) {
	    throw new NullPointerException();
	}

	setFlag(PendragonToken.FLAGS_KNIGHT, isKnight);
    }

    public final void setReligionData(final Religion religion) {
	if (religion == null) {
	    throw new NullPointerException();
	}

	this.religion = religion;

	addTextValue(PendragonToken.TEXT_RELIGION_NAME, getReligion().getName());
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

    protected final Map<String, Skill> _getExclusiveSkills() {
	return exclusiveSkills;
    }

    protected final Map<String, DistinctiveFeature> _getFeatures() {
	return features;
    }

    protected final Set<String> _getFlags() {
	return flags;
    }

    protected final Set<Follower> _getFollowers() {
	return followers;
    }

    protected final Set<Item> _getHoldingsAtHome() {
	return holdingsAtHome;
    }

    protected final Set<Item> _getHoldingsCarried() {
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
