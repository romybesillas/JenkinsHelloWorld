package com.besillas.java.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Control {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Album newAlbum = new Album("Ultraelectromagneticpop!");
		newAlbum.addSong("Easy Ka Lang", 4.23);
		newAlbum.addSong("Maling Akala", 4.11);
		newAlbum.addSong("Pare Ko", 5.11);
		newAlbum.addSong("Toyang", 3.45);
		
		LinkedList<Song> playList = new LinkedList<Song>();
		newAlbum.addPlaylist("Easy Ka Lang", playList);
		newAlbum.addPlaylist("Maling Akala", playList);
		newAlbum.addPlaylist("Pare Ko", playList);
		newAlbum.addPlaylist("Toyang", playList);
		newAlbum.addPlaylist("Toyang#", playList);		
		ListIterator<Song> linkIter = playList.listIterator();
		Boolean quit = false;
		showOptions();
		Boolean forwardDirection = true;
		while(!quit) {
			int option = scan.nextInt();
			switch (option) {
			case 1:
				showOptions();
				break;
			case 2:
				//move forward
				if (!forwardDirection) {
					if(linkIter.hasNext()) {
						linkIter.next();
						forwardDirection =true;
					}else {
						System.out.println("At end of the playlist");
					}
				}
				if (linkIter.hasNext()) {
					System.out.println("Playing "+ linkIter.next().getName());
				}else
				{
					System.out.println("At end of the playlist");
				}
				break;
			case 3:
				//move backward
				if (forwardDirection) {
					if(linkIter.hasPrevious()) {
						linkIter.previous();
						forwardDirection =false;
					}else {
						System.out.println("At start of the playlist");
					}
				}
				if (linkIter.hasPrevious()){
					System.out.println("Playing "+ linkIter.previous().getName());
				}else
				{
					System.out.println("At start of the playlist");
				}
				break;				
				
				
				
			case 4:
				//quit
				quit = true;
				break;
			}
		}
		
	}

	private static void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("1: Show Options");
		System.out.println("2: Play forward");
		System.out.println("3: Play backward");		
		System.out.println("4: Quit");
				
	}

}
