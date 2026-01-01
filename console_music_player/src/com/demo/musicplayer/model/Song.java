package com.demo.musicplayer.model;

public class Song {				// DTO
	private int id;					// 1
	private String title;			// Madhuvarame
	private String artist;			// Sarath Santosh
	private String album;			// Dragon
	private int durationSeconds;	// 5.0
	private String genre;			// Telugu
	
	public Song(int id, String title, String artist, String album, int durationSeconds, String genre) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.durationSeconds = durationSeconds;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(int durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + ", durationSeconds="
				+ durationSeconds + ", genre=" + genre + "]";
	}
}