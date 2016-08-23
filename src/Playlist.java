/**
 * Music Player Part 1
 * Playlist class
 * 
 * @author Meriel
 * @version 1/23/2016
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Playlist {

	/**instance variables*/
	final static Integer SONG_NOT_ADDED = Integer.MIN_VALUE;
	final static Integer SONG_NOT_FOUND = Integer.MIN_VALUE;
	final static private int maxSongs = 10;
	private int songCounter = 0;
	private String name;
	private HashMap<Integer, Song> list;
	
	public Playlist(String name, HashMap<Integer, Song> list){
		this.name = name;
		this.list = list;
		this.songCounter = list.size();
	} // end constructor

	public String getName() {
		return name;
	} // end getName

	public void setName(String name) {
		this.name = name;
	} // end setName

	public HashMap<Integer, Song> getList() {
		return list;
	} // end getList

	public void setList(HashMap<Integer, Song> list) {
		this.list = list;
	} // end setList
	
	public int addSong(Song song){
		if (songCounter >= maxSongs){
			return SONG_NOT_ADDED;
		}
		else{
			list.put(songCounter, song);
			System.out.println("songCounter = "+songCounter);
			System.out.println(song+ " was added at index "+String.valueOf(songCounter)+"\n");
			songCounter++;
			return songCounter;	
		}
	} // end addSong
	
	public void search(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter song title: ");
		String searchTerm = sc.nextLine().toLowerCase();
		boolean found = false;
		for(int i = 0; i < list.size(); i++){
			if (list.get(i).getSongTitle().toLowerCase().equals(searchTerm)){
				found = true;
				ArrayList<Artist> artistList = list.get(i).getArtists();
				Artist primaryArtist = artistList.get(0);
				System.out.println(searchTerm+" is song "+(i+1));
				System.out.println("The primary artist is "+primaryArtist);
			}
		}
		if (found == false){
			System.out.println(searchTerm+" not found\n");
		}
		sc.close();
	} // end search
	
	public void deleteSong(Song song){
		//need to change the keys for the rest of the songs to close the gap
		//double check if a for loop is okay with a HashMap
		if(list.containsValue(song)){
			for(int i = 0; i < list.size(); i++){
				if (list.get(i).equals(song)){
					list.remove(i);
					songCounter--;
					System.out.println(songCounter);
					for (int j = i; j < songCounter; j++){
						//if (j != songCounter){
							list.put(j, list.get(j+1));
						//}
						//else{
							
						//}
					}
				}
			}
		}
	} // end deleteSong
	
	public void reverseArtists(){
		for (int i = 0; i < list.size(); i++){						//for each song in the Playlist
			ArrayList<Artist> artists = list.get(i).getArtists();	//temp reference to Artist collection of current completePlaylist song 	
			for (int j = artists.size()-1; j >= 0; j--){			//for each Artist in the song's artist collection
				artists.add(artists.get(j));
				artists.remove(artists.get(j));
			}
			list.get(i).setArtists(artists);
		}
	}
	
	public String display(){
		String output = name + "\n";
		ArrayList<Artist> artists;
		for (int i = 0; i < songCounter; i++){
			artists = list.get(i).getArtists();
			output += (i+1) + ". " + list.get(i).getSongTitle()+"\n";
			for (int j = 0; j < artists.size(); j++){
				if (artists.get(j) != null){
					output += "     "+artists.get(j)+"\n";
				}//end if
			}//end for
		}//end for
		return output;
	}//end displayPlaylist
}
