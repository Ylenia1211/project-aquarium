package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Activity;
import com.uge.j2ee.aquarium.model.Employee;
import com.uge.j2ee.aquarium.service.ActivityService;
import com.uge.j2ee.aquarium.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/activity")
    public Iterable<Activity> getAll() {
        return activityService.getAll();
    }

    @GetMapping("/activity/{id}")
    public Activity getById(@PathVariable String id) {
        return activityService.getById(id);
    }

    @PostMapping("/activity")
    @ResponseBody
    public Activity create(@RequestBody Activity activity) {
        return activityService.save(activity);
    }

    @PutMapping("/activity/{id}")
    @ResponseBody
    public Activity updateEmployee(@PathVariable String id, @RequestBody Map<String, String> allParams) {
        Activity p = activityService.getById(id);
        p.setNameActivity(allParams.get("nameActivity"));
        p.setState(allParams.get("state"));
        return  activityService.save(p);
    }

    @DeleteMapping("/activity/{id}")
    public Activity delete(@PathVariable String id) {
        return  activityService.remove( activityService.getById(id));
    }
}
