package com.finalyearproject.learnpashto;

public class Word {

    //Fields
    private String english;
    private String pashto;
    private int audio;
    private int image = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    //Constructors
    public Word(String eEnglish, String pPashto, int aAudio) {
        english = eEnglish;
        pashto = pPashto;
        audio = aAudio;
    }
    //Constructors
    public Word(String eEnglish, String pPashto, int iImage, int aAudio){
        english = eEnglish;
        pashto = pPashto;
        image = iImage;
        audio = aAudio;
}

    //Methods
    public String geteEnglish(){
        return english;
    }

    public String getpPashto(){
        return pashto;
    }

    public int getiImage(){
        return image;
    }

    public boolean hasImage(){
        return image != NO_IMAGE_PROVIDED;
    }

    public int getaAudio(){
        return audio;
    }
}
