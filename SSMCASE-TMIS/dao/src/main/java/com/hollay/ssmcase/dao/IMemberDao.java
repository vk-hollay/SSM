package com.hollay.ssmcase.dao;

import com.hollay.ssmcase.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author hollay
 * @create 2021-02-25-18:32
 * @description
 */
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
