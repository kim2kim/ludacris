package com.ludacris.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game extends BaseObject {

	@Column(name = "flash_link")
	private String flashLink;
	
	private String title;
	
	private String description;
	
	public Game(){
		super();
	}

	public String getFlashLink() {
		return flashLink;
	}

	public void setFlashLink(String flashLink) {
		this.flashLink = flashLink;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((flashLink == null) ? 0 : flashLink.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flashLink == null) {
			if (other.flashLink != null)
				return false;
		} else if (!flashLink.equals(other.flashLink))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
