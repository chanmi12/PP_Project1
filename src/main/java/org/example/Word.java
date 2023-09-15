package org.example;

public class Word {
    private int id;
    private int level;
    private String word;
    private String mean;

    Word(){}
    Word(int level, String word, String mean){
        this.level = level;
        this.word = word;
        this.mean = mean;
    }
    Word(int id, int level, String word, String mean){
        this.id = id;
        this.level = level;
        this.word = word;
        this.mean = mean;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
    public String toString() {
        String wordLevel = "";
        for(int i = 0; i < level; i++) wordLevel += "*";
        //string format은 워드를 정렬하는 방법이다.
        String str = String.format("%-3s",wordLevel) + String.format("%15s",word) + "   " + mean;
        return str;
    }
    public String toFileString(){
        return this.level + "|" + this.word + "|" + this.mean;
    }
}
