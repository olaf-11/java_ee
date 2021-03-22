package by.htp.project.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class News implements Serializable{
	private static final long serialVersionUID = -6424814275615643088L;
	
	private int id;
	private String title;
	private String brief;
	private String content;
	private LocalDate date;
	private String status;
	
	public News() {}
	
	public News(int i, String ttl, String brf, String cnt, String st) {
		super();
		id = i;
		title = ttl;
		brief = brf;
		content = cnt;
		status = st;
	}
	
	public News(String ttl, String br, String cn, String st) {
		super();
		title = ttl;
		brief = br;
		content = cn;
		status = st;
	}

	public News(int i, String ttl, String br, String cn, LocalDate dt) {
		super();
		id = i;
		title = ttl;
		brief = br;
		content = cn;
		date = dt;
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News id = " + id + "\n" + 
			   "title: " + title + "\n" +
			   "brief: " + brief + "\n" +
			   "content: " + content + "\n" +
			   "date: " + date + "\n" +
			   "status = " + status + "\n\n";
	}	
}