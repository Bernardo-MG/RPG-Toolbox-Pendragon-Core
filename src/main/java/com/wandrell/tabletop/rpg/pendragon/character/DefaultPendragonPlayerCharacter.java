package com.wandrell.tabletop.rpg.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.wandrell.tabletop.rpg.character.Gender;
import com.wandrell.tabletop.rpg.pendragon.character.background.Religion;
import com.wandrell.tabletop.rpg.pendragon.character.follower.Follower;
import com.wandrell.tabletop.rpg.pendragon.character.follower.Wife;
import com.wandrell.tabletop.rpg.pendragon.character.module.DefaultTraitsBonusSwitchsData;
import com.wandrell.tabletop.rpg.pendragon.character.module.TraitsBonusSwitchsData;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.pendragon.glory.DefaultGloryController;
import com.wandrell.tabletop.rpg.pendragon.glory.GloryController;
import com.wandrell.tabletop.rpg.pendragon.inventory.ArmorData;
import com.wandrell.tabletop.rpg.pendragon.inventory.DefaultArmorData;
import com.wandrell.tabletop.rpg.pendragon.inventory.DefaultMoneyData;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonItem;
import com.wandrell.tabletop.rpg.pendragon.inventory.PendragonMoneyData;
import com.wandrell.tabletop.rpg.pendragon.manor.ManorAnimal;
import com.wandrell.tabletop.rpg.pendragon.util.DefaultTextValue;
import com.wandrell.tabletop.rpg.pendragon.util.PendragonValueHandlerUtils;
import com.wandrell.tabletop.rpg.pendragon.util.TextValue;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAppearanceFeature;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonAttribute;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonSkill;
import com.wandrell.tabletop.rpg.pendragon.valuehandler.PendragonTrait;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultPendragonPlayerCharacter extends
	AbstractPendragonSimpleCharacter implements PendragonPlayerCharacter,
	NewInstantiable {

    private final ArmorData dataArmor;
    private final GloryController dataGlory;
    private final PendragonMoneyData dataMoney;
    private Religion dataReligion;
    private final TraitsBonusSwitchsData dataTraitsBonusSwitchs;
    private String knightKind = null;
    private final Map<String, String> mapTextValues = new LinkedHashMap<>();
    private final Set<String> setFlags = new LinkedHashSet<>();
    private final Set<Follower> setFollowers = new LinkedHashSet<>();
    private final Set<HorseCharacter> setHorses = new LinkedHashSet<>();
    private final Set<ManorAnimal> setPets = new LinkedHashSet<>();
    private final Map<String, PendragonSkill> storeExclusiveSkills = new LinkedHashMap<>();
    private final Map<String, PendragonAppearanceFeature> storeFeatures = new LinkedHashMap<>();
    private final Set<PendragonItem> storeHoldingsAtHome = new LinkedHashSet<>();
    private final Set<PendragonItem> storeHoldingsCarried = new LinkedHashSet<>();
    private final Map<String, ValueHandler<Integer>> storeValueHandlers = new LinkedHashMap<>();
    private final Set<Wife> storeWives = new LinkedHashSet<>();

    public DefaultPendragonPlayerCharacter(
	    final Collection<PendragonAttribute> attributes,
	    final Collection<PendragonTrait> traits) {
	super(attributes, traits);

	// Initializes data holders
	dataTraitsBonusSwitchs = new DefaultTraitsBonusSwitchsData();
	dataGlory = new DefaultGloryController();
	dataMoney = new DefaultMoneyData();
	dataArmor = new DefaultArmorData();
    }

    public DefaultPendragonPlayerCharacter(
	    final DefaultPendragonPlayerCharacter character) {
	super(character);

	setFlags.addAll(character.getFlagsSet());
	// TODO: Copy correctly
	setFollowers.addAll(character.setFollowers);
	setHorses.addAll(character.setHorses);
	setPets.addAll(character.setPets);

	for (final PendragonAppearanceFeature feature : character.storeFeatures
		.values()) {
	    addFeature(feature.createNewInstance());
	}
	for (final PendragonSkill skill : character.storeExclusiveSkills
		.values()) {
	    addExclusiveSkill(skill);
	}
	for (final Entry<String, ValueHandler<Integer>> entry : character.storeValueHandlers
		.entrySet()) {
	    storeValueHandlers.put(entry.getKey(), entry.getValue());
	}

	for (final Entry<String, String> entry : mapTextValues.entrySet()) {
	    mapTextValues.put(entry.getKey(), entry.getValue());
	}

	// TODO: Copy correctly
	storeHoldingsAtHome.addAll(character.storeHoldingsAtHome);
	storeHoldingsCarried.addAll(character.storeHoldingsCarried);
	storeWives.addAll(character.storeWives);
	setFollowers.addAll(character.setFollowers);
	setHorses.addAll(character.setHorses);
	setFlags.addAll(character.setFlags);

	// Initializes data holders
	dataArmor = character.dataArmor.createNewInstance();
	dataGlory = character.dataGlory.createNewInstance();
	dataMoney = character.dataMoney.createNewInstance();
	dataTraitsBonusSwitchs = character.dataTraitsBonusSwitchs
		.createNewInstance();

	setKnight(character.isKnight());
	setKnightKind(character.knightKind);
	setReligionData(character.dataReligion.createNewInstance());

	// TODO: Handle this
	// getGloryData().setReligiousAnnualGlorySwitch(
	// getTraitsBonusSwitchsData().getBonusSwitch(
	// PendragonLabels.BONUS_TRAITS_RELIGIOUS_SWITCH));
    }

    public void addExclusiveSkill(final PendragonSkill vhExcSkill) {
	getExclusiveSkillsStore().put(
		PendragonValueHandlerUtils.getNameAnnotationKey(
			vhExcSkill.getName(), vhExcSkill.getAnnotation()),
		vhExcSkill);
    }

    public void addFeature(final PendragonAppearanceFeature feature) {
	getFeaturesStore().put(feature.getName(), feature);
    }

    public void addFollower(final Follower follower) {
	getFollowersSet().add(follower);
    }

    public void addHoldingAtHome(final PendragonItem item) {
	_getHoldingsAtHome().add(item);
    }

    public void addHoldingCarried(final PendragonItem item) {
	_getHoldingsCarried().add(item);
    }

    public void addHorse(final HorseCharacter horse) {
	getHorsesSet().add(horse);
    }

    public void addPet(final ManorAnimal pet) {
	getPetsSet().add(pet);
    }

    public void addTextValue(final String key, final String value) {
	_getTextValues().put(key, value);
    }

    public void addValueHandler(final ValueHandler<Integer> vh) {
	_getValueHandlers().put(vh.getName(), vh);
    }

    public void addWife(final Wife wife) {
	_getWives().add(wife);
    }

    @Override
    public DefaultPendragonPlayerCharacter createNewInstance() {
	return new DefaultPendragonPlayerCharacter(this);
    }

    @Override
    public boolean equals(final Object obj) {
	final DefaultPendragonPlayerCharacter received;
	boolean equals;

	if (super.equals(obj)) {
	    received = (DefaultPendragonPlayerCharacter) obj;
	    if (received.dataArmor == null) {
		equals = (dataArmor == null);
	    } else {
		equals = (received.dataArmor.equals(dataArmor));
	    }
	    if ((equals) && (received.dataGlory == null)) {
		equals = (dataGlory == null);
	    } else if (equals) {
		equals = (received.dataGlory.equals(dataGlory));
	    }
	    if ((equals) && (received.dataMoney == null)) {
		equals = (dataMoney == null);
	    } else if (equals) {
		equals = (received.dataMoney.equals(dataMoney));
	    }
	    if ((equals) && (received.knightKind == null)) {
		equals = (knightKind == null);
	    } else if (equals) {
		equals = (received.knightKind.equals(knightKind));
	    }
	    if ((equals) && (received.storeFeatures == null)) {
		equals = (storeFeatures == null);
	    } else if (equals) {
		equals = (received.storeFeatures.equals(storeFeatures));
	    }
	    if ((equals) && (received.setFollowers == null)) {
		equals = (setFollowers == null);
	    } else if (equals) {
		equals = (received.setFollowers.equals(setFollowers));
	    }
	    if ((equals) && (received.storeHoldingsAtHome == null)) {
		equals = (storeHoldingsAtHome == null);
	    } else if (equals) {
		equals = (received.storeHoldingsAtHome
			.equals(storeHoldingsAtHome));
	    }
	    if ((equals) && (received.storeHoldingsCarried == null)) {
		equals = (storeHoldingsCarried == null);
	    } else if (equals) {
		equals = (received.storeHoldingsCarried
			.equals(storeHoldingsCarried));
	    }
	    if ((equals) && (received.setHorses == null)) {
		equals = (setHorses == null);
	    } else if (equals) {
		equals = (received.setHorses.equals(setHorses));
	    }
	    if ((equals) && (received.mapTextValues == null)) {
		equals = (mapTextValues == null);
	    } else if (equals) {
		equals = (received.mapTextValues.equals(mapTextValues));
	    }
	    if ((equals) && (received.storeValueHandlers == null)) {
		equals = (storeValueHandlers == null);
	    } else if (equals) {
		equals = (received.storeValueHandlers
			.equals(storeValueHandlers));
	    }
	    if ((equals) && (received.storeWives == null)) {
		equals = (storeWives == null);
	    } else if (equals) {
		equals = (received.storeWives.equals(storeWives));
	    }
	    if ((equals) && (received.setFlags == null)) {
		equals = (setFlags == null);
	    } else if (equals) {
		equals = (received.setFlags.equals(setFlags));
	    }
	} else {
	    equals = false;
	}

	return equals;
    }

    @Override
    public ArmorData getArmorData() {
	return dataArmor;
    }

    @Override
    public PendragonSkill getExclusiveSkill(final String name,
	    final String annotation) {
	return getExclusiveSkillsStore().get(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public Collection<PendragonSkill> getExclusiveSkills() {
	return Collections.unmodifiableCollection(getExclusiveSkillsStore()
		.values());
    }

    @Override
    public Collection<PendragonAppearanceFeature> getFeatures() {
	return Collections.unmodifiableCollection(getFeaturesStore().values());
    }

    @Override
    public Boolean getFlag(final String name) {
	return getFlagsSet().contains(name);
    }

    @Override
    public Collection<String> getFlags() {
	return Collections.unmodifiableCollection(getFlagsSet());
    }

    @Override
    public Collection<Follower> getFollowers() {
	return Collections.unmodifiableCollection(getFollowersSet());
    }

    @Override
    public GloryController getGloryData() {
	return dataGlory;
    }

    @Override
    public Collection<PendragonItem> getHoldingsAtHome() {
	return Collections.unmodifiableCollection(_getHoldingsAtHome());
    }

    @Override
    public Collection<PendragonItem> getHoldingsCarried() {
	return Collections.unmodifiableCollection(_getHoldingsCarried());
    }

    @Override
    public Collection<HorseCharacter> getHorses() {
	return Collections.unmodifiableCollection(getHorsesSet());
    }

    @Override
    public String getKnightKind() {
	return knightKind;
    }

    @Override
    public PendragonMoneyData getMoney() {
	return dataMoney;
    }

    @Override
    public Collection<ManorAnimal> getPets() {
	return Collections.unmodifiableCollection(getPetsSet());
    }

    @Override
    public String getPlayerName() {
	return getTextValue(PendragonLabels.TEXT_PLAYER_NAME);
    }

    @Override
    public Religion getReligion() {
	return dataReligion;
    }

    @Override
    public String getTextValue(final String name) {
	final String text;

	if (hasTextValue(name)) {
	    text = _getTextValues().get(name);
	} else {
	    text = "";
	}

	return text;
    }

    @Override
    public Collection<TextValue> getTextValues() {
	final Collection<TextValue> values;

	values = new LinkedList<>();
	for (final Entry<String, String> entry : _getTextValues().entrySet()) {
	    values.add(new DefaultTextValue(entry.getKey(), entry.getValue()));
	}

	return Collections.unmodifiableCollection(values);
    }

    @Override
    public TraitsBonusSwitchsData getTraitsBonusSwitchsData() {
	return dataTraitsBonusSwitchs;
    }

    @Override
    public ValueHandler<Integer> getValueHandler(final String name) {
	return _getValueHandlers().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getValueHandlers() {
	return Collections.unmodifiableCollection(_getValueHandlers().values());
    }

    @Override
    public Collection<Wife> getWives() {
	return Collections.unmodifiableCollection(_getWives());
    }

    @Override
    public Boolean hasExclusiveSkill(final String name, final String annotation) {
	return getExclusiveSkillsStore().containsKey(
		PendragonValueHandlerUtils.getNameAnnotationKey(name,
			annotation));
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result
		+ ((dataArmor == null) ? 0 : dataArmor.hashCode());
	result = prime * result
		+ ((dataGlory == null) ? 0 : dataGlory.hashCode());
	result = prime * result
		+ ((dataMoney == null) ? 0 : dataMoney.hashCode());
	result = prime * result
		+ ((knightKind == null) ? 0 : knightKind.hashCode());
	result = prime * result
		+ ((storeFeatures == null) ? 0 : storeFeatures.hashCode());
	result = prime * result
		+ ((setFollowers == null) ? 0 : setFollowers.hashCode());
	result = prime
		* result
		+ ((storeHoldingsAtHome == null) ? 0 : storeHoldingsAtHome
			.hashCode());
	result = prime
		* result
		+ ((storeHoldingsCarried == null) ? 0 : storeHoldingsCarried
			.hashCode());
	result = prime * result
		+ ((setHorses == null) ? 0 : setHorses.hashCode());
	result = prime * result
		+ ((mapTextValues == null) ? 0 : mapTextValues.hashCode());
	result = prime
		* result
		+ ((storeValueHandlers == null) ? 0 : storeValueHandlers
			.hashCode());
	result = prime * result
		+ ((storeWives == null) ? 0 : storeWives.hashCode());
	result = prime * result
		+ ((setFlags == null) ? 0 : setFlags.hashCode());
	return result;
    }

    @Override
    public Boolean hasTextValue(final String name) {
	return _getTextValues().containsKey(name);
    }

    @Override
    public Boolean hasValueHandler(final String name) {
	return _getValueHandlers().containsKey(name);
    }

    @Override
    public boolean isKnight() {
	return getFlag(PendragonLabels.FLAGS_KNIGHT);
    }

    public void setExclusiveSkills(final Collection<PendragonSkill> skills) {
	getExclusiveSkillsStore().clear();
	for (final PendragonSkill skill : skills) {
	    addExclusiveSkill(skill);
	}
    }

    public void setFeatures(
	    final Collection<PendragonAppearanceFeature> features) {
	getFeaturesStore().clear();
	for (final PendragonAppearanceFeature feature : features) {
	    addFeature(feature);
	}
    }

    public void setFlag(final String name, final Boolean value) {
	if ((getFlag(name)) && (!value)) {
	    getFlagsSet().remove(name);
	} else if (value) {
	    getFlagsSet().add(name);
	}
    }

    public void setFlags(final Collection<String> flags) {
	getFlagsSet().clear();
	for (final String flag : flags) {
	    setFlag(flag, true);
	}
    }

    public void setFollowers(final Collection<Follower> followers) {
	getFollowersSet().clear();
	for (final Follower follower : followers) {
	    addFollower(follower);
	}
    }

    @Override
    public void setGender(final Gender gender) {
	super.setGender(gender);
    }

    public void setHoldingsAtHome(final Collection<PendragonItem> items) {
	_getHoldingsAtHome().clear();
	for (final PendragonItem item : items) {
	    addHoldingAtHome(item);
	}
    }

    public void setHoldingsCarried(final Collection<PendragonItem> items) {
	_getHoldingsCarried().clear();
	for (final PendragonItem item : items) {
	    addHoldingCarried(item);
	}
    }

    public void setHorses(final Collection<HorseCharacter> horses) {
	getHorsesSet().clear();
	for (final HorseCharacter horse : horses) {
	    addHorse(horse);
	}
    }

    public void setKnight(final Boolean isKnight) {
	setFlag(PendragonLabels.FLAGS_KNIGHT, isKnight);
    }

    public void setKnightKind(final String knightKind) {
	this.knightKind = knightKind;
    }

    public void setReligionData(final Religion religion) {
	dataReligion = religion;

	addTextValue(PendragonLabels.TEXT_RELIGION_NAME, getReligion()
		.getName());
    }

    public void setTextValue(final String name, final String value) {
	_getTextValues().put(name, value);
    }

    public void setTextValues(final Collection<TextValue> texts) {
	_getTextValues().clear();
	for (final TextValue text : texts) {
	    _getTextValues().put(text.getKey(), text.getValue());
	}
    }

    public void setValueHandlers(final Collection<ValueHandler<Integer>> values) {
	_getValueHandlers().clear();
	for (final ValueHandler<Integer> value : values) {
	    addValueHandler(value);
	}
    }

    public void setWives(final Collection<Wife> wives) {
	_getWives().clear();
	for (final Wife wife : wives) {
	    addWife(wife);
	}
    }

    protected Set<PendragonItem> _getHoldingsAtHome() {
	return storeHoldingsAtHome;
    }

    protected Set<PendragonItem> _getHoldingsCarried() {
	return storeHoldingsCarried;
    }

    protected Map<String, String> _getTextValues() {
	return mapTextValues;
    }

    protected Map<String, ValueHandler<Integer>> _getValueHandlers() {
	return storeValueHandlers;
    }

    protected Set<Wife> _getWives() {
	return storeWives;
    }

    protected Map<String, PendragonSkill> getExclusiveSkillsStore() {
	return storeExclusiveSkills;
    }

    protected Map<String, PendragonAppearanceFeature> getFeaturesStore() {
	return storeFeatures;
    }

    protected Set<String> getFlagsSet() {
	return setFlags;
    }

    protected Set<Follower> getFollowersSet() {
	return setFollowers;
    }

    protected Set<HorseCharacter> getHorsesSet() {
	return setHorses;
    }

    protected Set<ManorAnimal> getPetsSet() {
	return setPets;
    }

}
