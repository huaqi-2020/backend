package cn.edu.whu.huaqi_2020.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.UUID;

/**
 * Author: eamon
 * Email: eamon@eamon.cc
 * Time: 2020-03-17 18:18:25
 */
public class TokenFilter implements GlobalFilter, Ordered {

    private static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info(exchange.getRequest().getPath().toString());
        if (exchange.getRequest().getPath().toString().contains("common")) {
            return chain.filter(exchange);
        } else if (exchange.getRequest().getPath().toString().contains("swagger")) {
            return chain.filter(exchange);
        } else if (exchange.getRequest().getPath().toString().contains("api-docs")) {
            return chain.filter(exchange);
        } else if (!exchange.getRequest().getPath().toString().contains("api")) {
            logger.info("path is not a api");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return filterUser(exchange, chain);
    }

    private Mono<Void> filterUser(ServerWebExchange exchange, GatewayFilterChain chain) {
        String userId = exchange.getRequest().getHeaders().getFirst("userId");
        if (StringUtils.isEmpty(userId)) {
            HttpCookie cookie = exchange.getRequest().getCookies().getFirst("userId");
            if (cookie != null) userId = cookie.getValue();
        }
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            HttpCookie cookie = exchange.getRequest().getCookies().getFirst("token");
            if (cookie != null) token = cookie.getValue();
        }
        String newToken = UUID.randomUUID().toString();
        if (newToken == null) {
            logger.info("token is null");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        exchange.getResponse().getHeaders().put("token", Collections.singletonList(newToken));
        exchange.getResponse().getCookies().add("token", ResponseCookie.from("token", newToken).path("/").build());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }

}
