package Project1.logic;

import Project1.model.Address.WriteAddress;
import Project1.model.Grade.WriteGrade;
import Project1.model.Person.ReadPersonById;
import Project1.model.Person.ReadPersonLogIn;
import Project1.model.Person.Student.ReadStudentById;
import Project1.model.Repository;
import Project1.model.Subject.ReadSubjectById;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author marcin
 */
public class Service {
    private final Repository repository;
    private Transaction transaction;
    private final Mapper mapper;
    private final DataProjector projector;
    private final int PARAM_NUM = 8;
    
    public Service() {
        this.repository = new Repository();
        this.mapper = new Mapper();
        this.projector = new DataProjector();
    }
    
    Service(Repository repository) {
        this.repository = repository;
        this.mapper = new Mapper();
        this.projector = new DataProjector();
    }
    
    public String request(String data) throws ClassNotFoundException, SQLException {
        //processing input data, splitting arguments
        Map<String, String> task = mapper.requestingData(data);
        if (task.isEmpty())
            return response("");
        Set<Object> dataSet = projector.convert(task);
        List<String> args = Arrays.asList(new String[PARAM_NUM]);
        
        dataSet.forEach(obj -> {
            if (obj.getClass() == ReadPersonLogIn.class) {
                Integer id = ((ReadPersonLogIn)obj).getId();
                String arg = id.toString();
                args.set(0, arg);
                args.set(7, ((ReadPersonLogIn)obj).getPass());
            }
            else if (obj.getClass() == ReadPersonById.class) {
                Integer id = ((ReadPersonById)obj).getId();
                String arg = id.toString();
                args.set(0, arg);
            }
            else if (obj.getClass() == ReadStudentById.class){
                Integer id = ((ReadStudentById)obj).getId();
                String arg = id.toString();
                args.set(1, arg);
            }
            else if (obj.getClass() == ReadSubjectById.class){
                Integer id = ((ReadSubjectById)obj).getId();
                String arg = id.toString();
                args.set(2, arg);
            }
            else if (obj.getClass() == WriteGrade.class){
                Integer grade = ((WriteGrade)obj).getGrade();
                String arg = grade.toString();
                args.set(3, arg);
            }
            else if (obj.getClass() == WriteAddress.class){
                args.set(4, (((WriteAddress)obj).getCity()));
                args.set(5, ((WriteAddress)obj).getStreet_and_number());
                args.set(6, ((WriteAddress)obj).getPost_code());
            }
        });
        
        //put arguments in right order
        ArrayList<String> arguments = new ArrayList<>();
        for (int i = 0; i < PARAM_NUM; ++i)
            if (args.get(i) != null)
                arguments.add(args.get(i));
        
        //making request to database
        transaction = new Transaction(projector.getRequestType(), arguments);
        String databaseData = repository.connect(transaction);
        //returning response
        return response(databaseData);
    }

    //preparing response, returns json
    private String response(String databaseData) {
        if (databaseData.isEmpty()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Error", "Problem with server!");
            return jsonObj.toJSONString();
        }
        
        if (projector.getRequestType() == RequestType.GET_STUDENT_GRADES || 
            projector.getRequestType() == RequestType.GET_TEACHER_ALL_HIS_STUDENTS_GRADES ||
            projector.getRequestType() == RequestType.GET_TEACHER_PROVIDED_ALL_GRADES_FROM )
        {
            List<Map<String, String>> responseMappedData = mapper.responsingData(projector.getRequestType(), databaseData);
            
            if (responseMappedData.size() == 0) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("Error", "Problem with server!");
                return jsonObj.toJSONString();
            }
            else {
                return JSONValue.toJSONString(responseMappedData);
            }
        }
        Map<String, String> responseMappedData = mapper.responsingData(projector.getRequestType(), databaseData);
        
        if (responseMappedData.size() == 0) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Error", "Problem with server!");
            return jsonObj.toJSONString();
        }
        else {
            return JSONValue.toJSONString(responseMappedData);
        }
    }
    
}
