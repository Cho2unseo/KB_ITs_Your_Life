package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    // 사용자 정보를 담는 클래스
    private String id;
    private String password;
    private String name;
    private String role;
}
