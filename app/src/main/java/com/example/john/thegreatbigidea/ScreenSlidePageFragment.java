package com.example.john.thegreatbigidea;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ScreenSlidePageFragment extends Fragment
{
    private String imageURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        imageURL = bundle.getString("image");
        View view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        ImageView img= (ImageView) view.findViewById(R.id.image);

        Resources res = getResources();
        int resID = res.getIdentifier(imageURL , "drawable", "com.example.john.thegreatbigidea");
        Drawable drawable = res.getDrawable(resID );
        img.setImageDrawable(drawable);

        /*Matrix matrix = new Matrix();
        img.setScaleType(ImageView.ScaleType.MATRIX);   //required
        matrix.postRotate((float) 90, pivX, pivY);
        img.setImageMatrix(matrix);*/

        img.setRotation(90);

        return view;
    }
}