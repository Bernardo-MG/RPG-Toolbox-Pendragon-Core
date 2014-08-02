package com.wandrell.tabletop.pendragon.glory;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

import com.wandrell.tabletop.pendragon.valuehandler.DefaultTrait;
import com.wandrell.tabletop.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.valuehandler.ValueHandler;

public final class DefaultGloryKeeper implements GloryKeeper {

    @SuppressWarnings("unused")
    private static void assembleAnnualGlorySwitch(
	    final DelegateValueHandler<Integer> vhAnnualGlory,
	    final ValueHandler<Integer> vhSwitch, final int gloryValue) {
	// final DelegateValueHandler<Integer> vh;
	// final StoreModule<Integer> vc;
	// final StatusEventThrower set;

	// vh = vhAnnualGlory;
	// set = (StatusEventThrower) vhSwitch.getStore();
	// vc = new IntegerSwitchStore(vh, set, 0, gloryValue);
	// vh.setStore(vc);
    }

    private final Map<String, ValueHandler<Integer>> annualSources = new LinkedHashMap<>();
    private final Queue<GloryEvent> history = new PriorityQueue<>();

    public DefaultGloryKeeper() {
	super();

	// final IntegerSecondaryValuesValueHandler<ValueHandler<Integer>>
	// vhYearGlory = new
	// IntegerSecondaryValuesValueHandler<ValueHandler<Integer>>(
	// NameLabels.GLORY_YEAR);

	// Initializes the annual glory ValueHandlers
	// ValueHandler<Integer> vh;
	// vh = new IntegerSecondaryValuesValueHandler<ValueHandler<Integer>>(
	// NameLabels.GLORY_PASSIONS);

	// Initializes the passions glory ValueHandler
	// ((ModularValueHandler<Integer>) vh)
	// .setStore(new TraitsGloryMarginStore(
	// (ModularValueHandler<Integer>) vh,
	// Integer.parseInt(ConfigurationFactory
	// .getConstant(ConfigurationLabels.PASSION_GLORY_TRESHOLD))));

	// getAnnualGlorySourcesStore().addInterval(vh);
	// getAnnualGlorySourcesStore().addInterval(
	// new IntegerValueHandler(NameLabels.GLORY_RELIGIOUS));
	// getAnnualGlorySourcesStore().addInterval(
	// new IntegerSecondaryValuesValueHandler<ValueHandler<Integer>>(
	// NameLabels.GLORY_TRAITS));

	// Adds all the glory sources to the annual glory
	// Iterator<ValueHandler<Integer>> itr = getAnnualGlorySourcesStore()
	// .getIterator();
	// while (itr.hasNext()) {
	// vhYearGlory.addValueHandler(itr.next());
	// /}

	// getAnnualGlorySourcesStore().addInterval(
	// new IntegerSecondaryValuesValueHandler<ValueHandler<Integer>>(
	// NameLabels.GLORY_YEAR));
    }

    public DefaultGloryKeeper(final DefaultGloryKeeper glory) {
	super();

	for (final Entry<String, ValueHandler<Integer>> entry : glory.annualSources
		.entrySet()) {
	    annualSources.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	for (final GloryEvent data : glory.history) {
	    history.add(data.createNewInstance());
	}
    }

    public final void addGlory(final DefaultGloryEvent event) {
	if (event == null) {
	    throw new NullPointerException();
	}

	_getHistory().add(event);
    }

    @Override
    public final DefaultGloryKeeper createNewInstance() {
	return new DefaultGloryKeeper(this);
    }

    @Override
    public final ValueHandler<Integer> getAnnualGlorySource(final String name) {
	return _getAnnualGlorySources().get(name);
    }

    @Override
    public final Collection<ValueHandler<Integer>> getAnnualGlorySources() {
	return Collections.unmodifiableCollection(_getAnnualGlorySources()
		.values());
    }

    @Override
    public final Collection<GloryEvent> getHistory() {
	return Collections.unmodifiableCollection(_getHistory());
    }

    @Override
    public final Boolean hasAnnualGlorySource(final String name) {
	return _getAnnualGlorySources().containsKey(name);
    }

    public final void setChivaldryAnnualGlorySwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// setChivaldryOrGentlewomanAnnualGlorySwitch(vhSwitch,
	// NameLabels.GLORY_CHIVALDRY,
	// ConfigurationLabels.GLORY_ANNUAL_CHIVALDRY);
    }

    public final void setGentlewomanAnnualGlorySwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// setChivaldryOrGentlewomanAnnualGlorySwitch(vhSwitch,
	// NameLabels.GLORY_GENTLEWOMAN,
	// ConfigurationLabels.GLORY_ANNUAL_GENTLEWOMAN);
    }

    public final void setGlory(final Iterator<DefaultGloryEvent> iteratorGlory) {
	_getHistory().clear();
	while (iteratorGlory.hasNext()) {
	    addGlory(iteratorGlory.next());
	}
    }

    public final void setReligiousAnnualGlorySwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// assembleAnnualGlorySwitch(
	// getAnnualGlorySource(NameLabels.GLORY_RELIGIOUS),
	// vhSwitch,
	// Integer.parseInt(ConfigurationFactory
	// .getConstant(ConfigurationLabels.GLORY_ANNUAL_RELIGIOUS)));
    }

    public final void setTraitsAnnualGlorySwitch(
	    final Iterator<DefaultTrait> itrTraits) {
	// final List<ValueHandler<Integer>> traitsList = new
	// ArrayList<ValueHandler<Integer>>();
	// final ValueHandler<Integer> vh;
	// final int gloryValue;
	// DefaultPendragonTrait vhm;
	//
	// Creates a list with all the traits, good and bad
	// while (itrTraits.hasNext()) {
	// vhm = itrTraits.next();
	// traitsList.add(vhm);
	// traitsList.add(vhm.getMirrorTrait());
	// }
	//
	// Initializes the traits glory ValueHandler
	// All the traits equal or above the threshold are added to this glory
	// value
	// vh = getAnnualGlorySource(NameLabels.GLORY_TRAITS);
	// gloryValue = Integer.parseInt(ConfigurationFactory
	// .getConstant(ConfigurationLabels.TRAIT_GLORY_TRESHOLD));
	// ((ModularValueHandler<Integer>) vh)
	// .setStore(new TraitsGloryMarginStore(
	// (ModularValueHandler<Integer>) vh, traitsList
	// .iterator(), gloryValue));

    }

    @SuppressWarnings("unused")
    private final void setChivaldryOrGentlewomanAnnualGlorySwitch(
	    final DelegateValueHandler<Integer> vhSwitch,
	    final String sourceName, final String gloryValueName) {
	// final ValueHandler<Integer> vhGlory;
	// if (!hasAnnualGlorySource(sourceName)) {
	// vhGlory = new IntegerValueHandler(sourceName);
	// getAnnualGlorySourcesStore().addInterval(vhGlory);
	// ((ValueHandlersContainer<Integer, ValueHandler<Integer>>)
	// getAnnualGlorySource(NameLabels.GLORY_YEAR))
	// .addValueHandler(getAnnualGlorySource(sourceName));
	// }
	// assembleAnnualGlorySwitch(getAnnualGlorySource(sourceName), vhSwitch,
	// Integer.parseInt(ConfigurationFactory
	// .getConstant(gloryValueName)));
    }

    protected final Map<String, ValueHandler<Integer>> _getAnnualGlorySources() {
	return annualSources;
    }

    protected final Queue<GloryEvent> _getHistory() {
	return history;
    }

}
