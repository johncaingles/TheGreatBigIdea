package com.example.john.thegreatbigidea;

import android.content.Context;
import android.content.res.Resources;

public class SavedIdea extends Idea {
    private String note;
    private int ideaID;

    public SavedIdea(int ideaID, String name, String category, String imgurl, String note) {
        super(name, category, imgurl);
        this.ideaID = ideaID;
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    public int getID()
    {
        return ideaID;
    }

    public int getDrawableID(Context context)
    {
        Resources res = context.getResources();
        int resID = res.getIdentifier(super.getImage() , "drawable", "com.example.john.thegreatbigidea");
        return resID;
    }
}
