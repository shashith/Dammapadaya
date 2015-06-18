package com.enovators.shashithdarshana.dammapadaya;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import models.Verse;

/**
 * Created by VDARSSH on 5/31/2015.
 */
public class VerseAdapter extends ArrayAdapter<Verse> {
    HashMap<Verse, Integer> mIdMap = new HashMap<Verse, Integer>();
    int resource;
    Context context;
    List<Verse> items;
    public VerseAdapter(Context context, int resource, List<Verse> objects) {
        super(context, resource, objects);
        this.resource=resource;
        this.context=context;
        this.items=objects;

        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }
    @Override
    public long getItemId(int position) {
        Verse item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);
        TextView verseText = (TextView) rowView.findViewById(R.id.verseText);
       // Utility.setFont(verseText,context);
        TextView verseMeaning = (TextView) rowView.findViewById(R.id.verseMeaning);
        //Utility.setFont(verseMeaning,context);
        verseText.setText((items.get(position)).getVerseText());
        verseMeaning.setText((items.get(position)).getVerseMeaning());
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/kaputaunicode.ttf");
        //verseText.setTypeface(font);

        return rowView;
    }
}
