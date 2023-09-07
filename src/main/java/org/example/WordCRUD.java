package org.example;
import java.util.*;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner keyboard;
    WordCRUD(Scanner keyboard){
        list = new ArrayList<>();
        this.keyboard = keyboard;
    }
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력:");
        int level = keyboard.nextInt();
        String word = keyboard.nextLine();
        System.out.print("뜻 입력:");
        String mean =keyboard.nextLine();
        return new Word(level,word, mean);
    }
    public void addWord(){
        Word w = (Word)add();
        list.add(w);
        System.out.println("새 단어가 단어장에 추가되었습니다.");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    public void listAll(){
        System.out.println("--------------------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.print((i+1)+ " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
}
