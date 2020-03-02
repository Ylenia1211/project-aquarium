package com.uge.j2ee.aquarium.service;

import com.uge.j2ee.aquarium.model.Activity;
import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.repository.ActivityRepository;
import com.uge.j2ee.aquarium.repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepo;

    public Iterable<Activity> getAll() {
        return activityRepo.findAll();
    }

    public Activity save(Activity poolActivity) {
        return activityRepo.save(poolActivity);
    }

    public void update(Activity poolActivity) {
        activityRepo.save(poolActivity);
    }

    public Activity getById(String id) {
        return activityRepo.findById(Long.parseLong(id)).get();
    }

    public Activity remove(Activity poolActivity) {
        activityRepo.delete(poolActivity);
        return poolActivity;
    }
}

