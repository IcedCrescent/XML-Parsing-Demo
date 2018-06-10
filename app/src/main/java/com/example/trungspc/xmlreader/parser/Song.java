package com.example.trungspc.xmlreader.parser;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "song", strict = false)
public class Song {
    @Element(name = "id")
    public int id;
    @Element(name = "title")
    public String title;
    @Element(name = "artist")
    public String artist;
    @Element(name = "duration")
    public String duration;
    @Element(name = "thumb_url")
    public String img;
}
