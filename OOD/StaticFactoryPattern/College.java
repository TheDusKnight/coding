package OOD.StaticFactoryPattern;

// 静态工厂模式
public class College {
    private String collegeName;

    // 这里我们将构造方法的访问权限设置为私有，以防止有人从外部调用它
    private College(String collegeName) {
        this.collegeName = collegeName;
    }

    public static College getInformationCollege() {
        return new College("信息学院");
    }

    public static College getFinanceCollege() {
        return new College("财经学院");
    }

    public static College getEngineering() {
        return new College("工程学院");
    }

    public String getCollegeName() {
        return collegeName;
    }
}