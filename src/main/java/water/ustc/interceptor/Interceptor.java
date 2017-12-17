package water.ustc.interceptor;

import java.io.StringReader;

public class Interceptor {
    private String name ;
    private String _class;
    private String preDo;
    private String afterDo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getPreDo() {
        return preDo;
    }

    public void setPreDo(String preDo) {
        this.preDo = preDo;
    }

    public String getAfterDo() {
        return afterDo;
    }

    public void setAfterDo(String afterDo) {
        this.afterDo = afterDo;
    }
}
