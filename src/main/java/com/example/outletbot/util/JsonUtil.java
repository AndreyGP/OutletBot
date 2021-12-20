package com.example.outletbot.util;

import com.example.outletbot.bot.WebHookOutletBot;
import com.example.outletbot.bot.service.BotServiceImpl;
import com.example.outletbot.common.exception.JsonUploadException;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: JsonUtil.java
 * Date/time: 19 декабрь 2021 in 5:48
 */
//@Setter
//@Getter
//@Component
//@Scope("prototype")
//public class JsonUtil {
//    private BotServiceImpl service;
//    private String botToken = service.getBotToken();
//    private Message inMessage;
//
//    @Lazy
//    public JsonUtil(BotServiceImpl service) {
//        this.service = service;
//    }
//
//    private List<String> getJSONStringsList() throws MalformedURLException {
//        final Document document = inMessage.getDocument();
//        JSONObject path = new JSONObject();
//        URL url = new URL("https://api.telegram.org/bot" + botToken + "/getFile?file_id=" + document.getFileId());
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
//            String res = in.readLine();
//            JSONObject jresult = new JSONObject(res);
//            path = jresult.getJSONObject("result");
//        } catch (IOException e) {
//            try {
//                throw new JsonUploadException(service, inMessage.getChatId().toString(), "Ошибка загрузки файла со стороны пользоователя");
//            } catch (JsonUploadException jsonUploadException) {
//                jsonUploadException.printStackTrace();
//            }
//        }
//
//        URL downoload = new URL("https://api.telegram.org/file/bot" + botToken + "/" + path.getString("file_path"));
//        List<String> result = Collections.emptyList();
//        try (BufferedReader outToString = new BufferedReader(new InputStreamReader(downoload.openStream()))) {
//            StringBuilder strings = new StringBuilder();
//            while (outToString.ready())
//                strings.append(outToString.readLine());
//            result = splitJSONsStringToJSONList(strings.toString());
//        } catch (IOException e) {
//            try {
//                throw new JsonUploadException(service, inMessage.getChatId().toString(), "Ошибка загрузки файла со стороны сервера");
//            } catch (JsonUploadException jsonUploadException) {
//                jsonUploadException.printStackTrace();
//            }
//        }
//
//        return result;
//    }
//
//    private List<String> splitJSONsStringToJSONList(final String jsons) {
//        return Arrays.stream(jsons.substring(2, jsons.length() - 2).split("},\\{")).collect(Collectors.toList());
//    }
//
//    private List<List<String>> getOrdersList(final List<String> jsonStrings) {
//        if (jsonStrings == null) return Collections.emptyList();
//        return jsonStrings.parallelStream()
//                .map(s -> Arrays.stream(s.replace("\":", "\" : ")
//                        .replace(":null", ": null")
//                        .replace("\\s:\\d", " : ")
//                        .replace(" : ", " | ")
//                        .replace(",\"", ";")
//                        .replace("\"", "")
//                        .split(";"))
//                        .collect(Collectors.toList()))
//                .collect(Collectors.toList());
//    }
//
//    private List<Map<String, String>> getListOrdersMap(final List<List<String>> ordersList) {
//        List<Map<String, String>> result = new ArrayList<>();
//        if (ordersList.isEmpty()) return result;
//        for (List<String> orders : ordersList) {
//            Map<String, String> orderMap = new HashMap<>();
//            for (String fieldOrder : orders) {
//                String[] keyValue = fieldOrder.split(" \\| ");
//                if (keyValue.length > 1) orderMap.put(keyValue[0], keyValue[1]);
//            }
//            result.add(orderMap);
//        }
//        return result;
//    }
//
//    public List<Map<String, String>> getCurrentOrdersMap() {
//        try {
//            return getListOrdersMap(getOrdersList(getJSONStringsList()));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return Collections.emptyList();
//    }
//}
