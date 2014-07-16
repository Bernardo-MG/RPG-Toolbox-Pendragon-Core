package com.wandrell.tabletop.pendragon.character.background.culture;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.dice.RollTable;
import com.wandrell.tabletop.pendragon.conf.PendragonToken;
import com.wandrell.tabletop.pendragon.inventory.AdditionalBelongings;
import com.wandrell.tabletop.pendragon.util.DefaultFileNameWrapper;
import com.wandrell.tabletop.pendragon.util.FileNameWrapper;

public class DefaultCulture implements Culture {

    private final Map<String, Path> files = new LinkedHashMap<>();
    private RollTable<AdditionalBelongings> initialLuckTableFemale;
    private RollTable<AdditionalBelongings> initialLuckTableMale;
    private final String name;
    private final DefaultCultureCharacterTemplate templateDefaultFemale;
    private final DefaultCultureCharacterTemplate templateDefaultMale;
    private final DefaultCultureCharacterTemplate templateRandomFemale;
    private final DefaultCultureCharacterTemplate templateRandomMale;

    public DefaultCulture(final DefaultCulture culture) {
	super();

	name = culture.name;

	templateDefaultFemale = culture.templateDefaultFemale
		.createNewInstance();
	templateDefaultMale = culture.templateDefaultMale.createNewInstance();
	templateRandomFemale = culture.templateRandomFemale.createNewInstance();
	templateRandomMale = culture.templateRandomMale.createNewInstance();

	for (final Entry<String, Path> entry : culture.files.entrySet()) {
	    files.put(entry.getKey(), entry.getValue());
	}
    }

    public DefaultCulture(final String name) {
	super();

	if (name == null) {
	    throw new NullPointerException();
	}

	this.name = name;

	templateDefaultFemale = new DefaultCultureCharacterTemplate();
	templateDefaultMale = new DefaultCultureCharacterTemplate();
	templateRandomFemale = new DefaultCultureCharacterTemplate();
	templateRandomMale = new DefaultCultureCharacterTemplate();
    }

    public final void addFile(final String name, final Path file) {
	if (name == null) {
	    throw new NullPointerException();
	}

	if (file == null) {
	    throw new NullPointerException();
	}

	getFilesMap().put(name, file);
    }

    @Override
    public DefaultCulture createNewInstance() {
	return new DefaultCulture(this);
    }

    @Override
    public final Path getFamilyCharacteristicFile(final Gender gender) {
	final Path result;

	switch (gender) {
	case MALE:
	    result = getFile(PendragonToken.FILE_CULTURE_FAMILY_CHAR_MALE);
	    break;
	case FEMALE:
	    result = getFile(PendragonToken.FILE_CULTURE_FAMILY_CHAR_FEMALE);
	    break;
	default:
	    result = null;
	}

	return result;
    }

    @Override
    public final CultureCharacterTemplate getFemaleRandomTemplate() {
	return templateRandomFemale;
    }

    @Override
    public final CultureCharacterTemplate getFemaleTemplate() {
	return templateDefaultFemale;
    }

    @Override
    public final Path getFile(final String name) {
	return getFilesMap().get(name);
    }

    @Override
    public final Collection<FileNameWrapper> getFiles() {
	final Collection<FileNameWrapper> files;

	files = new LinkedList<>();
	for (final Entry<String, Path> entry : getFilesMap().entrySet()) {
	    files.add(new DefaultFileNameWrapper(entry.getKey(), entry
		    .getValue()));
	}

	return Collections.unmodifiableCollection(files);
    }

    @Override
    public final RollTable<AdditionalBelongings> getInitialLuckTable(
	    final Gender gender) {
	final RollTable<AdditionalBelongings> result;

	switch (gender) {
	case MALE:
	    result = initialLuckTableMale;
	    break;
	case FEMALE:
	    result = initialLuckTableFemale;
	    break;
	default:
	    result = null;
	}

	return result;
    }

    @Override
    public final CultureCharacterTemplate getMaleRandomTemplate() {
	return templateRandomMale;
    }

    @Override
    public final CultureCharacterTemplate getMaleTemplate() {
	return templateDefaultMale;
    }

    @Override
    public final String getName() {
	return name;
    }

    @Override
    public final Boolean hasFile(final String name) {
	return getFilesMap().containsKey(name);
    }

    public final void setFiles(final Collection<FileNameWrapper> files) {
	if (files == null) {
	    throw new NullPointerException();
	}

	getFilesMap().clear();
	for (final FileNameWrapper file : files) {
	    addFile(file.getName(), file.getFile());
	}
    }

    @Override
    public String toString() {
	return getName();
    }

    protected final Map<String, Path> getFilesMap() {
	return files;
    }

}