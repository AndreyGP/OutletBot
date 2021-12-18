package com.example.outletbot.bot.config;

import com.example.outletbot.bot.WebHookOutletBot;
import com.example.outletbot.bot.service.BotServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotConfiguration.java
 * Date/time: 19 декабрь 2021 in 1:26
 */
@Slf4j
@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "instamart")
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

    @Bean("MessageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}
