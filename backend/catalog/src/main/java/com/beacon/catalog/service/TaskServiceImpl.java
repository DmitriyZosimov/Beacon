package com.beacon.catalog.service;

import com.beacon.catalog.dao.TaskDao;
import com.beacon.model.order.Order;
import com.beacon.model.order.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Task> findAllByShopIdInOrders(Long shopId) {
        return taskDao.findAllByShopIdInOrders(shopId);
    }

    @Override
    public boolean saveTask(Task task) {
        List<Task> tasks = new LinkedList<>();
        List<Order> orders = task.getOrders();
        while (!orders.isEmpty()) {
            Long shopId = orders.get(0).getShopId();
            List<Order> subOrder = orders.stream().filter(order -> order.getShopId().equals(shopId)).collect(Collectors.toList());
            orders.removeAll(subOrder);
            Task newTask = task.clone();
            subOrder.forEach(order -> order.setTask(newTask));
            newTask.setOrders(subOrder);
            tasks.add(newTask);
        }
        tasks = taskDao.saveAllAndFlush(tasks);
        tasks.forEach(t -> {
            if (t.getTaskId() == null) {
                //TODO: use logger
                throw new RuntimeException("Task was not saved: " + t);
            }
        });
        return true;
    }

    @Override
    public int updateTaskState(Task task) {
        return taskDao.updateStateByTaskId(task.getTaskId(), task.getState());
    }
}
