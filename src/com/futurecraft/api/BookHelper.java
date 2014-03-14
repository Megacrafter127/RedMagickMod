package com.futurecraft.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class BookHelper {
	
	public static final BookHelper instance = new BookHelper();
	/**
	 * Creates a book itemstack from a nbt tag list
	 * @param l the nbt tag list
	 * @param author the author of the book
	 * @param title the title of the book
	 * @return the bookstack
	 */
	public ItemStack createBookFromNBT(NBTTagList l,String author, String title) {
		ItemStack tomeStack = new ItemStack(Item.writableBook);
		 tomeStack.setTagInfo("pages", l);
		 tomeStack.setTagInfo("author", new NBTTagString("author", author));
		 tomeStack.setTagInfo("title", new NBTTagString("title", title));
		 tomeStack.itemID = Item.writtenBook.itemID;
		 
		 return tomeStack;
	}
	/**
	 * Creates a bookstack from a string[]
	 * @param pages the pages
	 * @param author the author
	 * @param title the title
	 * @return the bookstack
	 */
	public ItemStack createBookFromString(String[] pages, String author, String title) {
		ItemStack tomeStack = new ItemStack(Item.writableBook);
		NBTTagList bookPages = new NBTTagList("pages");
			for(int i = 0; i <= pages.length-1; i++) {
				bookPages.appendTag(new NBTTagString(Integer.toString(i),pages[i]));
			}
			tomeStack.setTagInfo("pages", bookPages);
			 tomeStack.setTagInfo("author", new NBTTagString("author", author));
			 tomeStack.setTagInfo("title", new NBTTagString("title", title));
			 tomeStack.itemID = Item.writtenBook.itemID;
			return tomeStack;
	}
}
