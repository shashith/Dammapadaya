package models;

/**
 * Created by VDARSSH on 5/30/2015.
 */
public class Chapter {
    String chapterName;
    String chapterDescription;
    String relatedfile;

    public String getRelatedfile() {
        return relatedfile;
    }

    public void setRelatedfile(String relatedfile) {
        this.relatedfile = relatedfile;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDescription() {
        return chapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }
}
