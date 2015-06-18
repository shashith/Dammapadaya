package com.enovators.shashithdarshana.dammapadaya;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dataaccess.FileHandler;
import models.Chapter;


public class MainActivity extends ActionBarActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView chapterList=(ListView)findViewById(R.id.chapterList);
        context=this;

        FileHandler fh=new FileHandler();

        List<Chapter> chapters = new ArrayList<>();

        try {
            int resource=R.raw.chapterjson;
            String output=fh.readFile(context,resource);
            JSONArray chapterArray=new JSONArray(output);
            for(int i=0;i<chapterArray.length();i++){
                JSONObject chapterObj=chapterArray.getJSONObject(i);Chapter chapter=new Chapter();
                chapter.setChapterDescription(chapterObj.getString("description"));
                chapter.setChapterName(chapterObj.getString("chapterName"));
                chapter.setRelatedfile(chapterObj.getString("relatedFile"));
                chapters.add(i,chapter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ChapterAdaptor chapterAdaptor=new ChapterAdaptor(this,
                R.layout.chapter_names, chapters);

        chapterList.setAdapter(chapterAdaptor);
        //onclick listner for the Listview in main activity
        chapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chapter item = (Chapter)chapterAdaptor.getItem(position);
                Toast.makeText(context, item.getChapterName() + " selected", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,ChapterContent.class);
                intent.putExtra("chapterName",item.getRelatedfile());
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
