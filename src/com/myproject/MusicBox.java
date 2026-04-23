package com.myproject;

public class MusicBox implements MusicPlayer {

    @Override
    public void playMusic() {
        System.out.println("The MusicBox is playing the music");
    }

    @Override
    public void pauseMusic() {
        System.out.println("The MusicBox is pausing the music");
    }

    @Override
    public void stopMusic() {
        System.out.println("The MusicBox is stopping the music");
    }

}
