package com.ustc.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleController
 */
public class SimpleController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Map<String, String[]> map = request.getParameterMap();
        int a = 0;
        for (Iterator iter = map.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry element = (Map.Entry) iter.next();
            // key值  
            Object strKey = element.getKey();
            // value,数组形式  
            String[] value = (String[]) element.getValue();
            System.out.print(strKey.toString() + "=");

            session.setAttribute("name" + a, strKey.toString());

            for (int i = 0; i < value.length; i++) {
                System.out.print(value[i] + ",");
                session.setAttribute("param" + a++, value[i]);
            }


        }


        String path = request.getServletPath();
        String actionname = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
        session.setAttribute("path", actionname);
        File file = new File(SimpleController.class.getResource("/controller.xml").getFile());
        List<String> xmlValueActionName = ReadXmlFile.getXmlValueActionName(file);

        List<String> xmlValueActionClass = ReadXmlFile.getXmlValueActionClass(file);

        List<String> xmlValueResultName = ReadXmlFile.getXmlValueResultName(file, actionname);

        List<String> xmlValueResultValue = ReadXmlFile.getXmlValueResultValue(file, actionname);

        List<String> xmlValueResultType = ReadXmlFile.getXmlValueResultType(file, actionname);

        if (!xmlValueActionName.contains(actionname)) {
            System.out.println("不可识别的action请求");

        }

        for (int m = 0; m < xmlValueActionName.size(); m++)

        {
            actionname = actionname.toUpperCase().charAt(0) + actionname.substring(1);

            if (xmlValueActionClass.get(m).equals("water.ustc.action." + actionname + "Action")) {
                Class clazz;
                try {
                    clazz = Class.forName(xmlValueActionClass.get(m));


                    Method method = clazz.getDeclaredMethod("handle" + actionname);
                    String result = (String) method.invoke(clazz.newInstance());
                    if (!xmlValueResultName.contains(result)) {
                        System.out.println("没有请求的资源");
                    } else {
                        for (int i = 0; i < xmlValueResultName.size(); i++) {
                            if (result.equals(xmlValueResultName.get(i))) {
                                if (xmlValueResultType.get(i).equals("forward")) {
                                    request.getRequestDispatcher(xmlValueResultValue.get(i)).forward(request, response);

                                }
                                if (xmlValueResultType.get(i).equals("redirect")) {
                                    response.sendRedirect(xmlValueResultValue.get(i));
                                }
                            }
                        }
                    }

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }


    }

}
