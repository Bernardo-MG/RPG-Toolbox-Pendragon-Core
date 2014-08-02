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
import com.wandrell.tabletop.pendragon.util.DefaultPathNameWrapper;
import com.wandrell.tabletop.pendragon.util.PathNameWrapper;

public final class DefaultCulture implements Culture {

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

	templateDefaultFemale = culture.templateDefaultFemale;
	templateDefaultMale = culture.templateDefaultMale;
	templateRandomFemale = culture.templateRandomFemale;
	templateRandomMale = culture.templateRandomMale;

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
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultCulture other = (DefaultCulture) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
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
    public final Collection<PathNameWrapper> getFiles() {
	final Collection<PathNameWrapper> files;

	files = new LinkedList<>();
	for (final Entry<String, Path> entry : getFilesMap().entrySet()) {
	    files.add(new DefaultPathNameWrapper(entry.getKey(), entry
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

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    public final void setFiles(final Collection<PathNameWrapper> files) {
	if (files == null) {
	    throw new NullPointerException();
	}

	getFilesMap().clear();
	for (final PathNameWrapper file : files) {
	    addFile(file.getName(), file.getPath());
	}
    }

    @Override
    public final String toString() {
	return getName();
    }

    protected final Map<String, Path> getFilesMap() {
	return files;
    }

}