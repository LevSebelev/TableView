package com.dz.mlayerlev;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class dal {
    private List<String> lines;
    private File file;

    public dal(String filePath) throws IOException {
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла: " + e.getMessage());
            }
        }
        lines = new ArrayList<>();
        readLinesFromFile();
    }

    private void readLinesFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    reader.close();
    }

    public void addLine(String line) {

        lines.add(line);
    }

    public void deleteLine(int index) {

        lines.remove(index);
    }

    public void saveToFile() throws IOException {
        file.delete();
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }
    public int search(String line){
        for(int i = 0; i < lines.size(); i++) {
            if(line.equals(lines.get(i)))
                return i;
        }
        return -1;
    }
    public String GetLine(int n){
        for(int i = 0; i < lines.size(); i++) {
            if(n == i) return lines.get(i);
    }
        return "-111";}

    public int GetEndIndex(){
       return lines.size();

    }
}