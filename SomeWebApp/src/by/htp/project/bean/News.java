package by.htp.project.bean;

import java.time.LocalDate;

public class News {
	private int id;
	private String title;
	private String brief;
	private String content;
	private LocalDate date;
	private String status;
	
	public News(int i, String ttl, String brf, String cnt, String st) {
		super();
		id = i;
		title = ttl;
		brief = brf;
		content = cnt;
		status = st;
	}
	
	public News(String ttl, String brf, String cnt, String st) {
		title = ttl;
		brief = brf;
		content = cnt;
		status = st;
	}

	public News(int id, String title, String brief, String content, LocalDate date) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
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
}