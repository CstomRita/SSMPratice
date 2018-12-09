package spring.aoptest1;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:54 2018/10/29
 * @ Description：用户POJO类
 * @ Modified By：
 * @Version: $
 */
public class User {
    private String userName;
    private String passWord;
    private Long userId;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
