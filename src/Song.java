/**
 * Music Player, Part 1
 * Song class
 *
 * @author Meriel Stein
 * @version 1/23/2016
 * 
 */

import java.util.ArrayList;

public class Song {
	private String songTitle, genre;
	private int year;
	private final static int maxArtists = 8;
	private final static Integer ARTIST_NOT_ADDED = Integer.MIN_VALUE;
	private ArrayList<Artist> artists;
	private int artistCounter = 0;

	/**constructor*/
	public Song(String songTitle, String genre, int year){
		this.songTitle = songTitle;
		this.genre = genre;
		this.year = year;
		this.artists = new ArrayList<Artist>(maxArtists);
	}

	/**getters and setters*/
	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Artist> getArtists() {
		return artists;
	}

	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}
	
	public int addArtist(Artist artist){
		if (artistCounter >= maxArtists){
			return ARTIST_NOT_ADDED;
		}
		else{
			artistCounter++;
			artists.add(artist);
			return artistCounter-1;
		}
	}
	
	public boolean equals(Song song){
		if (this.songTitle.equals(song.getSongTitle()) && this.year == song.getYear()){
			return true;
		}
		return false;
	}
	
	/*moves the artist higher in the list (e.g. from third to second)*/
	public void moveArtistUp(int position){
		if (position-1 > 0){
			Artist artist = artists.remove(position);
			artists.add(position-1, artist);			
		}
		else{
			System.out.println("Song is already first, cannot be moved higher\n");
		}
	}
	
	/*moves the artist lower in the list (e.g. from second to third)*/
	public void moveArtistDown(int position){
		Artist artist = artists.remove(position);
		artists.add(position+1, artist);
	}
	
	/*moves the artist to the top of the list*/
	public void moveArtistTop(int position){
		Artist artist = artists.remove(position);
		artists.add(0, artist);
	}
	
	/*moves the artist to the bottom of the list*/
	public void moveArtistBottom (int position){
		Artist artist = artists.remove(position);
		artists.add(artists.size(), artist);
	}
	
	@Override
	public String toString(){
		return songTitle+" ("+year+")";
	} // end toString
} // end main
