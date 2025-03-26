package com.vsked.auth.web;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {
    private static final Logger log = LoggerFactory.getLogger(KaptchaController.class);

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/kaptcha")
    public void kaptcha(HttpServletRequest req, HttpServletResponse res) throws IOException {
        log.info(req.getMethod());
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);
        res.setContentType("image/png");
        ImageIO.write(image, "png", res.getOutputStream());
    }
}
