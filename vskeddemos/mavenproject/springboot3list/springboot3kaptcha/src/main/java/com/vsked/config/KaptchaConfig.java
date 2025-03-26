package com.vsked.config;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha() {
        Properties properties = new Properties();

        // 设置验证码图片的宽度
        properties.put(Constants.KAPTCHA_IMAGE_WIDTH, "200");

        // 设置验证码图片的高度
        properties.put(Constants.KAPTCHA_IMAGE_HEIGHT, "50");

        // 设置验证码文本字体的大小
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");

        // 设置验证码文本字体的颜色
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");

        // 设置验证码字符之间的间距
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");

        // 设置验证码文本的字符数
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");

        // 设置验证码使用的字体
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial,Courier");

        // 设置验证码的噪声类型
        properties.put(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");

        // 设置验证码的扭曲效果
        properties.put(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.WaterRipple");

        // 设置验证码背景的起始颜色
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "white");

        // 设置验证码背景的结束颜色
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "white");

        // 使用 Config 创建 Kaptcha 实例
        Config config = new Config(properties);

        // 创建 DefaultKaptcha 实例
        DefaultKaptcha kaptcha = new DefaultKaptcha();

        // 设置 Kaptcha 配置
        kaptcha.setConfig(config);

        return kaptcha;
    }
}
