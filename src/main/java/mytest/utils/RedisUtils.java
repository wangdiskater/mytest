package mytest.utils;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Singleton
public class RedisUtils {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Inject
    private StatefulRedisConnection<String, String> conn;

    private RedisCommands<String, String> getCommand() {
        logger.info("redis get command start on :{}", LocalDateTime.now());
        RedisCommands<String, String> sync = conn.sync();
        logger.info("redis connection state is open:{}", sync.isOpen());
        if (!sync.isOpen()) {
            logger.info("redis connection is closed,will be reset on :{}", LocalDateTime.now());
            sync.reset();
            logger.info("redis connection reset over");
        }
        logger.info("return :{} connection", sync.isOpen());
        return sync;
    }

    public String setByKey(String key, String value) {
        return getCommand().set(key, value);
    }

    public String getByKey(String key) {
        return getCommand().get(key);
    }

    public long deleteByKey(String key) {
        return getCommand().del(key);
    }

    public long incr(String key) {
        return getCommand().incr(key);
    }


    public Optional<String> getString(String key) {
        String value = getCommand().get(key);
        return value != null ? Optional.of(value) : Optional.empty();
    }

    /**
     * 保存有期限的数据
     *
     * @return
     */
    public String setByKeyAndExpireSeconds(String key, Long expireSeconds, String value) {
        return getCommand().setex(key, expireSeconds, value);
    }

    /**
     * ZSet相关方法
     */
    public List<String> getAllZSetList(String key) {
        Long zcard = getCommand().zcard(key);
        List<String> zrange = getCommand().zrange(key, 0, zcard);
        return zrange;
    }

    public void zIncrbyKey(String key, double amount, String member) {
        Double zincrby = getCommand().zincrby(key, amount, member);
    }

    public List<String> zRangeByScore(String key, double start, double end) {
        return getCommand().zrangebyscore(key,start,end,0,-1);
    }

    public void zAdd(String key, double score, String member) {
        Long zadd = getCommand().zadd(key, score, member);
    }

    /**
     * hash方法
     */
    public void setHSet(String key, String field, String value) {
        RedisCommands<String, String> command = getCommand();
        Boolean hset = command.hset(key, field, value);

    }
    public String getHSet(String key, String field) {
        RedisCommands<String, String> command = getCommand();
        return command.hget(key, field);
    }

    public void delHSet(String key, String field) {
        RedisCommands<String, String> command = getCommand();
        command.hdel(key, field);
    }

    /**
     * 简单实现redis分布式锁
     */

    public Boolean getLock(String transactionId) {
        RedisCommands<String, String> command = getCommand();
        String id = UUID.randomUUID().toString().substring(0, 10);

        String key = "wechat.notify.%s";
        String notifyKey = String.format(key, transactionId);
        // 过期时间5s，且不存在才设置值
        SetArgs args = SetArgs.Builder.ex(5).nx();
        String value = command.set(notifyKey,id, args);

        return "OK".equals(value);
    }

    public void delLock(String transactionId) {
        RedisCommands<String, String> command = getCommand();

        String key = "wechat.notify.%s";
        String notifyKey = String.format(key, transactionId);
        Long del = command.del(notifyKey);

        return;
    }
}
