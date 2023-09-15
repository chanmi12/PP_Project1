package org.example;
import java.util.*;
import java.io.*;

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
        System.out.print("수정할 단어를 입력하세요:");
        String updateWord = keyboard.nextLine();
        System.out.print("수정할 번호 선택:");
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

    public ArrayList<Integer>listAll(String keyword){
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("--------------------------------");
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1)+ " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------------");
        return idlist;
    }

    public void update(){
        System.out.print("=> 수정할 단어 검색: ");
        String keyword = keyboard.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택 :");
        int id = keyboard.nextInt();
        System.out.print("=> 뜻 입력 :");
        String mean = keyboard.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMean(mean);
        System.out.println("단어가 수정되없습니다.");
    }


    public void loadFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
            String line;
            int count = 0;

            while(true) {
                line = br.readLine();
                if (line == null) break;

                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String mean = data[2];
                list.add(new Word(0, level, word, mean));
                count++;
            }
            br.close();
            System.out.println("==>" + count + "개 로딩 완료!!!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void saveFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("dictionary.txt"));
            for(Word dict: list){
                pw.write(dict.toFileString() + "\n");
            }
            pw.close();
            System.out.println("모든 단어 파일 저장 완료 !!! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
