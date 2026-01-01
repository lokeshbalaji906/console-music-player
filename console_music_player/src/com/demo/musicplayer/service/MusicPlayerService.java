package com.demo.musicplayer.service;
import com.demo.musicplayer.model.Playlist;
import com.demo.musicplayer.model.Song;
import com.demo.musicplayer.exception.SongNotFoundException;

public class MusicPlayerService {
    // @Autowired	
	private Playlist playlist;		
	private int currentIndex = -1;	// // To track the currently playing song without UI dependency.
	
	// @Autowired
	public MusicPlayerService(Playlist playlist) {
		this.playlist = playlist;
	}
	
	// Add song to playList
	public boolean addSong(Song song) {
		return playlist.addSong(song);
	}
	
	// Play first song
	public Song play() {
		Song[] songs = playlist.getAllSongs();
		if(songs.length == 0) {
//			return null;
			throw new SongNotFoundException("No songs available to play");
		}
		currentIndex = 0;
		return songs[currentIndex];
	}
	
	// Play next song
	public Song next() {
		Song[] songs = playlist.getAllSongs();
		if(songs.length == 0 || currentIndex >= songs.length - 1) { 
//			return null;
			throw new SongNotFoundException("No songs available to play");
		}
		currentIndex++;
		return songs[currentIndex];
	}
	
	// Play previous song
	public Song previous() {
		Song[] songs = playlist.getAllSongs();
		if(currentIndex<=0) {
//			return null;
			throw new SongNotFoundException("No songs available to play");
		}
		currentIndex--;
		return songs[currentIndex];
	}
	
	// Search song by title
	public Song searchByTitle(String title) {
		Song[] songs = playlist.getAllSongs();
		for(Song song : songs) {
			if(song.getTitle().equalsIgnoreCase(title)) {
				return song;
			}
		}
//		return null;
		throw new SongNotFoundException("No songs available to play");
	}
	
	// Remove song
	public boolean removeSong(int songId) {
		return playlist.removeSongById(songId);
	}
}