package hr.riteh.praksafakture.database.entity;

import hr.riteh.praksafakture.constants.ColumnNames;
import hr.riteh.praksafakture.constants.TableNames;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = TableNames.USERS)
public class UserEntity {

    @Id
    @Column(name = ColumnNames.USERNAME, nullable = false)
    private String username;

    @Basic
    @Column(name = ColumnNames.PASSWORD, nullable = false)
    private String password;

    @Basic
    @Column(name = ColumnNames.FULL_NAME, nullable = false)
    private String fullName;

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}