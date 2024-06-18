package com.enums;

public enum javascriptExecutorCommands {
    EnableTextField("document.querySelector('#').disabled=false");
    private String query;

    private javascriptExecutorCommands(String query) {
        this.query = query;
    }
    //made this to access private value
    public String getQuery() {
        return query;
    }

}
