package com.demo.musicplayer;

import com.demo.musicplayer.model.Playlist;
import com.demo.musicplayer.model.Song;
import com.demo.musicplayer.service.MusicPlayerService;

public class Test {
	public static void main(String[] args) {
		
		Playlist playlist = new Playlist(10);
		MusicPlayerService service = new MusicPlayerService(playlist);
		
		 service.addSong(new Song(1, "Believer", "Imagine Dragons", "Evolve", 210, "Rock"));
		 service.addSong(new Song(2, "Numb", "Linkin Park", "Meteora", 185, "Rock"));

		 System.out.println(service.play());
		 System.out.println(service.next());
		 System.out.println(service.previous());
	}
}
