package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    properties = {
        "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration"
    }
)


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SalaryApplicationTests {

    // Mock existing beans instead of redefining them
    @MockBean
    private RedisTemplate<Object, Object> redisTemplate;

    @MockBean
    private RedisCacheManager cacheManager;

    
    // Mock Cassandra beans
    @MockBean
    private CassandraTemplate cassandraTemplate;

    @MockBean
    private CassandraAdminTemplate cassandraAdminTemplate;

    @Test
    void contextLoads() {
        // Ensures Spring context starts successfully
    }
}
