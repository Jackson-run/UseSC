package water.ustc.interceptor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name="action")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder= {
        "name",
        "s_time",
        "e_time",
        "result",
})
public class Action implements Serializable{
    @XmlElement
    private String name;
    @XmlElement
    private String s_time;
    @XmlElement
    private String e_time;
    @XmlElement
    private String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
