package com.demo.musicplayer.exception;

import com.demo.musicplayer.model.Song;

public class SongNotFoundException extends RuntimeException{
	
	public SongNotFoundException(String message) {
		super(message);
	}
}
