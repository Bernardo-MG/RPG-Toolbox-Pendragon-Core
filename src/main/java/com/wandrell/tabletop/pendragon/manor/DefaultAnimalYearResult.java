package com.wandrell.tabletop.pendragon.manor;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.pendragon.util.DefaultPathNameWrapper;
import com.wandrell.tabletop.pendragon.util.PathNameWrapper;

public final class DefaultAnimalYearResult implements AnimalYearResult {

    private final Map<String, Path>    files;
    private final Collection<String>   flags;
    private final String               name;
    private final Map<String, Integer> values;

    public DefaultAnimalYearResult(final DefaultAnimalYearResult result) {
        super();

        name = result.name;

        files = result.files;
        flags = result.flags;
        values = result.values;
    }

    public DefaultAnimalYearResult(final String name,
            final Map<String, Path> files, final Collection<String> flags,
            final Map<String, Integer> values) {
        super();

        this.name = name;

        this.files = files;
        this.flags = flags;
        this.values = values;
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
    public final Map<String, Integer> getValues() {
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
    public final String toString() {
        return getName();
    }

    protected final Map<String, Path> _getFiles() {
        return files;
    }

    protected final Collection<String> _getFlags() {
        return flags;
    }

    protected final Map<String, Integer> _getValues() {
        return values;
    }

}
