package com.wandrell.tabletop.pendragon.character.background.culture;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
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

    private final Map<String, Path>               files;
    private final RollTable<AdditionalBelongings> initialLuckFemale;
    private final RollTable<AdditionalBelongings> initialLuckMale;
    private final String                          name;
    private final CultureCharacterTemplate        templateDefaultFemale;
    private final CultureCharacterTemplate        templateDefaultMale;
    private final CultureCharacterTemplate        templateRandomFemale;
    private final CultureCharacterTemplate        templateRandomMale;

    public DefaultCulture(final DefaultCulture culture) {
        super();

        name = culture.name;

        templateDefaultFemale = culture.templateDefaultFemale;
        templateDefaultMale = culture.templateDefaultMale;
        templateRandomFemale = culture.templateRandomFemale;
        templateRandomMale = culture.templateRandomMale;

        initialLuckFemale = culture.initialLuckFemale;
        initialLuckMale = culture.initialLuckMale;

        files = culture.files;
    }

    public DefaultCulture(final String name, final Map<String, Path> files,
            final CultureCharacterTemplate templateDefaultFemale,
            final CultureCharacterTemplate templateRandomFemale,
            final CultureCharacterTemplate templateDefaultMale,
            final CultureCharacterTemplate templateRandomMale,
            final RollTable<AdditionalBelongings> initialLuckFemale,
            final RollTable<AdditionalBelongings> initialLuckMale) {
        super();

        if (name == null) {
            throw new NullPointerException();
        }

        if (files == null) {
            throw new NullPointerException();
        }

        if ((templateDefaultFemale == null) || (templateDefaultMale == null)
                || (templateRandomFemale == null)
                || (templateRandomMale == null)) {
            throw new NullPointerException();
        }

        if ((initialLuckFemale == null) || (initialLuckMale == null)) {
            throw new NullPointerException();
        }

        this.name = name;

        this.files = files;

        this.templateDefaultFemale = templateDefaultFemale;
        this.templateDefaultMale = templateDefaultMale;
        this.templateRandomFemale = templateRandomFemale;
        this.templateRandomMale = templateRandomMale;

        this.initialLuckFemale = initialLuckFemale;
        this.initialLuckMale = initialLuckMale;
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
                result = initialLuckMale;
                break;
            case FEMALE:
                result = initialLuckFemale;
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

    @Override
    public final String toString() {
        return getName();
    }

    protected final Map<String, Path> getFilesMap() {
        return files;
    }

}