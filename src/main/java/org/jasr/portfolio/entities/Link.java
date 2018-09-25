package org.jasr.portfolio.entities;

import javax.persistence.Entity;

@Entity
public class Link extends BaseEntity{
    private String name;
    private String display;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }


}
