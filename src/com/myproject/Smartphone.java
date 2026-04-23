package com.myproject;

public class Smartphone implements VideoPlayer, MusicPlayer {

    @Override
    public void playMusic() {
        System.out.println("The Smartphone is playing the music");
    }

    @Override
    public void pauseMusic() {
        System.out.println("The Smartphone is pausing the music");
    }

    @Override
    public void stopMusic() {
        System.out.println("The Smartphone is stopping the music");
    }

    @Override
    public void playVideo() {
        System.out.println("The Smartphone is playing the video");
    }

    @Override
    public void pauseVideo() {
        System.out.println("The Smartphone is pausing the video");
    }

    @Override
    public void stopVideo() {
        System.out.println("The Smartphone is stopping the video");
    }

}
