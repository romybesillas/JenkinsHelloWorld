package com.besillas.java.linkedlist;

import java.util.LinkedList;

public class Album {

	private LinkedList<Song> songs = new LinkedList <Song>();
	private String name = "";
		
	public Album (String name) {
		this.name = name;
		this.songs = new LinkedList<Song>();
	}
	public Boolean addSong(String title, double duration) {
		if (findSong(title)==null) {
			Song newSong = new Song(title, duration);
			songs.add(newSong);
			System.out.println("Added song " + title + " to album " + this.getName());
			return true;
		}
		System.out.println("Song " + title + " already existing in album " + this.getName());
		return false;
	}
	
	public LinkedList<Song> getSongs() {
		return songs;
	}

	public void setSongs(LinkedList<Song> songs) {
		this.songs = songs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Song findSong(String title) {
		for (Song theSong: this.getSongs()) {
			if(theSong.getName().equalsIgnoreCase(title)) {
				return theSong;
			}
		}
		
		return null;
	}
	

	public boolean addPlaylist(String title, LinkedList <Song> playlist) {
		Song newSong = findSong(title);
		if (newSong!=null) {
			playlist.add(newSong);
			System.out.println("Added to the playlist the song " + newSong.getName() + " of " + this.getName());
			return true;
		}
		System.out.println("Song " + title + " not existing in album " + this.getName());
		return false;		
	}
	
}
