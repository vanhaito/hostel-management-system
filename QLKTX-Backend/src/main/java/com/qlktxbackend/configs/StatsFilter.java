package com.qlktxbackend.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Component
public class StatsFilter implements Filter {


    private static final Logger LOGGER = LoggerFactory.getLogger(StatsFilter.class);


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Instant start = Instant.now();
        try {
            chain.doFilter(req, resp);
        } finally {
            Instant finish = Instant.now();
            long time = Duration.between(start, finish).toMillis();
            LOGGER.info("URI: " +  ((HttpServletRequest) req).getRequestURI() + ", time: " + time + "ms, startTime: " +  start + ", endTime: " + finish);
        }
    }
}
