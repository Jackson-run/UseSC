package water.ustc.interceptor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Action2Xml {
    final String path = "/log.xml";
    public void persist(Action action){
        try {
            JAXBContext context = JAXBContext.newInstance(Action.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //marshaller.marshal(stu, System.out);
            StringWriter writer = new StringWriter();
            marshaller.marshal(action, writer);
            File file = new File(Action2Xml.class.getResource(path).getFile());
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.append(writer.toString());
            fileWriter.close();
            System.out.println(writer.toString());
        } catch (JAXBException e) {
            e.getMessage();
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        Action action = new Action();
        action.setResult("dad");
        action.setE_time("dasda");
        action.setName("dasd");
        action.setS_time("dadsa");
        new Action2Xml().persist(action);
    }*/
}
