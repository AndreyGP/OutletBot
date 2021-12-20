package com.example.outletbot.bot.config;

import com.example.outletbot.bot.WebHookOutletBot;
import com.example.outletbot.bot.service.BotServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import java.util.Locale;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotConfiguration.java
 * Date/time: 19 декабрь 2021 in 1:26
 */
@Slf4j
@Getter
@Setter
@Configuration
@PropertySources({
        @PropertySource(value = "classpath:application.properties", encoding = "UTF-8"),
        @PropertySource(value = "classpath:message.properties", encoding = "UTF-8")
})
@ConfigurationProperties(prefix = "instamart")
@ComponentScan(basePackages = "com.example.outletbot")
public class BotConfiguration {
    private String webHookPath;
    private String botUserName;
    private String botToken;
    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public DefaultBotOptions defaultBotOptions() {
        DefaultBotOptions options = new DefaultBotOptions();
        options.setProxyHost(proxyHost);
        options.setProxyPort(proxyPort);
        options.setProxyType(proxyType);
        return options;
    }

    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder().url(webHookPath).build();
    }

    @Bean
    public WebHookOutletBot webHookOutletBot(BotServiceImpl botService) {
        return new WebHookOutletBot(botService, this);
    }
//
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
//        source.setBasename("classpath:message");
//        source.setDefaultLocale(Locale.ROOT);
//        source.setDefaultEncoding("UTF-8");
//        return source;
//    }
}
