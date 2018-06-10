package com.example.trungspc.xmlreader.parser;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "music", strict = false)
public class XMLResponse {
    @ElementList(inline =  true)
    public ArrayList<Song> songList;
}
