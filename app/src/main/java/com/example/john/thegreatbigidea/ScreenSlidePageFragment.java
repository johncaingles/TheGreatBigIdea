package com.example.john.thegreatbigidea;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ScreenSlidePageFragment extends Fragment
{
    private String imageURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        imageURL = bundle.getString("image");
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        ImageView img= (ImageView) view.findViewById(R.id.ideaView);

        Resources res = getResources();
        int resID = res.getIdentifier(imageURL , "drawable", "com.example.john.thegreatbigidea");
        Drawable drawable = res.getDrawable(resID );
        img.setImageDrawable(drawable);

        ImageButton save = (ImageButton) view.findViewById(R.id.imageButton);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainMenu.class);
                startActivity(i);
            }});
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Image saved!");
                builder.setMessage("Save the image with a note:\n");
                // Set up the input
                final EditText input;
                input = new EditText(getActivity());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mtext = input.getText().toString();
                        //setImageResource();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

        return view;
    }
}