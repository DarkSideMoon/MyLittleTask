package com.greenowl.model;

import java.awt.*;
import java.sql.Date;

/**
 * Created by acube on 20.04.2016.
 */
public class Note {

    public String header;

    public String body;

    public Color color;

    public Date date;

    public Note(String header, String body, Color color, Date date) {
        this.header = header;
        this.body = body;
        this.color = color;
        this.date = date;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }

}
