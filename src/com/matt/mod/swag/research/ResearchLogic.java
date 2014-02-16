package com.matt.mod.swag.research;

public class ResearchLogic {
	int requiredMana;
	EnumTier requiredTier;
	String[] aspect;
	public ResearchLogic(int mana, EnumTier newTier, String[] newAspect) {
		requiredMana = mana;
		requiredTier = newTier;
		aspect = newAspect;
	}
	public void processMana(ManaProcessor p) {
		for(String s : aspect) {
			p.process(s);
		}
	}
}
