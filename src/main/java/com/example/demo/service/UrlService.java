package com.example.demo.service;

import com.example.demo.Base62Encoder;
import com.example.demo.model.Url;
import com.example.demo.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String createShortUrl(String longUrl) {

        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setCreatedAt(LocalDateTime.now());
        url.setExpiryAt(LocalDateTime.now().plusDays(7));
        url.setClickCount(0);

        repository.save(url);

        String shortCode = Base62Encoder.encode(url.getId());
        url.setShortCode(shortCode);

        repository.save(url);

        return shortCode;
    }

    public String getLongUrl(String shortCode) {

        String cached = redisTemplate.opsForValue().get(shortCode);

        if (cached != null) {
            return cached;
        }

        System.out.println("DB HIT");

        Url url = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        if (url.getExpiryAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Link expired");
        }

        url.setClickCount(url.getClickCount() + 1);
        repository.save(url);

        redisTemplate.opsForValue()
                .set(shortCode, url.getLongUrl(), Duration.ofMinutes(10));

        return url.getLongUrl();
    }

    public Url getUrlDetails(String shortCode) {
        return repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }

    public boolean isAllowed(String ip) {

        String key = "rate_limit:" + ip;

        String count = redisTemplate.opsForValue().get(key);

        if (count == null) {
            redisTemplate.opsForValue().set(key, "1", Duration.ofMinutes(1));
            return true;
        }

        int current = Integer.parseInt(count);

        if (current >= 100) {
            return false;
        }

        redisTemplate.opsForValue().increment(key);
        return true;
    }
}