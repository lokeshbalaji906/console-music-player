package com.demo.musicplayer.ui;

import java.lang.StackWalker.Option;
import java.util.Scanner;

import com.demo.musicplayer.model.Playlist;
import com.demo.musicplayer.model.Song;
import com.demo.musicplayer.service.MusicPlayerService;

public class MusicPlayerApp {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Playlist playlist = new Playlist(10);
		MusicPlayerService service = new MusicPlayerService(playlist);
		
		boolean running = true;
		
		while(running) {
			printMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
            case 1:
                addSong(service);
                break;
            case 2:
                playSong(service);
                break;
            case 3:
                playNext(service);
                break;
            case 4:
                playPrevious(service);
                break;
            case 5:
                searchSong(service);
                break;
            case 6:
                removeSong(service);
                break;
            case 0:
            	running = false;
            	System.out.println("Exiting Music Player...");
            	break;
            default:
            	System.out.println("Invalid Option. Try again");
			}
		}
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("\n === Console Music Player ===");
		System.out.println("1. Add Song");
		System.out.println("2. Play");
		System.out.println("3. Next Song");
		System.out.println("4. Previous Song");
		System.out.println("5. Search Song by Title");
		System.out.println("6. Remove Song");
		System.out.println("0. Exit");
		System.out.println("Enter choice: ");
	}
	
	private static void addSong(MusicPlayerService service) {
        System.out.print("Enter Song ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Enter Album: ");
        String album = scanner.nextLine();

        System.out.print("Enter Duration (seconds): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        
        Song song = new Song(id, title, artist, album, duration, genre);
        
        if(service.addSong(song)) {
        	System.out.println("Song added successfully");
        }else {
        	System.out.println("Playlist is full.");
        }
	}
	
	private static void playSong(MusicPlayerService service) {
		Song song = service.play();
		if(song == null) {
			System.out.println("No songs available");
		}else {
			System.out.println("Now Playing: "+song);
		}
	}
	
	private static void playNext(MusicPlayerService service) {
		Song song = service.next();
		if(song == null) {
			System.out.println("No songs available");
		}else {
			System.out.println("Now Playing: "+song);
		}
	}
	
	private static void playPrevious(MusicPlayerService service) {
		Song song = service.previous();
		if(song == null) {
			System.out.println("No songs available");
		}else {
			System.out.println("Now Playing: "+song);
		}
	}
	
	private static void searchSong(MusicPlayerService service) {
		System.out.println("Enter song title: ");
		String title = scanner.nextLine();
		
		Song song = service.searchByTitle(title);
		if(song == null) {
			System.out.println("Song not found.");
		}else {
			System.out.println("Found: "+song);
		}
	}
	
    private static void removeSong(MusicPlayerService service) {
        System.out.print("Enter Song ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (service.removeSong(id)) {
            System.out.println("Song removed.");
        } else {
            System.out.println("Song not found.");
        }
    }
}
