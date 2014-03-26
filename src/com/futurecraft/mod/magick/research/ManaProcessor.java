package com.futurecraft.mod.magick.research;

import java.util.HashMap;

public class ManaProcessor {
 public HashMap<String,Integer> manaMap = new HashMap<String,Integer>();
 public void process(String str) {
	 int mana = manaMap.get(str);
	 if(mana == 0) {
		 //Skip the current operation
		 
	 } else if(mana > 10) {
		 //You have base mana for research
	 } else if(mana > 100) {
		 //You have enough mana for infusion
	 } else if(mana >= 1000) {
		 //YOU'VE EXCEEDED THE MANA LIMIT!!
	 }
	 
 }
 
}
