package org.andot.graphene.common.utils;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Zip {
    public static void main(String[] args) throws ZipException {
        ZipFile zipFile = new ZipFile("/Users/andot/Document/ipsos/评论模板 (4).zip");
        zipFile.setCharset(Charset.forName("GBK"));
        zipFile.extractAll("/Users/andot/Document/ipsos/"+zipFile.getFile().getName());


        File[] files = searchFile(new File("/Users/andot/Document/ipsos/ping"), "commit.xlsx");
        if(files.length > 0){
            System.err.println(files[0].getAbsolutePath());
        }
    }

    /**
     * 搜索指定文件夹下的文件
     * @param folder
     * @param keyWord
     * @return
     */
    public static File[] searchFile(File folder, final String keyWord) {// 递归查找包含关键字的文件
        File[] subFolders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || (pathname.isFile() && pathname.getName().toLowerCase().contains(keyWord.toLowerCase()))) {
                    return true;
                }
                return false;
            }
        });
        List<File> result = new ArrayList<>();
        for (int i = 0; i < subFolders.length; i++) {
            if (subFolders[i].isFile()) {
                result.add(subFolders[i]);
            } else {
                File[] foldResult = searchFile(subFolders[i], keyWord);
                for (int j = 0; j < foldResult.length; j++) {
                    result.add(foldResult[j]);
                }
            }
        }
        File[] files = new File[result.size()];
        result.toArray(files);
        return files;
    }
}
