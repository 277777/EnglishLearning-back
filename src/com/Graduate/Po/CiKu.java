package com.Graduate.Po;

public class CiKu {
	
	private int wordid;
	private String word;
	private int list;
	public CiKu() {
		super();
	}
	public CiKu(int wordid, String word, int list) {
		super();
		this.wordid = wordid;
		this.word = word;
		this.list = list;
	}
	public int getWordid() {
		return wordid;
	}
	public void setWordid(int wordid) {
		this.wordid = wordid;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getList() {
		return list;
	}
	public void setList(int list) {
		this.list = list;
	}
	
}
