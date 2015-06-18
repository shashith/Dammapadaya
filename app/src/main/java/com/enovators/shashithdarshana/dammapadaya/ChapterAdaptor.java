package com.enovators.shashithdarshana.dammapadaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import models.Chapter;

/**
 * Created by VDARSSH on 5/30/2015.
 */
public class ChapterAdaptor extends ArrayAdapter<Chapter>{

    HashMap<Chapter, Integer> mIdMap = new HashMap<Chapter, Integer>();
    int resource;
    Context context;
    List<Chapter> items;
    public ChapterAdaptor(Context context, int resource, List<Chapter> objects) {
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
        Chapter item = getItem(position);
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
        TextView chapterName = (TextView) rowView.findViewById(R.id.firstLine);
        TextView chapterDescription = (TextView) rowView.findViewById(R.id.secondLine);
        chapterName.setText((items.get(position)).getChapterName());
        chapterDescription.setText((items.get(position)).getChapterDescription());


        return rowView;
    }
}
