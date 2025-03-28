package dev.eindopdracht.entities.sprite.fixed;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageLoader {

    //Autocomplete was On-Fire!!!

    public static List<String> getImagePaths(String folderPath) {
        List<String> imagePaths = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && isImageFile(file.getName())) {
                    imagePaths.add(file.toURI().toString());
                }
            }
        }
        return imagePaths;
    }
    private static boolean isImageFile(String fileName) {
        return fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".jpeg");
    }
}
