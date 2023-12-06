package com.melik.redis.repo;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public interface StringRepository {

    void setProgrammer(String idKey, String programmer);

    String getProgrammer(String idKey);

    void removeProgrammer(String idKey);
}
