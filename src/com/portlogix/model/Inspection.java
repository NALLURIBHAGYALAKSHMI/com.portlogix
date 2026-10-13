package com.portlogix.model;

public class Inspection {

    private int inspectionId;
    private int containerId;
    private String inspectorName;
    private String result;
    private String inspectionDate;

    // Default constructor
    public Inspection() {
    }

    // Parameterized constructor
    public Inspection(int inspectionId,
                      int containerId,
                      String inspectorName,
                      String result,
                      String inspectionDate) {

        this.inspectionId = inspectionId;
        this.containerId = containerId;
        this.inspectorName = inspectorName;
        this.result = result;
        this.inspectionDate = inspectionDate;
    }

    // Getters and Setters

    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    // toString method
    @Override
    public String toString() {

        return "Inspection {" +
                "ID = " + inspectionId +
                ", Container ID = " + containerId +
                ", Inspector = '" + inspectorName + '\'' +
                ", Result = '" + result + '\'' +
                ", Date = '" + inspectionDate + '\'' +
                '}';
    }
}