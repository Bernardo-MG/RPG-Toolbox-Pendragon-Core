package com.wandrell.tabletop.business.model.pendragon.character;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.wandrell.tabletop.business.model.pendragon.valuehandler.Attribute;
import com.wandrell.tabletop.business.model.valuehandler.EditableValueHandler;

public final class DefaultHorseCharacter extends AbstractPendragonBaseCharacter
        implements HorseCharacter {

    private final Collection<String>                flags               = new LinkedHashSet<String>();
    private final Map<String, EditableValueHandler> secondaryAttributes = new LinkedHashMap<>();
    private String                                  type                = "";

    public DefaultHorseCharacter(final Collection<Attribute> attributes) {
        super(attributes);
    }

    public DefaultHorseCharacter(final DefaultHorseCharacter horse) {
        super(horse);

        for (final Entry<String, EditableValueHandler> entry : horse.secondaryAttributes
                .entrySet()) {
            secondaryAttributes.put(entry.getKey(), entry.getValue()
                    .createNewInstance());
        }

        type = horse.type;
        flags.addAll(horse.flags);
    }

    @Override
    public final void
            addSecondaryAttribute(final EditableValueHandler attribute) {
        if (attribute == null) {
            throw new NullPointerException();
        }

        _getSecondaryAttributes().put(attribute.getName(), attribute);
    }

    @Override
    public final DefaultHorseCharacter createNewInstance() {
        return new DefaultHorseCharacter(this);
    }

    @Override
    public final Boolean getFlag(final String flag) {
        return _getFlags().contains(flag);
    }

    @Override
    public final Collection<String> getFlags() {
        return Collections.unmodifiableCollection(_getFlags());
    }

    @Override
    public final String getHorseType() {
        return type;
    }

    @Override
    public final EditableValueHandler getSecondaryAttribute(final String name) {
        return _getSecondaryAttributes().get(name);
    }

    @Override
    public final Collection<EditableValueHandler> getSecondaryAttributes() {
        return Collections.unmodifiableCollection(_getSecondaryAttributes()
                .values());
    }

    @Override
    public final Boolean hasFlag(final String name) {
        return _getFlags().contains(name);
    }

    @Override
    public final Boolean hasSecondaryAttribute(final String name) {
        return _getSecondaryAttributes().containsKey(name);
    }

    public final void setFlag(final String name, final Boolean value) {
        if (name == null) {
            throw new NullPointerException();
        }

        if (value == null) {
            throw new NullPointerException();
        }

        if ((hasFlag(name)) && (!value)) {
            _getFlags().remove(name);
        } else if (value) {
            _getFlags().add(name);
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

    public final void setHorseType(final String type) {
        if (type == null) {
            throw new NullPointerException();
        }

        this.type = type;
    }

    public final void setSecondaryAttributes(
            final Collection<EditableValueHandler> attributes) {
        _getSecondaryAttributes().clear();
        for (final EditableValueHandler attribute : attributes) {
            addSecondaryAttribute(attribute);
        }
    }

    protected final Collection<String> _getFlags() {
        return flags;
    }

    protected final Map<String, EditableValueHandler> _getSecondaryAttributes() {
        return secondaryAttributes;
    }

}
