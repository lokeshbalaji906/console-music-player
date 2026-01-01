package com.demo.musicplayer.exception;

public class PlaylistFullException extends RuntimeException {

    public PlaylistFullException(String message) {
        super(message);
    }
}
