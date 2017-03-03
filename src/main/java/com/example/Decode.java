package com.example;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.Hashtable;

/**
 * Created by Julian on 2017/3/3.
 */
@RestController
public class Decode {

    private DecoderService decoderService;

    @RequestMapping("/decode")
    public String decode(){

        File file = new File("E://code.jpg");

        BufferedImage bufferedImage = null;

        try {

            bufferedImage = ImageIO.read(file);

        } catch (IOException e) {

            e.printStackTrace();

        }

        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();

        hints.put(DecodeHintType.CHARACTER_SET, "GBK");

        Result result = null;

        try {

            result = new MultiFormatReader().decode(bitmap, hints);

        } catch (NotFoundException e) {

            e.printStackTrace();

        }

        return result.toString();
    }
}
