package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Vector;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.event.ValueChangeListener;
import com.wandrell.tabletop.pendragon.model.character.stats.event.TraitsListener;
import com.wandrell.tabletop.valuebox.DefaultEditableValueBox;
import com.wandrell.tabletop.valuebox.EditableValueBox;

public final class DefaultTraitsHolder implements TraitsHolder {

    private final EditableValueBox  arbitrary;
    private final EditableValueBox  chaste;
    private final EditableValueBox  cowardly;
    private final EditableValueBox  cruel;
    private final EditableValueBox  deceitful;
    private final EditableValueBox  energetic;
    private final EditableValueBox  forgiving;
    private final EditableValueBox  generous;
    private final EditableValueBox  honest;
    private final EditableValueBox  indulgent;
    private final EditableValueBox  just;
    private final EditableValueBox  lazy;
    private final EventListenerList listeners = new EventListenerList();
    private final EditableValueBox  lustful;
    private final EditableValueBox  merciful;
    private final EditableValueBox  modest;
    private final EditableValueBox  pious;
    private final EditableValueBox  proud;
    private final EditableValueBox  prudent;
    private final EditableValueBox  reckless;
    private final EditableValueBox  selfish;
    private final EditableValueBox  suspicious;
    private final EditableValueBox  temperate;
    private final EditableValueBox  trusting;
    private final EditableValueBox  valorous;
    private final EditableValueBox  vengeful;
    private final EditableValueBox  worldly;

    public DefaultTraitsHolder() {
        super();

        // TODO: Maybe the max value should be configurable
        chaste = new DefaultEditableValueBox(20);
        energetic = new DefaultEditableValueBox(20);
        forgiving = new DefaultEditableValueBox(20);
        generous = new DefaultEditableValueBox(20);
        honest = new DefaultEditableValueBox(20);
        just = new DefaultEditableValueBox(20);
        merciful = new DefaultEditableValueBox(20);
        modest = new DefaultEditableValueBox(20);
        pious = new DefaultEditableValueBox(20);
        prudent = new DefaultEditableValueBox(20);
        temperate = new DefaultEditableValueBox(20);
        trusting = new DefaultEditableValueBox(20);
        valorous = new DefaultEditableValueBox(20);

        arbitrary = new DefaultEditableValueBox(0);
        cowardly = new DefaultEditableValueBox(0);
        cruel = new DefaultEditableValueBox(0);
        deceitful = new DefaultEditableValueBox(0);
        indulgent = new DefaultEditableValueBox(0);
        lazy = new DefaultEditableValueBox(0);
        lustful = new DefaultEditableValueBox(0);
        proud = new DefaultEditableValueBox(0);
        reckless = new DefaultEditableValueBox(0);
        selfish = new DefaultEditableValueBox(0);
        suspicious = new DefaultEditableValueBox(0);
        vengeful = new DefaultEditableValueBox(0);
        worldly = new DefaultEditableValueBox(0);

        linkTraits();
        setTraitsListeners();
    }

    public DefaultTraitsHolder(final DefaultTraitsHolder holder) {
        super();

        checkNotNull(holder, "Received a null pointer as traits holder");

        chaste = holder.chaste.createNewInstance();
        energetic = holder.energetic.createNewInstance();
        forgiving = holder.forgiving.createNewInstance();
        generous = holder.generous.createNewInstance();
        honest = holder.honest.createNewInstance();
        just = holder.just.createNewInstance();
        merciful = holder.merciful.createNewInstance();
        modest = holder.modest.createNewInstance();
        pious = holder.pious.createNewInstance();
        prudent = holder.prudent.createNewInstance();
        temperate = holder.temperate.createNewInstance();
        trusting = holder.trusting.createNewInstance();
        valorous = holder.valorous.createNewInstance();

        arbitrary = holder.arbitrary.createNewInstance();
        cowardly = holder.cowardly.createNewInstance();
        cruel = holder.cruel.createNewInstance();
        deceitful = holder.deceitful.createNewInstance();
        indulgent = holder.indulgent.createNewInstance();
        lazy = holder.lazy.createNewInstance();
        lustful = holder.lustful.createNewInstance();
        proud = holder.proud.createNewInstance();
        reckless = holder.reckless.createNewInstance();
        selfish = holder.selfish.createNewInstance();
        suspicious = holder.suspicious.createNewInstance();
        vengeful = holder.vengeful.createNewInstance();
        worldly = holder.worldly.createNewInstance();

        linkTraits();
        setTraitsListeners();
    }

    @Override
    public final void addTraitsListener(final TraitsListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(TraitsListener.class, listener);
    }

    @Override
    public final DefaultTraitsHolder createNewInstance() {
        return new DefaultTraitsHolder(this);
    }

    @Override
    public final Integer getArbitrary() {
        return arbitrary.getValue();
    }

    @Override
    public final Integer getChaste() {
        return chaste.getValue();
    }

    @Override
    public final Integer getCowardly() {
        return cowardly.getValue();
    }

    @Override
    public final Integer getCruel() {
        return cruel.getValue();
    }

    @Override
    public final Integer getDeceitful() {
        return deceitful.getValue();
    }

    @Override
    public final Integer getEnergetic() {
        return energetic.getValue();
    }

    @Override
    public final Integer getForgiving() {
        return forgiving.getValue();
    }

    @Override
    public final Integer getGenerous() {
        return generous.getValue();
    }

    @Override
    public final Integer getHonest() {
        return honest.getValue();
    }

    @Override
    public final Integer getIndulgent() {
        return indulgent.getValue();
    }

    @Override
    public final Integer getJust() {
        return just.getValue();
    }

    @Override
    public final Integer getLazy() {
        return lazy.getValue();
    }

    @Override
    public final Integer getLustful() {
        return lustful.getValue();
    }

    @Override
    public final Integer getMerciful() {
        return merciful.getValue();
    }

    @Override
    public final Integer getModest() {
        return modest.getValue();
    }

    @Override
    public final Integer getPious() {
        return pious.getValue();
    }

    @Override
    public final Integer getProud() {
        return proud.getValue();
    }

    @Override
    public final Integer getPrudent() {
        return prudent.getValue();
    }

    @Override
    public final Integer getReckless() {
        return reckless.getValue();
    }

    @Override
    public final Integer getSelfish() {
        return selfish.getValue();
    }

    @Override
    public final Integer getSuspicious() {
        return suspicious.getValue();
    }

    @Override
    public final Integer getTemperate() {
        return temperate.getValue();
    }

    @Override
    public final Integer getTrusting() {
        return trusting.getValue();
    }

    @Override
    public final Integer getValorous() {
        return valorous.getValue();
    }

    @Override
    public final Integer getVengeful() {
        return vengeful.getValue();
    }

    @Override
    public final Integer getWorldly() {
        return worldly.getValue();
    }

    @Override
    public final void removeTraitsListener(final TraitsListener listener) {
        getListeners().remove(TraitsListener.class, listener);
    }

    @Override
    public final void setArbitrary(final Integer arbitrary) {
        this.arbitrary.setValue(arbitrary);
    }

    @Override
    public final void setChaste(final Integer chaste) {
        this.chaste.setValue(chaste);
    }

    @Override
    public final void setCowardly(final Integer cowardly) {
        this.cowardly.setValue(cowardly);
    }

    @Override
    public final void setCruel(final Integer cruel) {
        this.cruel.setValue(cruel);
    }

    @Override
    public final void setDeceitful(final Integer deceitful) {
        this.deceitful.setValue(deceitful);
    }

    @Override
    public final void setEnergetic(final Integer energetic) {
        this.energetic.setValue(energetic);
    }

    @Override
    public final void setForgiving(final Integer forgiving) {
        this.forgiving.setValue(forgiving);
    }

    @Override
    public final void setGenerous(final Integer generous) {
        this.generous.setValue(generous);
    }

    @Override
    public final void setHonest(final Integer honest) {
        this.honest.setValue(honest);
    }

    @Override
    public final void setIndulgent(final Integer indulgent) {
        this.indulgent.setValue(indulgent);
    }

    @Override
    public final void setJust(final Integer just) {
        this.just.setValue(just);
    }

    @Override
    public final void setLazy(final Integer lazy) {
        this.lazy.setValue(lazy);
    }

    @Override
    public final void setLustful(final Integer lustful) {
        this.lustful.setValue(lustful);
    }

    @Override
    public final void setMerciful(final Integer merciful) {
        this.merciful.setValue(merciful);
    }

    @Override
    public final void setModest(final Integer modest) {
        this.modest.setValue(modest);
    }

    @Override
    public final void setPious(final Integer pious) {
        this.pious.setValue(pious);
    }

    @Override
    public final void setProud(final Integer proud) {
        this.proud.setValue(proud);
    }

    @Override
    public final void setPrudent(final Integer prudent) {
        this.prudent.setValue(prudent);
    }

    @Override
    public final void setReckless(final Integer reckless) {
        this.reckless.setValue(reckless);
    }

    @Override
    public final void setSelfish(final Integer selfish) {
        this.selfish.setValue(selfish);
    }

    @Override
    public final void setSuspicious(final Integer suspicious) {
        this.suspicious.setValue(suspicious);
    }

    @Override
    public final void setTemperate(final Integer temperate) {
        this.temperate.setValue(temperate);
    }

    public final void setTraitsListeners() {
        final ValueChangeListener listener;

        listener = new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                fireTraitChangedEvent(new ValueChangeEvent(this,
                        event.getOldValue(), event.getNewValue()));
            }

        };

        chaste.addValueChangeListener(listener);
        energetic.addValueChangeListener(listener);
        forgiving.addValueChangeListener(listener);
        generous.addValueChangeListener(listener);
        honest.addValueChangeListener(listener);
        just.addValueChangeListener(listener);
        merciful.addValueChangeListener(listener);
        modest.addValueChangeListener(listener);
        pious.addValueChangeListener(listener);
        prudent.addValueChangeListener(listener);
        temperate.addValueChangeListener(listener);
        trusting.addValueChangeListener(listener);
        valorous.addValueChangeListener(listener);

        arbitrary.addValueChangeListener(listener);
        cowardly.addValueChangeListener(listener);
        cruel.addValueChangeListener(listener);
        deceitful.addValueChangeListener(listener);
        indulgent.addValueChangeListener(listener);
        lazy.addValueChangeListener(listener);
        lustful.addValueChangeListener(listener);
        proud.addValueChangeListener(listener);
        reckless.addValueChangeListener(listener);
        selfish.addValueChangeListener(listener);
        suspicious.addValueChangeListener(listener);
        vengeful.addValueChangeListener(listener);
        worldly.addValueChangeListener(listener);
    }

    @Override
    public final void setTrusting(final Integer trusting) {
        this.trusting.setValue(trusting);
    }

    @Override
    public final void setValorous(final Integer valorous) {
        this.valorous.setValue(valorous);
    }

    private final void fireTraitChangedEvent(final ValueChangeEvent event) {
        final TraitsListener[] listnrs;

        checkNotNull(event, "Received a null pointer as event");

        listnrs = getListeners().getListeners(TraitsListener.class);
        for (final TraitsListener l : listnrs) {
            l.traitChanged(event);
        }
    }

    private final EventListenerList getListeners() {
        return listeners;
    }

    private final Integer getMirrorValue(final Integer value) {
        final Integer mirror;

        if (value >= 20) {
            mirror = 0;
        } else {
            mirror = 20 - value;
        }

        return mirror;
    }

    private final void linkTraits() {
        linkTraits(chaste, lustful);
        linkTraits(energetic, indulgent);
        linkTraits(forgiving, vengeful);
        linkTraits(generous, selfish);
        linkTraits(honest, deceitful);
        linkTraits(just, arbitrary);
        linkTraits(merciful, cruel);
        linkTraits(modest, proud);
        linkTraits(pious, worldly);
        linkTraits(prudent, reckless);
        linkTraits(temperate, indulgent);
        linkTraits(trusting, suspicious);
        linkTraits(valorous, cowardly);
    }

    private final void linkTraits(final EditableValueBox trait1,
            final EditableValueBox trait2) {
        final Collection<Object> flagBag;

        flagBag = new Vector<>();
        trait1.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                if (flagBag.isEmpty()) {
                    flagBag.add(true);
                    trait2.setValue(getMirrorValue(event.getNewValue()));
                    flagBag.clear();
                }
            }

        });

        trait2.addValueChangeListener(new ValueChangeListener() {

            @Override
            public final void valueChanged(final ValueChangeEvent event) {
                if (flagBag.isEmpty()) {
                    flagBag.add(true);
                    trait1.setValue(getMirrorValue(event.getNewValue()));
                    flagBag.clear();
                }
            }

        });
    }

}
