package com.wandrell.tabletop.pendragon.manor;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.wandrell.tabletop.pendragon.util.DefaultPathNameWrapper;
import com.wandrell.tabletop.pendragon.util.PathNameWrapper;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultAnimalYearResult implements AnimalYearResult {

    private final Map<String, Path> files = new LinkedHashMap<>();
    private final Set<String> flags = new LinkedHashSet<String>();
    private final String name;
    private final Map<String, ValueHandler<Integer>> values = new LinkedHashMap<>();

    public DefaultAnimalYearResult(final DefaultAnimalYearResult result) {
	super();

	this.name = result.name;

	// TODO: Maybe it should create new instances
	getValuesMap().putAll(result.getValuesMap());

	setFlags(result.getFlags());
	setFiles(result.getFiles());
    }

    public DefaultAnimalYearResult(final String name) {
	super();

	this.name = name;
    }

    public final void addValue(final ValueHandler<Integer> value) {
	if (value == null) {
	    throw new NullPointerException();
	}

	getValuesMap().put(value.getName(), value);
    }

    @Override
    public final boolean equals(final Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	DefaultAnimalYearResult other = (DefaultAnimalYearResult) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public final Path getFile(final String name) {
	return _getFiles().get(name);
    }

    @Override
    public final Collection<PathNameWrapper> getFiles() {
	final List<PathNameWrapper> listFiles;

	listFiles = new LinkedList<PathNameWrapper>();
	for (final Entry<String, Path> entry : _getFiles().entrySet()) {
	    listFiles.add(new DefaultPathNameWrapper(entry.getKey(), entry
		    .getValue()));
	}

	return listFiles;
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
    public final String getName() {
	return name;
    }

    @Override
    public final ValueHandler<Integer> getValue(final String name) {
	return getValuesMap().get(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getValues() {
	return Collections.unmodifiableCollection(getValuesMap().values());
    }

    public final Map<String, ValueHandler<Integer>> getValuesMap() {
	return Collections.unmodifiableMap(_getValues());
    }

    @Override
    public final Boolean hasFile(final String name) {
	return _getFiles().containsKey(name);
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public final Boolean hasValue(final String name) {
	return getValuesMap().containsKey(name);
    }

    public final void setFiles(final Collection<PathNameWrapper> files) {
	_getFiles().clear();
	for (final PathNameWrapper file : files) {
	    if (file == null) {
		throw new NullPointerException();
	    }

	    _getFiles().put(file.getName(), file.getPath());
	}
    }

    public final void setFlags(final Collection<String> flags) {
	_getFlags().clear();
	for (final String flag : flags) {
	    if (flag == null) {
		throw new NullPointerException();
	    }

	    _getFlags().add(flag);
	}
    }

    public final void setValues(final Collection<ValueHandler<Integer>> values) {
	for (final ValueHandler<Integer> value : values) {
	    if (value == null) {
		throw new NullPointerException();
	    }

	    _getValues().put(value.getName(), value);
	}
    }

    @Override
    public String toString() {
	return getName();
    }

    protected final Map<String, Path> _getFiles() {
	return files;
    }

    protected final Collection<String> _getFlags() {
	return flags;
    }

    protected final Map<String, ValueHandler<Integer>> _getValues() {
	return values;
    }

}
