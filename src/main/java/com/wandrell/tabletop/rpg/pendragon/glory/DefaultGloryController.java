package com.wandrell.tabletop.rpg.pendragon.glory;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

import com.wandrell.tabletop.rpg.pendragon.valuehandler.DefaultPendragonTrait;
import com.wandrell.tabletop.rpg.valuehandler.DelegateValueHandler;
import com.wandrell.tabletop.rpg.valuehandler.ValueHandler;

public class DefaultGloryController implements GloryController {

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

    private final Queue<GloryEvent> queueGloryHistory = new PriorityQueue<>();
    private final Map<String, ValueHandler<Integer>> storeAnnualGlorySources = new LinkedHashMap<>();

    public DefaultGloryController() {
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

    public DefaultGloryController(final DefaultGloryController glory) {
	super();

	for (final Entry<String, ValueHandler<Integer>> entry : glory.storeAnnualGlorySources
		.entrySet()) {
	    storeAnnualGlorySources.put(entry.getKey(), entry.getValue()
		    .createNewInstance());
	}

	for (final GloryEvent data : glory.queueGloryHistory) {
	    queueGloryHistory.add(data.createNewInstance());
	}
    }

    public void addGlory(final DefaultGloryEvent event) {
	getGloryHistoryQueue().add(event);
    }

    @Override
    public DefaultGloryController createNewInstance() {
	return new DefaultGloryController(this);
    }

    @Override
    public ValueHandler<Integer> getAnnualGlorySource(final String name) {
	return getAnnualGlorySourcesStore().get(name);
    }

    @Override
    public Collection<ValueHandler<Integer>> getAnnualGlorySources() {
	return Collections.unmodifiableCollection(getAnnualGlorySourcesStore()
		.values());
    }

    @Override
    public Collection<GloryEvent> getGloryEvents() {
	return Collections.unmodifiableCollection(getGloryHistoryQueue());
    }

    @Override
    public Boolean hasAnnualGlorySource(final String name) {
	return getAnnualGlorySourcesStore().containsKey(name);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((storeAnnualGlorySources == null) ? 0
			: storeAnnualGlorySources.hashCode());
	result = prime
		* result
		+ ((queueGloryHistory == null) ? 0 : queueGloryHistory
			.hashCode());
	return result;
    }

    public void setChivaldryAnnualGlorySwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// setChivaldryOrGentlewomanAnnualGlorySwitch(vhSwitch,
	// NameLabels.GLORY_CHIVALDRY,
	// ConfigurationLabels.GLORY_ANNUAL_CHIVALDRY);
    }

    public void setGentlewomanAnnualGlorySwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// setChivaldryOrGentlewomanAnnualGlorySwitch(vhSwitch,
	// NameLabels.GLORY_GENTLEWOMAN,
	// ConfigurationLabels.GLORY_ANNUAL_GENTLEWOMAN);
    }

    public void setGlory(final Iterator<DefaultGloryEvent> iteratorGlory) {
	getGloryHistoryQueue().clear();
	while (iteratorGlory.hasNext()) {
	    addGlory(iteratorGlory.next());
	}
    }

    public void setReligiousAnnualGlorySwitch(
	    final ValueHandler<Integer> vhSwitch) {
	// assembleAnnualGlorySwitch(
	// getAnnualGlorySource(NameLabels.GLORY_RELIGIOUS),
	// vhSwitch,
	// Integer.parseInt(ConfigurationFactory
	// .getConstant(ConfigurationLabels.GLORY_ANNUAL_RELIGIOUS)));
    }

    public void setTraitsAnnualGlorySwitch(
	    final Iterator<DefaultPendragonTrait> itrTraits) {
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

    private Map<String, ValueHandler<Integer>> getAnnualGlorySourcesStore() {
	return storeAnnualGlorySources;
    }

    private Queue<GloryEvent> getGloryHistoryQueue() {
	return queueGloryHistory;
    }

    private void setChivaldryOrGentlewomanAnnualGlorySwitch(
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

}
