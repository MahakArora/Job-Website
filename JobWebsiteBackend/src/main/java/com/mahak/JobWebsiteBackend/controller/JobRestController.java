package com.mahak.JobWebsiteBackend.controller;

import com.mahak.JobWebsiteBackend.model.JobPost;
import com.mahak.JobWebsiteBackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.returnAllJobPosts();
    }
    @GetMapping("jobPost/{id}")
    public JobPost getJob(@PathVariable int id){
        return service.returnJobPost(id);
    }

    @PostMapping("jobPost")
    public JobPost addJobPost(@RequestBody JobPost job){
        service.addJobPost(job);
        return service.returnJobPost(job.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost editPost(@RequestBody JobPost job){
        service.updateJobPost(job);
        return service.returnJobPost(job.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJobPost(@PathVariable int id){
        service.deleteJobPost(id);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        return "done";
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyWord(@PathVariable String keyword){
        return service.searchByKeyword(keyword);
    }
}
