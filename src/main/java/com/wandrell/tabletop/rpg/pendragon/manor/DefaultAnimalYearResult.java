package com.wandrell.tabletop.rpg.pendragon.manor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.wandrell.tabletop.rpg.pendragon.util.DefaultFileNameWrapper;
import com.wandrell.tabletop.rpg.pendragon.util.FileNameWrapper;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;
import com.wandrell.util.tag.NewInstantiable;

public class DefaultAnimalYearResult implements AnimalYearResult,
	NewInstantiable {

    private final Map<String, Path> mapFiles = new TreeMap<>();
    private final Map<String, ValueHandler<Integer>> mapValues = new TreeMap<>();
    private String name = "";
    private final Set<String> setFlags = new TreeSet<String>();

    public DefaultAnimalYearResult() {
	super();
    }

    public DefaultAnimalYearResult(final DefaultAnimalYearResult result) {
	super();

	this.name = result.name;

	// TODO: Maybe it should create new instances
	getValuesMap().putAll(result.getValuesMap());

	setFlags(result.getFlags());
	setFiles(result.getFiles());
    }

    public void addValue(final ValueHandler<Integer> vhValue) {
	getValuesMap().put(vhValue.getName(), vhValue);
    }

    @Override
    public DefaultAnimalYearResult createNewInstance() {
	return new DefaultAnimalYearResult(this);
    }

    @Override
    public Path getFile(final String name) {
	return getFilesMap().get(name);
    }

    @Override
    public Collection<FileNameWrapper> getFiles() {
	final List<FileNameWrapper> listFiles;

	listFiles = new ArrayList<FileNameWrapper>(getFilesMap().size());
	for (final Entry<String, Path> entry : getFilesMap().entrySet()) {
	    listFiles.add(new DefaultFileNameWrapper(entry.getKey(), entry
		    .getValue()));
	}

	return Collections.unmodifiableCollection(listFiles);
    }

    @Override
    public boolean getFlag(final String name) {
	return _getFlags().contains(name);
    }

    @Override
    public Collection<String> getFlags() {
	return Collections.unmodifiableCollection(_getFlags());
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public ValueHandler<Integer> getValue(final String name) {
	return getValuesMap().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getValues() {
	return Collections.unmodifiableCollection(getValuesMap().values());
    }

    public Map<String, ValueHandler<Integer>> getValuesMap() {
	return Collections.unmodifiableMap(_getValuesMap());
    }

    @Override
    public boolean hasFile(final String name) {
	return getFilesMap().containsKey(name);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean hasValue(final String name) {
	return getValuesMap().containsKey(name);
    }

    public void setFiles(final Collection<FileNameWrapper> files) {
	getFilesMap().clear();
	for (final FileNameWrapper file : files) {
	    getFilesMap().put(file.getName(), file.getFile());
	}
    }

    public void setFlags(final Collection<String> flags) {
	_getFlags().clear();
	for (final String flag : flags) {
	    _getFlags().add(flag);
	}
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setValues(final Collection<ValueHandler<Integer>> values) {
	for (final ValueHandler<Integer> vhValue : values) {
	    _getValuesMap().put(vhValue.getName(), vhValue);
	}
    }

    protected Collection<String> _getFlags() {
	return setFlags;
    }

    protected Map<String, ValueHandler<Integer>> _getValuesMap() {
	return mapValues;
    }

    protected Map<String, Path> getFilesMap() {
	return mapFiles;
    }

}
