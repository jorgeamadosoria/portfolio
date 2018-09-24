package org.jasr.portfolio.entities;

import java.util.Set;

public class Project {

    private String name;
    private Integer year;
    private String description;
    private Type type;
    private Set<Tag> tags;
    private Set<Link> links;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Set<Tag> getTags() {
        return tags;
    }
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    public Set<Link> getLinks() {
        return links;
    }
    public void setLinks(Set<Link> links) {
        this.links = links;
    }
    
}
