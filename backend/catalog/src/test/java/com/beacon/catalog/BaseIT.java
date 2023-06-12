package com.beacon.catalog;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public interface BaseIT {

    static byte[] loadFirstImage() {
        File imgF = new File("src/test/resources/img/sample-phone.jpeg");
        return loadImage(imgF);
    }

    static byte[] loadSecondImage() {
        File imgS = new File("src/test/resources/img/sample-phone-2.jpeg");
        return loadImage(imgS);
    }

    static byte[] loadThirdImage() {
        File imgS = new File("src/test/resources/img/sample-phone-3.jpeg");
        return loadImage(imgS);
    }

    static byte[] loadImage(File file) {
        byte[] image = new byte[0];

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            image = bufferedInputStream.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
