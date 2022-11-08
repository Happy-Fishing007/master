package com.gjq.generator.service.Impl;

import com.gjq.generator.pojo.Student;
import com.gjq.generator.mapper.StudentMapper;
import com.gjq.generator.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjq
 * @since 2022-10-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
