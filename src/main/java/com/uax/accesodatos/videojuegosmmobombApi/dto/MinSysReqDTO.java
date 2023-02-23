package com.uax.accesodatos.videojuegosmmobombApi.dto;



/**
 * @author AlvaroLozoya
 * 
 * DTO de los requerimientos minimos para el juego
 */
public class MinSysReqDTO {
	public String os;
	public String processor;
	public String memory;
	public String graphics;
	public String storage;
	
	public MinSysReqDTO(String os) {
		this.os=os;
		this.processor="";
		this.memory="";
		this.graphics="";
		this.storage="";
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getGraphics() {
		return graphics;
	}
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}

	
}
