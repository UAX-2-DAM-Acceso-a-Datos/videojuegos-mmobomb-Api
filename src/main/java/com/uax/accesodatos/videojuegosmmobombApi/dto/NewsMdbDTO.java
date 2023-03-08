package com.uax.accesodatos.videojuegosmmobombApi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "noticias")
public class NewsMdbDTO {
	
	@Id
	public int id;
	public String title;
	public String short_description;
	public String thumbnail;
	public String main_image;
	public String article_content;
	public String article_url;

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
