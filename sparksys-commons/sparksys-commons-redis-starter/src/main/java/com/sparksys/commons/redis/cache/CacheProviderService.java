package com.sparksys.commons.redis.cache;

import java.util.Map;
import java.util.function.Function;

/**
 * description: 缓存提供接口
 *
 * @author zhouxinlei
 * @date 2020-05-24 13:25:06
 */
public interface CacheProviderService {

    /**
     * 查询缓存
     *
     * @param key 缓存键 不可为空
     * @return T
     * @author zhouxinlei
     * @date 2020-01-27 20:19:27
     */
    <T> T get(String key);

    /**
     * 查询缓存
     *
     * @param key      缓存键 不可为空
     * @param function 如没有缓存，调用该callable函数返回对象 可为空
     * @return T
     */
    <T> T get(String key, Function<String, T> function);

    /**
     * 查询缓存
     *
     * @param key       缓存键 不可为空
     * @param function  如没有缓存，调用该callable函数返回对象 可为空
     * @param funcParam function函数的调用参数
     * @return T
     */
    <T, M> T get(String key, Function<M, T> function, M funcParam);

    /**
     * 查询缓存
     *
     * @param key        缓存键 不可为空
     * @param function   如没有缓存，调用该callable函数返回对象 可为空
     * @param expireTime 过期时间（单位：毫秒） 可为空
     * @return T
     **/
    <T> T get(String key, Function<String, T> function, Long expireTime);

    /**
     * 查询缓存
     *
     * @param key        缓存键 不可为空
     * @param function   如没有缓存，调用该callable函数返回对象 可为空
     * @param funcParam  function函数的调用参数
     * @param expireTime 过期时间（单位：毫秒） 可为空
     * @return T
     **/
    <T, M> T get(String key, Function<M, T> function, M funcParam, Long expireTime);

    /**
     * 设置缓存键值
     *
     * @param key 缓存键 不可为空
     * @param obj 缓存值 不可为空
     * @return void
     **/
    <T> void set(String key, T obj);

    /**
     * 设置缓存键值
     *
     * @param key        缓存键 不可为空
     * @param obj        缓存值 不可为空
     * @param expireTime 过期时间（单位：毫秒） 可为空
     * @return void
     **/
    <T> void set(String key, T obj, Long expireTime);

    /**
     * 设置缓存有效期
     *
     * @param key        缓存键 不可为空
     * @param expireTime 过期时间（单位：毫秒） 可为空
     * @return void
     */
    void expire(String key, Long expireTime);

    /**
     * 自增长
     *
     * @param key   key值
     * @param delta 自增间距
     * @return Long
     */
    Long increment(String key, long delta);

    /**
     * 自减
     *
     * @param key   key值
     * @param delta 自减间距
     * @return Long
     * @author zhouxinlei
     * @date 2019-10-11 16:23:58
     */
    Long decrement(String key, long delta);

    /**
     * 移除缓存
     *
     * @param key 缓存键 不可为空
     * @return void
     **/
    void remove(String key);

    /**
     * 是否存在缓存
     *
     * @param key 缓存键 不可为空
     * @return boolean
     **/
    boolean contains(String key);

    /**
     * 插入有序set集合
     *
     * @param key
     * @param score
     * @param value
     * @param <T>
     * @return
     */
    <T> Boolean setZSet(String key, Long score, T value);

    /**
     * 获取score
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    <T> Long get(String key, T value);

    /**
     * 获取zset 中的value
     *
     * @param key
     * @param score
     * @param <T>
     * @return
     */
    <T> T get(String key, Long score);

    /**
     * 设置hash
     *
     * @param key
     * @param hashKey
     * @param value
     * @param <K>
     * @param <V>
     */
    <K, V> void setHash(String key, K hashKey, V value);

    <K> void removeHashEntity(String key, K hashKey);

    /**
     * 获取map
     *
     * @param key
     * @return
     */
    Map getHash(String key);

}