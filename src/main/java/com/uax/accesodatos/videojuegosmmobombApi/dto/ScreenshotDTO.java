package com.uax.accesodatos.videojuegosmmobombApi.dto;

/**
 * @author AlvaroLozoya
 * 
 * DTO de las screenshots de los juegos
 */
public class ScreenshotDTO {
	public int id;
    public String image;
    
    public ScreenshotDTO(int id, String image) {
    	this.id=id;
    	this.image=image;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

    
}
