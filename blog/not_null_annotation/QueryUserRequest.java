package not_null_annotation;


import com.sun.istack.internal.NotNull;

/**
 * @author Alan Yin
 * @date 2019/12/25
 */

public class QueryUserRequest extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
