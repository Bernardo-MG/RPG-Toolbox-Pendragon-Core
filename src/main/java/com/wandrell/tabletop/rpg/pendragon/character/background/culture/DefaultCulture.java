package com.wandrell.tabletop.rpg.pendragon.character.background.culture;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.wandrell.tabletop.rpg.character.Gender;
import com.wandrell.tabletop.rpg.dice.RollTable;
import com.wandrell.tabletop.rpg.pendragon.conf.PendragonLabels;
import com.wandrell.tabletop.rpg.pendragon.inventory.AdditionalBelongingsSetData;
import com.wandrell.tabletop.rpg.pendragon.util.DefaultFileNameWrapper;
import com.wandrell.tabletop.rpg.pendragon.util.FileNameWrapper;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultCulture implements Culture, Comparable<Culture>,
	NewInstantiable {

    private String cultureName = "";
    private final Map<String, Path> mapFiles = new TreeMap<>();
    private RollTable<AdditionalBelongingsSetData> mapInitialLuckFemale;
    private RollTable<AdditionalBelongingsSetData> mapInitialLuckMale;
    private final DefaultCultureCharacterTemplate templateDefaultFemale;
    private final DefaultCultureCharacterTemplate templateDefaultMale;
    private final DefaultCultureCharacterTemplate templateRandomFemale;
    private final DefaultCultureCharacterTemplate templateRandomMale;

    public DefaultCulture() {
	super();

	templateDefaultFemale = new DefaultCultureCharacterTemplate();
	templateDefaultMale = new DefaultCultureCharacterTemplate();
	templateRandomFemale = new DefaultCultureCharacterTemplate();
	templateRandomMale = new DefaultCultureCharacterTemplate();
    }

    public DefaultCulture(final DefaultCulture culture) {
	super();

	setName(culture.cultureName);

	templateDefaultFemale = culture.templateDefaultFemale
		.createNewInstance();
	templateDefaultMale = culture.templateDefaultMale.createNewInstance();
	templateRandomFemale = culture.templateRandomFemale.createNewInstance();
	templateRandomMale = culture.templateRandomMale.createNewInstance();

	for (final Entry<String, Path> entry : culture.mapFiles.entrySet()) {
	    mapFiles.put(entry.getKey(), entry.getValue());
	}
    }

    public void addFile(final String name, final Path file) {
	getFilesMap().put(name, file);
    }

    @Override
    public int compareTo(final Culture culture) {
	return getName().compareTo(culture.getName());
    }

    @Override
    public DefaultCulture createNewInstance() {
	return new DefaultCulture(this);
    }

    @Override
    public Path getFamilyCharacteristicFile(final Gender gender) {
	final Path result;

	switch (gender) {
	case MALE:
	    result = getFile(PendragonLabels.FILE_CULTURE_FAMILY_CHAR_MALE);
	    break;
	case FEMALE:
	    result = getFile(PendragonLabels.FILE_CULTURE_FAMILY_CHAR_FEMALE);
	    break;
	default:
	    result = null;
	}

	return result;
    }

    @Override
    public CultureCharacterTemplate getFemaleRandomTemplate() {
	return templateRandomFemale;
    }

    @Override
    public CultureCharacterTemplate getFemaleTemplate() {
	return templateDefaultFemale;
    }

    @Override
    public Path getFile(final String name) {
	return getFilesMap().get(name);
    }

    @Override
    public Collection<FileNameWrapper> getFiles() {
	final Collection<FileNameWrapper> files;

	files = new LinkedList<>();
	for (final Entry<String, Path> entry : getFilesMap().entrySet()) {
	    files.add(new DefaultFileNameWrapper(entry.getKey(), entry
		    .getValue()));
	}

	return Collections.unmodifiableCollection(files);
    }

    @Override
    public RollTable<AdditionalBelongingsSetData> getInitialLuckTable(
	    final Gender gender) {
	final RollTable<AdditionalBelongingsSetData> result;

	switch (gender) {
	case MALE:
	    result = mapInitialLuckMale;
	    break;
	case FEMALE:
	    result = mapInitialLuckFemale;
	    break;
	default:
	    result = null;
	}

	return result;
    }

    @Override
    public CultureCharacterTemplate getMaleRandomTemplate() {
	return templateRandomMale;
    }

    @Override
    public CultureCharacterTemplate getMaleTemplate() {
	return templateDefaultMale;
    }

    @Override
    public String getName() {
	return cultureName;
    }

    @Override
    public Boolean hasFile(final String name) {
	return getFilesMap().containsKey(name);
    }

    public void setFiles(final Collection<FileNameWrapper> files) {
	getFilesMap().clear();
	for (final FileNameWrapper file : files) {
	    addFile(file.getName(), file.getFile());
	}
    }

    public void setName(final String name) {
	this.cultureName = name;
    }

    protected Map<String, Path> getFilesMap() {
	return mapFiles;
    }

}