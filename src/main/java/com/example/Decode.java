package com.example;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import java.io.*;


@RestController
public class Decode {

    private DecoderService decoderService;
    private static final String FilePath = "E://code.jpg";

    @RequestMapping(value = "decode", method = RequestMethod.GET)
    public String decode(){
        return new DecoderService().decodeService(FilePath);
    }

    @RequestMapping(value = "decode", method = RequestMethod.POST)
    public String post(@RequestParam("name") String name,
                       @RequestParam("image") MultipartFile image,
                       HttpServletRequest request) throws IOException {
        if (image.isEmpty()) {
            return "file is no find";
        }

        byte[] bytes = new byte[0];
        try {
            bytes = image.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String rootPath = request.getSession().getServletContext().getRealPath("/upload");

        System.out.println("rootPath:"+rootPath);

        BufferedOutputStream stream = null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(new File(rootPath + name)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (stream != null) {
            stream.write(bytes);

        }
        assert stream != null;
        stream.close();



        return new DecoderService().decodeService(rootPath + name);
    }


}
