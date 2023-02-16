package com.uax.accesodatos.videojuegosmmobombApi.dto;

public class VideojuegosDTO {
	
    public int id;
    public String title;
    public String thumbnail;
    public String short_description;
    public String game_url;
    public String genre;
    public String platform;
    public String publisher;
    public String developer;
    public String release_date;
    public String profile_url;
    
	public VideojuegosDTO(int id, String title, String thumbnail, String short_description, String game_url,
			String genre, String platform, String publisher, String developer, String release_date,
			String profile_url) 
	{
		
	
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.short_description = short_description;
		this.game_url = game_url;
		this.genre = genre;
		this.platform = platform;
		this.publisher = publisher;
		this.developer = developer;
		this.release_date = release_date;
		this.profile_url = profile_url;
	}

	public VideojuegosDTO(int id) {
		this.id = id;
	}

	public VideojuegosDTO() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public String getShort_description() {
		return short_description;
	}
	
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	
	public String getGame_url() {
		return game_url;
	}
	
	public void setGame_url(String game_url) {
		this.game_url = game_url;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	public String getProfile_url() {
		return profile_url;
	}
	
	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}
    
    

}
