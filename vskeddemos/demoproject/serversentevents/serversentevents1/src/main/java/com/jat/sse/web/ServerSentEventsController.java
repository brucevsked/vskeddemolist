package com.jat.sse.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/mysse")
public class ServerSentEventsController {

    private static final Logger log = LoggerFactory.getLogger(ServerSentEventsController.class);

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @RequestMapping(value = "pushData",produces = "text/event-stream")
    public SseEmitter pushData(){
        log.trace("---------------------------------enter push data");
        try {
            Thread.sleep(1000);
            //第三方数据源调用
        } catch (InterruptedException e) {
            log.error("sleep error1",e);
        }

        SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);

        sseEmitter.onCompletion(() -> log.info("SseEmitter is completed"));

        sseEmitter.onTimeout(() -> log.info("SseEmitter is timed out"));

        sseEmitter.onError((ex) -> log.info("SseEmitter got error:", ex));

        executor.execute(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    sseEmitter.send(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
                    sleep(1, sseEmitter);
                } catch (IOException e) {
                    log.error("send error or sleep erro",e);
                    sseEmitter.completeWithError(e);
                }
            }
            sseEmitter.complete();
        });

        return sseEmitter;
    }

    private void sleep(int seconds, SseEmitter sseEmitter) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.error("sleep error",e);
            sseEmitter.completeWithError(e);
        }
    }

}
