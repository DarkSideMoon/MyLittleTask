import com.greenowl.logic.dao.impl.TaskDaoImpl;
import com.greenowl.model.Task;
import com.greenowl.model.TaskType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by acube on 15.05.2016.
 * Package PACKAGE_NAME
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public class TestTaskJPA {

    /*
    @Test
    public void TestCreateTask() {
        TaskType taskType = new TaskType();
        taskType.Id = (long)1;

        Task task = new Task();
        task.name = "New task";
        task.prioritising = 3;
        task.isDone = true;
        task.taskType = taskType;
        task.body = "Body of task";
        task.dateDeadLine = new Date();
        task.dateCreate = new Date();

        TaskDaoImpl dao = new TaskDaoImpl();
        dao.create(task);
    }
    */
    /*
    @Test
    public void TestGetAll() {
        TaskDaoImpl dao = new TaskDaoImpl();
        List<Task> allTasks = dao.getAll();
    }

    @Test
    public void TestGetAllInDone() {
        TaskDaoImpl dao = new TaskDaoImpl();
        List<Task> allDoneTasks = dao.getAllInDone();
    }

    @Test
    public void TestGetTaskByTypeId() {
        TaskDaoImpl dao = new TaskDaoImpl();
        List<Task> allDoneTasks = dao.getByTypeId(1);
    }

    @Test
    public void TestGetTaskByPriority() {
        TaskDaoImpl dao = new TaskDaoImpl();
        List<Task> allDoneTasks = dao.getByPrioritazing(2);
    }
    */

    /*
    @Test
    public void TestGetTasksByTypesCount() {
        TaskDaoImpl dao = new TaskDaoImpl();
        List<Integer> res = dao.getTasksByTypes();

        Assert.assertEquals(res.get(0).intValue(), 3);
        Assert.assertEquals(res.get(1).intValue(), 2);
        Assert.assertEquals(res.get(2).intValue(), 2);
        Assert.assertEquals(res.get(3).intValue(), 7);
    }
    */
}