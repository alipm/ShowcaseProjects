package com.application.limitless.sourav.showcaseprojects.modle.dto;

public class CLListItem {

    private String activityName;
//    Class aClass;

    public CLListItem(String activityName)
    {
        this.activityName = activityName;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }
}
