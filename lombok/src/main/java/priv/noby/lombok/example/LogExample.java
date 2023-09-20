package priv.noby.lombok.example;

import lombok.extern.java.Log;

/**
 * 为该类添加属性
 * private static final Logger log = Logger.getLogger(LogExample.class.getName());
 */
@Log
public class LogExample {
    public static void main(String[] args) {
        log.info("level info");
        log.warning("level warning");
        log.severe("level severe");
    }
}
