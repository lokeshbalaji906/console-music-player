package com.demo.musicplayer.model;

public class Playlist {		// DAO
	private Song[] songs;		// Instance Variables 
	private int size;			// Instance Variables
	
	public Playlist(int capacity) {		// Parameterized Constructor
		songs = new Song[capacity];
		size = 0;
	}
	
	public boolean addSong(Song song) {
		if(size >= songs.length) {
			return false;
		}
		songs[size++] = song;
		System.out.println(size);
		return true;
	}
	
	public boolean removeSongById(int songId) {
		for(int i=0; i<size; i++) {
			if(songs[i].getId() == songId) {
				for(int j=i; j<size-1; j++) {
					songs[j] = songs[j+1];
				}
				songs[--size] = null;	// Element duplicated. We are making null.
				return true;
			}
		}
		return false;
	}
	
	public Song[] getAllSongs() {
		Song[] result = new Song[size];		// Empty Array
		for(int i=0; i<size; i++) {
			result[i] = songs[i];
		}
		return result;
	}
}