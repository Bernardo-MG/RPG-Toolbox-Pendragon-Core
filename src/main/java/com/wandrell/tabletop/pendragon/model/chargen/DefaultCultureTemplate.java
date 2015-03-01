package com.wandrell.tabletop.pendragon.model.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public final class DefaultCultureTemplate implements CultureTemplate {

    private final FamilyCharacteristicTemplate femaleFamilyCharacteristic;
    private final AdditionalBelongingsTable    initialLuckFemale;
    private final AdditionalBelongingsTable    initialLuckMale;
    private final FamilyCharacteristicTemplate maleFamilyCharacteristic;
    private final String                       name;
    private final CultureCharacterTemplate     templateDefaultFemale;
    private final CultureCharacterTemplate     templateDefaultMale;

    public DefaultCultureTemplate(final String name,
            final CultureCharacterTemplate templateDefaultFemale,
            final CultureCharacterTemplate templateDefaultMale,
            final AdditionalBelongingsTable initialLuckFemale,
            final AdditionalBelongingsTable initialLuckMale,
            final FamilyCharacteristicTemplate femaleFamilyCharacteristic,
            final FamilyCharacteristicTemplate maleFamilyCharacteristic) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(templateDefaultFemale,
                "Received a null pointer as default female template");
        checkNotNull(templateDefaultMale,
                "Received a null pointer as default male template");
        checkNotNull(initialLuckFemale,
                "Received a null pointer as female initial luck");
        checkNotNull(initialLuckMale,
                "Received a null pointer as male initial luck");
        checkNotNull(femaleFamilyCharacteristic,
                "Received a null pointer as female family characteristic");
        checkNotNull(maleFamilyCharacteristic,
                "Received a null pointer as male family characteristic");

        this.name = name;

        this.templateDefaultFemale = templateDefaultFemale;
        this.templateDefaultMale = templateDefaultMale;

        this.initialLuckFemale = initialLuckFemale;
        this.initialLuckMale = initialLuckMale;

        this.femaleFamilyCharacteristic = femaleFamilyCharacteristic;
        this.maleFamilyCharacteristic = maleFamilyCharacteristic;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultCultureTemplate other = (DefaultCultureTemplate) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final FamilyCharacteristicTemplate getFemaleFamilyCharacteristic() {
        return femaleFamilyCharacteristic;
    }

    @Override
    public final AdditionalBelongingsTable getFemaleInitialLuckTable() {
        return initialLuckFemale;
    }

    @Override
    public final CultureCharacterTemplate getFemaleTemplate() {
        return templateDefaultFemale;
    }

    @Override
    public final FamilyCharacteristicTemplate getMaleFamilyCharacteristic() {
        return maleFamilyCharacteristic;
    }

    @Override
    public final AdditionalBelongingsTable getMaleInitialLuckTable() {
        return initialLuckMale;
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
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}