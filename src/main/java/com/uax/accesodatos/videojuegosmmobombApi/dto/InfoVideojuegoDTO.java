package com.uax.accesodatos.videojuegosmmobombApi.dto;

import java.util.ArrayList;

/**
 * @author AlvaroLozoya
 *
 *         DTO de toda la info de un videojuego, incluye los DTOs de los
 *         requeriminetos minimos y las screenshots
 */
public class InfoVideojuegoDTO {
	public int id;
	public String title;
	public String thumbnail;
	public String status;
	public String short_description;
	public String description;
	public String game_url;
	public String genre;
	public String platform;
	public String publisher;
	public String developer;
	public String release_date;
	public String profile_url;
	public MinSysReqDTO minimum_system_requirements;
	public ArrayList<ScreenshotDTO> screenshots;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public MinSysReqDTO getMinimum_system_requirements() {
		return minimum_system_requirements;
	}

	public void setMinimum_system_requirements(MinSysReqDTO minimum_system_requirements) {
		this.minimum_system_requirements = minimum_system_requirements;
	}

	public ArrayList<ScreenshotDTO> getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(ArrayList<ScreenshotDTO> screenshots) {
		this.screenshots = screenshots;
	}

}
