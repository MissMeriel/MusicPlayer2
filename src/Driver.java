/**
 * OOPDA, Myers, Spring 2016
 *Music Player Part 2
 *Lab Directions here: http://jackmyers.info/oopda/musicPlayerPart2.pdf
 *Driver class
 *
 *@author Meriel Stein
 *@version 1/23/2016
 */

import java.util.HashMap;

public class Driver{
	
	public static void main(String[] args){
		/*repeated artists*/
		Artist mya = new Artist("Mya","");
		
		/*add song 1 in complete playlist*/
		Song song1 = new Song("Roar", "Pop", 2013);
		song1.addArtist(new Artist("Katy", "Perry"));
		
		/*add song 2 in complete playlist*/
		Song song2 = new Song("Lady Marmalade", "Disco", 2001);
		song2.addArtist(new Artist("Christina", "Aguilera"));
		song2.addArtist(new Artist("", "P!nk"));
		song2.addArtist(mya);
		song2.addArtist(new Artist("Li'l", "Kim"));
		
		/*add song 3 in complete playlist*/
		Song song3 = new Song("Just Give Me A Reason", "Pop", 2012);
		song3.addArtist(new Artist("", "P!nk"));
		song3.addArtist(new Artist("Nate", "Ruess"));
		
		/*add song 4 in complete playlist*/
		Song song4 = new Song("Evolve", "R&B", 2012);
		song4.addArtist(mya);
		
		/*add song 5 in complete playlist*/
		Song song5 = new Song("Centuries", "Rock", 2014);
		song5.addArtist(new Artist("", "Fall Out Boy"));
		
		/*add song 6 in complete playlist*/
		Song song6 = new Song("Crush on You", "R&B", 1997);
		song6.addArtist(mya);
		song6.addArtist(new Artist("", "The Notorious B.I.G."));
		song6.addArtist(new Artist("Lil", "Cease"));
		
		/*add song 7 in complete playlist*/
		Song song7 = new Song("Crush on You", "Pop", 1985);
		song7.addArtist(new Artist("", "The Jets"));
		
		/*add song 8 in complete playlist*/
		Song song8 = new Song("We Are the World", "Christmas", 1985);
		song8.addArtist(new Artist("Lionel", "Ritchie"));
		song8.addArtist(new Artist("Stevie", "Wonder"));
		song8.addArtist(new Artist("Michael", "Jackson"));
		song8.addArtist(new Artist("Bono", ""));
		song8.addArtist(new Artist("Bruce", "Springsteen"));
		song8.addArtist(new Artist("Ray", "Charles"));
		song8.addArtist(new Artist("Billy", "Joel"));
		song8.addArtist(new Artist("Diana", "Ross"));
		song8.addArtist(new Artist("Bob", "Dylan"));
		
		/*initialize completePlaylist*/
		Song[] completeSonglist = {song1, song2, song3, song4, song5, song6, song7, song8};
		int songCounter = 0;
		HashMap<Integer, Song> songs = new HashMap<Integer, Song>();
		for (Song song : completeSonglist){
			songs.put(songCounter, song);
			songCounter++;
		}
		Playlist completePlaylist = new Playlist("Complete Playlist", songs);
		System.out.println(completePlaylist.display());
		
		/*search completePlaylist*/
		completePlaylist.search();
		
		/*reverse artist order of completePlaylist songs*/
		//HashMap<Integer, Song> songList = completePlaylist.getList();
		System.out.println("Complete playlist before artist order reversal:");
		System.out.println(completePlaylist.display());
		completePlaylist.reverseArtists();
		System.out.println("Complete playlist after artist order reversal: ");
		System.out.println(completePlaylist.display());
		
		/*build Dance Songs playlist*/
		HashMap<Integer, Song> danceSongsList = new HashMap<Integer, Song>();
		int songCount1 = 0;
		for (int i = 0; i < completePlaylist.getList().size(); i++){
			String genre = completePlaylist.getList().get(i).getGenre();
			if (genre.equals("Dance") || genre.equals("Disco")){
				danceSongsList.put(songCount1, completePlaylist.getList().get(i));
				songCount1++;
			}
		} // end for loop
		Playlist danceSongs = new Playlist("Dance Songs", danceSongsList);
		System.out.println(danceSongs.display());
		
		/*build Mya's Greatest Hits playlist*/
		HashMap<Integer, Song> myaSongs = new HashMap<Integer, Song>();
		int songCount2 = 0;
		for (int i = 0; i < completePlaylist.getList().size(); i++){
			if (completePlaylist.getList().get(i).getArtists().contains(mya)){
				myaSongs.put(songCount2, completePlaylist.getList().get(i));
				songCount2++;
			}
		} // end for loop
		Playlist myaHits = new Playlist("Mya's Greatest Hits", myaSongs);
		System.out.println(myaHits.display());
		
		/*Remove Roar, add a rock song*/
		completePlaylist.deleteSong(song1);
		Song newRockSong = new Song("Black Tongue", "Rock", 2007);
		newRockSong.addArtist(new Artist("", "The Yeah Yeah Yeahs"));
		completePlaylist.addSong(newRockSong);
		System.out.println("Complete Playlist after removing Roar and adding a rock song: ");
		System.out.println(completePlaylist.display());
		
		/*add acoustic versions of rock songs to completePlaylist*/
		for (int i = 0 ; i < completePlaylist.getList().size() ; i++){
			Song song = completePlaylist.getList().get(i);
			if(song.getGenre().equals("Rock") && !song.getSongTitle().contains("[acoustic version]")){
				Song newSong = new Song(song.getSongTitle(), song.getGenre(), song.getYear());
				newSong.setArtists(song.getArtists());
				newSong.setSongTitle(song.getSongTitle() + " [acoustic version]");
				if(completePlaylist.addSong(newSong) == Integer.MIN_VALUE){
					System.out.println(newSong+" could not be added.");
				}
				System.out.println(completePlaylist.display());
			}
		}
		System.out.println(completePlaylist.getName() + " with acoustic versions: ");
		System.out.println(completePlaylist.display());
		
		/*songToBeDeleted exercise*/
		Song songToBeDeleted = new Song("Crush On You", "R&B", 1985);
		completePlaylist.deleteSong(songToBeDeleted);
		System.out.println("After deleting "+songToBeDeleted);
		System.out.println(completePlaylist.display()+"\n");
		
		/*testing moveArtist* methods with "We Are the World"*/
		System.out.println(song8+" before testing moveArtist* methods:");
		System.out.println(song8.getArtists());
		System.out.println("Moving 4th artist to the top:");
		song8.moveArtistTop(3);
		System.out.println(song8.getArtists());
		System.out.println("Moving 7th artist to the bottom:");
		song8.moveArtistBottom(6);
		System.out.println(song8.getArtists());
		System.out.println("Moving 2nd artist to 3rd:");
		song8.moveArtistDown(1);
		System.out.println(song8.getArtists());
		System.out.println("Moving 3rd artist to 2nd:");
		song8.moveArtistUp(2);
		System.out.println(song8.getArtists());
		
		/*display Complete Playlist, Mya's Greatest Hits, and Dance Songs*/
		System.out.println("\n"+completePlaylist.display());
		System.out.println(myaHits.display());
		System.out.println(danceSongs.display());
		
	}//end main
}// end Driver class
