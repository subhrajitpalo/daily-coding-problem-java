package palo.mantu.practice.algorithm;

import java.util.ArrayList;
import java.util.List;

import palo.mantu.practice.algorithm.FileCount.Directory.File;

public class FileCount {
    public int countFiles(Directory dir) {
        int count = 0;
        for (File f : dir.files) {
            if (f.name != null && !f.name.isEmpty()) {
                count++;
            }
        }
        if (dir.subs.isEmpty()) {
            return count;
        }
        for (Directory d : dir.subs) {
            count += countFiles(d);
        }
        return count;
    }

    public int countHiddenFiles(Directory dir) {
        int count = 0;
        for (File f : dir.files) {
            if (f.name != null && f.name.startsWith(".")) {
                count++;
            }
        }
        if (dir.subs.isEmpty()) {
            return count;
        }
        for (Directory d : dir.subs) {
            count += countHiddenFiles(d);
        }
        return count;
    }

    public class Directory {
        List<Directory> subs = new ArrayList<>();
        List<File> files = new ArrayList<>();

        public Directory(String fileName) {
            files.add(new File(fileName));
        }

        public Directory(List<String> fileNames) {
            fileNames.forEach(n -> files.add(new File(n)));
        }

        public void addSub(Directory sub) {
            subs.add(sub);
        }

        class File {
            String name;

            File(String name) {
                this.name = name;
            }
        }
    }
}