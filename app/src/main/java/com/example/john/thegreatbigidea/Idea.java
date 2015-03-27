package com.example.john.thegreatbigidea;

/**
 * Created by Jolo Simeon on 3/7/2015.
 */
public class Idea
{
    private String id;
    private String name;
    private String category;
    private String imgurl;

    public Idea(String name, String category, String imgurl)
    {
        this.name = name;
        this.category = category;
        this.imgurl = imgurl;
    }

    public String getCategory()
    {
        return category;
    }

    public String getImage()
    {
        return imgurl;
    }

    public String getName()
    {
        return name;
    }

    public String getID() { return id; }

}
