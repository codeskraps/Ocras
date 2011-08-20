package com.codeskraps.ocras;


public class ListItem {

	private String mText;

	public ListItem(String text) {
		setText(text);
	}

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		mText = text;
	}
}