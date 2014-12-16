package com.wandrell.tabletop.business.model.pendragon.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.business.model.character.Gender;
import com.wandrell.tabletop.business.model.interval.IntervalTable;

public final class DefaultCultureBonus implements CultureBonus {

    private final FamilyCharacteristicBonus           femaleFamilyCharacteristic;
    private final IntervalTable<AdditionalBelongings> initialLuckFemale;
    private final IntervalTable<AdditionalBelongings> initialLuckMale;
    private final FamilyCharacteristicBonus           maleFamilyCharacteristic;
    private final String                              name;
    private final CultureCharacterTemplate            templateDefaultFemale;
    private final CultureCharacterTemplate            templateDefaultMale;
    private final CultureCharacterTemplate            templateRandomFemale;
    private final CultureCharacterTemplate            templateRandomMale;

    public DefaultCultureBonus(final String name,
            final Map<String, Path> files,
            final CultureCharacterTemplate templateDefaultFemale,
            final CultureCharacterTemplate templateRandomFemale,
            final CultureCharacterTemplate templateDefaultMale,
            final CultureCharacterTemplate templateRandomMale,
            final IntervalTable<AdditionalBelongings> initialLuckFemale,
            final IntervalTable<AdditionalBelongings> initialLuckMale,
            final FamilyCharacteristicBonus femaleFamilyCharacteristic,
            final FamilyCharacteristicBonus maleFamilyCharacteristic) {
        super();

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(files, "Received a null pointer as files");
        checkNotNull(templateDefaultFemale,
                "Received a null pointer as default female template");
        checkNotNull(templateRandomFemale,
                "Received a null pointer as random female template");
        checkNotNull(templateDefaultMale,
                "Received a null pointer as default male template");
        checkNotNull(templateRandomMale,
                "Received a null pointer as random male template");
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
        this.templateRandomFemale = templateRandomFemale;
        this.templateRandomMale = templateRandomMale;

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
        DefaultCultureBonus other = (DefaultCultureBonus) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public final String getCulture() {
        return name;
    }

    @Override
    public final FamilyCharacteristicBonus getFamilyCharacteristic(
            final Gender gender) {
        final FamilyCharacteristicBonus result;

        checkNotNull(gender, "Received a null pointer as gender");

        switch (gender) {
            case MALE:
                result = getMaleFamilyCharacteristic();
                break;
            case FEMALE:
                result = getFemaleFamilyCharacteristic();
                break;
            default:
                result = null;
        }

        return result;
    }

    @Override
    public final IntervalTable<AdditionalBelongings> getInitialLuckTable(
            final Gender gender) {
        final IntervalTable<AdditionalBelongings> result;

        checkNotNull(gender, "Received a null pointer as gender");

        switch (gender) {
            case MALE:
                result = getMaleInitialLuck();
                break;
            case FEMALE:
                result = getFemaleInitialLuck();
                break;
            default:
                result = null;
        }

        return result;
    }

    @Override
    public final CultureCharacterTemplate
            getRandomTemplate(final Gender gender) {
        final CultureCharacterTemplate result;

        checkNotNull(gender, "Received a null pointer as gender");

        switch (gender) {
            case MALE:
                result = getMaleRandomTemplate();
                break;
            case FEMALE:
                result = getFemaleRandomTemplate();
                break;
            default:
                result = null;
        }

        return result;
    }

    @Override
    public final CultureCharacterTemplate getTemplate(final Gender gender) {
        final CultureCharacterTemplate result;

        checkNotNull(gender, "Received a null pointer as gender");

        switch (gender) {
            case MALE:
                result = getMaleTemplate();
                break;
            case FEMALE:
                result = getFemaleTemplate();
                break;
            default:
                result = null;
        }

        return result;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

    private final FamilyCharacteristicBonus getFemaleFamilyCharacteristic() {
        return femaleFamilyCharacteristic;
    }

    private final IntervalTable<AdditionalBelongings> getFemaleInitialLuck() {
        return initialLuckFemale;
    }

    private final CultureCharacterTemplate getFemaleRandomTemplate() {
        return templateRandomFemale;
    }

    private final CultureCharacterTemplate getFemaleTemplate() {
        return templateDefaultFemale;
    }

    private final FamilyCharacteristicBonus getMaleFamilyCharacteristic() {
        return maleFamilyCharacteristic;
    }

    private final IntervalTable<AdditionalBelongings> getMaleInitialLuck() {
        return initialLuckMale;
    }

    private final CultureCharacterTemplate getMaleRandomTemplate() {
        return templateRandomMale;
    }

    private final CultureCharacterTemplate getMaleTemplate() {
        return templateDefaultMale;
    }

}