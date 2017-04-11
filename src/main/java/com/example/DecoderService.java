package com.example;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;


@Service
public class DecoderService {
    private static final String CHARSET = "utf-8";

    String decodeService(String realImgPath){

        File file = new File(realImgPath);

        BufferedImage bufferedImage = null;

        try {

            bufferedImage = ImageIO.read(file);

        } catch (IOException e) {

            e.printStackTrace();

        }

        if (bufferedImage == null){
            return null;
        }

        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);

        Result result = null;

        try {

            result = new MultiFormatReader().decode(bitmap, hints);

        } catch (NotFoundException e) {

            e.printStackTrace();

        }
        if (result == null) {
            return null;
        }

        return result.toString();

    }
}
