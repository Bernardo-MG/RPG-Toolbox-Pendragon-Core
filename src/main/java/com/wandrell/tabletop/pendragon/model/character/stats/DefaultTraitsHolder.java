package com.wandrell.tabletop.pendragon.model.character.stats;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Objects;
import java.util.Vector;

import javax.swing.event.EventListenerList;

import com.wandrell.tabletop.pendragon.model.character.stats.event.TraitsListener;
import com.wandrell.tabletop.stats.event.ValueChangeEvent;
import com.wandrell.tabletop.stats.event.ValueChangeListener;
import com.wandrell.tabletop.stats.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

public final class DefaultTraitsHolder implements TraitsHolder {

    private final ValueBox          arbitrary;
    private final ValueBox          chaste;
    private final ValueBox          cowardly;
    private final ValueBox          cruel;
    private final ValueBox          deceitful;
    private final ValueBox          energetic;
    private final ValueBox          forgiving;
    private final ValueBox          generous;
    private final ValueBox          honest;
    private final ValueBox          indulgent;
    private final ValueBox          just;
    private final ValueBox          lazy;
    private final EventListenerList listeners = new EventListenerList();
    private final ValueBox          lustful;
    private final ValueBox          merciful;
    private final ValueBox          modest;
    private final ValueBox          pious;
    private final ValueBox          proud;
    private final ValueBox          prudent;
    private final ValueBox          reckless;
    private final ValueBox          selfish;
    private final ValueBox          suspicious;
    private final ValueBox          temperate;
    private final ValueBox          trusting;
    private final ValueBox          valorous;
    private final ValueBox          vengeful;
    private final ValueBox          worldly;

    public DefaultTraitsHolder() {
        super();

        // TODO: Add the equals method

        chaste = new DefaultValueBox(20);
        energetic = new DefaultValueBox(20);
        forgiving = new DefaultValueBox(20);
        generous = new DefaultValueBox(20);
        honest = new DefaultValueBox(20);
        just = new DefaultValueBox(20);
        merciful = new DefaultValueBox(20);
        modest = new DefaultValueBox(20);
        pious = new DefaultValueBox(20);
        prudent = new DefaultValueBox(20);
        temperate = new DefaultValueBox(20);
        trusting = new DefaultValueBox(20);
        valorous = new DefaultValueBox(20);

        arbitrary = new DefaultValueBox(0);
        cowardly = new DefaultValueBox(0);
        cruel = new DefaultValueBox(0);
        deceitful = new DefaultValueBox(0);
        indulgent = new DefaultValueBox(0);
        lazy = new DefaultValueBox(0);
        lustful = new DefaultValueBox(0);
        proud = new DefaultValueBox(0);
        reckless = new DefaultValueBox(0);
        selfish = new DefaultValueBox(0);
        suspicious = new DefaultValueBox(0);
        vengeful = new DefaultValueBox(0);
        worldly = new DefaultValueBox(0);

        linkTraits();
        setTraitsListeners();
    }

    public DefaultTraitsHolder(final DefaultTraitsHolder holder) {
        super();

        checkNotNull(holder, "Received a null pointer as traits holder");

        chaste = new DefaultValueBox(holder.chaste.getValue());
        energetic = new DefaultValueBox(holder.energetic.getValue());
        forgiving = new DefaultValueBox(holder.forgiving.getValue());
        generous = new DefaultValueBox(holder.generous.getValue());
        honest = new DefaultValueBox(holder.honest.getValue());
        just = new DefaultValueBox(holder.just.getValue());
        merciful = new DefaultValueBox(holder.merciful.getValue());
        modest = new DefaultValueBox(holder.modest.getValue());
        pious = new DefaultValueBox(holder.pious.getValue());
        prudent = new DefaultValueBox(holder.prudent.getValue());
        temperate = new DefaultValueBox(holder.temperate.getValue());
        trusting = new DefaultValueBox(holder.trusting.getValue());
        valorous = new DefaultValueBox(holder.valorous.getValue());

        arbitrary = new DefaultValueBox(holder.arbitrary.getValue());
        cowardly = new DefaultValueBox(holder.cowardly.getValue());
        cruel = new DefaultValueBox(holder.cruel.getValue());
        deceitful = new DefaultValueBox(holder.deceitful.getValue());
        indulgent = new DefaultValueBox(holder.indulgent.getValue());
        lazy = new DefaultValueBox(holder.lazy.getValue());
        lustful = new DefaultValueBox(holder.lustful.getValue());
        proud = new DefaultValueBox(holder.proud.getValue());
        reckless = new DefaultValueBox(holder.reckless.getValue());
        selfish = new DefaultValueBox(holder.selfish.getValue());
        suspicious = new DefaultValueBox(holder.suspicious.getValue());
        vengeful = new DefaultValueBox(holder.vengeful.getValue());
        worldly = new DefaultValueBox(holder.worldly.getValue());

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
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultTraitsHolder other = (DefaultTraitsHolder) obj;
        return Objects.equals(chaste, other.chaste)
                && Objects.equals(energetic, other.energetic)
                && Objects.equals(forgiving, other.forgiving)
                && Objects.equals(generous, other.generous)
                && Objects.equals(honest, other.honest)
                && Objects.equals(just, other.just)
                && Objects.equals(merciful, other.merciful)
                && Objects.equals(modest, other.modest)
                && Objects.equals(pious, other.pious)
                && Objects.equals(prudent, other.prudent)
                && Objects.equals(temperate, other.temperate)
                && Objects.equals(trusting, other.trusting)
                && Objects.equals(valorous, other.valorous);
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

    @Override
    public final void setVengeful(final Integer vengeful) {
        this.vengeful.setValue(vengeful);
    }

    @Override
    public final void setWorldly(final Integer wordlly) {
        this.worldly.setValue(wordlly);
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

    private final void linkTraits(final ValueBox trait1, final ValueBox trait2) {
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
