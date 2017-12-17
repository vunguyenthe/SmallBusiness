package com.small.business.model.option;

import com.small.business.model.base.BaseMessage;

public class ProgressStatus extends BaseMessage {

    private Long id;
    private String progressStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }
}
