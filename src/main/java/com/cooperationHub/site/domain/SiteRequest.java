package com.cooperationHub.site.domain;

public class SiteRequest {

	private int id;
	private String team;
	private String part;
	private String name;
	private String stageUrl;
	private String realUrl;
	private String description;
			
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStageUrl() {
		return stageUrl;
	}
	public void setStageUrl(String stageUrl) {
		this.stageUrl = stageUrl;
	}
	public String getRealUrl() {
		return realUrl;
	}
	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	
	
}
