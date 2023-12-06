package com.melik.redis.service;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface StringService {

    void setProgrammer(String idKey, String programmer);

    String getProgrammer(String idKey);

    void removeProgrammer(String idKey);
}
