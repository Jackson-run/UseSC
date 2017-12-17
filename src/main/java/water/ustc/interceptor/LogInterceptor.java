package water.ustc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogInterceptor {
    public Action preAction(HttpServletRequest request, HttpServletResponse response){
        Action action = new Action();
        String path = request.getServletPath();
        String actionname = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        action.setName(actionname);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        action.setS_time(df.format(new Date()));
        return action;
    }
    public void afterAction(Action action,String actionName,String result){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                action.setE_time(df.format(new Date()));
                action.setResult(result);
                Action2Xml action2Xml = new Action2Xml();
                action2Xml.persist(action);
    }
}
