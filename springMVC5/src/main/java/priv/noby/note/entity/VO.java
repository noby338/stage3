package priv.noby.note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 该对象用于请求时封装集合(集合的封装一般借助其他类)
 *
 * @author Noby
 * @since 2022/10/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VO {
    private List<Student> studentList;
}
