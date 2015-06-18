package com.enovators.shashithdarshana.dammapadaya;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.enovatiors.shashithdarshana.utility.Utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import dataaccess.FileHandler;
import models.Chapter;
import models.Verse;


public class ChapterContent extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_content);
        Intent intent=getIntent();
        String chapterName=intent.getStringExtra("chapterName");
        ListView verseList=(ListView)findViewById(R.id.verseListView);
        List<Verse> verses=new ArrayList<Verse>();
        FileHandler fh=new FileHandler();
        int resourceId=-1;
        try{
            Class res=R.raw.class;
            Field field=res.getField(chapterName);
            resourceId=field.getInt(null);
        }catch(Exception e){
            e.printStackTrace();
        }

        try {


            if(resourceId!=-1){
                String output=fh.readFile(this,resourceId);
                JSONArray chapterArray=new JSONArray(output);
                for(int i=0;i<chapterArray.length();i++){
                    JSONObject verseObj=chapterArray.getJSONObject(i);
                    Verse verse=new Verse();
                    verse.setVerseNo(verseObj.getString("verse_no"));
                    verse.setVerseText(verseObj.getString("verse_text"));
                    verse.setVerseMeaning(verseObj.getString("verse_meaning"));
                    verses.add(i,verse);
                }
                final VerseAdapter verseAdapter=new VerseAdapter(this,
                        R.layout.verse, verses);
                verseList.setAdapter(verseAdapter);
            }
            else{

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        verseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chapter_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
