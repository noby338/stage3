package priv.noby.note.service.impl;

import org.springframework.stereotype.Service;
import priv.noby.note.service.StudentService;

/**
 * @author Noby
 * @since 2022/10/17
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void selectById(int id) {
        System.out.println("StudentServiceImpl.selectById id = " + id);
    }
}
