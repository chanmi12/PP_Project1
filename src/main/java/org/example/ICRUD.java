package org.example;
import java.util.*;
import java.io.*;

public interface ICRUD {
    public Object add();
    public int update(Object obj);
    public int delete(Object obj);
    public void selectOne(int id);
    public void loadFile();
    public void saveFile();
}
