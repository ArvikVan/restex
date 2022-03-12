package rest.exception;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.03.2022
 * класс который подставляет в жсон поле инфо, если в жсоне при ексепшене
 * хочется видеть больше инфо, то ее необходимо указать тут
 */
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
