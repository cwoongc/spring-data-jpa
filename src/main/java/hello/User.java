package hello;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity // @Table 태그 없이는 @Entity가 붙은 클래스 명으로 spring.jpa.hibernate.ddl-auto=create, create-drop 일경우 테이블을 만든다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;



}
