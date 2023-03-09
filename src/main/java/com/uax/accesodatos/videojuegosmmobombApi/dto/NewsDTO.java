package com.uax.accesodatos.videojuegosmmobombApi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lista")
public class NewsDTO{
	@Id
	public String idMDB;
	
	public int id;
	public String title;
	public String short_description;
	public String thumbnail;
	public String main_image;
	public String article_content;
	public String article_url;
	
	
	
	public NewsDTO() {
		super();
	}

	public NewsDTO(int id, String title, String short_description, String thumbnail, String main_image,
			String article_content, String article_url) {
		this.id = id;
		this.title = title;
		this.short_description = short_description;
		this.thumbnail = thumbnail;
		this.main_image = main_image;
		this.article_content = article_content;
		this.article_url = article_url;
	}

	public String getIdMDB() {
		return idMDB;
	}

	public void setIdMDB(String idMDB) {
		this.idMDB = idMDB;
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
	
	public String getShort_description() {
		return short_description;
	}
	
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public String getMain_image() {
		return main_image;
	}
	
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	
	public String getArticle_content() {
		return article_content;
	}
	
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	
	public String getArticle_url() {
		return article_url;
	}
	
	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}
 
 
}

