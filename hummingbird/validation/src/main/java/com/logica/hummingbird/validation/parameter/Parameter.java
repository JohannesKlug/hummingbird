package com.logica.hummingbird.validation.parameter;

import java.util.ArrayList;
import java.util.List;

import com.logica.hummingbird.validation.TmParameterDummy;

public class Parameter {

	protected List<IParameterRule> rules = new ArrayList<IParameterRule>();

	/** The current value of this parameter. */
	protected TmParameterDummy value = null;

	public Parameter(double upperLimit, double lowerLimit) {
		rules.add(new LowerLimit(lowerLimit));
		rules.add(new UpperLimit(upperLimit));
	}
	
	public Parameter(double value) {
		this.value = new TmParameterDummy(value);
	}

	public void addRule(IParameterRule rule) {
		rules.add(rule);
	}

	public void check() {
		check(value);
	}
	
	public void check(TmParameterDummy value) {

		/** Remember the value. */
		this.value = value;

		/** Run through all rules.*/
		for (IParameterRule rule : rules) {						
			rule.check(value);
		}
	}

	public List<IParameterRule> getRules() {
		return rules;
	}

	public void setRules(List<IParameterRule> rules) {
		this.rules = rules;
	}

	public TmParameterDummy getValue() {
		return value;
	}

	public void setValue(TmParameterDummy value) {
		this.value = value;
	}	
}
