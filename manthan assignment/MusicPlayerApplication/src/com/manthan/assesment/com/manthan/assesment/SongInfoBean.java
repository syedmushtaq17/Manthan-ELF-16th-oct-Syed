package com.manthan.assesment;

public class SongInfoBean {

	int song_id;
	String song_title;
	String artist_name;
	String album_name;
	String song_location;
	String description;
	
	public SongInfoBean() {
	}
	public int getSong_id() {
		return song_id;
	}
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	public String getSong_title() {
		return song_title;
	}
	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	public String getSong_location() {
		return song_location;
	}
	public void setSong_location(String song_location) {
		this.song_location = song_location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
