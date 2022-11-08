package com.gjq.generator.mapper;

import com.gjq.generator.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gjq
 * @since 2022-10-12
 */
public interface StudentMapper extends BaseMapper<Student> {

        void saveAll(List<Student> students);


}
