package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class TaskRequest {

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    /*Local Data Send To Server*/
    String Project;






    /*Initiate Class*/
    public TaskRequest() {


    }

    public TaskRequest(TaskRequest data) {

        Project = data.getProject();

    }
}