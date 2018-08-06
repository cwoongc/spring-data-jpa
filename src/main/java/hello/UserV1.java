package hello;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserV1 implements Serializable {

    private String name;
    private String email;
}
