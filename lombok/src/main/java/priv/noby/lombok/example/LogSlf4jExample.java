package priv.noby.lombok.example;

import lombok.extern.slf4j.Slf4j;

/**
 * 为该类添加属性
 * private static final Logger log = LoggerFactory.getLogger(LogSlf4jExample.class);
 */
@Slf4j
public class LogSlf4jExample {
    public static void main(String[] args) {
        log.info("level:{}","info");
        log.warn("level:{}","warn");
        log.error("level:{}", "error");
    }
}
