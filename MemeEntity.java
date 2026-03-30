package com.crio.starter.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "memes")
public class MemeEntity {

    @Id
    private String id;

    private String name;
    private String url;
    private String caption;

    public MemeEntity() {}

    public MemeEntity(String name, String url, String caption) {
        this.name = name;
        this.url = url;
        this.caption = caption;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getUrl() { return url; }
    public String getCaption() { return caption; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }
    public void setCaption(String caption) { this.caption = caption; }
}