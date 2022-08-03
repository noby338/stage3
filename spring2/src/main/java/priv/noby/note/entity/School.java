package priv.noby.note.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Component
public class School {
    @Value("100")
    private int scId;
    @Value("蜗牛大学")
    private String scName;
}
